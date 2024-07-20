package Day1;
public class Player {

   private Thread thread;
   private boolean isRunning;
   private int speed;

   public Player() {
       speed = 0;
   }

   public void start() {
       isRunning = true;
       thread = new Thread(new Runnable() {
           @Override
           public void run() {
               while (isRunning) {
                   speed += 1;
                   System.out.println("Speed: " + speed);
                   try {
                       Thread.sleep(1000);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
               }
           }
       });
       thread.start();
   }

   public void stop() {
       isRunning = false;
   }

   public int getSpeed() {
       return speed;
   }
}