/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.0.4181.a593105a9 modeling language!*/

package ca.mcgill.ecse428.chiron.model;
import java.util.*;

// line 60 "../../../../../ChironModel.ump"
public class User
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //User Attributes
  private String id;
  private double feedbackScore;
  private double bitcoinAmount;
  private String email;
  private double tradeVolumn;
  private String passcode;
  private String userstatus;
  private String creditlevel;

  //User Associations
  private List<Advertisement> advertisements;
  private BitcoinSystem bitcoinSystem;
  private List<Service> services;
  private List<Trade> trades;
  private List<Transaction> transactions;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public User(String aId, double aFeedbackScore, double aBitcoinAmount, String aEmail, double aTradeVolumn, String aPasscode, String aUserstatus, String aCreditlevel, BitcoinSystem aBitcoinSystem)
  {
    id = aId;
    feedbackScore = aFeedbackScore;
    bitcoinAmount = aBitcoinAmount;
    email = aEmail;
    tradeVolumn = aTradeVolumn;
    passcode = aPasscode;
    userstatus = aUserstatus;
    creditlevel = aCreditlevel;
    advertisements = new ArrayList<Advertisement>();
    boolean didAddBitcoinSystem = setBitcoinSystem(aBitcoinSystem);
    if (!didAddBitcoinSystem)
    {
      throw new RuntimeException("Unable to create user due to bitcoinSystem");
    }
    services = new ArrayList<Service>();
    trades = new ArrayList<Trade>();
    transactions = new ArrayList<Transaction>();
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

  public boolean setFeedbackScore(double aFeedbackScore)
  {
    boolean wasSet = false;
    feedbackScore = aFeedbackScore;
    wasSet = true;
    return wasSet;
  }

  public boolean setBitcoinAmount(double aBitcoinAmount)
  {
    boolean wasSet = false;
    bitcoinAmount = aBitcoinAmount;
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

  public boolean setTradeVolumn(double aTradeVolumn)
  {
    boolean wasSet = false;
    tradeVolumn = aTradeVolumn;
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

  public boolean setUserstatus(String aUserstatus)
  {
    boolean wasSet = false;
    userstatus = aUserstatus;
    wasSet = true;
    return wasSet;
  }

  public boolean setCreditlevel(String aCreditlevel)
  {
    boolean wasSet = false;
    creditlevel = aCreditlevel;
    wasSet = true;
    return wasSet;
  }

  public String getId()
  {
    return id;
  }

  public double getFeedbackScore()
  {
    return feedbackScore;
  }

  public double getBitcoinAmount()
  {
    return bitcoinAmount;
  }

  public String getEmail()
  {
    return email;
  }

  public double getTradeVolumn()
  {
    return tradeVolumn;
  }

  public String getPasscode()
  {
    return passcode;
  }

  public String getUserstatus()
  {
    return userstatus;
  }

  public String getCreditlevel()
  {
    return creditlevel;
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
  /* Code from template association_GetOne */
  public BitcoinSystem getBitcoinSystem()
  {
    return bitcoinSystem;
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
  /* Code from template association_GetMany */
  public Trade getTrade(int index)
  {
    Trade aTrade = trades.get(index);
    return aTrade;
  }

  public List<Trade> getTrades()
  {
    List<Trade> newTrades = Collections.unmodifiableList(trades);
    return newTrades;
  }

  public int numberOfTrades()
  {
    int number = trades.size();
    return number;
  }

  public boolean hasTrades()
  {
    boolean has = trades.size() > 0;
    return has;
  }

  public int indexOfTrade(Trade aTrade)
  {
    int index = trades.indexOf(aTrade);
    return index;
  }
  /* Code from template association_GetMany */
  public Transaction getTransaction(int index)
  {
    Transaction aTransaction = transactions.get(index);
    return aTransaction;
  }

  public List<Transaction> getTransactions()
  {
    List<Transaction> newTransactions = Collections.unmodifiableList(transactions);
    return newTransactions;
  }

  public int numberOfTransactions()
  {
    int number = transactions.size();
    return number;
  }

  public boolean hasTransactions()
  {
    boolean has = transactions.size() > 0;
    return has;
  }

  public int indexOfTransaction(Transaction aTransaction)
  {
    int index = transactions.indexOf(aTransaction);
    return index;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfAdvertisements()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Advertisement addAdvertisement(String aId, String aAdType, String aRate, String aCurrency, String aPaymentMethod, String aAdStatus, double aPrice, String aCreateTime, double aMin, double aMax, BitcoinSystem aBitcoinSystem)
  {
    return new Advertisement(aId, aAdType, aRate, aCurrency, aPaymentMethod, aAdStatus, aPrice, aCreateTime, aMin, aMax, this, aBitcoinSystem);
  }

  public boolean addAdvertisement(Advertisement aAdvertisement)
  {
    boolean wasAdded = false;
    if (advertisements.contains(aAdvertisement)) { return false; }
    User existingCreator = aAdvertisement.getCreator();
    boolean isNewCreator = existingCreator != null && !this.equals(existingCreator);
    if (isNewCreator)
    {
      aAdvertisement.setCreator(this);
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
    //Unable to remove aAdvertisement, as it must always have a creator
    if (!this.equals(aAdvertisement.getCreator()))
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
      existingBitcoinSystem.removeUser(this);
    }
    bitcoinSystem.addUser(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfServices()
  {
    return 0;
  }
  /* Code from template association_AddManyToManyMethod */
  public boolean addService(Service aService)
  {
    boolean wasAdded = false;
    if (services.contains(aService)) { return false; }
    services.add(aService);
    if (aService.indexOfUser(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aService.addUser(this);
      if (!wasAdded)
      {
        services.remove(aService);
      }
    }
    return wasAdded;
  }
  /* Code from template association_RemoveMany */
  public boolean removeService(Service aService)
  {
    boolean wasRemoved = false;
    if (!services.contains(aService))
    {
      return wasRemoved;
    }

    int oldIndex = services.indexOf(aService);
    services.remove(oldIndex);
    if (aService.indexOfUser(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aService.removeUser(this);
      if (!wasRemoved)
      {
        services.add(oldIndex,aService);
      }
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
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfTrades()
  {
    return 0;
  }
  /* Code from template association_AddManyToManyMethod */
  public boolean addTrade(Trade aTrade)
  {
    boolean wasAdded = false;
    if (trades.contains(aTrade)) { return false; }
    trades.add(aTrade);
    if (aTrade.indexOfUser(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aTrade.addUser(this);
      if (!wasAdded)
      {
        trades.remove(aTrade);
      }
    }
    return wasAdded;
  }
  /* Code from template association_RemoveMany */
  public boolean removeTrade(Trade aTrade)
  {
    boolean wasRemoved = false;
    if (!trades.contains(aTrade))
    {
      return wasRemoved;
    }

    int oldIndex = trades.indexOf(aTrade);
    trades.remove(oldIndex);
    if (aTrade.indexOfUser(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aTrade.removeUser(this);
      if (!wasRemoved)
      {
        trades.add(oldIndex,aTrade);
      }
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addTradeAt(Trade aTrade, int index)
  {  
    boolean wasAdded = false;
    if(addTrade(aTrade))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfTrades()) { index = numberOfTrades() - 1; }
      trades.remove(aTrade);
      trades.add(index, aTrade);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveTradeAt(Trade aTrade, int index)
  {
    boolean wasAdded = false;
    if(trades.contains(aTrade))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfTrades()) { index = numberOfTrades() - 1; }
      trades.remove(aTrade);
      trades.add(index, aTrade);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addTradeAt(aTrade, index);
    }
    return wasAdded;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfTransactions()
  {
    return 0;
  }
  /* Code from template association_AddManyToManyMethod */
  public boolean addTransaction(Transaction aTransaction)
  {
    boolean wasAdded = false;
    if (transactions.contains(aTransaction)) { return false; }
    transactions.add(aTransaction);
    if (aTransaction.indexOfUser(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aTransaction.addUser(this);
      if (!wasAdded)
      {
        transactions.remove(aTransaction);
      }
    }
    return wasAdded;
  }
  /* Code from template association_RemoveMany */
  public boolean removeTransaction(Transaction aTransaction)
  {
    boolean wasRemoved = false;
    if (!transactions.contains(aTransaction))
    {
      return wasRemoved;
    }

    int oldIndex = transactions.indexOf(aTransaction);
    transactions.remove(oldIndex);
    if (aTransaction.indexOfUser(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aTransaction.removeUser(this);
      if (!wasRemoved)
      {
        transactions.add(oldIndex,aTransaction);
      }
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addTransactionAt(Transaction aTransaction, int index)
  {  
    boolean wasAdded = false;
    if(addTransaction(aTransaction))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfTransactions()) { index = numberOfTransactions() - 1; }
      transactions.remove(aTransaction);
      transactions.add(index, aTransaction);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveTransactionAt(Transaction aTransaction, int index)
  {
    boolean wasAdded = false;
    if(transactions.contains(aTransaction))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfTransactions()) { index = numberOfTransactions() - 1; }
      transactions.remove(aTransaction);
      transactions.add(index, aTransaction);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addTransactionAt(aTransaction, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    for(int i=advertisements.size(); i > 0; i--)
    {
      Advertisement aAdvertisement = advertisements.get(i - 1);
      aAdvertisement.delete();
    }
    BitcoinSystem placeholderBitcoinSystem = bitcoinSystem;
    this.bitcoinSystem = null;
    if(placeholderBitcoinSystem != null)
    {
      placeholderBitcoinSystem.removeUser(this);
    }
    ArrayList<Service> copyOfServices = new ArrayList<Service>(services);
    services.clear();
    for(Service aService : copyOfServices)
    {
      if (aService.numberOfUsers() <= Service.minimumNumberOfUsers())
      {
        aService.delete();
      }
      else
      {
        aService.removeUser(this);
      }
    }
    ArrayList<Trade> copyOfTrades = new ArrayList<Trade>(trades);
    trades.clear();
    for(Trade aTrade : copyOfTrades)
    {
      if (aTrade.numberOfUsers() <= Trade.minimumNumberOfUsers())
      {
        aTrade.delete();
      }
      else
      {
        aTrade.removeUser(this);
      }
    }
    ArrayList<Transaction> copyOfTransactions = new ArrayList<Transaction>(transactions);
    transactions.clear();
    for(Transaction aTransaction : copyOfTransactions)
    {
      if (aTransaction.numberOfUsers() <= Transaction.minimumNumberOfUsers())
      {
        aTransaction.delete();
      }
      else
      {
        aTransaction.removeUser(this);
      }
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "id" + ":" + getId()+ "," +
            "feedbackScore" + ":" + getFeedbackScore()+ "," +
            "bitcoinAmount" + ":" + getBitcoinAmount()+ "," +
            "email" + ":" + getEmail()+ "," +
            "tradeVolumn" + ":" + getTradeVolumn()+ "," +
            "passcode" + ":" + getPasscode()+ "," +
            "userstatus" + ":" + getUserstatus()+ "," +
            "creditlevel" + ":" + getCreditlevel()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "bitcoinSystem = "+(getBitcoinSystem()!=null?Integer.toHexString(System.identityHashCode(getBitcoinSystem())):"null");
  }
}