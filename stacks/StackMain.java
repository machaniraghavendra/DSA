package stacks;

import java.util.Arrays;

public class StackMain {
     public static void main(String... args) {

          Stacks<Integer> stacks = new Stacks<>();

          stacks.push(9);

          stacks.push(11);

          stacks.push(12);

          stacks.push(13);

          stacks.getPeek();

          stacks.pop();

          stacks.isEmpty(false);

          stacks.pop();

          stacks.pop();

          stacks.push(12);

          stacks.pop();

          stacks.pop();

          stacks.pop();
     }
}
