package designPatterns.structuralPattern.adapter;

/**
 * The Adapter Pattern is a structural design pattern that acts as a
 * bridge between two incompatible interfaces so that they can work together
 * ---------------------------------------------------------------------------
 * OCP (Open/Closed Principle): You add adapters without changing existing code.
 * SRP (Single Responsibility Principle): Adapter’s only job is translation between interfaces.
 * LSP (Liskov Substitution Principle): Clients can use adapter instead of real target without knowing.
 */
public interface AdapterPattern {
     class OldPaymentGatway {
          void makePayment(int amount) {
               System.out.println("Old payment :" + amount);
          }
     }

     interface PaymentGatway {
          void pay(int amount);
     }

     record NewPaymentAdapter(OldPaymentGatway oldPaymentGatway) implements PaymentGatway {
          @Override
          public void pay(int amount) {
               oldPaymentGatway.makePayment(amount);
          }
     }

     static void main(String[] args) {
          PaymentGatway newPaymentAdapter = new NewPaymentAdapter(new OldPaymentGatway());
          newPaymentAdapter.pay(10);
     }
}
