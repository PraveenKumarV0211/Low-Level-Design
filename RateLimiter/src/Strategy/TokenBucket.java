package Strategy;

public class TokenBucket {
    private int id;
    private long capacity;
    private double refillRate;
    private long lastRefilltimeStamp;
    private double currentTokens;

    public TokenBucket(int id, long capacity, double refillRate, long lastRefilltimeStamp, double currentTokens) {
        this.id = id;
        this.capacity = capacity;
        this.refillRate = refillRate;
        this.lastRefilltimeStamp = lastRefilltimeStamp;
        this.currentTokens = currentTokens;
    }

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
