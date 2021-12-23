/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.0.4181.a593105a9 modeling language!*/

package ca.mcgill.ecse428.chiron.model;
import java.util.*;

// line 51 "../../../../../ChironModel.ump"
public class Transaction
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Transaction Attributes
  private String txid;
  private double amount;
  private String time;
  private String description;

  //Transaction Associations
  private List<User> users;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Transaction(String aTxid, double aAmount, String aTime, String aDescription, User... allUsers)
  {
    txid = aTxid;
    amount = aAmount;
    time = aTime;
    description = aDescription;
    users = new ArrayList<User>();
    boolean didAddUsers = setUsers(allUsers);
    if (!didAddUsers)
    {
      throw new RuntimeException("Unable to create Transaction, must have 1 to 2 users");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setTxid(String aTxid)
  {
    boolean wasSet = false;
    txid = aTxid;
    wasSet = true;
    return wasSet;
  }

  public boolean setAmount(double aAmount)
  {
    boolean wasSet = false;
    amount = aAmount;
    wasSet = true;
    return wasSet;
  }

  public boolean setTime(String aTime)
  {
    boolean wasSet = false;
    time = aTime;
    wasSet = true;
    return wasSet;
  }

  public boolean setDescription(String aDescription)
  {
    boolean wasSet = false;
    description = aDescription;
    wasSet = true;
    return wasSet;
  }

  public String getTxid()
  {
    return txid;
  }

  public double getAmount()
  {
    return amount;
  }

  public String getTime()
  {
    return time;
  }

  public String getDescription()
  {
    return description;
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
  /* Code from template association_IsNumberOfValidMethod */
  public boolean isNumberOfUsersValid()
  {
    boolean isValid = numberOfUsers() >= minimumNumberOfUsers() && numberOfUsers() <= maximumNumberOfUsers();
    return isValid;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfUsers()
  {
    return 1;
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
    if (aUser.indexOfTransaction(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aUser.addTransaction(this);
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
    if (aUser.indexOfTransaction(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aUser.removeTransaction(this);
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
        aNewUser.addTransaction(this);
      }
    }

    for (User anOldUser : oldUsers)
    {
      anOldUser.removeTransaction(this);
    }
    wasSet = true;
    return wasSet;
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

  public void delete()
  {
    ArrayList<User> copyOfUsers = new ArrayList<User>(users);
    users.clear();
    for(User aUser : copyOfUsers)
    {
      aUser.removeTransaction(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "txid" + ":" + getTxid()+ "," +
            "amount" + ":" + getAmount()+ "," +
            "time" + ":" + getTime()+ "," +
            "description" + ":" + getDescription()+ "]";
  }
}