import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner; 
//import java.util.ArrayList;

public class daypart1 {
   public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("input.txt"));
        //ArrayList<Integer> numbers = new ArrayList<>();
        String[] nums = new String[1000];
        int count = 0;
        String gamma = "";
        String epsilon = "";
        while(scanner.hasNextLine()) {
            String input = scanner.nextLine();
            nums[count] = input;
            count++;
        }
        

        for(int i = 0; i < 12; i++) {
           int count1 = 0;
           int count2 = 0; 
           for(int j = 0; j < 1000; j++) {
               if (String.valueOf(nums[j].charAt(i)).equals("0")) {
                  count1++;
               } else {
                  count2++;
               }
               
           }
           if (count1 > count2) {
                  gamma += "0";
                  epsilon += "1";
               } else {
                  gamma += "1";
                  epsilon += "0";
               }
        }
        System.out.println(Integer.parseInt(gamma, 2)*Integer.parseInt(epsilon, 2));


   } 
}
