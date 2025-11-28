package designPatterns.structuralPattern.composite;

import java.util.ArrayList;
import java.util.List;

// Composite pattern is a structural pattern which treats individual objects and groups uniformly.
public interface Composite {
     interface FileSystemComponent {
          void showDetails();
     }

     class File implements FileSystemComponent {
          private String name;

          public File(String name) {
               this.name = name;
          }

          @Override
          public void showDetails() {
               System.out.println("File : " + name);
          }
     }

     class Directory implements FileSystemComponent {
          private String name;
          private List<FileSystemComponent> fileSystemComponentList = new ArrayList<>();

          public Directory(String name) {
               this.name = name;
          }

          public void add(FileSystemComponent fileSystemComponent) {
               fileSystemComponentList.add(fileSystemComponent);
          }

          public void remove(FileSystemComponent fileSystemComponent) {
               fileSystemComponentList.remove(fileSystemComponent);
          }

          @Override
          public void showDetails() {
               System.out.println("Directory : " + name);
               for (FileSystemComponent fileSystemComponent : fileSystemComponentList) {
                    fileSystemComponent.showDetails();
               }
          }
     }

     static void main(String[] args) {
          FileSystemComponent fileSystemComponent = new File("Name.txt");
          FileSystemComponent fileSystemComponent1 = new File("Name.img");

          Directory directory = new Directory("Documents");
          directory.add(fileSystemComponent);
          directory.add(fileSystemComponent1);
          Directory directory1 = new Directory("Pictures");
          directory1.add(fileSystemComponent1);

          Directory root = new Directory("Root");
          root.add(directory);
          root.add(directory1);
          root.showDetails();
     }
}
