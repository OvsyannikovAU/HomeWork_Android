import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<String>();
        ArrayList<String> arrayList = new ArrayList<>();
        String a = "1";
        String b = "2";
        String c = "3";
        String d = "not_number";
        linkedList.add(a);
        linkedList.add(b);
        linkedList.add(c);
        linkedList.add(d);
        arrayList.add(a);
        arrayList.add(b);
        arrayList.add(c);
        arrayList.add(d);


        //первый способ удаления
        ArrayList<Integer> delPos = new ArrayList<Integer>();  //отдельный список, уранящий удаляемые из базового листа позиции
        for (int i = 0; i < linkedList.size(); i++) {          //перебираем базовый список
            if (linkedList.get(i) == "not_number") {    //если нашли элемент для удаления, то
                delPos.add(i);                          //запоминаем его индекс в отдельный список
            }
        }
        for (int i = 0; i < delPos.size(); i++) {              //теперь перебираем отдельный список
            linkedList.remove((int) delPos.get(i));   //и удаляем из базового списка элементы с индесками из особого списка
        }

        //второй способ удаления
        int j = 0;                                        //счетчик текущей позиции в массиве
        while (j < arrayList.size()) {                    //проверяем, что массив еще не закончился
            if (arrayList.get(j) == "not_number") {
                arrayList.remove(j);
            } else {
                j++;                                    //увелчиваем j только если не удаляли элемент из массива
            }
        }

        //теперь распечатаем оставшиеся элементы
        System.out.println("ArrayList:");
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }
        System.out.println("LinkedList:");
        for (int i = 0; i < linkedList.size(); i++) {
            System.out.println(linkedList.get(i));
        }


    }
}
