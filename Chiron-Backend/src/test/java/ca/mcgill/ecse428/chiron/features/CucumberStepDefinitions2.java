package ca.mcgill.ecse428.chiron.features;
import io.cucumber.java.After;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import ca.mcgill.ecse428.chiron.ChironApplication;
import ca.mcgill.ecse428.chiron.controller.BitcoinSystemController;
import ca.mcgill.ecse428.chiron.controller.BitcoinSystemController2;
import ca.mcgill.ecse428.chiron.model.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
public class CucumberStepDefinitions2 {
	
	@Given("A patch is not installed")
	public void a_patch_is_not_installed() {
		BitcoinSystemController2.removePatch();
	}

	@Given("A patch in already installed")
	public void a_patch_in_already_installed() {
		BitcoinSystemController2.installPatch();
	}

	@When("Manager {string} is logged-in")
	public void manager_is_logged_in(String string) {
	   BitcoinSystemController.addNewUser(string, string, string);
	}

	@When("A new patch is installed by {string}")
	public void a_new_patch_is_installed_by(String string) {
	    String user = BitcoinSystemController2.getManager();
	    if(user.equals(string)) {
	    	BitcoinSystemController2.installPatch();
	    }
	}
	@When("A new patch is removed by {string}")
	public void a_new_patch_is_removed_by(String string) {
		String user = BitcoinSystemController2.getManager();
	    if(user.equals(string)) {
	    	BitcoinSystemController2.removePatch();
	    }
	}

	@Then("The system indicates that a new patch is {string}")
	public void the_system_indicates_that_a_new_patch_is(String string) {
		String str = BitcoinSystemController2.getPatchCondition()?"true":"false";
		Assert.assertEquals(string,str);
	}

	@When("Ordinary user {string} is logged-in")
	public void ordinary_user_is_logged_in(String string) {
		 BitcoinSystemController.addNewUser(string, string, string);
	}

	@When("A time period {string} is defined by {string}")
	public void a_time_period_is_defined_by(String string, String string2) {
	    if(string2.equals(BitcoinSystemController2.getManager())) {
	    	BitcoinSystemController2.setActiveTime(string);
	    }else {
	    	BitcoinSystemController2.setActiveTime("");
	    }
	}	

	@Then("The systems trading time is now {string}")
	public void the_systems_trading_time_is_now(String string) {
	    String activeTime = BitcoinSystemController2.getActiveTime();
	    Assert.assertEquals(string,activeTime);
	}

	@Then("The systems returns an error message {string} showing permission denied")
	public void the_systems_returns_an_error_message_showing_permission_denied(String string) {
			String message = "";
			//System.out.print("=============================="+BitcoinSystemController2.getActiveTime());
		if(BitcoinSystemController2.getActiveTime().equals("")) {
	    	message = "permission denied";
	    }
		else {
			message = "defined";
		}
		Assert.assertEquals(string, message);
	}
	
	@When("manager {string} requests to generate user summary")
	public void manager_requests_to_generate_user_summary(String string) {
		if(string.equals(BitcoinSystemController2.getManager())) {
			BitcoinSystemController2.generateUserSummary();
		}
	}


	@Then("the total number of users is {int}")
	public void the_total_number_of_users_is(Integer int1) {
		 int num = BitcoinSystemController2.getUserSummary();
		    Assert.assertTrue(int1==num);
	}

	@When("user {string} requests to generate user summary")
	public void user_requests_to_generate_user_summary(String string) {
		if(string.equals(BitcoinSystemController2.getManager())) {
			BitcoinSystemController2.generateUserSummary();
		}
	}

	@When("user {string} requests to generate user change summary")
	public void user_requests_to_generate_user_change_summary(String string) {
		if(string.equals(BitcoinSystemController2.getManager())) {
			BitcoinSystemController2.generateUserChangeSummary();
		}
	}
	@Then("The systems returns an error message {string} showing view user summary permission denied")
	public void the_systems_returns_an_error_message_showing_view_user_summary_permission_denied(String string) {
	    Assert.assertEquals(string, BitcoinSystemController2.getErrorMessage());
	}

	@When("the current total number of users is {int}")
	public void the_current_total_number_of_users_is(Integer int1) {
		Assert.assertTrue(int1==BitcoinSystemController2.getCurrentTotal());
	}

	@Then("the number of user affected is {int}")
	public void the_number_of_user_affected_is(Integer int1) {
		Assert.assertTrue(int1==BitcoinSystemController2.getChangeNumber());
	}

	@Then("The systems returns an error message {string} showing that generate user change summary permission denied")
	public void the_systems_returns_an_error_message_showing_that_generate_user_change_summary_permission_denied(String string) {
		 Assert.assertEquals(string, BitcoinSystemController2.getErrorMessage());
	}
	@When("the user with username {string} is removed")
	public void the_user_with_username_is_removed(String string) {
		BitcoinSystemController2.removeUser();
	}
	
	
	@Given("the follow transcations exist in system:")
	public void the_follow_transcations_exist_in_system(io.cucumber.datatable.DataTable dataTable) {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
	    BitcoinSystem bitcoinSystem = ChironApplication.getBitcoinSystem();
		List<Map<String, String>> valueMaps = dataTable.asMaps();
		for (Map<String, String> map : valueMaps) {
			String trans_id = map.get("transc_id");
			String amount = map.get("amount");
			String user_id1 = map.get("user_id1");
			String user_id2 = map.get("user_id2");
			BitcoinSystemController2.addTranscationToSystem(trans_id, amount, user_id1,user_id2);
			
		}
	}
	@When("{string} requests to view the transcation report of {string}")
	public void requests_to_view_the_transcation_report_of(String string, String string2) {
	    boolean isTranscationOwner = BitcoinSystemController2.checkIfUserInTransc(string,string2);	  
	    if(isTranscationOwner) {
	    	BitcoinSystemController2.generateTranscReport();	    	
	    }
	}

	@Then("the total number of transcations is {int}")
	public void the_total_number_of_transcations_is(Integer int1) {
		  int transc = BitcoinSystemController2.getTranscNumber();
		  Assert.assertTrue(transc==int1);
	}

	@Then("the total amount of transcations is {int}")
	public void the_total_amount_of_transcations_is(Integer int1) {
		int transc = BitcoinSystemController2.getTranscAmount();
		  Assert.assertTrue(transc==int1);
	}

	@Then("The systems returns an error message {string} showing that viewing others transcation report permission denied")
	public void the_systems_returns_an_error_message_showing_that_viewing_others_transcation_report_permission_denied(String string) {
		Assert.assertEquals(string, BitcoinSystemController2.getErrorMessage());
	}
	
	
	@Given("{string} has {int} bitcoin in the wallet")
	public void has_bitcoin_in_the_wallet(String string, Integer int1) {
		BitcoinSystem bitcoinSystem = ChironApplication.getBitcoinSystem();
		BitcoinSystemController.getUserWithId(string).setBitcoinAmount(int1);
	}
	@When("{string} send {int} bitcoin to {string}")
	public void send_bitcoin_to(String string, Integer int1, String string2) {
		BitcoinSystemController.sendBitcoin(string2, int1);
	}
	@Given("the User with username {string} is logged in")
	public void the_User_with_username_is_logged_in(String string) {
		User user = BitcoinSystemController.getUserWithId(string);
		assertNotEquals(null, user);
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
