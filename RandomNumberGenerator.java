
   /**
  * The RandomNumberGenerator class is used to generate random numbers using the maximum and minimum values given to it in the methods.
  * It is used to determine various probabilities and a few allocations randomly.
  * 
  * 
  * @author Muhammad Ibrahim
  * @version 1.0 (31.May.2019)
  */
 
 /**
  * Declaring the two fields of the class.
  * 
  * @return class
  */
public class RandomNumberGenerator 
{

    private int minimumValue;
    private int maximumValue;
    
    /**
     * This is the default constructor for the RandomNumberGenerator class.
     */
    public RandomNumberGenerator()
    {
        minimumValue = 0;
        maximumValue = 0;
        
    }
    
    /**
     * This is the non-default constructor for the RandomNumberGenerator class.
     * 
     * @param minimumValue and maximumValue are used for assign different upper and lower
     * limits for the random number geenrator in this class.
     */
    public RandomNumberGenerator(int minimumValue, int maximumValue)
    {
        this.minimumValue = minimumValue;
        this.maximumValue = maximumValue; 
    }


    /**
     * This is the method to check for the probability of the rain during the championship.
     * 
     * @param per is a local variable being used in this method for comparison.
     * @return boolean is returned to check if it will rain or not.
     */
    public boolean checkForRain(double per) 
    {
        boolean ch = false;
        int rainPercent = (int) (Math.random()*100) + 1;
        if  (rainPercent <= per)
        {
            ch = true;
        }
        return ch;
    }


//    public boolean fiftyPer() {
//        boolean ch = false;
//        int fiftyPercent = (int) (Math.random()*100) + 1;
//        if  (fiftyPercent <= 50){
//            ch = true;
//        }
//        return ch;
//    }

    
    public boolean randomNumGen(int minimumValue, int maximumValue)
    {
        boolean b = false;
        int percent = (int) (Math.random()*maximumValue) + minimumValue;
        if  (percent<= 3)
        {
            b = true;
        }
        return b;
    }


//    public boolean minorMechanicalFault(){
//        boolean fiveOrMore = false;
//        int fivePercent = (int) (Math.random()*100) + 5;
//        if  (fivePercent <= 5){
//            fiveOrMore = true;
//        }
//        return fiveOrMore;
//    }

/**
 * This is the method commonly being used in other classes to generate random number using
 *  the amximum and minimum values.
 *  
 *  @param minimumValue and maximumValue are being used in this method to assign upper and lower
 *  limit for the random number generator.
 *  @return int is returned as this method is used to generate random numbers.
 */
    public int randomNumGen2(int minimumValue, int maximumValue)
    {
        int time = (int) (Math.random()*maximumValue) + minimumValue;        //will give lap time between 1 and 8 seconds
        return time;
    }

//    public int oneToTwo() {
//        int no = (int) (Math.random()*2) + 1;        //will give lap time between 10 and 20 seconds
//        return no;
//    }

//    public int tenToTwenty(){
//        int time = (int) (Math.random()*11) + 10;        //will give lap time between 10 and 20 seconds
//        return time;
//    }


//    public boolean unrecoverableMechanicalFault(){
//        boolean oneOrMore = false;
//        int onePercent = (int) (Math.random()*100) + 1;
//        if  (onePercent <= 1){
//            oneOrMore = true;
//        }
//        return oneOrMore;
//    }

//    public int determineVenue(){
//        int num = (int) (Math.random()*8) + 1;
//        return num;
//    }


}
