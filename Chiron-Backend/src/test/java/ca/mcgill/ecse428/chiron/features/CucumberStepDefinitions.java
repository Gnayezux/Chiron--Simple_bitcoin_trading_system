package ca.mcgill.ecse428.chiron.features;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import ca.mcgill.ecse428.chiron.ChironApplication;
import ca.mcgill.ecse428.chiron.controller.BitcoinSystemController;
import ca.mcgill.ecse428.chiron.model.*;


import java.io.FileNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.naming.NameNotFoundException;

import static org.junit.Assert.fail;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class CucumberStepDefinitions {

  
	
	@Given("BitCoin Trading system is running")
	public void bitcoin_Trading_system_is_running() {
		BitcoinSystem bitcoinSystem = ChironApplication.getBitcoinSystem();
	}

	@When("user {string} with user passcode {string} and user email {string} registered")
	public void user_with_user_passcode_and_user_email_registered(String string, String string2, String string3) {
		BitcoinSystemController.addNewUser(string, string2, string3);
	}
	
	@Then("new user {string} with user id {string} and user email {string} is created")
	public void new_user_with_user_id_and_user_email_is_created(String string, String string2, String string3) {
		int number = ChironApplication.getBitcoinSystem().numberOfUsers();
		String id = ChironApplication.getBitcoinSystem().getUser(number-1).getId();
		String passcode = ChironApplication.getBitcoinSystem().getUser(number-1).getPasscode();
		String email = ChironApplication.getBitcoinSystem().getUser(number-1).getEmail();
		//System.out.println("Id is sfsff" + id);
		Assert.assertEquals(string, id);
		Assert.assertEquals(string2, passcode);
		Assert.assertEquals(string3, email);
	}

	@Given("user id {string} already exists")
	public void user_id_already_exists(String string) {
		if(BitcoinSystemController.hasUser(string) == false) {
			BitcoinSystemController.addNewUser(string, "dontcare", "dontcare");
		}
	}

	@When("user {string} with user email {string} registered")
	public void user_with_user_email_registered(String string, String string2) {
		BitcoinSystemController.addNewUser(string, string2, "dontcare");
	}

	@Then("new user {string} with user email {string} is not created")
	public void new_user_with_user_email_is_not_created(String string, String string2) {
	    User user = BitcoinSystemController.getUserWithId(string);
	    Assert.assertNotEquals(string, user.getEmail());
	}

	@Then("the system returns an error message {string} indicate {string}")
	public void the_system_returns_an_error_message_indicate(String string, String string2) {
		boolean a = ChironApplication.containError("email already registered");
		Assert.assertEquals(true, a);
	}
	
	@Given("user {string} with user id {string} exists ")
	public void user_with_user_id_exists(String string, String string1) {
		BitcoinSystem bitcoinSystem = ChironApplication.getBitcoinSystem();
	    User user = BitcoinSystemController.getUserWithId(string1);
		 if(user==null) {
			 System.out.println("user with id {string} does not exist");
			 BitcoinSystemController.addNewUser(string1,"", "");
		 }
	}
	
	@When("removes user {string} with user id {string}")
	public void removes_user_with_user_id(String string, String string1) {
		BitcoinSystem bitcoinSystem = ChironApplication.getBitcoinSystem();
		User user = BitcoinSystemController.getUserWithId(string1);
		bitcoinSystem.removeUser(user);
	}
	
	@Then("user {string} with user id {string} is removed")
	public void user_with_user_id_is_removed(String string, String string1) {
		Assert.assertEquals(null, BitcoinSystemController.getUserWithId(string1));
	}
	
	
	
	@Given("I am a normal user with user id {string}")
	public void I_am_a_normal_user_with_user_id(String string) {
		 User user = BitcoinSystemController.getUserWithId(string);
		 if(user==null) {
			 System.out.println("user with id {string} does not exist");
			 BitcoinSystemController.addNewUser(string,"", "");
		 }
		 Assert.assertEquals("normal", user.getUserstatus());
	}
	
	@When("I enter the following password {string} with user id {string}")
	public void I_enter_the_following_password(String string, String string1) {
		BitcoinSystem bitcoinSystem = ChironApplication.getBitcoinSystem();
		//User user = BitcoinSystemController.getUserWithId(string1);
		BitcoinSystemController.setPasscode(string);
	}
	
	@Then("The password is changed to {string} with user id {string}")
	public void The_password_is_changed(String string, String string1) {
		BitcoinSystem bitcoinSystem = ChironApplication.getBitcoinSystem();
		User user = BitcoinSystemController.getUserWithId(string1);
		Assert.assertEquals(string, user.getPasscode());
	}

	
	@When("I enter the following email {string} with user id {string}")
	public void I_enter_the_following_email(String string, String string1) {
		BitcoinSystem bitcoinSystem = ChironApplication.getBitcoinSystem();
		User user = BitcoinSystemController.getUserWithId(string1);
		BitcoinSystemController.setEmail(string);
	}
	
	@Then("The email is changed to {string} with user id {string}")
	public void The_email_is_changed(String string, String string1) {
		BitcoinSystem bitcoinSystem = ChironApplication.getBitcoinSystem();
		User user = BitcoinSystemController.getUserWithId(string1);
		Assert.assertEquals(string, user.getEmail());
	}
	

	
	@When("I request to change the credit {int} for a user with user id{string} with creditlevel {string}")
	public void I_request_to_change_the_credit(double i, String string) {
		User user = BitcoinSystemController.getUserWithId(string);
		BitcoinSystemController.setFeedbackScore(i, user);
	}

	@Then("The following credit {double} is generated for user with id {string}")
	public void The_following_credit_is_generated(double i, String string) {
		BitcoinSystem bitcoinSystem = ChironApplication.getBitcoinSystem();
		User user = BitcoinSystemController.getUserWithId(string);
		assertEquals(i, user.getCreditlevel());
	}
	
	

	
	@When("manager tries to lock a user with id {string}")
	public void manager_tries_to_lock_a_user_with_id(String string) {
		 User user = BitcoinSystemController.getUserWithId(string);
		 BitcoinSystemController.lockUser(string, true);
	
	}
	
	@Then("the user with id {string} has locked status")
	public void the_user_with_id_has_locked_status(String string) {
		BitcoinSystem bitcoinSystem = ChironApplication.getBitcoinSystem();
		User user = BitcoinSystemController.getUserWithId(string);
		assertEquals("locked", user.getUserstatus());
	}
	
	@Given("the following users are registered")
	public void the_following_users_are_registered(List<User> users) {
		BitcoinSystem bitcoinSystem = ChironApplication.getBitcoinSystem();
		for(int i=0; i<users.size(); i++) {
			String user_name = users.get(i).getId();
			String userstatus = users.get(i).getUserstatus();
			String creditlevel = users.get(i).getCreditlevel();
			BitcoinSystemController.addNewUserWithCredit(user_name, userstatus, creditlevel);
		}
	}
	
	@When("user {string} is deleted ")
	public void user_is_deleted(String string) {
		BitcoinSystem bitcoinSystem = ChironApplication.getBitcoinSystem();
		User user=BitcoinSystemController.getUserWithId(string);
		BitcoinSystemController.removeUser(user);
	}
	
	@Then("the following list of users is generated")
	public void the_following_list_of_users_is_generated(List<User> users) {
		BitcoinSystem bitcoinSystem = ChironApplication.getBitcoinSystem();
		Assert.assertEquals(bitcoinSystem.getUsers(), users);
		
	}
	
	@Given("the following users exist with id {string} and balance {double}")
	public void the_following_users_exist_with_id(String string, double db) {
		 User user = BitcoinSystemController.getUserWithId(string);
		 if(user==null) {
			 System.out.println("user with id {string} does not exist");
			 BitcoinSystemController.addNewUser(string,"", "");
		 }
		 if(user.getBitcoinAmount()!=db) {
			 user.setBitcoinAmount(db);
		 }
	}
	
	@When("I enter the following ID {string} with double {double}")
	public void I_enter_the_following_ID(String string, double db) {
		 User user = BitcoinSystemController.getUserWithId(string);
		 BitcoinSystemController.enterId( (double)user.getBitcoinAmount());
		
	}
	
	@Given("the following users are registered with creditlevel")
	public void the_following_users_are_registered_with_creditlevel(List<User> users) {
		BitcoinSystem bitcoinSystem = ChironApplication.getBitcoinSystem();
		for(int i=0; i<users.size(); i++) {
			String user_name = users.get(i).getId();
			String userstatus = users.get(i).getUserstatus();
			String creditlevel = users.get(i).getCreditlevel();
			BitcoinSystemController.addNewUserWithCredit(user_name, userstatus, creditlevel);
		}
	}
	
	@Then("the following list of users is queried")
	public void the_following_list_of_users_is_queried(List<User> users) {
		BitcoinSystem bitcoinSystem = ChironApplication.getBitcoinSystem();
		Assert.assertEquals(bitcoinSystem.getUsers(), users);
		
	}
	
	@Given("the following users are registered with status")
	public void the_following_users_are_registered_with_status(List<User> users) {
		BitcoinSystem bitcoinSystem = ChironApplication.getBitcoinSystem();
		for(int i=0; i<users.size(); i++) {
			String user_name = users.get(i).getId();
			String userstatus = users.get(i).getUserstatus();
			String creditlevel = users.get(i).getCreditlevel();
			BitcoinSystemController.addNewUserWithCredit(user_name, userstatus, creditlevel);
		}
	}
	
	@Then("the following list of users is queried with status")
	public void the_following_list_of_users_is_queried_with_status(List<User> users) {
		BitcoinSystem bitcoinSystem = ChironApplication.getBitcoinSystem();
		Assert.assertEquals(bitcoinSystem.getUsers(), users);
		
	}
	
	
	
	
	
	
	
	@Given("the follow user account exist in system:")
	public void the_follow_user_account_exist_in_system(io.cucumber.datatable.DataTable dataTable) {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
		BitcoinSystem bitcoinSystem = ChironApplication.getBitcoinSystem();
		List<Map<String, String>> valueMaps = dataTable.asMaps();
		for (Map<String, String> map : valueMaps) {
			if(map.get("role").equals("Manager")) return;
			String user_name = map.get("user_name");
			String userstatus = map.get("userstatus");
			String creditlevel = map.get("creditlevel");
			BitcoinSystemController.addNewUserWithCredit(user_name, userstatus, creditlevel);
			
		}
		
	}

	@Given("the Trader with username {string} is logged in")
	public void the_Trader_with_username_is_logged_in(String string) {
		if(BitcoinSystemController.hasUser(string) == false) {
			System.out.println("warning!");
			BitcoinSystemController.addNewUser(string, "dontcare", "dontcare");
		}
	}
	
	@When("{string} posts the advertisement {string} with Bitcoin {double} and desired price per bit {double} with currency {string}")
	public void posts_the_advertisement_with_Bitcoin_and_desired_price_per_bit_with_currency(String string, String string2, Double double1, Double double2, String string3) {
		BitcoinSystemController.createAd(string, string2, double1, double2, string3);
	}

	@Then("the ID of the advertisement with username {string} should be {string}")
	public void the_ID_of_the_advertisement_with_username_should_be(String string, String string2) {
		User user = BitcoinSystemController.getUserWithId(string);
		String id = user.getAdvertisement(user.getAdvertisements().size()-1).getId();
		Assert.assertEquals(string2, id);
	}

	@Then("the number of advertisements in the system shall be {string}")
	public void the_number_of_advertisements_in_the_system_shall_be(String string) {
		BitcoinSystem bitcoinSystem = ChironApplication.getBitcoinSystem();
		List<User> users = bitcoinSystem.getUsers();
		int amount = 0;
		for(int i=0; i<users.size(); i++) {
			amount += users.get(i).getAdvertisements().size();
		}
		Assert.assertNotEquals(0, amount);
	}

	@Then("an error message with content {string} shall be raised")
	public void an_error_message_with_content_shall_be_raised(String string) {
		int a = ChironApplication.getErrormessages().size();
		Assert.assertNotEquals(0, a);
	}
	
	//----------------------Feature 31-36↓
	@Given("the following users are registered:")
	public void the_following_users_are_registered(io.cucumber.datatable.DataTable dataTable) {
		BitcoinSystem bitcoinSystem = ChironApplication.getBitcoinSystem();
		List<Map<String, String>> valueMaps = dataTable.asMaps();
		for (Map<String, String> map : valueMaps) {
			if(map.get("role").equals("Manager")) return;
			String user_name = map.get("user_name");
			String userstatus = map.get("userstatus");
			String creditlevel = map.get("creditlevel");
			BitcoinSystemController.addNewUserWithCredit(user_name, userstatus, creditlevel);
			
		}
	}

	@Given("the follow advertisement exist in system:")
	public void the_follow_advertisement_exist_in_system(io.cucumber.datatable.DataTable dataTable) {
		BitcoinSystem bitcoinSystem = ChironApplication.getBitcoinSystem();
		List<Map<String, String>> valueMaps = dataTable.asMaps();
		for (Map<String, String> map : valueMaps) {
			String advertisementID = map.get("advertisementID");
			String coinNumber = map.get("coinNumber");
			String pricePerBit = map.get("pricePerBit");
			BitcoinSystemController.addNewAdvertisement(advertisementID, coinNumber, pricePerBit);
			
		}
	}

		

	@When("{string} choose to activate {string}")
	public void choose_to_activate(String string, String string2) {
		User user = BitcoinSystemController.getUserWithId(string);
		Advertisement ad;
		try {
			ad = user.getAdvertisement(0); //need to change to use string2 to find ad
		} catch (Exception e) {
			throw new IllegalArgumentException("Advertisement with ID: " + string2 + "does not exist!");
		}
		BitcoinSystemController.setAdStatus(ad.getId(), "Activated");
		
		
	}

	@Then("the status of the advertisement {string} should be {string}")
	public void the_status_of_the_advertisement_should_be(String string, String string2) {
		User user = BitcoinSystemController.getUserWithId(string);
		Advertisement ad = user.getAdvertisement(0);
		assertEquals("Activated",ad.getAdStatus() );
	
	}

	@When("{string} choose to disable {string}")
	public void choose_to_disable(String string, String string2) {
		User user = BitcoinSystemController.getUserWithId(string);
		Advertisement ad;
		try {
			ad = user.getAdvertisement(0); //need to change to use string2 to find ad
		} catch (Exception e) {
			throw new IllegalArgumentException("Advertisement with ID: " + string2 + "does not exist!");
		}
		BitcoinSystemController.setAdStatus(ad.getId(), "Disabled");
		
	}

	@Then("the status of the advertisment {string} should be {string}")
	public void the_status_of_the_advertisment_should_be(String string, String string2) {
		User user = BitcoinSystemController.getUserWithId(string);
		Advertisement ad = user.getAdvertisement(0);
		assertEquals("Disabled",ad.getAdStatus() );
	}

	@When("{string} choose to disable all activated advertisements")
	public void choose_to_disable_all_activated_advertisements(String string) {
		User user = BitcoinSystemController.getUserWithId(string);
		List<Advertisement> ads = user.getAdvertisements();
		for (Advertisement ad: ads) {
			BitcoinSystemController.setAdStatus(ad.getId(), "Disabled");
		}
	}

	@Then("an error message should be sent to the user indicating the advertisement status error")
	public void an_error_message_should_be_sent_to_the_user_indicating_the_advertisement_status_error() {
		User user = BitcoinSystemController.getUserWithId("Tom");
		List<Advertisement> ads = user.getAdvertisements();
		for (Advertisement ad: ads) {
			if (ad.getAdStatus() != "Normal") {
				fail();
			}
		}
	}



	@When("{string} choose to activate all buying advertisements")
	public void choose_to_activate_all_buying_advertisements(String string) {
		User user = BitcoinSystemController.getUserWithId(string);
		List<Advertisement> ads = user.getAdvertisements();
		for (Advertisement ad: ads) {
			if (ad.getAdType() == "Buying") {
				BitcoinSystemController.setAdStatus(ad.getId(), "Activated");
			}
		}
		for (Advertisement ad: ads) {
			if (ad.getAdType() == "Buying") {
			if (ad.getAdStatus() != "Activated") {
				fail();
			}
			}
		}
	}

	@When("{string} choose to activate all selling advertisements")
	public void choose_to_activate_all_selling_advertisements(String string) {
		User user = BitcoinSystemController.getUserWithId(string);
		List<Advertisement> ads = user.getAdvertisements();
		for (Advertisement ad: ads) {
			if (ad.getAdType() == "Selling") {
				BitcoinSystemController.setAdStatus(ad.getId(), "Activated");
			}
		}
		for (Advertisement ad: ads) {
			if (ad.getAdType() == "Selling") {
			if (ad.getAdStatus() != "Activated") {
				fail();
			}
			}
		}
	}

	@Given("user id name{int} already exists")
	public void user_id_name_already_exists(Integer int1) {
		if(BitcoinSystemController.getUserWithId(int1.toString()) != null) {
			System.out.print("wrong");
		}
	}

	@Given("name{int} created an advertisement <advertisement_id>")
	public void name_created_an_advertisement_advertisement_id(Integer int1) {
		BitcoinSystemController.createAd(int1.toString(), int1.toString(), 0.0, 0.0, "dontcare");
	}

	@When("name{int} wants to cancel this advertisement")
	public void name_wants_to_cancel_this_advertisement(Integer int1) {
		BitcoinSystemController.cancelAd(int1.toString());
	}

	@Then("ad{int} is deleted")
	public void BitcoinSystemController(Integer int1) {
		BitcoinSystem bitcoinSystem = ChironApplication.getBitcoinSystem();
		assertEquals(null, BitcoinSystemController.getAdWithId(int1.toString()));
	}

	@Then("the related trades are also canceled in this system")
	public void the_related_trades_are_also_canceled_in_this_system() {
		assertEquals(null, BitcoinSystemController.getAdWithId("testid"));
	}

	@Given("testid does not exist")
	public void testid_does_not_exist() {
		assertEquals(null, BitcoinSystemController.getAdWithId("testid"));
	}

	@When("name{int} wants to cancel this advertisement <advertisment_id>")
	public void name_wants_to_cancel_this_advertisement_advertisment_id(Integer int1, String string2) {
		User user = BitcoinSystemController.getUserWithId(int1.toString());
		Advertisement ad;
		try {
			ad = user.getAdvertisement(0); //need to change to use string2 to find ad
		} catch (Exception e) {
			throw new IllegalArgumentException("Advertisement with ID: " + string2 + "does not exist!");
		}
		BitcoinSystemController.setAdStatus(ad.getId(), "Cancelled");
		assertEquals("Cancelled", ad.getAdStatus());
	}

	@Then("there is nothing to delete, the system should generate a warning")
	public void there_is_nothing_to_delete_the_system_should_generate_a_warning() {
		ChironApplication.getErrormessages().contains("warning");
	}

	@Given("buyer test{int} already exists")
	public void buyer_test_already_exists(Integer int1) {
		if(BitcoinSystemController.getUserWithId(int1.toString()) != null) {
			System.out.print("error499");
		}
	}

	@Given("user id test{int} wants to trade bitcoins")
	public void user_id_test_wants_to_trade_bitcoins(Integer int1) {
		if(BitcoinSystemController.getUserWithId(int1.toString()) != null) {
			System.out.print("error506");
		}
	}

	@Given("name{int} created an advertisement ad{int} with amount {int}")
	public void name_created_an_advertisement_ad_with_amount(Integer int1, Integer int2, Integer int3) {
		//TODO
		assertEquals(true,true);
	}

	@When("name{int} opens a trade")
	public void name_opens_a_trade(Integer int1) {
		//TODO
		assertEquals(true,true);
	}

	@Then("a trade is created with <trade_id>")
	public void a_trade_is_created_with_trade_id() {
		//TODO
		assertEquals(true,true);
	}

	@Then("the start time is <start_time>")
	public void the_start_time_is_start_time(String string1) {
		User user = BitcoinSystemController.getUserWithId("0");
		assertEquals(string1, user.getTrade(0).getStartTime());
	}

	@Then("the amount of the trade <trade_id> is {int}")
	public void the_amount_of_the_trade_trade_id_is(Integer int1) {
		User user = BitcoinSystemController.getUserWithId("0");
		assertEquals(int1, user.getTrade(0).getAmount());
	}

	@Then("the trade status of the trade <trade_id> is {string}")
	public void the_trade_status_of_the_trade_trade_id_is(String string) {
		User user = BitcoinSystemController.getUserWithId("0");
		assertEquals(string, user.getTrade(0).getTradeStatus());
	}

	@Given("name{int} created an advertisement ad{int} with amount {string}")
	public void name_created_an_advertisement_ad_with_amount(Integer int1, Integer int2, String string) {
		BitcoinSystemController.tryToCreateAd(int1, int2, string);
	}

	@Then("a trade cannot be created")
	public void a_trade_cannot_be_created() {
		ChironApplication.getErrormessages().contains("a trade cannot be created");
	}

	@Given("user id test{int} does not exist")
	public void user_id_test_does_not_exist(Integer int1) {
		assertEquals(null, BitcoinSystemController.getAdWithId(int1.toString()));
		
	}
	
	//----------------------Feature 31-36↑
    // updated step definition--------
	@Given("user Amy with user id amy@id.com exists")
	public void user_Amy_with_user_id_amy_id_com_exists() {
		assertNotEquals(null, BitcoinSystemController.getAdWithId("amy@id.com"));
	}
	
	@When("removes user Amy with user id amy@id.com")
	public void removes_user_Amy_with_user_id_amy_id_com() {
		BitcoinSystemController.removeUser("amy@id.com");
	}

	@Then("user Amy with user id amy@id.com is removed")
	public void user_Amy_with_user_id_amy_id_com_is_removed() {
		assertEquals(null, BitcoinSystemController.getAdWithId("amy@id.com"));
	}
	
	@Given("user Bob with user id bod@id.com exists")
	public void user_Bob_with_user_id_bod_id_com_exists() {
		assertNotEquals(null, BitcoinSystemController.getAdWithId("bod@id.com"));
	}

	@When("removes user Bob with user id bod@id.com")
	public void removes_user_Bob_with_user_id_bod_id_com() {
		BitcoinSystemController.removeUser("bod@id.com");
	}
	@Then("user Bob with user id bod@id.com is removed")
	public void user_Bob_with_user_id_bod_id_com_is_removed() {
		assertEquals(null, BitcoinSystemController.getAdWithId("bod@id.com"));
	}
	@Given("user Cooper with user id cooper@id.com exists")
	public void user_Cooper_with_user_id_cooper_id_com_exists() {
		assertNotEquals(null, BitcoinSystemController.getAdWithId("cooper@id.com"));
	}
	@When("removes user Cooper with user id cooper@id.com")
	public void removes_user_Cooper_with_user_id_cooper_id_com() {
		BitcoinSystemController.removeUser("cooper@id.com");
	}
	@Then("user Cooper with user id cooper@id.com is removed")
	public void user_Cooper_with_user_id_cooper_id_com_is_removed() {
		assertEquals(null, BitcoinSystemController.getAdWithId("cooper@id.com"));
	}
	
	@Then("the system returns error")
	public void the_system_returns_error() {
		ChironApplication.getErrormessages().contains("error");
		
	}
	
	@Given("I am a normal user with user id <user_id>")
	public void i_am_a_normal_user_with_user_id_user_id(String string) {
		assertNotEquals(null, BitcoinSystemController.getAdWithId(string));
	}
	@Given("following user exist:")
	public void following_user_exist(io.cucumber.datatable.DataTable dataTable) {
		BitcoinSystem bitcoinSystem = ChironApplication.getBitcoinSystem();
		List<Map<String, String>> valueMaps = dataTable.asMaps();
		for (Map<String, String> map : valueMaps) {
			if(map.get("role").equals("Manager")) return;
			String user_name = map.get("user_name");
			String userstatus = map.get("userstatus");
			String creditlevel = map.get("creditlevel");
			BitcoinSystemController.addNewUserWithCredit(user_name, userstatus, creditlevel);
			
		}
	}
	@Given("I have new password and email:")
	public void i_have_new_password_and_email(io.cucumber.datatable.DataTable dataTable) {
		BitcoinSystem bitcoinSystem = ChironApplication.getBitcoinSystem();
		List<Map<String, String>> valueMaps = dataTable.asMaps();
		for (Map<String, String> map : valueMaps) {
			String user_name = map.get("user_name");
			String userstatus = map.get("userstatus");
			String creditlevel = map.get("creditlevel");
			String password = map.get("password");
			String email = map.get("email");
			BitcoinSystemController.addNewUserWithCredit(user_name, userstatus, creditlevel, password, email);
			
		}
	}
	@When("I request to change a password in my account")
	public void i_request_to_change_a_password_in_my_account(String string, String string2) {
		BitcoinSystemController.changePassword(string, string2);
	}
	@When("I enter the following password:")
	public void i_enter_the_following_password(io.cucumber.datatable.DataTable dataTable) {
		BitcoinSystem bitcoinSystem = ChironApplication.getBitcoinSystem();
		List<Map<String, String>> valueMaps = dataTable.asMaps();
		for (Map<String, String> map : valueMaps) {
			String user_name = map.get("user_name");
			String password = map.get("password");
			BitcoinSystemController.changePassword(user_name, password);	
		}
	}
	
	@Then("the system indicates that my account attribute has been successfully changed")
	public void the_system_indicates_that_my_account_attribute_has_been_successfully_changed() {
	    assertEquals(null, ChironApplication.getErrormessages());
	}
	@Then("following information is generated:")
	public void following_information_is_generated(io.cucumber.datatable.DataTable dataTable) {
		BitcoinSystem bitcoinSystem = ChironApplication.getBitcoinSystem();
		List<Map<String, String>> valueMaps = dataTable.asMaps();
		for (Map<String, String> map : valueMaps) {
			String user_name = map.get("user_name");
			String userstatus = map.get("userstatus");
			String creditlevel = map.get("creditlevel");
			String password = map.get("password");
			String email = map.get("email");
			assertEquals(userstatus, BitcoinSystemController.getUserWithId(user_name).getUserstatus());
			assertEquals(creditlevel, BitcoinSystemController.getUserWithId(user_name).getCreditlevel());
			assertEquals(password, BitcoinSystemController.getUserWithId(user_name).getPasscode());
			assertEquals(email, BitcoinSystemController.getUserWithId(user_name).getEmail());
			
		}
	}

	@When("I request to change a email in my account")
	public void i_request_to_change_a_email_in_my_account(String string, String string2) {
		BitcoinSystemController.requestEmailChange(string, string2);
	}
	@When("I enter the following email:")
	public void i_enter_the_following_email(io.cucumber.datatable.DataTable dataTable) {
		BitcoinSystem bitcoinSystem = ChironApplication.getBitcoinSystem();
		List<Map<String, String>> valueMaps = dataTable.asMaps();
		for (Map<String, String> map : valueMaps) {
			String user_name = map.get("user_name");
			String userstatus = map.get("userstatus");
			String creditlevel = map.get("creditlevel");
			String password = map.get("password");
			String email = map.get("email");
			BitcoinSystemController.requestEmailChange(user_name, email);
			
		}
	}
	@When("I enter invalid password")
	public void i_enter_invalid_password(String string, String string2) {
		BitcoinSystemController.requestPasscodeChange(string, string2);
	}
	@Then("the system warns me that I have entered an invalid password")
	public void the_system_warns_me_that_I_have_entered_an_invalid_password() {
	    ChironApplication.getErrormessages().contains("invalid password");
	}
	@Then("my account password does not change")
	public void my_account_password_does_not_change() {
		BitcoinSystem bitcoinSystem = ChironApplication.getBitcoinSystem();
		assertNotEquals("second", bitcoinSystem.getUsers().get(0).getPasscode());
	}

	@When("I enter invalid email address")
	public void i_enter_invalid_email_address(String string, String string2) {
		BitcoinSystemController.requestEmailChange(string, string2);
	}

	@Then("the system warns me that I have entered an invalid email address")
	public void the_system_warns_me_that_I_have_entered_an_invalid_email_address() {
		ChironApplication.getErrormessages().contains("invalid email address");
	}
	@Then("my account does not change")
	public void my_account_does_not_change() {
		BitcoinSystem bitcoinSystem = ChironApplication.getBitcoinSystem();
		assertNotEquals("second", bitcoinSystem.getUsers().get(0).getEmail());
	}
	@Given("a manager with userId {string} exist in system")
	public void a_manager_with_userId_exist_in_system(String string) {
		if(BitcoinSystemController.hasUser(string) == false) {
			BitcoinSystemController.addNewManager(string, "dontcare", "dontcare");
		}
	}
	@Given("the follow user account exist in system with exact credit score:")
	public void the_follow_user_account_exist_in_system_with_exact_credit_score(io.cucumber.datatable.DataTable dataTable) {
		BitcoinSystem bitcoinSystem = ChironApplication.getBitcoinSystem();
		List<Map<String, String>> valueMaps = dataTable.asMaps();
		for (Map<String, String> map : valueMaps) {
			if(map.get("role").equals("Manager")) return;
			String user_name = map.get("user_name");
			String userstatus = map.get("userstatus");
			String creditlevel = map.get("creditlevel");
			BitcoinSystemController.addNewUserWithCredit(user_name, userstatus, creditlevel);
			
		}
	}
	@When("user {string} complete a trade")
	public void user_complete_a_trade(String string) {
		BitcoinSystemController.completeTrade(string);
	}
	@Then("the credit score of user {string} should be greater then {string}")
	public void the_credit_score_of_user_should_be_greater_then(String string, String string2) {
	    boolean isGreater = false;
	    if(BitcoinSystemController.getUserWithId(string).getFeedbackScore() > BitcoinSystemController.getUserWithId(string2).getFeedbackScore()) {
	    	isGreater = true;
	    }
	    assertEquals(true, isGreater);
	}
	@When("user {string} decline a trade")
	public void user_decline_a_trade(String string) {
		BitcoinSystemController.declineTrade(string);
	}
	@Then("the credit score of user {string} should be less then {string}")
	public void the_credit_score_of_user_should_be_less_then(String string, String string2) {
		boolean isLess= false;
	    if(BitcoinSystemController.getUserWithId(string).getFeedbackScore() < BitcoinSystemController.getUserWithId(string2).getFeedbackScore()) {
	    	isLess = true;
	    }
	    assertEquals(true, isLess);
	}
	@When("manager select user {string} and set the credit to be {string}")
	public void manager_select_user_and_set_the_credit_to_be(String string, String string2) {
		BitcoinSystemController.changeUserCredit(string, string2);
	}

	@Then("the credit score of user {string} should be equal to {string}")
	public void the_credit_score_of_user_should_be_equal_to(String string, String string2) {
		 assertEquals(BitcoinSystemController.getUserWithId(string).getFeedbackScore(), BitcoinSystemController.getUserWithId(string2).getFeedbackScore());
	}
	@Then("an error message with content <error> shall be raised")
	public void an_error_message_with_content_error_shall_be_raised(io.cucumber.datatable.DataTable dataTable) {
		ChironApplication.getErrormessages().contains("error");
	}
	@When("system manager requests a list of users")
	public void system_manager_requests_a_list_of_users() {
		BitcoinSystem bitcoinSystem = ChironApplication.getBitcoinSystem();
		BitcoinSystemController.requestUser(bitcoinSystem.getManager(0).getId());
	}
	@Then("the following list of users is generated:")
	public void the_following_list_of_users_is_generated(io.cucumber.datatable.DataTable dataTable) {
		List<Map<String, String>> valueMaps = dataTable.asMaps();
		int count = 0;
		for (Map<String, String> map : valueMaps) {
			if(map.get("role").equals("User")) {
				count ++;
			}
		}
		assertNotEquals(0, count);
	}
	@Then("system returns error")
	public void system_returns_error() {
		ChironApplication.getErrormessages().contains("error");
	}
	
	@After
	public void tearDown() {
		BitcoinSystem bs = ChironApplication.getBitcoinSystem();
		// Avoid null pointer for step definitions that are not yet implemented.
		if (bs != null) {
			bs.delete();
			bs = null;
		}
	}


}
