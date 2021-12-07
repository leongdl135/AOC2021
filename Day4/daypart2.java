import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner; 
import java.util.ArrayList;
import java.util.Arrays;


public class daypart2 {
   public static void main(String[] args) throws FileNotFoundException {
      ArrayList<String[][]> game = new ArrayList<>();
      ArrayList<Integer> counter = new ArrayList<>(); 
      Scanner scanner = new Scanner(new File("input.txt"));
      String firstLine = scanner.nextLine();
      String[] numberOrder = firstLine.split(",");
      int count = 0;
      int count2 = 0;

      while(true) {
         if (count2 == 100) {
            break;
         } else if (count == 0) {
            String temp = scanner.nextLine();
            count++;
         } else {
            String[][] arrays = new String[5][];
            for(int i = 0; i < 5; i++) {
               String nums = scanner.nextLine();
               String[] temp = nums.trim().split("\\s+");
               arrays[i] = temp;
            }
            game.add(arrays);
            count = 0;
            count2++;
         }

           
      }
      Boolean cont = true;
      
      for(int i = 0; i < numberOrder.length && cont; i++) {
         String checker = numberOrder[i];
         for(int j = 0; j < 100; j++) {
            if(!counter.contains(j)) {
               String[][] board = game.get(j);
               for(int x = 0; x < 5; x++) {
                  for (int y = 0; y < 5; y++) {
                     if(board[x][y].equals(checker)) {
                        board[x][y] = "X";
                     }
                  }
               }
               if(winner(board)) {
                  if (counter.size() < 99) {
                     counter.add(j);
                  } else {
                     System.out.println(Arrays.deepToString(board));
                     System.out.println(sumArray(board));
                     System.out.println(Integer.valueOf(checker));
                     cont = false;
               }
            }
            }
            
              
            }
         }
      // for(int i = 0; i < numberOrder.length && cont; i++) {
      //    String checker = numberOrder[i];
      //    String[][] board = game.get(39);
      //    for(int x = 0; x < 5; x++) {
      //       for (int y = 0; y < 5; y++) {
      //          if(board[x][y].equals(checker)) {
      //             board[x][y] = "X";
      //          }
      //       }
      //    }
      //    System.out.println(Arrays.deepToString(board));
      //    if(winner(board)) {
      //       System.out.println(sumArray(board));
      //       System.out.println(Integer.valueOf(checker));
      //    }
      // }
   }
      

   
   
      

   public static Boolean winner(String[][] board) {
      Boolean truthy = true;
      for(int i = 0; i < 5; i++) {
         truthy = true;
         for(int j = 0; j < 5; j++) {
            truthy = truthy && board[i][j].equals("X");
         }
         if(truthy) {
            return true;
         }
      }
      
      for(int i = 0; i < 5; i++) {
         truthy = true;
         for(int j = 0; j < 5; j++) {
            truthy = truthy && board[j][i].equals("X");
         }
         if(truthy) {
            return true;
         }
      }
      return false;
   }
   
   public static int sumArray(String[][] board) {
      int total = 0;
      for(int i = 0; i < 5; i++) {
         for(int j = 0; j < 5; j++) {
            if (board[i][j].equals("X")) {
            } else {
               total = total + Integer.valueOf(board[i][j]);
            }
         }
      }
      return total;
   }
      
} 
