package Strategy;

public class TokenBucket implements RateLimiterStrategy{

    private long capacity;
    private double refillRate;
    private long lastRefilltimeStamp;
    private double currentTokens;

    public TokenBucket(long capacity, double refillRate) {
        this.capacity = capacity;
        this.refillRate = refillRate;
        this.lastRefilltimeStamp = System.nanoTime();
    }

    @Override
    public boolean allowRequest(int tokens){
        if(capacity >= tokens){
            capacity -= tokens;
            return true;
        }
        return false;
    }

    public void refill(){
        long now = System.nanoTime();
        long elapsedTime = now - lastRefilltimeStamp;
        double tokenstoBeAdded = elapsedTime * refillRate;
        if(tokenstoBeAdded > 0){
            currentTokens = Math.min(capacity,currentTokens + tokenstoBeAdded);
            lastRefilltimeStamp = now;
        }
    }
}
