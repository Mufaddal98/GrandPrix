 /**
  * The Driver class holds all the current and updateds features of the 
  * driver.
  * 
  * @author Muhammad Ibrahim
  * @version 1.0 (31.May.2019)
  */
    
/**
 * Declaring the fields of the class.
 * 
 * @return class
 */   
public class Drivers 
{

    private int ranking, eligibilty;
    private int time, points;
    private String name, skill, tyreType;

    /**
     * this is the default consteructor of the driver.
     */
   public Drivers() 
    {
        ranking = 0;
        eligibilty = 0;
        time = 0;
        points = 0;
        name = "";
        skill = "";
        tyreType = "dry";
    }

    /**
     * This is the non-default constructor of the driver.
     * 
     * @param name, skill, tyreType, ranking, eligibilty, time and points
     *   are all the features of the driver.
     * 
     */
    public Drivers(String name,String skill, String tyreType,int ranking,int eligibilty,int time, int poitns) 
    {
        this.ranking = ranking;
        this.eligibilty = eligibilty;
        this.time = time;
        this.points = points;
        this.name = name;
        this.skill = skill;
        this.tyreType = tyreType;
    }

/**
 * This method converts all types into a string.
 * 
 * @return String is the return type,as the function of this
 *  method is to return everything in string.
 */
    public String toString() 
    {
        return "Drivers{" +
                "ranking=" + ranking +
                ", eligibilty=" + eligibilty +
                ", points=" + points +
                ", name='" + name + '\'' +
                ", skill='" + skill + '\'' +
                ", time='" + time + '\'' +
                '}' + "\n";
    }

    public int compareToTime(Drivers z) 
    {
        int res = 0;
        if (time < z.time)
        {
            res = -1;
        }
        if (time > z.time) 
        {
            res = 1;
        }
        return res;
    }

    public int compareToPoints(Drivers z) 
    {
        int res = 0;
        if (points < z.points) 
        {
            res = -1;
        }
        if (points > z.points) 
        {
            res = 1;
        }
        return res;
    }

    /**
     * This is the accessor method of name
     * 
     * @ return String value is returned for the driver name.
     */
    public String getName() 
    {
        return name;
    }

    /**
     * This is the mutator method for the name.
     * 
     * @param name is to change the driver name
     * @return void, as nothing is to be returned in this mehtod.
     */
    public void setName(String name) 
    {
        this.name = name;
    }
    
/**
 * this is the accessor method for ranking
 * 
 * @return int value is returned for the ranking.
 */
    public int getRanking()
    {
        return ranking;
    }
    
/**
 * this is the mutator method for ranking.
 * 
 * @param ranking is to change the driver ranking.
 * @return void, as nothing is to be returned in this method.
 */
    public void setRanking(int ranking) 
    {
        this.ranking = ranking;
    }

    /**
     * this is the accessor method for the driver's eligibilty.
     * 
     * @return int is returned to check if the driver is eligibilty to 
     *  or not.
     */
    public int getEligibilty() 
    {
        return eligibilty;
    }
/**
 * this is the mutator method for driver's eligibilty.
 * 
 * @param eligibilty is to change the eligibilty of the driver.
 * @return void, as nothing is to be returned in this method.
 */
    public void setEligibilty(int eligibilty) 
    {
        this.eligibilty = eligibilty;
    }

    /**
     * this is the accessor method for driver's points
     * 
     * @return int is returned to get the driver's points.
     */
    public int getPoints() 
    {
        return points;
    }

    /**
     * this is the mutator method for the driver's points.
     * 
     * @param points is to update the drivers points after each lap.
     * @return void, as nothing is to be returned in this method.
     */
    public void setPoints(int points)
    {
        this.points = points;
    }

    /**
     * this is the accessor method for the driver's skill.
     * 
     * @return string is returned to get bthe driver's skill
     */
    public String getSkill() 
    {
        return skill;
    }

    /**
     * thisis the mutator method of the driver's skill.
     * 
     * @param skill is to change the driver's skill
     * @return void, as nothing is to be returned in this method.
     */
    public void setSkill(String skill)
    {
        this.skill = skill;
    }

    /**
     * this is the accessor method of the driver's time.
     * 
     * @return int is returned to get the driver's time.
     */
    public int getTime() 
    {
        return time;
    }

    /**
     * this is the mutator method for the driver's time.
     * 
     * @param time is to update the driver's time after each lap.
     * @return void, as nothing is to be returned in this method.
     */
    public void setTime(int time) 
    {
        this.time = time;
    }

    /**
     * this is the accessor method of the driver's tyre type.
     * 
     * @return string is returned to get the 
     */
    public String getTyreType() 
    {
        return tyreType;
    }

    /**
     * this is the mutator method of the driver's tyre type.
     * 
     * @param tyretype changes the driver's tyre type as per the probablity check.
     */
    public void setTyreType(String tyreType) 
    {
        this.tyreType = tyreType;
    }

}
