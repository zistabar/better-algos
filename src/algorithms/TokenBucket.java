/**
 *  Rate limiting
 */
public class TokenBucket {

    private final long maxBucketSize;
    private final long refillRate;

    private double bucketSize;
    private long lastRefillTimestamp;

    public TokenBucket(long maxBucketSize, long refillRate) {
        this.maxBucketSize = maxBucketSize;
        this.refillRate = refillRate;

        bucketSize = maxBucketSize;
        lastRefillTimestamp = System.nanoTime();
    }

    public synchronized boolean allowRequest(int tokens) {
        refill();

        if (bucketSize > tokens) {
            bucketSize -= tokens;

            return true;
        }
        return false;
    }

    private void refill() {
        long now = System.nanoTime();
        double tokensToRefill = (now - lastRefillTimestamp) * refillRate / 1e9;

        bucketSize = Math.min(maxBucketSize, bucketSize + tokensToRefill);
        lastRefillTimestamp = now;
    }
}
