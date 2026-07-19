package Service;

import Strategy.RateLimiterStrategy;
import Strategy.TokenBucket;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class RateLimitManager {
    private final ConcurrentHashMap<String,TokenBucket> buckets = new ConcurrentHashMap<>();
    private final long capacity;
    private final double refillRate;

    public RateLimitManager(long capacity, double refillRate) {
        this.capacity = capacity;
        this.refillRate = refillRate;
    }

    boolean allowRequest(String clientId){
        TokenBucket tokenBucket = buckets.computeIfAbsent(clientId, k -> new TokenBucket(capacity,refillRate));
       return tokenBucket.allowRequest(1);
    }
}
