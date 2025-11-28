package arrays;

public class IsUnique {
     public static void main(String[] args) {
          System.out.println(isUnique(new int[]{1,2,3,4,5,6}));
     }

     public static boolean isUnique(int[] intArray) {
          boolean isUnique = true;
          for (int i = 0; i < intArray.length; i++) {
               for (int j = i+1; j < intArray.length; j++) {
                    if (intArray[i] == intArray[j]){
                         return false;
                    }
               }
          }
          return isUnique;
     }
}
