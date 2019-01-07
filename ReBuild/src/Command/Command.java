package Command;

/**
 *
 * @author vang
 */
public abstract class Command {
    private static Command currentCommand,previousCommand;
    public abstract void excute();
    public static void setCurrentCommand(Command command){ currentCommand = command; }
    public static void setPreviousCommand(Command command){ previousCommand = command;}
    public static Command getCurrentCommand(){ return currentCommand; }
    
    public static void resetCurrentCommand(){
        previousCommand = currentCommand;
        currentCommand = null;
    }
}
