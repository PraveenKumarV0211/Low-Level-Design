import Service.RateLimiter;
import Strategy.SlidingWindowStrategy;
import Strategy.TokenBucketStrategy;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        // Token bucket: capacity 5, refills 2 tokens/sec
        RateLimiter rateLimiter = new RateLimiter(new TokenBucketStrategy(5, 2));
        System.out.println("--- Token Bucket ---");
        for (int i = 1; i <= 7; i++) {
            System.out.println("Request " + i + ": " + rateLimiter.allowRequest("user1"));
        }
        Thread.sleep(1000); // ~2 tokens refill
        System.out.println("After 1s refill: " + rateLimiter.allowRequest("user1"));

        // Swap strategy at runtime: max 3 requests per 1000ms window
        rateLimiter.setStrategy(new SlidingWindowStrategy(3, 1000));
        System.out.println("--- Sliding Window ---");
        for (int i = 1; i <= 5; i++) {
            System.out.println("Request " + i + ": " + rateLimiter.allowRequest("user2"));
        }
        Thread.sleep(1000); // window clears
        System.out.println("After window clears: " + rateLimiter.allowRequest("user2"));
    }
}