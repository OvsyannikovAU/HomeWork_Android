package MultiThreads;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Producer implements Runnable {
    private static final String WORD_TO_FIND_WIN1251 = "[Сс]трада\\S*\\b";
    private LinkedBlockingQueue<String> queue;
    private File file;

    public Producer(LinkedBlockingQueue<String> queue, File file) {
        this.queue = queue;
        this.file = file;
    }

    @Override
    public void run() {
        Scanner scanner = null;
        ArrayList<String> list = new ArrayList<>();
        String WORD_TO_FIND_UTF8 = encodeToUTF8(WORD_TO_FIND_WIN1251);
        Pattern pattern = Pattern.compile(WORD_TO_FIND_UTF8);
        try {
            scanner = new Scanner(file, StandardCharsets.UTF_8);
            list = scanner.findAll(pattern)
                    .map(MatchResult::group)
                    .collect(Collectors.toCollection(ArrayList::new));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
        for (String line : list) {
            line = encodeToWin1251(line);
            put_string(line, false);
        }
        put_string("end", false); //завершаем очередь спец-строкой
    }

    private void put_string(String str, boolean echo) {
        try {
            queue.put(str);
            if (echo) {
                System.out.println("PRODUCER: put string to queue: " + str);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private String encodeToUTF8(String str) {
        String ret = null;
        try {
            ret = new String(str.getBytes("windows-1251"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return ret;
    }

    private String encodeToWin1251(String str) {
        String ret = null;
        try {
            ret = new String(str.getBytes("UTF-8"), Charset.forName("windows-1251"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return ret;
    }
}
