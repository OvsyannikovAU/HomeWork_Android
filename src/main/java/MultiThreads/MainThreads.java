package MultiThreads;

import java.io.File;
import java.util.concurrent.LinkedBlockingQueue;

public class MainThreads {

    public void run() {
        //мессенджеры, вывод\щие сообщения раз в несколько секунд, синхронизированные с хронометром
        /*Tick tick = new Tick(1000);
        Printer printer5sec = new Printer(tick, 5, "5 second message");
        Printer printer7sec = new Printer(tick, 7, "7 second message");
        Chronometr chronometr = new Chronometr(tick);
        new Thread(chronometr).start();
        new Thread(printer5sec).start();
        new Thread(printer7sec).start();*/

        LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<>();
        File file = new File("voyna.txt");
        Producer producer = new Producer(queue, file);
        Consumer consumer = new Consumer(queue);
        new Thread(producer).start();
        new Thread(consumer).start();
    }
}
