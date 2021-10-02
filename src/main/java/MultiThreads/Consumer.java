package MultiThreads;

import java.util.concurrent.LinkedBlockingQueue;

public class Consumer implements Runnable {
    private LinkedBlockingQueue<String> queue;

    public Consumer(LinkedBlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                String str = queue.take();
                if (str == "end") {
                    break;
                }
                System.out.println("CONSUMER: take string from queue: " + str);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
