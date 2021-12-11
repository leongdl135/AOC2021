import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
//import java.util.ArrayList;
import java.util.Arrays;

public class daypart1 {
   public static int[][] grid = new int[10][];
   public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("input.txt"));
        //ArrayList<Integer> numbers = new ArrayList<>();
        int c = 0;
        while(scanner.hasNextLine()) {
            String input = scanner.nextLine();
            String[] parts = input.split("");
            int[] temp = new int[10];
            for(int i = 0; i < 10; i++) {
                temp[i] = Integer.valueOf(parts[i]);
            }
           grid[c] = temp;
           c++;
        }

        int i = 1;
        while(true) {
            int flashes = 0;
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 10; k++) {
                        grid[j][k] += 1;
                }
            }
            while(containsTen()) {
                for (int a = 0; a < 10; a++) {
                    for (int b = 0; b < 10; b++) {
                        if (grid[a][b] == 10) {
                            flashes++;
                            flasher(a, b);
                            grid[a][b] = 0;
                            
                        }
                    }
                }
                
            }
            if (flashes == 100) {
                System.out.println(i);
                break;
            } else {
                i++;
            }
            
            
            
        }
        
        

   }
   public static void increase(int j, int k) {
       if (j < 0 || k < 0 || j >= 10 || k >= 10) {
       } else {
           if (grid[j][k] == 0 || grid[j][k] == 10) {
           } else {
             grid[j][k]++;
        }
       }
   }

   
   public static void flasher(int j, int k) {
        increase(j-1, k-1);
        increase(j, k-1);
        increase(j+1, k-1);
        increase(j-1, k);
        increase(j-1, k+1);
        increase(j, k+1);
        increase(j+1, k);
        increase(j+1, k+1);
   }

   public static Boolean containsTen() {
       for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (grid[i][j] == 10) {
                    return true;
                }
            }
       }
       return false;
   }
}
