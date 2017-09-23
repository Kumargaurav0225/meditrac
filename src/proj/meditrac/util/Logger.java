package proj.meditrac.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.DateFormat;
import java.util.Date;

import proj.meditrac.core.ConfigurationManager;
import proj.meditrac.core.enums.Configuration;

final public class Logger {
    
    private final static File logFile = new File(ConfigurationManager.getInstance().getProperty(Configuration.LOG_FILE));
    private static String dateTime = DateFormat.getInstance().format(new Date());
    
    public static final String EXCEPTION = "EXC";
    public static final String ERROR = "ERR";
    public static final String INFO = "INF";
    public static final String SQL = "SQL";
    public static final String EXIT = "EXIT";
    
    public static final int PRINT_TO_CONSOLE = 0;
    public static final int APPEND_TO_FILE = 1;

    private static BufferedWriter writer;
    
    public static void logToConsole(Exception e,final int append){
        String log = e.getClass().getName() + " : " + e.getMessage();
        switch (append) {
            case Logger.APPEND_TO_FILE:
                System.out.println(dateTime+" | " + Logger.EXCEPTION + " -> " + log);
                logToFile(Logger.EXCEPTION,log);
                System.exit(0);
                break;
            default:
                System.out.println(dateTime+" | " + Logger.EXCEPTION + " -> " + log);
                break;
        }
        
    }
    
    public static void logToConsole(final String type,String log,final int append){
        if(append == Logger.APPEND_TO_FILE){
            System.out.println(dateTime+" | " + type + " -> " + log);
            logToFile(type,log);
        } else 
            System.out.println(dateTime+" | " + type + " -> " + log);
        
    }
   
    public static void logToFile(final String type,final String log){
        if(logFile.isFile()){
            try {
               writer = new BufferedWriter(new FileWriter(logFile,true));
               writer.newLine();
               writer.append(dateTime+" | " + type + " -> " +log);
               writer.close();
            } catch (Exception ex) {
                logToConsole(ex,Logger.PRINT_TO_CONSOLE);
            }
        } else {
            logToConsole(Logger.ERROR,"LOG FILE NOT FOUND, CREATING ONE ("+logFile.getAbsolutePath()+")",Logger.PRINT_TO_CONSOLE);
            try {
                logFile.createNewFile();
                logToFile(type,log);
            } catch (Exception ex) {
                logToConsole(ex,Logger.PRINT_TO_CONSOLE);
            }
        }
    }
    
}
