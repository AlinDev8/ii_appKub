package com.example;

import org.springframework.web.bind.annotation.*;
import java.util.Random;

@RestController
@RequestMapping("/api")
public class SentimentController {
    private final Random random = new Random();
    
    @GetMapping("/sentiment")
    public AnalysisResult analyzeSentiment(@RequestParam String text) {
        String[] sentiments = {"positive", "negative", "neutral"};
        String sentiment = sentiments[random.nextInt(sentiments.length)];
        double confidence = 0.5 + random.nextDouble() * 0.5;
        
        return new AnalysisResult(text, sentiment, confidence);
    }
    
    @GetMapping("/health")
    public String health() {
        return "OK";
    }
    
    public static class AnalysisResult {
        private String text;
        private String sentiment;
        private double confidence;
        
        public AnalysisResult(String text, String sentiment, double confidence) {
            this.text = text;
            this.sentiment = sentiment;
            this.confidence = confidence;
        }
        
        public String getText() { return text; }
        public String getSentiment() { return sentiment; }
        public double getConfidence() { return confidence; }
    }
}
