package designPatterns.creationPatterns.protoType;

import java.util.ArrayList;
import java.util.List;

public interface Prototype {
     class Author implements Cloneable {
          private String name;

          public Author(String name) {
               this.name = name;
          }

          @Override
          public Author clone() throws CloneNotSupportedException {
               return (Author) super.clone();
          }

          @Override
          public String toString() {
               return "Author{" +
                    "name='" + name + '\'' +
                    '}';
          }
     }

     class Document implements Cloneable {
          String title;
          int version;
          List<String> pages;
          Author author;

          public Document(String title, int version, List<String> pages, Author author) {
               this.title = title;
               this.version = version;
               this.pages = pages;
               this.author = author;
          }

          // SHALLOW COPY
          @Override
          protected Document clone() throws CloneNotSupportedException {
               return (Document) super.clone(); // Copies only the top-level
          }

          // DEEP COPY
          public Document deepClone() throws CloneNotSupportedException {
               Document cloned = (Document) super.clone();

               // Deep copy mutable reference fields
               cloned.pages = new ArrayList<>(this.pages);
               cloned.author = this.author.clone();
               return cloned;
          }

          @Override
          public String toString() {
               return "Document{" +
                    "title='" + title + '\'' +
                    ", version=" + version +
                    ", pages=" + pages +
                    ", author=" + author +
                    '}';
          }
     }

     static void main(String[] args) throws CloneNotSupportedException {
          List<String> pages = new ArrayList<>();
          pages.add("Page 1 content");
          pages.add("Page 2 content");

          Author author = new Author("John Doe");
          Document original = new Document("Design Patterns", 1, pages, author);

          // Shallow copy
          Document shallowCopy = original.clone();

          // Deep copy
          Document deepCopy = original.deepClone();

          // Modify original
          original.pages.add("Page 3 content");
          original.author.name = "Jane Smith";

          System.out.println("Original: " + original);
          System.out.println("Shallow Copy: " + shallowCopy);
          System.out.println("Deep Copy: " + deepCopy);
     }
}
