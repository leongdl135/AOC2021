import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner; 

public class day1 {
   public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("day1inputlol.txt"));
        int count = 0;
        int current = 0;

        while (scanner.hasNextLine()) {
            int num = Integer.valueOf(scanner.nextLine());
            if (num  > current) {
                count += 1;
            }
            current = num;
   
        }
        System.out.println("Count: " + (count - 1));
   } 
}
