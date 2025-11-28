package designPatterns.structuralPattern.facade;

//The Facade Pattern provides a unified, simplified interface to a complex subsystem.
//Without facade → client has to deal with many classes directly.
//With facade → client only talks to one entry point, and the facade internally coordinates everything.
public interface Facade {
     class Amplifier {
          public void on() {
               System.out.println("Amplifier is ON");
          }

          public void setVolume(int level) {
               System.out.println("Volume set to " + level);
          }
     }

     class DvdPlayer {
          public void on() {
               System.out.println("DVD Player is ON");
          }

          public void play(String movie) {
               System.out.println("Playing movie: " + movie);
          }
     }

     class Projector {
          public void on() {
               System.out.println("Projector is ON");
          }

          public void wideScreenMode() {
               System.out.println("Projector in widescreen mode");
          }
     }

     class HomeTheaterFacade {
          private Amplifier amp;
          private DvdPlayer dvd;
          private Projector projector;

          public HomeTheaterFacade(Amplifier amp, DvdPlayer dvd, Projector projector) {
               this.amp = amp;
               this.dvd = dvd;
               this.projector = projector;
          }

          public void watchMovie(String movie) {
               System.out.println("Get ready to watch a movie...");
               amp.on();
               amp.setVolume(10);
               projector.on();
               projector.wideScreenMode();
               dvd.on();
               dvd.play(movie);
          }
     }

     public static void main(String[] args) {
          Amplifier amp = new Amplifier();
          DvdPlayer dvd = new DvdPlayer();
          Projector projector = new Projector();

          HomeTheaterFacade homeTheater = new HomeTheaterFacade(amp, dvd, projector);

          // Client interacts only with Facade
          homeTheater.watchMovie("Inception");
     }
}
