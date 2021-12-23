package ca.mcgill.ecse428.chiron;

import java.util.ArrayList;
import java.util.List;



import ca.mcgill.ecse428.chiron.model.*;


public class ChironApplication {

	private static BitcoinSystem bitcoinSystem;
	private static List<String> errormessages;
	private static boolean hasPatch;
	private static String activeTime;
	private static boolean isBackup;
	
    public static String getActiveTime() {
		return activeTime;
	}

	public static void setActiveTime(String aTime) {
		activeTime = aTime;
	}

	public static boolean isHasPatch() {
		return hasPatch;
	}

	public static void setHasPatch(boolean hasPatch) {
		ChironApplication.hasPatch = hasPatch;
	}

	public static List<String> getErrormessages() {
    	if(errormessages == null) {
    		errormessages = new ArrayList<String>();
    	}
		return errormessages;
	}
	
	public static boolean isBackup() {
		return isBackup;
	}
	
	public static void setIsBackup(boolean backupStatus) {
		ChironApplication.isBackup = backupStatus;
	}

	public static BitcoinSystem getBitcoinSystem() {
    	if(bitcoinSystem == null) {
    		bitcoinSystem = new BitcoinSystem();
    	}
		return bitcoinSystem;
	}
    
    public static boolean containError(String error) {
    	return getErrormessages().contains(error);
    }
    
    public static boolean addError(String error) {
    	return getErrormessages().add(error);
    }


	public static void main(String[] args) {
        //SpringApplication.run(ChironApplication.class, args);
    }


}
