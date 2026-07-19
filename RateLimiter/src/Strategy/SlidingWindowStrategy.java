package Strategy;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SlidingWindowStrategy implements RateLimitingStrategy{
    private final int maxRequests;
    private final long windowSizeMillis;
    private final Map<String, Deque<Long>> requestLogs = new ConcurrentHashMap<>();

    public SlidingWindowStrategy(int maxRequests, long windowSizeMillis) {
        this.maxRequests = maxRequests;
        this.windowSizeMillis = windowSizeMillis;
    }

    @Override
    public boolean allowRequest(String clientId) {
        long now = System.nanoTime();
        Deque<Long> requests = requestLogs.getOrDefault(clientId, new ArrayDeque<>());
        synchronized (requests){
            while (!requests.isEmpty() && requests.peekFirst() <= now - windowSizeMillis){
                requests.pollFirst();
            }
            if(requests.size() < maxRequests){
                requests.addLast(now);
                return true;
            }
            return false;
        }
    }
}
