/**
  * The Venue class holds all the details of the venues for the races.
  * 
  * 
  * @author Muhammad Ibrahim
  * @version 1.0 (31.May.2019)
  */
 
 
 /**
  * Declaring the fields of the class.
  * 
  * @return class
  */   
public class Venue 
{

    private int noOfLaps, avgTime;
    private double rainPer;
    private String name;
    private boolean used;

    /**
     * This is the default constructor for the Venue class.
     */
    public Venue() 
    {
        noOfLaps = 0;
        avgTime = 0;
        rainPer = 0;
        name = "";
        used = false;
        
    }

    /**
     * This is the non-default constructor of the Venue.
     * 
     * @param noOfLaps, avgTime, rainPer, name and used are all the features of the venues which vary for rach race. 
     */
    public Venue(int noOfLaps, int avgTime, int rainPer,String name,boolean used)
    {
        this.noOfLaps = noOfLaps;
        this.avgTime = avgTime;
        this.rainPer = rainPer;
        this.name = name;
        this.used = used;
    }

    /**
     * This is the accessor method of noOfLaps.
     * 
     * @return int is the value, which shows the number of laps in each venue.
     */
    public int getNoOfLaps()
    {
        return noOfLaps;
    }

    /**
     * This is the mutator method of noOfLaps.
     * 
     * @param noOfLaps, as each venue has different number of laps.
     * @return void, as nothing is to be returned in this method.
     */
    public void setNoOfLaps(int noOfLaps) 
    {
        this.noOfLaps = noOfLaps;
    }

    /**
     * This is the accessor method of avgTime.
     * 
     * @return int, as each venue has a different average time.
     */
    public int getAvgTime() 
    {
        return avgTime;
    }

    /**
     * This is the mutator method of the avgTime.
     * 
     * @param avgTime to change the averagew time of any of the venue.
     * @return void, as nothing is to be returned in this method.
     */
    public void setAvgTime(int avgTime) 
    {
        this.avgTime = avgTime;
    }

    /**
     * This is the accessor method of the rainPer.
     * 
     * @return int to get the rain probability of the venue.
     */
    public double getRainPer() 
    {
        return rainPer;
    }

    /**
     * This is the mutator method of the rainPer.
     * 
     * @param rainPer is the to set the rain probability of each venue.
     * @return void, as nothing is to be returned in this method.
     */
    public void setRainPer(int rainPer)
    {
        this.rainPer = rainPer;
    }

    /**
     * This is the accessor method to get the venue name.
     * 
     * @return String to get the string value of the venue name.
     */
    public String getName()
    {
        return name;
    }

    /**
     * This si the mutator method for the venue name.
     * 
     * @param name to set the different names of the venue.
     * @return void, as nothing is to be returned in this method.
     */
    public void setName(String name) 
    {
        this.name = name;
    }

    /**
     * This is the accessor method to check if the venue has been used in 
     * the championship.
     * 
     * @return boolean will return true or false to make sure the venue is not re used.
     */
    public boolean isUsed() 
    
    {
        return used;
    }

    /**
     * This is the mutator method of the used method.
     * 
     * @param used will be updated after a venue has been reselected in the 
     * championship.
     * @return void, as nothing is expected to be returned in this method.
     */
    public void setUsed(boolean used)
    {
        this.used = used;
    }
}
