package Strategy;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TokenBucketStrategy implements RateLimitingStrategy{

    private final int capacity;
    private final double refillRatePerSecond;
    private final Map<String, TokenBucket> buckets = new ConcurrentHashMap<>();

    public TokenBucketStrategy(int capacity, double refillRatePerSecond) {
        this.capacity = capacity;
        this.refillRatePerSecond = refillRatePerSecond;
    }
    @Override
    public boolean allowRequest(String clientId) {
        TokenBucket bucket = buckets.computeIfAbsent(
                clientId, id -> new TokenBucket(capacity, refillRatePerSecond));
        return bucket.allowRequest();
    }
}
