package designPatterns.creationPatterns.abstractPattern;

//Satisfies the OPEN/CLOSED principle, Single responsibility principle, Dependency inversion principle
public interface AbstractPattern {
     interface ComputeInstance {
          void start();
     }

     interface StorageService {
          void store(String file);
     }

     class AWSComputeInstance implements ComputeInstance {
          public void start() {
               System.out.println("Started the AwsComputeInstance");
          }
     }

     class S3StorageService implements StorageService {
          @Override
          public void store(String file) {
               System.out.println("Storing the file in S3StorageService " + file);
          }
     }

     class AzureComputeInstance implements ComputeInstance {
          @Override
          public void start() {
               System.out.println("Started the AzureComputeInstance");
          }
     }

     class AzureBlobStorageService implements StorageService {
          @Override
          public void store(String file) {
               System.out.println("Storing the file in AzureBlobStorageService " + file);
          }
     }

     class GCPComputeInstance implements ComputeInstance {
          public void start() {
               System.out.println("Started the GCPComputeInstance");
          }
     }

     class GCPCloudStorage implements StorageService {
          @Override
          public void store(String file) {
               System.out.println("Storing the file in GCPCloudStorage " + file);
          }
     }

     interface CloudResourceFactory {
          ComputeInstance createCompute();

          StorageService createStorage();
     }

     enum CloudType {AZURE, AWS, GCP}

     record ResourceFactory(CloudType type) implements CloudResourceFactory {
          @Override
          public ComputeInstance createCompute() {
               return switch (type) {
                    case AWS -> new AWSComputeInstance();
                    case AZURE -> new AzureComputeInstance();
                    case GCP -> new GCPComputeInstance();
               };
          }

          @Override
          public StorageService createStorage() {
               return switch (type) {
                    case AWS -> new S3StorageService();
                    case AZURE -> new AzureBlobStorageService();
                    case GCP -> new GCPCloudStorage();
               };
          }
     }

     class CloudService {
          public void provideResource(String fileName, CloudResourceFactory cloudResourceFactory) {
               ComputeInstance computeInstance = cloudResourceFactory.createCompute();
               StorageService storageService = cloudResourceFactory.createStorage();
               computeInstance.start();
               storageService.store(fileName);
          }
     }

     static void main(String[] args) {
          CloudService cloudService = new CloudService();
          cloudService.provideResource("Testing file", new ResourceFactory(CloudType.AWS));
          cloudService.provideResource("Testing file", new ResourceFactory(CloudType.AZURE));
          cloudService.provideResource("Testing file", new ResourceFactory(CloudType.GCP));
     }
}

