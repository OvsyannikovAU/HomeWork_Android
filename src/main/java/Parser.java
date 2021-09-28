import java.io.*;
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
            //reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF8"));
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
            scanner.useLocale(new Locale("ru", "RU"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            list.add(line);
        }
        /*try( Scanner scanner = new Scanner(file).useDelimiter("[^а-яА-Я]+") ) {
            String line = scanner.nextLine();
            while (scanner.hasNextLine()) {
                list.add(line);
                line = scanner.nextLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }*/
        return list;
    }
}
