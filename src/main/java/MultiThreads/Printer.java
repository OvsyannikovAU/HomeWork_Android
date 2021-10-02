package MultiThreads;

public class Printer implements Runnable {
    private Tick tick;
    private String msg;
    private int pause;
    private int step = 0;

    public Printer(Tick tick, int pause, String msg) {
        this.tick = tick;
        this.pause = pause;
        this.msg = msg;
    }

    @Override
    public void run() {
        System.out.println("Start printer every " + pause + " second with message: " + msg);
        while (true) {
            synchronized (tick) {
                if (step >= pause) {
                    step = 0;
                    System.out.println(msg);
                } else {
                    try {
                        //System.out.println("Wait on step " + step);
                        tick.wait();
                        step++;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
