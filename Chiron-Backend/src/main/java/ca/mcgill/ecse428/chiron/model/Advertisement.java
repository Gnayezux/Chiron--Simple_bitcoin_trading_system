/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.0.4181.a593105a9 modeling language!*/

package ca.mcgill.ecse428.chiron.model;
import java.util.*;

// line 3 "../../../../../ChironModel.ump"
public class Advertisement
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Advertisement Attributes
  private String id;
  private String adType;
  private String rate;
  private String currency;
  private String paymentMethod;
  private String adStatus;
  private double price;
  private String createTime;
  private double min;
  private double max;

  //Advertisement Associations
  private List<Trade> trades;
  private User creator;
  private BitcoinSystem bitcoinSystem;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Advertisement(String aId, String aAdType, String aRate, String aCurrency, String aPaymentMethod, String aAdStatus, double aPrice, String aCreateTime, double aMin, double aMax, User aCreator, BitcoinSystem aBitcoinSystem)
  {
    id = aId;
    adType = aAdType;
    rate = aRate;
    currency = aCurrency;
    paymentMethod = aPaymentMethod;
    adStatus = aAdStatus;
    price = aPrice;
    createTime = aCreateTime;
    min = aMin;
    max = aMax;
    trades = new ArrayList<Trade>();
    boolean didAddCreator = setCreator(aCreator);
    if (!didAddCreator)
    {
      throw new RuntimeException("Unable to create advertisement due to creator");
    }
    boolean didAddBitcoinSystem = setBitcoinSystem(aBitcoinSystem);
    if (!didAddBitcoinSystem)
    {
      throw new RuntimeException("Unable to create advertisement due to bitcoinSystem");
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

  public boolean setAdType(String aAdType)
  {
    boolean wasSet = false;
    adType = aAdType;
    wasSet = true;
    return wasSet;
  }

  public boolean setRate(String aRate)
  {
    boolean wasSet = false;
    rate = aRate;
    wasSet = true;
    return wasSet;
  }

  public boolean setCurrency(String aCurrency)
  {
    boolean wasSet = false;
    currency = aCurrency;
    wasSet = true;
    return wasSet;
  }

  public boolean setPaymentMethod(String aPaymentMethod)
  {
    boolean wasSet = false;
    paymentMethod = aPaymentMethod;
    wasSet = true;
    return wasSet;
  }

  public boolean setAdStatus(String aAdStatus)
  {
    boolean wasSet = false;
    adStatus = aAdStatus;
    wasSet = true;
    return wasSet;
  }

  public boolean setPrice(double aPrice)
  {
    boolean wasSet = false;
    price = aPrice;
    wasSet = true;
    return wasSet;
  }

  public boolean setCreateTime(String aCreateTime)
  {
    boolean wasSet = false;
    createTime = aCreateTime;
    wasSet = true;
    return wasSet;
  }

  public boolean setMin(double aMin)
  {
    boolean wasSet = false;
    min = aMin;
    wasSet = true;
    return wasSet;
  }

  public boolean setMax(double aMax)
  {
    boolean wasSet = false;
    max = aMax;
    wasSet = true;
    return wasSet;
  }

  public String getId()
  {
    return id;
  }

  public String getAdType()
  {
    return adType;
  }

  public String getRate()
  {
    return rate;
  }

  public String getCurrency()
  {
    return currency;
  }

  public String getPaymentMethod()
  {
    return paymentMethod;
  }

  public String getAdStatus()
  {
    return adStatus;
  }

  public double getPrice()
  {
    return price;
  }

  public String getCreateTime()
  {
    return createTime;
  }

  public double getMin()
  {
    return min;
  }

  public double getMax()
  {
    return max;
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
  /* Code from template association_GetOne */
  public User getCreator()
  {
    return creator;
  }
  /* Code from template association_GetOne */
  public BitcoinSystem getBitcoinSystem()
  {
    return bitcoinSystem;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfTrades()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Trade addTrade(String aStartTime, String aEndTime, String aAmount, String aTradeStatus, User... allUsers)
  {
    return new Trade(aStartTime, aEndTime, aAmount, aTradeStatus, this, allUsers);
  }

  public boolean addTrade(Trade aTrade)
  {
    boolean wasAdded = false;
    if (trades.contains(aTrade)) { return false; }
    Advertisement existingAdvertisement = aTrade.getAdvertisement();
    boolean isNewAdvertisement = existingAdvertisement != null && !this.equals(existingAdvertisement);
    if (isNewAdvertisement)
    {
      aTrade.setAdvertisement(this);
    }
    else
    {
      trades.add(aTrade);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeTrade(Trade aTrade)
  {
    boolean wasRemoved = false;
    //Unable to remove aTrade, as it must always have a advertisement
    if (!this.equals(aTrade.getAdvertisement()))
    {
      trades.remove(aTrade);
      wasRemoved = true;
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
  /* Code from template association_SetOneToMany */
  public boolean setCreator(User aCreator)
  {
    boolean wasSet = false;
    if (aCreator == null)
    {
      return wasSet;
    }

    User existingCreator = creator;
    creator = aCreator;
    if (existingCreator != null && !existingCreator.equals(aCreator))
    {
      existingCreator.removeAdvertisement(this);
    }
    creator.addAdvertisement(this);
    wasSet = true;
    return wasSet;
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
      existingBitcoinSystem.removeAdvertisement(this);
    }
    bitcoinSystem.addAdvertisement(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    for(int i=trades.size(); i > 0; i--)
    {
      Trade aTrade = trades.get(i - 1);
      aTrade.delete();
    }
    User placeholderCreator = creator;
    this.creator = null;
    if(placeholderCreator != null)
    {
      placeholderCreator.removeAdvertisement(this);
    }
    BitcoinSystem placeholderBitcoinSystem = bitcoinSystem;
    this.bitcoinSystem = null;
    if(placeholderBitcoinSystem != null)
    {
      placeholderBitcoinSystem.removeAdvertisement(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "id" + ":" + getId()+ "," +
            "adType" + ":" + getAdType()+ "," +
            "rate" + ":" + getRate()+ "," +
            "currency" + ":" + getCurrency()+ "," +
            "paymentMethod" + ":" + getPaymentMethod()+ "," +
            "adStatus" + ":" + getAdStatus()+ "," +
            "price" + ":" + getPrice()+ "," +
            "createTime" + ":" + getCreateTime()+ "," +
            "min" + ":" + getMin()+ "," +
            "max" + ":" + getMax()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "creator = "+(getCreator()!=null?Integer.toHexString(System.identityHashCode(getCreator())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "bitcoinSystem = "+(getBitcoinSystem()!=null?Integer.toHexString(System.identityHashCode(getBitcoinSystem())):"null");
  }
}