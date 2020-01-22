import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.*;

 /**
  * The ListOfDrivers class 
  * 
  * @author Muhammad Ibrahim
  * @version 1.0 (31.May.2019)
  * 
  * This ListOfDrivers class is used to create a list of all the drivers given in the drivers.txt file and store them in an Arraylist.
  * This class is also serving the purpose of sorting the list and assessing the faults etc as given in the requirements.
  */
    
public class ListOfDrivers
{

    private ArrayList<Drivers> drivers;
    private RandomNumberGenerator rng;

    public ListOfDrivers() 
    {
        rng = new RandomNumberGenerator();
        
        drivers = new ArrayList();
    }

    public ArrayList<Drivers> getDrivers() 
    {
        return drivers;
    }

    /**
     * This method runs the probability for the occurance of minir, major or unrecoverable fault during the race for each player in each lap.
     * 
     * @return void, nothing is to be returned within this method.
     */
    public void checkForFaults() 
    {

        for (Drivers driver : drivers) 
        {
            if (driver.getEligibilty() == 0) 
            {
                continue;
            }
            if (rng.randomNumGen(5,100)) 
            {
                driver.setTime(driver.getTime() + 20);
                System.out.println(driver.getName() + " suffered a minor fault and added :" + 20);
            }
            if (rng.randomNumGen(3,100)) 
            {
                System.out.println(driver.getName() + " - " + driver.getTime());
                driver.setTime(driver.getTime() + 120);
                System.out.println(driver.getName() + " suffered a major fault and added :" + 120);
            }
            if (rng.randomNumGen(1,100)) 
            {
                driver.setEligibilty(0);
                System.out.println(driver.getName() + " suffered an unrecoverable fault and is no longer eligible");
            }
        }
    }
    
    /**
     * This method stores all the data read by FileIO class from drivers.txt into an ArrayList.
     * 
     * @param console is being used to read the data from the drivers.txt" file.
     * @return void, nothing is being returned within this method.
     */
    public void createList(Scanner console) 
    {        
        
        while (console.hasNextLine()) //Will return true and keep going on and cover every line in the file
        {
                String line = console.nextLine(); //Reads the lines in the file line by line
                String[] values = line.split(",");
                Drivers driver = new Drivers();
                driver.setName(values[0]);
                driver.setRanking(Integer.parseInt(values[1]));
                driver.setSkill(values[2]);
                driver.setEligibilty(Integer.parseInt(values[3]));
                driver.setPoints(Integer.parseInt(values[4]));
                drivers.add(driver);
        }
    }
    
    /**
     * This method is responsible to print the updated names (the new rankings after races have been ran) back to the drivers.txt file.
     * 
     * @params write is being used in order to write the updated names in the drivers.txt file
     * @return void, nothing is being returned within this method.
     */
    
    public void printDriversToFile(PrintWriter write) 
    {
        for (Drivers driver : drivers) 
        {
                write.println(driver.getName() + "," + driver.getRanking() + "," +
                        driver.getSkill() + "," + driver.getEligibilty() + "," + driver.getPoints());
            }
    }

    /**
     * This method is adding the time to each driver at the start of each race depending on their starting position.
     * 
     * @return void, as nothing is to be returned within this method.
     */
    public void setPenalties() 
    {
        //Check ranks and add penalty time to race time to each driver here
        for (Drivers driver : drivers)
        {
            if (driver.getEligibilty() == 0)
                continue;
            switch (driver.getRanking()) 
            {
                case 1:
                    break;
                case 2:
                    driver.setTime(driver.getTime() + 3);
                    break;
                case 3:
                    driver.setTime(driver.getTime() + 5);
                    break;
                case 4:
                    driver.setTime(driver.getTime() + 7);
                    break;
                case 5:
                    driver.setTime(driver.getTime() + 10);
                    break;
            }
        }
    }

/**
 * This method serves the purpose of checking whether the driver is eligible or not and then assign a randomly generated time to them.
 * 
 * @params time is being used to assess race time for each player
 * @return void, nothing is being returned within this method.
 */
    public void setRaceTime(int time) 
    {
        for (Drivers driver : drivers) 
        {
            if (driver.getEligibilty() == 0)
                continue;
            driver.setTime(time);
        }
    }

    /**
     * This method is being used to sort the driver after each race accoridng to their time for the race.
     * Driver with the least time to complete the race is given the highest rank.
     * 
     * @return void, as nothing is to be returned within this method.
     */
    public void sortByTime() 
    {
        Drivers temp;
        if (drivers.size() > 1) // check if the number of drivers is larger than 1
        {
            for (int x = 0; x < drivers.size(); x++) // bubble sort outer loop
            {
                for (int i = 0; i < drivers.size() - x - 1; i++) 
                {
                    if (drivers.get(i).compareToTime(drivers.get(i + 1)) > 0) 
                    {
                        temp = drivers.get(i);
                        drivers.set(i, drivers.get(i + 1));
                        drivers.set(i + 1, temp);
                    }
                }
            }
        }
    }

    /**
     * This method is being used to sort the drivers after each race according to the points they have
     * been awarded.
     * 
     * @return void, as nothing is to be returned 
     */
    public void sortByPoints()
    {
        Drivers temp;
        if (drivers.size() > 1) // check if the number of drivers is larger than 1
        {
            for (int x = 0; x < drivers.size(); x++) // bubble sort outer loop
            {
                for (int i = 0; i < drivers.size() - x - 1; i++) 
                {
                    if (drivers.get(i).compareToPoints(drivers.get(i + 1)) < 0) 
                    {
                        temp = drivers.get(i);
                        drivers.set(i, drivers.get(i + 1));
                        drivers.set(i + 1, temp);
                    }
                }
            }
        }
    }   
   
    /**
     * This method is being used to assign different skills to each driver during each lap, which
     * gives them a random time reduction aswell, which generated using a random number genertor.
     * "overtaking" skill is only being assigned on every third lap.
     * 
     * @param lap is being used here to assign the skills to drivers during each lap.
     * @return void, as nothing is to be returned within this method.
     */
    public void useSkills(int lap)
    {
        System.out.println();
        for (Drivers driver : drivers)
        {
            if (driver.getEligibilty() == 0)
                continue;
                
            if (driver.getSkill().equals("braking"))
            {
                int rand = rng.randomNumGen2(1,8);
                driver.setTime(driver.getTime() - rand);
                System.out.println(driver.getName() + " used braking and got a reduction of: " + rand + " seconds");
            } 
            else if (driver.getSkill().equals("cornering")) 
            {
                int rand = rng.randomNumGen2(1,8);
                driver.setTime(driver.getTime() - rand);
                System.out.println(driver.getName() + " used cornering and got a reduction of: " + rand + " seconds");
            } 
            else if (driver.getSkill().equals("overtaking")) 
            {
                if (lap % 3 == 0) {
                    int rand = rng.randomNumGen2(10,20);
                    driver.setTime(driver.getTime() - rand);
                    System.out.println(driver.getName() + " used overtaking and got a reduction of: " + rand + " seconds");
                }
            }
        }
        System.out.println();
    }


}
