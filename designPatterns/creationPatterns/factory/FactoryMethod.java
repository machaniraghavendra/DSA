package designPatterns.creationPatterns.factory;

//Satisfies the OPEN/CLOSED principle
public interface FactoryMethod {
     interface Notification {
          void notifyUser();
     }

     abstract class NotificationFactory {
          abstract Notification createNotification(String message);
     }

     record EmailNotification(String message) implements Notification {
          @Override
          public void notifyUser() {
               System.out.println("Sending email notification: " + message);
          }
     }

     class EmailNotificationFactory extends NotificationFactory {
          @Override
          public Notification createNotification(String message) {
               return new EmailNotification(message);
          }
     }

     record PushNotification(String message) implements Notification {
          @Override
          public void notifyUser() {
               System.out.println("Sending message from push : " + message);
          }
     }

     class PushNotificationFactory extends NotificationFactory {
          @Override
          public Notification createNotification(String message) {
               return new PushNotification(message);
          }
     }

     class NotificationService {
          public void sendNotification(String message, NotificationFactory notificationFactory) {
               Notification notification = notificationFactory.createNotification(message);
               notification.notifyUser();
          }
     }

     static void main(String[] args) {
          NotificationService notificationService = new NotificationService();
          notificationService.sendNotification("Hello Raghu", new FactoryMethod.EmailNotificationFactory());
          notificationService.sendNotification("Hello Raghu", new FactoryMethod.PushNotificationFactory());
     }
}