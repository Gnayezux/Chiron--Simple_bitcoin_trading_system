/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.0.4181.a593105a9 modeling language!*/

package ca.mcgill.ecse428.chiron.model;
import java.util.*;

// line 19 "../../../../../ChironModel.ump"
public class BitcoinSystem
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //BitcoinSystem Associations
  private List<Manager> managers;
  private List<User> users;
  private List<Advertisement> advertisements;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public BitcoinSystem()
  {
    managers = new ArrayList<Manager>();
    users = new ArrayList<User>();
    advertisements = new ArrayList<Advertisement>();
  }

  //------------------------
  // INTERFACE
  //------------------------
  /* Code from template association_GetMany */
  public Manager getManager(int index)
  {
    Manager aManager = managers.get(index);
    return aManager;
  }

  public List<Manager> getManagers()
  {
    List<Manager> newManagers = Collections.unmodifiableList(managers);
    return newManagers;
  }

  public int numberOfManagers()
  {
    int number = managers.size();
    return number;
  }

  public boolean hasManagers()
  {
    boolean has = managers.size() > 0;
    return has;
  }

  public int indexOfManager(Manager aManager)
  {
    int index = managers.indexOf(aManager);
    return index;
  }
  /* Code from template association_GetMany */
  public User getUser(int index)
  {
    User aUser = users.get(index);
    return aUser;
  }

  public List<User> getUsers()
  {
    List<User> newUsers = Collections.unmodifiableList(users);
    return newUsers;
  }

  public int numberOfUsers()
  {
    int number = users.size();
    return number;
  }

  public boolean hasUsers()
  {
    boolean has = users.size() > 0;
    return has;
  }

  public int indexOfUser(User aUser)
  {
    int index = users.indexOf(aUser);
    return index;
  }
  /* Code from template association_GetMany */
  public Advertisement getAdvertisement(int index)
  {
    Advertisement aAdvertisement = advertisements.get(index);
    return aAdvertisement;
  }

  public List<Advertisement> getAdvertisements()
  {
    List<Advertisement> newAdvertisements = Collections.unmodifiableList(advertisements);
    return newAdvertisements;
  }

  public int numberOfAdvertisements()
  {
    int number = advertisements.size();
    return number;
  }

  public boolean hasAdvertisements()
  {
    boolean has = advertisements.size() > 0;
    return has;
  }

  public int indexOfAdvertisement(Advertisement aAdvertisement)
  {
    int index = advertisements.indexOf(aAdvertisement);
    return index;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfManagers()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Manager addManager(String aId, String aEmail, String aPasscode)
  {
    return new Manager(aId, aEmail, aPasscode, this);
  }

  public boolean addManager(Manager aManager)
  {
    boolean wasAdded = false;
    if (managers.contains(aManager)) { return false; }
    BitcoinSystem existingBitcoinSystem = aManager.getBitcoinSystem();
    boolean isNewBitcoinSystem = existingBitcoinSystem != null && !this.equals(existingBitcoinSystem);
    if (isNewBitcoinSystem)
    {
      aManager.setBitcoinSystem(this);
    }
    else
    {
      managers.add(aManager);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeManager(Manager aManager)
  {
    boolean wasRemoved = false;
    //Unable to remove aManager, as it must always have a bitcoinSystem
    if (!this.equals(aManager.getBitcoinSystem()))
    {
      managers.remove(aManager);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addManagerAt(Manager aManager, int index)
  {  
    boolean wasAdded = false;
    if(addManager(aManager))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfManagers()) { index = numberOfManagers() - 1; }
      managers.remove(aManager);
      managers.add(index, aManager);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveManagerAt(Manager aManager, int index)
  {
    boolean wasAdded = false;
    if(managers.contains(aManager))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfManagers()) { index = numberOfManagers() - 1; }
      managers.remove(aManager);
      managers.add(index, aManager);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addManagerAt(aManager, index);
    }
    return wasAdded;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfUsers()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public User addUser(String aId, double aFeedbackScore, double aBitcoinAmount, String aEmail, double aTradeVolumn, String aPasscode, String aUserstatus, String aCreditlevel)
  {
    return new User(aId, aFeedbackScore, aBitcoinAmount, aEmail, aTradeVolumn, aPasscode, aUserstatus, aCreditlevel, this);
  }

  public boolean addUser(User aUser)
  {
    boolean wasAdded = false;
    if (users.contains(aUser)) { return false; }
    BitcoinSystem existingBitcoinSystem = aUser.getBitcoinSystem();
    boolean isNewBitcoinSystem = existingBitcoinSystem != null && !this.equals(existingBitcoinSystem);
    if (isNewBitcoinSystem)
    {
      aUser.setBitcoinSystem(this);
    }
    else
    {
      users.add(aUser);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeUser(User aUser)
  {
    boolean wasRemoved = false;
    //Unable to remove aUser, as it must always have a bitcoinSystem
    if (!this.equals(aUser.getBitcoinSystem()))
    {
      users.remove(aUser);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addUserAt(User aUser, int index)
  {  
    boolean wasAdded = false;
    if(addUser(aUser))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfUsers()) { index = numberOfUsers() - 1; }
      users.remove(aUser);
      users.add(index, aUser);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveUserAt(User aUser, int index)
  {
    boolean wasAdded = false;
    if(users.contains(aUser))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfUsers()) { index = numberOfUsers() - 1; }
      users.remove(aUser);
      users.add(index, aUser);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addUserAt(aUser, index);
    }
    return wasAdded;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfAdvertisements()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Advertisement addAdvertisement(String aId, String aAdType, String aRate, String aCurrency, String aPaymentMethod, String aAdStatus, double aPrice, String aCreateTime, double aMin, double aMax, User aCreator)
  {
    return new Advertisement(aId, aAdType, aRate, aCurrency, aPaymentMethod, aAdStatus, aPrice, aCreateTime, aMin, aMax, aCreator, this);
  }

  public boolean addAdvertisement(Advertisement aAdvertisement)
  {
    boolean wasAdded = false;
    if (advertisements.contains(aAdvertisement)) { return false; }
    BitcoinSystem existingBitcoinSystem = aAdvertisement.getBitcoinSystem();
    boolean isNewBitcoinSystem = existingBitcoinSystem != null && !this.equals(existingBitcoinSystem);
    if (isNewBitcoinSystem)
    {
      aAdvertisement.setBitcoinSystem(this);
    }
    else
    {
      advertisements.add(aAdvertisement);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeAdvertisement(Advertisement aAdvertisement)
  {
    boolean wasRemoved = false;
    //Unable to remove aAdvertisement, as it must always have a bitcoinSystem
    if (!this.equals(aAdvertisement.getBitcoinSystem()))
    {
      advertisements.remove(aAdvertisement);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addAdvertisementAt(Advertisement aAdvertisement, int index)
  {  
    boolean wasAdded = false;
    if(addAdvertisement(aAdvertisement))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfAdvertisements()) { index = numberOfAdvertisements() - 1; }
      advertisements.remove(aAdvertisement);
      advertisements.add(index, aAdvertisement);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveAdvertisementAt(Advertisement aAdvertisement, int index)
  {
    boolean wasAdded = false;
    if(advertisements.contains(aAdvertisement))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfAdvertisements()) { index = numberOfAdvertisements() - 1; }
      advertisements.remove(aAdvertisement);
      advertisements.add(index, aAdvertisement);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addAdvertisementAt(aAdvertisement, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    for(int i=managers.size(); i > 0; i--)
    {
      Manager aManager = managers.get(i - 1);
      aManager.delete();
    }
    for(int i=users.size(); i > 0; i--)
    {
      User aUser = users.get(i - 1);
      aUser.delete();
    }
    for(int i=advertisements.size(); i > 0; i--)
    {
      Advertisement aAdvertisement = advertisements.get(i - 1);
      aAdvertisement.delete();
    }
  }

}