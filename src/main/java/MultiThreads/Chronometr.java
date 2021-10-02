package MultiThreads;

import static java.lang.Thread.sleep;

public class Chronometr implements Runnable {
    private Tick tick;
    private long startTime;

    public Chronometr(Tick tick) {
        this.tick = tick;
    }

    @Override
    public void run() {
        startTime = System.currentTimeMillis();
        while (true) {
            try {
                sleep(tick.getDelay());
                synchronized (tick) {
                    tick.notifyAll();
                    //System.out.println("notifyAll произошел");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println((System.currentTimeMillis() - startTime) / 1000.0f + " sec");
        }
    }
}
