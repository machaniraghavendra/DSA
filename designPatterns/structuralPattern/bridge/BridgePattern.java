package designPatterns.structuralPattern.bridge;

/*
 * The Bridge Pattern is a structural design pattern that decouples an abstraction
 * from its implementation, allowing both to vary independently.
 * */
public interface BridgePattern {
     interface Device {
          void on();
          void off();
     }

     class TV implements Device {
          @Override
          public void on() {
               System.out.println("TV on");
          }
          @Override
          public void off() {
               System.out.println("TV off");
          }
     }

     class Radio implements Device {
          @Override
          public void on() {
               System.out.println("Radio on");
          }
          @Override
          public void off() {
               System.out.println("Radio off");
          }
     }

     abstract class RemoteControl {
          protected Device device;
          public RemoteControl(Device device) {
               this.device = device;
          }
          abstract void on();
          abstract void off();
     }

     class BasicRemote extends RemoteControl {
          public BasicRemote(Device device) {
               super(device);
          }
          @Override
          void on() {
               device.on();
          }
          @Override
          void off() {
               device.off();
          }

          void test(){

          }
     }

     static void main(String[] args) {
          Device device = new TV();
          RemoteControl remoteControl = new BasicRemote(device);
          remoteControl.on();
          remoteControl.off();
          Device device1 = new Radio();
          RemoteControl remoteControl1 = new BasicRemote(device1);
          remoteControl1.on();
          remoteControl1.off();
     }
}
