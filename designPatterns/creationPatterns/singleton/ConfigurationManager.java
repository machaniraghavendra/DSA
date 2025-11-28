package designPatterns.creationPatterns.singleton;

public class ConfigurationManager {
     private ConfigurationManager() {
     }

     private static class ConfigurationManagerHolder {
          private static final ConfigurationManager INSTANCE = new ConfigurationManager();
     }

     public static ConfigurationManager getInstance() {
          return ConfigurationManagerHolder.INSTANCE;
     }

     public String getSetting(String key) {
          return "Value of " + key;
     }
}

class ConfigManagerTest {
     public static void main(String[] args) {
          String value = ConfigurationManager.getInstance().getSetting("Key value");
          System.out.println(value);
     }
}
