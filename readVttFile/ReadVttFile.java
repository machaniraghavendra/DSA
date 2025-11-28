package readVttFile;

import java.io.*;
import java.util.Arrays;

public class ReadVttFile {
     public static void main(String[] args) {
          String vttContent = convertVttToText("readVttFile/files/sample.vvt", null);
          String vttData = "WEBVTT\n" +
               "\n" +
               "0:00:03.456 --> 0:00:09.582\n" +
               "Welcome to SimulTrans newest video,\n" +
               "\n" +
               "0:00:10.001 --> 0:00:11.032\n" +
               "Here, we'll discuss NOTE Add information about subtitle formats\n" +
               "\n" +
               "0:00:10.001 --> 0:00:11.032\n" +
               "Here, we'll discuss NOTE Add information about subtitle formats\n" +
               "\n" +
               "0:00:10.001 --> 0:00:11.032\n" +
               "Here, we'll discuss NOTE Add information about subtitle formats\n" +
               "\n" +
               "0:00:10.001 --> 0:00:11.032\n" +
               "Here, we'll discuss NOTE Add information about subtitle formats\n" +
               "\n" +
               "Note:\n" +
               "Here, we'll discuss NOTE Add information about subtitle formats";
          String vttContent1 = convertVttToText(null, vttData);
          System.out.println(vttContent);
          System.out.println(vttContent1);
     }

     private static String convertVttToText(String url, String vttData) {
          StringBuilder stringBuilder = new StringBuilder();
          if (url != null && !url.isEmpty()) {
               File file = new File(url);
               try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                    String newLine;
                    while ((newLine = reader.readLine()) != null) {
                         readLineAndAppend(newLine, stringBuilder);
                    }
               } catch (IOException e) {
                    System.out.println(e.getMessage());
                    return null;
               }
          } else if (vttData != null && !vttData.isEmpty()) {
               String[] newLines = vttData.split("\n");
               Arrays.stream(newLines).forEach(newLine -> readLineAndAppend(newLine, stringBuilder));
          }
          return stringBuilder.toString();
     }

     private static void readLineAndAppend(String newLine, StringBuilder stringBuilder) {
          if (newLine.equalsIgnoreCase("WEBVTT") || newLine.isEmpty()) {
               return;
          }
          if (newLine.matches("\\d:\\d{2}:\\d{2}.\\d{3} --> \\d:\\d{2}:\\d{2}.\\d{3}")) {
               return;
          }
          stringBuilder.append(newLine).append("\n");
     }
}
