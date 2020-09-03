package DelayQueue;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @author yinyg
 * @date 2020/9/1
 * @description
 */
public class DelayMessage implements Delayed {
    private String message;
    private long ttl;

    @Override
    public long getDelay(TimeUnit unit) {
        return ttl - System.currentTimeMillis();
    }

    @Override
    public int compareTo(Delayed o) {
        return (int) (this.getDelay(TimeUnit.MILLISECONDS) - o.getDelay(TimeUnit.MILLISECONDS));
    }

    public DelayMessage(String message, long ttl) {
        this.message = message;
        this.ttl = System.currentTimeMillis() + ttl;
    }

    public String getMessage() {
        return message;
    }

    public long getTtl() {
        return ttl;
    }
}
