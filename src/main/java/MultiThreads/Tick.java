package MultiThreads;

public class Tick {
    private long time;

    public Tick(long delay) {
        this.time = delay;
    }

    public long getDelay() {
        return time;
    }

    public void setDelay(long delay) {
        this.time = delay;
    }
}
