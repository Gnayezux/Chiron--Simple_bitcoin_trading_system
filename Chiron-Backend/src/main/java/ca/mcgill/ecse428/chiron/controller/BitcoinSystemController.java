package ca.mcgill.ecse428.chiron.controller;
import java.util.List;

import ca.mcgill.ecse428.chiron.ChironApplication;
import ca.mcgill.ecse428.chiron.model.*;


public class BitcoinSystemController {
	
	public static void addNewUser(String id, String passcode, String email) {
		BitcoinSystem bitcoinSystem = ChironApplication.getBitcoinSystem();
		if(hasUser(id)) {
			ChironApplication.addError("email already registered");
			return;
		}
		bitcoinSystem.addUser(id, 0, 0, email, 0, passcode, "Normal", "Bronze");
	}
	
	public static void addNewUserWithCredit(String id, String userstatus, String creditlevel) {
		BitcoinSystem bitcoinSystem = ChironApplication.getBitcoinSystem();
		if(hasUser(id)) {
			ChironApplication.addError("email already registered");
			return;
		}
		bitcoinSystem.addUser(id, 0, 0, "dontcare", 0, "dontcare", userstatus, creditlevel);
	}
	
	public static User getUserWithId(String id) {
		BitcoinSystem bitcoinSystem = ChironApplication.getBitcoinSystem();
		List<User> users = bitcoinSystem.getUsers();
		for(int i=0; i<users.size(); i++) {
			if(id.equals(users.get(i).getId())) {
				return users.get(i);
			}
		}
		return null;
	}
	
	public static boolean hasUser(String id) {
		BitcoinSystem bitcoinSystem = ChironApplication.getBitcoinSystem();
		List<User> users = bitcoinSystem.getUsers();
		for(int i=0; i<users.size(); i++) {
			if(id.equals(users.get(i).getId())) {
				return true;
			}
		}
		return false;
	}
	
	public static void addManager(String id, String passcode, String email) {
		BitcoinSystem bitcoinSystem = ChironApplication.getBitcoinSystem();
		if(hasUser(id)) {
			ChironApplication.addError("email already registered");

		}
	}

	public static void createAd(String id, String adId, Double amount, Double price, String currency) {
		BitcoinSystem bitcoinSystem = ChironApplication.getBitcoinSystem();
		User a = getUserWithId(id);
		if(amount<=0 || price<=0) {
			ChironApplication.addError("must be larger then zero");
			return;
		}
		a.addAdvertisement(adId, "dontcare", "dontcare", currency, "dontcare", "dontcare", price, "dontcare", 0.0001, amount, bitcoinSystem);
		//a.addAdvertisement(adId, aAdType, aRate, aCurrency, aPaymentMethod, aAdStatus, aPrice, aCreateTime, aMin, aMax, aBitcoinSystem);

	}

	public static void setPasscode(String string) {
		// TODO Auto-generated method stub
		
	}



	public static void cancelAd(String string) {
		// TODO Auto-generated method stub
		
	}

	public static Short getAdWithId(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	public static void setAdStatus(String string) {
		// TODO Auto-generated method stub
		
	}

	public static void setAdStatus(String id, String string) {
		// TODO Auto-generated method stub
		
	}

	public static void removeUser(User user) {
		// TODO Auto-generated method stub
		
	}

	public static void setFeedbackScore(double i, User user) {
		// TODO Auto-generated method stub
		
	}

	public static void lockUser(String string, boolean b) {
		// TODO Auto-generated method stub
		
	}

	public static void addNewAdvertisement(String advertisementID, String coinNumber, String pricePerBit) {
		// TODO Auto-generated method stub
		
	}

	public static void enterId(double bitcoinAmount) {
		// TODO Auto-generated method stub
		
	}

	public static void setEmail(String string) {
		// TODO Auto-generated method stub
		
	}

	public static void tryToCreateAd(Integer int1, Integer int2, String string) {
		// TODO Auto-generated method stub
		
	}

	public static void removeUser(String string) {
		// TODO Auto-generated method stub
		
	}

	public static void addNewUserWithCredit(String user_name, String userstatus, String creditlevel, String password,
			String email) {
		// TODO Auto-generated method stub
		
	}

	public static void changePassword(String string, String string2) {
		// TODO Auto-generated method stub
		
	}

	public static void requestEmailChange(String string, String string2) {
		// TODO Auto-generated method stub
		
	}

	public static void requestPasscodeChange(String string, String string2) {
		// TODO Auto-generated method stub
		
	}

	public static void addNewManager(String string, String string2, String string3) {
		// TODO Auto-generated method stub
		
	}

	public static void completeTrade(String string) {
		// TODO Auto-generated method stub
		
	}

	public static void declineTrade(String string) {
		// TODO Auto-generated method stub
		
	}

	public static void changeUserCredit(String string, String string2) {
		// TODO Auto-generated method stub
		
	}

	public static void requestUser(String id) {
		// TODO Auto-generated method stub
		
	}

	public static void sendBitcoin(String string2, Integer int1) {
		// TODO Auto-generated method stub
		
	}


}
