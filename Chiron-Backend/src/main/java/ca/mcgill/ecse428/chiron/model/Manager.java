/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.0.4181.a593105a9 modeling language!*/

package ca.mcgill.ecse428.chiron.model;
import java.util.*;

// line 26 "../../../../../ChironModel.ump"
public class Manager
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Manager Attributes
  private String id;
  private String email;
  private String passcode;

  //Manager Associations
  private List<Service> services;
  private BitcoinSystem bitcoinSystem;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Manager(String aId, String aEmail, String aPasscode, BitcoinSystem aBitcoinSystem)
  {
    id = aId;
    email = aEmail;
    passcode = aPasscode;
    services = new ArrayList<Service>();
    boolean didAddBitcoinSystem = setBitcoinSystem(aBitcoinSystem);
    if (!didAddBitcoinSystem)
    {
      throw new RuntimeException("Unable to create manager due to bitcoinSystem");
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

  public boolean setEmail(String aEmail)
  {
    boolean wasSet = false;
    email = aEmail;
    wasSet = true;
    return wasSet;
  }

  public boolean setPasscode(String aPasscode)
  {
    boolean wasSet = false;
    passcode = aPasscode;
    wasSet = true;
    return wasSet;
  }

  public String getId()
  {
    return id;
  }

  public String getEmail()
  {
    return email;
  }

  public String getPasscode()
  {
    return passcode;
  }
  /* Code from template association_GetMany */
  public Service getService(int index)
  {
    Service aService = services.get(index);
    return aService;
  }

  public List<Service> getServices()
  {
    List<Service> newServices = Collections.unmodifiableList(services);
    return newServices;
  }

  public int numberOfServices()
  {
    int number = services.size();
    return number;
  }

  public boolean hasServices()
  {
    boolean has = services.size() > 0;
    return has;
  }

  public int indexOfService(Service aService)
  {
    int index = services.indexOf(aService);
    return index;
  }
  /* Code from template association_GetOne */
  public BitcoinSystem getBitcoinSystem()
  {
    return bitcoinSystem;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfServices()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Service addService(String aId, String aContent, String aServiceStatus, User... allUsers)
  {
    return new Service(aId, aContent, aServiceStatus, this, allUsers);
  }

  public boolean addService(Service aService)
  {
    boolean wasAdded = false;
    if (services.contains(aService)) { return false; }
    Manager existingManager = aService.getManager();
    boolean isNewManager = existingManager != null && !this.equals(existingManager);
    if (isNewManager)
    {
      aService.setManager(this);
    }
    else
    {
      services.add(aService);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeService(Service aService)
  {
    boolean wasRemoved = false;
    //Unable to remove aService, as it must always have a manager
    if (!this.equals(aService.getManager()))
    {
      services.remove(aService);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addServiceAt(Service aService, int index)
  {  
    boolean wasAdded = false;
    if(addService(aService))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfServices()) { index = numberOfServices() - 1; }
      services.remove(aService);
      services.add(index, aService);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveServiceAt(Service aService, int index)
  {
    boolean wasAdded = false;
    if(services.contains(aService))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfServices()) { index = numberOfServices() - 1; }
      services.remove(aService);
      services.add(index, aService);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addServiceAt(aService, index);
    }
    return wasAdded;
  }
  /* Code from template association_SetOneToMany */
  public boolean setBitcoinSystem(BitcoinSystem aBitcoinSystem)
  {
    boolean wasSet = false;
    if (aBitcoinSystem == null)
    {
      return wasSet;
    }

    BitcoinSystem existingBitcoinSystem = bitcoinSystem;
    bitcoinSystem = aBitcoinSystem;
    if (existingBitcoinSystem != null && !existingBitcoinSystem.equals(aBitcoinSystem))
    {
      existingBitcoinSystem.removeManager(this);
    }
    bitcoinSystem.addManager(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    for(int i=services.size(); i > 0; i--)
    {
      Service aService = services.get(i - 1);
      aService.delete();
    }
    BitcoinSystem placeholderBitcoinSystem = bitcoinSystem;
    this.bitcoinSystem = null;
    if(placeholderBitcoinSystem != null)
    {
      placeholderBitcoinSystem.removeManager(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "id" + ":" + getId()+ "," +
            "email" + ":" + getEmail()+ "," +
            "passcode" + ":" + getPasscode()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "bitcoinSystem = "+(getBitcoinSystem()!=null?Integer.toHexString(System.identityHashCode(getBitcoinSystem())):"null");
  }
}