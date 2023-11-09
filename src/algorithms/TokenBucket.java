/**
 *  Rate limiting
 */
public class TokenBucket {

    private final long maxBucketSize;
    private final long refillRate;

    private double currentBucketSize;
    private long lastRefillTimestamp;

    public TokenBucket(long maxBucketSize, long refillRate) {
        this.maxBucketSize = maxBucketSize;
        this.refillRate = refillRate;
    }

    public synchronized boolean allowRequest(int tokens) {
        refill();

        if (currentBucketSize > tokens) {
            currentBucketSize -= tokens;

            return true;
        }
        return false;
    }

    private void refill() {
        long now = System.nanoTime();
        double tokensToRefill = (now - lastRefillTimestamp) * refillRate / 1e9;

        currentBucketSize = Math.min(maxBucketSize, currentBucketSize + tokensToRefill);
        lastRefillTimestamp = now;
    }
}
