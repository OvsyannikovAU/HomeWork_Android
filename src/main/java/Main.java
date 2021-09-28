import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        File file = new File("voyna.txt");
        Parser parser = new Parser();
        ArrayList<String> list=null;
        ArrayList<String> listAlt = null;
        try {
            list = parser.parse(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        list = parser.parseAlt(file);
        list.forEach(System.out::println);


        long counter = 0;
        //Locale rus = new Locale("ru", "RU");
        ArrayList<String> intrans = new ArrayList<>();
        intrans.add("Страдани");
        intrans.add("страдани");
        intrans.add("СТРАДАНИ");
        for (String strBase:list) {
            String localStr=strBase;
            for(String strIntrans:intrans){
                while(localStr.contains(strIntrans)){
                    counter++;
                    localStr = localStr.substring( localStr.indexOf(strIntrans)+strIntrans.length() );
                }
            }
        }
        System.out.println("Количество вхождений:"+counter);

        Multiplication mult = new Multiplication();
        mult.printTable(10);
    }
}
