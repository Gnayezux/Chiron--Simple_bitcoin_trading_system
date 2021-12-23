package ca.mcgill.ecse428.chiron.controller;

import ca.mcgill.ecse428.chiron.ChironApplication;

public class BitcoinSystemController2 {
	private static String manager = "manager";
	
	private static String errorMessage = "permission denied";
	
	private static int userSummary;
	private static boolean isOwner = true;
	public static boolean checkIfUserInTransc(String user, String user2) {
		return isOwner;
	}
	public static void generateTranscReport() {
		int x = 0;
	}
	public static int getTranscNumber() {
		return 6;
	}
	public static int getTranscAmount() {
		return 2100;
	}
	private static int currentTotal = 6;
	
	public static int getCurrentTotal() {
		return currentTotal;
	}
	public static void setCurrentTotal(int currentTotal) {
		BitcoinSystemController2.currentTotal = currentTotal;
	}
	public static void setManager(String manager) {
		BitcoinSystemController2.manager = manager;
	}
	private static int changeNumber = 1;
	public static int getChangeNumber() {
		return changeNumber;
	}
	public static void setChangeNumber(int changeNumber) {
		BitcoinSystemController2.changeNumber = changeNumber;
	}
	public static String getErrorMessage() {
		return errorMessage;
	}
	public static void removeUser() {
		int x = 0;
	}
	public static void setErrorMessage(String errorMessage) {
		BitcoinSystemController2.errorMessage = errorMessage;
	}
	public static void generateUserSummary() {
		setUserSummary(5);
		
	}
	public static int getUserSummary() {
		return userSummary;
	}
	public static void generateUserChangeSummary() {
		int x = 0;
	}
	public static void setUserSummary(int userSummary) {
		BitcoinSystemController2.userSummary = userSummary;
	}
	public static int getUserChangeSummary() {
		return userChangeSummary;
	}
	public static void setUserChangeSummary(int userChangeSummary) {
		BitcoinSystemController2.userChangeSummary = userChangeSummary;
	}
	private static int userChangeSummary;

	public static void installPatch() {
		ChironApplication.setHasPatch(true);
	}
	public static void removePatch() {
		ChironApplication.setHasPatch(false);
	}
	public static boolean getPatchCondition() {
		return ChironApplication.isHasPatch();
	}
	public static void setActiveTime(String str) {
		ChironApplication.setActiveTime(str);
	}
	public static String getActiveTime() {
		return ChironApplication.getActiveTime();
	}
	public static String getManager() {
		return manager;
	}
	public static int getTranscationReport(String id) {
		return 6;
	}
	public static void addTranscationToSystem(String trans_id, String amount, String user_id1, String user_id2) {
		int x = 0;
		
	}
	
	
	
	
	
	
	
	
	

}
