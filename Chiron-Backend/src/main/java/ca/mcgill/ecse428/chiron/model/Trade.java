/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.0.4181.a593105a9 modeling language!*/

package ca.mcgill.ecse428.chiron.model;
import java.util.*;

// line 42 "../../../../../ChironModel.ump"
public class Trade
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Trade Attributes
  private String startTime;
  private String endTime;
  private String amount;
  private String tradeStatus;

  //Trade Associations
  private List<User> users;
  private Advertisement advertisement;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Trade(String aStartTime, String aEndTime, String aAmount, String aTradeStatus, Advertisement aAdvertisement, User... allUsers)
  {
    startTime = aStartTime;
    endTime = aEndTime;
    amount = aAmount;
    tradeStatus = aTradeStatus;
    users = new ArrayList<User>();
    boolean didAddUsers = setUsers(allUsers);
    if (!didAddUsers)
    {
      throw new RuntimeException("Unable to create Trade, must have 2 users");
    }
    boolean didAddAdvertisement = setAdvertisement(aAdvertisement);
    if (!didAddAdvertisement)
    {
      throw new RuntimeException("Unable to create trade due to advertisement");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setStartTime(String aStartTime)
  {
    boolean wasSet = false;
    startTime = aStartTime;
    wasSet = true;
    return wasSet;
  }

  public boolean setEndTime(String aEndTime)
  {
    boolean wasSet = false;
    endTime = aEndTime;
    wasSet = true;
    return wasSet;
  }

  public boolean setAmount(String aAmount)
  {
    boolean wasSet = false;
    amount = aAmount;
    wasSet = true;
    return wasSet;
  }

  public boolean setTradeStatus(String aTradeStatus)
  {
    boolean wasSet = false;
    tradeStatus = aTradeStatus;
    wasSet = true;
    return wasSet;
  }

  public String getStartTime()
  {
    return startTime;
  }

  public String getEndTime()
  {
    return endTime;
  }

  public String getAmount()
  {
    return amount;
  }

  public String getTradeStatus()
  {
    return tradeStatus;
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
  /* Code from template association_GetOne */
  public Advertisement getAdvertisement()
  {
    return advertisement;
  }
  /* Code from template association_IsNumberOfValidMethod */
  public boolean isNumberOfUsersValid()
  {
    boolean isValid = numberOfUsers() >= minimumNumberOfUsers() && numberOfUsers() <= maximumNumberOfUsers();
    return isValid;
  }
  /* Code from template association_RequiredNumberOfMethod */
  public static int requiredNumberOfUsers()
  {
    return 2;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfUsers()
  {
    return 2;
  }
  /* Code from template association_MaximumNumberOfMethod */
  public static int maximumNumberOfUsers()
  {
    return 2;
  }
  /* Code from template association_AddManyToManyMethod */
  public boolean addUser(User aUser)
  {
    boolean wasAdded = false;
    if (users.contains(aUser)) { return false; }
    if (numberOfUsers() >= maximumNumberOfUsers())
    {
      return wasAdded;
    }

    users.add(aUser);
    if (aUser.indexOfTrade(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aUser.addTrade(this);
      if (!wasAdded)
      {
        users.remove(aUser);
      }
    }
    return wasAdded;
  }
  /* Code from template association_AddMNToMany */
  public boolean removeUser(User aUser)
  {
    boolean wasRemoved = false;
    if (!users.contains(aUser))
    {
      return wasRemoved;
    }

    if (numberOfUsers() <= minimumNumberOfUsers())
    {
      return wasRemoved;
    }

    int oldIndex = users.indexOf(aUser);
    users.remove(oldIndex);
    if (aUser.indexOfTrade(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aUser.removeTrade(this);
      if (!wasRemoved)
      {
        users.add(oldIndex,aUser);
      }
    }
    return wasRemoved;
  }
  /* Code from template association_SetMNToMany */
  public boolean setUsers(User... newUsers)
  {
    boolean wasSet = false;
    ArrayList<User> verifiedUsers = new ArrayList<User>();
    for (User aUser : newUsers)
    {
      if (verifiedUsers.contains(aUser))
      {
        continue;
      }
      verifiedUsers.add(aUser);
    }

    if (verifiedUsers.size() != newUsers.length || verifiedUsers.size() < minimumNumberOfUsers() || verifiedUsers.size() > maximumNumberOfUsers())
    {
      return wasSet;
    }

    ArrayList<User> oldUsers = new ArrayList<User>(users);
    users.clear();
    for (User aNewUser : verifiedUsers)
    {
      users.add(aNewUser);
      if (oldUsers.contains(aNewUser))
      {
        oldUsers.remove(aNewUser);
      }
      else
      {
        aNewUser.addTrade(this);
      }
    }

    for (User anOldUser : oldUsers)
    {
      anOldUser.removeTrade(this);
    }
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_SetOneToMany */
  public boolean setAdvertisement(Advertisement aAdvertisement)
  {
    boolean wasSet = false;
    if (aAdvertisement == null)
    {
      return wasSet;
    }

    Advertisement existingAdvertisement = advertisement;
    advertisement = aAdvertisement;
    if (existingAdvertisement != null && !existingAdvertisement.equals(aAdvertisement))
    {
      existingAdvertisement.removeTrade(this);
    }
    advertisement.addTrade(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    ArrayList<User> copyOfUsers = new ArrayList<User>(users);
    users.clear();
    for(User aUser : copyOfUsers)
    {
      aUser.removeTrade(this);
    }
    Advertisement placeholderAdvertisement = advertisement;
    this.advertisement = null;
    if(placeholderAdvertisement != null)
    {
      placeholderAdvertisement.removeTrade(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "startTime" + ":" + getStartTime()+ "," +
            "endTime" + ":" + getEndTime()+ "," +
            "amount" + ":" + getAmount()+ "," +
            "tradeStatus" + ":" + getTradeStatus()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "advertisement = "+(getAdvertisement()!=null?Integer.toHexString(System.identityHashCode(getAdvertisement())):"null");
  }
}