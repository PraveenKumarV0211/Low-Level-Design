package Service;

import Strategy.RateLimitingStrategy;

public class RateLimiter {
    private RateLimitingStrategy strategy;

    public RateLimiter(RateLimitingStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(RateLimitingStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean allowRequest(String clientId) {
        return strategy.allowRequest(clientId);
    }
}
