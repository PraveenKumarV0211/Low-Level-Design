package Strategy;

public interface RateLimiterStrategy {
    public boolean allowRequest(int tokens);
}
