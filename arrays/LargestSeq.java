package arrays;

import java.util.*;

public class LargestSeq {
     public static void main(String[] args) {
          String s = "abefabcddefjkdkmanr";
          System.out.println(printLargestSeq(s));
          System.out.println(printLargestSeqUsingHashMap(s));
     }

     private static String printLargestSeqUsingHashMap(String s) {
          var seqMap = new HashMap<Integer, String>();
          StringBuilder s1 = new StringBuilder();
          for (int i = 0; i < s.length(); i++) {
               if (s1.toString().contains(String.valueOf(s.charAt(i)))) {
                    if (s1.length() >= (seqMap.keySet().iterator().hasNext() ? seqMap.keySet().iterator().next() : 0)) {
                         seqMap.clear();
                         seqMap.put(s1.toString().length(), s1.toString());
                         s1 = new StringBuilder();
                    }
               }
               s1.append(s.charAt(i));
               seqMap.replace(s1.length(), s1.toString());
          }
          return seqMap.getOrDefault(seqMap.keySet().iterator().hasNext() ? seqMap.keySet().iterator().next() : 0, null);
//          return seqMap;
     }

     private static String printLargestSeq(String s) {
          String largestSeq = "";
          var seqSet = new TreeSet<String>();
          for (int i = 0; i < s.length(); i++) {
               if (largestSeq.length() <= seqSet.size()) {
                    if (seqSet.contains(String.valueOf(s.charAt(i)))) {
                         largestSeq = String.join("", seqSet);
                         seqSet.clear();
                    }
               }
               seqSet.add(String.valueOf(s.charAt(i)));
               if (largestSeq.length() <= seqSet.size()){
                    largestSeq = String.join("", seqSet);
               }
          }
          return largestSeq;
     }
}
