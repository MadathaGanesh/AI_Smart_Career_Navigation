package com.demo.service.Implementation;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import com.demo.exceptionHandling.BadRequest;
import com.demo.service.AiService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AiServiceImpl implements AiService {

    private final WebClient.Builder webClientBuilder;

    private static final String HUGGINGFACE_API_URL =
            "https://api-inference.huggingface.co/models/google/flan-t5-large";

    @Value("${huggingface.api.key}")
    private String apiKey;

    @Override
    public String extractSkills(String text) {
        String prompt = "Extract technical skills from this resume text:\n" + text;
        return callAI(prompt);
    }

    @Override
    public String generateRoadmap(String missingSkills) {
        String prompt = "Create a learning roadmap for these missing skills:\n" + missingSkills;
        return callAI(prompt);
    }

    private String callAI(String prompt) {

        WebClient webClient = webClientBuilder.build();

        Map<String, String> requestBody = Map.of("inputs", prompt);

        try {
            return webClient.post()
                    .uri(HUGGINGFACE_API_URL)
                    .header("Authorization", "Bearer " + apiKey)
                    .bodyValue(requestBody)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();

        } catch (WebClientResponseException ex) {

            if (ex.getStatusCode() == HttpStatus.UNAUTHORIZED) {
                throw new BadRequest("Invalid Hugging Face API Key");
            }

            if (ex.getStatusCode() == HttpStatus.TOO_MANY_REQUESTS) {
                throw new BadRequest("Hugging Face API rate limit exceeded");
            }

            throw new BadRequest(
                    "AI Service error: " + ex.getResponseBodyAsString());
        } catch (Exception ex) {
            throw new BadRequest("AI Service unavailable: " + ex.getMessage());
        }
    }
}
