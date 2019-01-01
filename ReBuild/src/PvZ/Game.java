package PvZ;

public class Game  implements Runnable {
    private Application application;
    private Thread thread;
    private boolean isRunning;
    
    public Game(Application application){
        this.application = application;
    }
    
    public synchronized void start(){
        isRunning = true;
        thread = new Thread(this);
        
        GUI.getInstance().setUp();
        thread.start();
    }
    public synchronized void stop(){
        isRunning = false;
        try{
            thread.join();
        
        }catch(InterruptedException ex){
            ex.printStackTrace();
        }
    }
    @Override
    public void run(){
        
        int fps = 60;       // Frame per second
        double delta = 0;
        double timePerTick = 1_000_000_000 / fps;
        long endTime;
        long startTime = System.nanoTime();
        while(isRunning){
            endTime = System.nanoTime();
            delta += (endTime - startTime)/ timePerTick;
            startTime = endTime;
            if( delta >= 1 ){
                application.tick();
                application.render();
                delta = 0;
            }
        }
        stop();
    
    }
    


}
