package designPatterns.structuralPattern.decorator;

//The Decorator Pattern allows you to add new behavior to an object
// dynamically at runtime without changing its class.
public interface Decorator {
     interface Coffee {
          String getDesc();

          int cost();
     }

     class SimpleCoffee implements Coffee {
          @Override
          public String getDesc() {
               return "Coffee";
          }

          @Override
          public int cost() {
               return 10;
          }
     }

     abstract class CoffeeDecorator implements Coffee {
          Coffee coffee;

          public CoffeeDecorator(Coffee coffee) {
               this.coffee = coffee;
          }

          @Override
          public String getDesc() {
               return coffee.getDesc();
          }

          @Override
          public int cost() {
               return coffee.cost();
          }
     }

     class MilkCoffee extends CoffeeDecorator {

          public MilkCoffee(Coffee coffee) {
               super(coffee);
          }

          @Override
          public String getDesc() {
               return super.getDesc() + ", Milk";
          }

          public int cost() {
               return super.cost() + 10;
          }
     }

     public static void main(String[] args) {
          Coffee coffee = new SimpleCoffee();
          System.out.println(coffee.getDesc() + "Cost" + coffee.cost());
          coffee = new MilkCoffee(coffee);
          System.out.println(coffee.getDesc() + "Cost" + coffee.cost());
     }
}
