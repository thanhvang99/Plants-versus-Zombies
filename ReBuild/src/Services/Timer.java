package Services;

public class Timer {
    private int timeOut;
    private long startTime;
    private long endTime;
    private double delta;
    
    public Timer(int timeOut){
        this.timeOut = timeOut;
        
        clock();
    }
    
    public void clock(){
        startTime = System.currentTimeMillis();
    }
    
    
    public boolean isTimeOut() {
        endTime = System.currentTimeMillis();
        delta += (endTime - startTime);
        startTime = endTime;
        if( delta >= timeOut ){
            delta = 0;
            return true;
        }
        return false;
        
    }
    public void setTimeOut(int timeOut){
        this.timeOut = timeOut;
    }
}   
