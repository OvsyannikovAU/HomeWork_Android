import java.util.stream.IntStream;

public class Multiplication {

    public void printTable(int maxInd){
        for (int i=1; i<=maxInd; i++){
            for(int j=1; j<=maxInd; j++){
                System.out.print(i*j);
                System.out.print("\t");
            }
            System.out.println("");
        }
    }

    public void printTableAlt(int maxInd){
        IntStream.rangeClosed(1, maxInd).forEach(i -> {
            IntStream.rangeClosed(1, maxInd).forEach(j -> System.out.print(i * j + "\t"));
            System.out.println();
        });
    }
}
