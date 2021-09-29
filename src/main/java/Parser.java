import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Parser {

    public ArrayList<String> parse(File file) throws IOException {
        BufferedReader reader = null;
        ArrayList<String> list = new ArrayList<>();
        try{
            reader = new BufferedReader(new FileReader(file));
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
        String line = reader.readLine();
        while (line !=null){
            list.add(line);
            line = reader.readLine();
        }
        return  list;
    }

    public ArrayList<String> parseAlt(File file){
        Scanner scanner = null;
        ArrayList<String> list = new ArrayList<>();
        try {
            scanner = new Scanner(file, StandardCharsets.UTF_8);
            //scanner.useLocale(new Locale("ru", "RU"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            try {
                line = new String(line.getBytes("UTF-8"), Charset.forName("windows-1251"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            list.add(line);
        }
        scanner.close();
        return list;
    }
}
