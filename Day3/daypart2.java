import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner; 
import java.util.ArrayList;

public class daypart2 {
   public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("input.txt"));
        ArrayList<String> numbers = new ArrayList<>();
        ArrayList<String> numbers2 = new ArrayList<>();


        while(scanner.hasNextLine()) {
           String input = scanner.nextLine();
           numbers.add(input);
           numbers2.add(input);
        }
        int pos = 0;
        while(numbers.size() != 1 && pos < 12) {
           numbers = helperC02(numbers, pos);
           pos++;
        }
        int pos2 = 0;
        while(numbers2.size() != 1 && pos2 < 12) {
           numbers2 = helper02(numbers2, pos2);
           pos2++;     
        }

        System.out.println("O2 rating: " + Integer.parseInt(numbers2.get(0),2));
        System.out.println("CO2 rating: " + Integer.parseInt(numbers.get(0),2));

   } 

   public static ArrayList<String> helper02(ArrayList<String> lst, int num) {
      ArrayList<String> zero = new ArrayList <>();
      ArrayList<String> one = new ArrayList <>();
      for(int j = 0; j < lst.size(); j ++) {
         if (String.valueOf(lst.get(j).charAt(num)).equals("0")) {
            zero.add(lst.get(j));
         } else {
            one.add(lst.get(j));
         }
      }
      if (zero.size() > one.size()) {
         return zero;
      } else {
         return one;
      }
   }

   public static ArrayList<String> helperC02(ArrayList<String> lst, int num) {
      ArrayList<String> zero = new ArrayList <>();
      ArrayList<String> one = new ArrayList <>();
      for(int j = 0; j < lst.size(); j ++) {
         if (String.valueOf(lst.get(j).charAt(num)).equals("0")) {
            zero.add(lst.get(j));
         } else {
            one.add(lst.get(j));
         }
      }
      if (zero.size() <= one.size()) {
         return zero;
      } else {
         return one;
      }
   }
} 

