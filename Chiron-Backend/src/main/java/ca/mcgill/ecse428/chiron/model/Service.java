/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.0.4181.a593105a9 modeling language!*/

package ca.mcgill.ecse428.chiron.model;
import java.util.*;

// line 34 "../../../../../ChironModel.ump"
public class Service
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Service Attributes
  private String id;
  private String content;
  private String serviceStatus;

  //Service Associations
  private List<User> users;
  private Manager manager;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Service(String aId, String aContent, String aServiceStatus, Manager aManager, User... allUsers)
  {
    id = aId;
    content = aContent;
    serviceStatus = aServiceStatus;
    users = new ArrayList<User>();
    boolean didAddUsers = setUsers(allUsers);
    if (!didAddUsers)
    {
      throw new RuntimeException("Unable to create Service, must have 1 to 2 users");
    }
    boolean didAddManager = setManager(aManager);
    if (!didAddManager)
    {
      throw new RuntimeException("Unable to create service due to manager");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setId(String aId)
  {
    boolean wasSet = false;
    id = aId;
    wasSet = true;
    return wasSet;
  }

  public boolean setContent(String aContent)
  {
    boolean wasSet = false;
    content = aContent;
    wasSet = true;
    return wasSet;
  }

  public boolean setServiceStatus(String aServiceStatus)
  {
    boolean wasSet = false;
    serviceStatus = aServiceStatus;
    wasSet = true;
    return wasSet;
  }

  public String getId()
  {
    return id;
  }

  public String getContent()
  {
    return content;
  }

  public String getServiceStatus()
  {
    return serviceStatus;
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
  public Manager getManager()
  {
    return manager;
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
    if (aUser.indexOfService(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aUser.addService(this);
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
    if (aUser.indexOfService(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aUser.removeService(this);
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
        aNewUser.addService(this);
      }
    }

    for (User anOldUser : oldUsers)
    {
      anOldUser.removeService(this);
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
  /* Code from template association_SetOneToMany */
  public boolean setManager(Manager aManager)
  {
    boolean wasSet = false;
    if (aManager == null)
    {
      return wasSet;
    }

    Manager existingManager = manager;
    manager = aManager;
    if (existingManager != null && !existingManager.equals(aManager))
    {
      existingManager.removeService(this);
    }
    manager.addService(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    ArrayList<User> copyOfUsers = new ArrayList<User>(users);
    users.clear();
    for(User aUser : copyOfUsers)
    {
      aUser.removeService(this);
    }
    Manager placeholderManager = manager;
    this.manager = null;
    if(placeholderManager != null)
    {
      placeholderManager.removeService(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "id" + ":" + getId()+ "," +
            "content" + ":" + getContent()+ "," +
            "serviceStatus" + ":" + getServiceStatus()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "manager = "+(getManager()!=null?Integer.toHexString(System.identityHashCode(getManager())):"null");
  }
}