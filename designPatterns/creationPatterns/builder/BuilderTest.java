package designPatterns.creationPatterns.builder;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.concurrent.Semaphore;

 class BuilderTest {
     Semaphore semaphore = new Semaphore(1);
     private final String name;
     private final int count;
     private final int score;

     private BuilderTest(Builder builder) {
          this.name = builder.name;
          this.count = builder.count;
          this.score = builder.score;
     }

     public static Builder builder() {
          return new Builder();
     }

     public static class Builder {
          private String name;
          private int count;
          private int score;

          public Builder name(String name) {
               this.name = name;
               return this;
          }

          public Builder count(int count) {
               this.count = count;
               return this;
          }

          public Builder score(int score) {
               this.score = score;
               return this;
          }

          public BuilderTest build() {
               return new BuilderTest(this);
          }
     }

     @Override
     public String toString() {
          return "{" +
               "name='" + name + '\'' +
               ", count=" + count +
               ", score=" + score +
               '}';
     }
}

@TestAnnotation(name = "Hello")
class Builder {
     public static void main(String[] args) {
          BuilderTest builderTest = BuilderTest.builder().name("name").count(1).score(1).build();
          System.out.println(builderTest);
     }
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface TestAnnotation{
      String name();
}
