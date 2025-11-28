package arrays;

public class SearchInArray {
     public static void main(String[] args) {
          System.out.println(searchInArray(new int[]{1,2,3,4,5,6}, 2));
     }

     private static int searchInArray(int[] intArray, int valueToSearch) {
          for (int i = 0; i < intArray.length; i++) {
               if (intArray[i] == valueToSearch){
                    return i;
               }
          }
          return 0;
     }
}
