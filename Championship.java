import java.io.IOException;
import java.io.*;
import java.util.*;
import java.util.InputMismatchException;

 /**
  * The Championship class is the main class of the program, it controls the game. All features and metjods of the game are called
  * in this class to play the game.
  * 
  * @author Muhammad Ibrahim
  * @version 1.0 (31.May.2019)
  */
    

 /**
  * The fields of the class are being declared.
  * 
  * @return class
  */
public class Championship 
{

    private ListOfDrivers drivers;
    private ListOfVenues venues;

    private FileIO file;
    private RandomNumberGenerator rng;

    public Championship() 
    {

        while (true) 
        {
            file = new FileIO();
            file.refreshDrivers();
            drivers = new ListOfDrivers();
            file.readDrivers(drivers);
            venues = new ListOfVenues();
            file.readVenues(venues);
            rng = new RandomNumberGenerator();

            startChampionship();
            System.out.println("Do you wish to start a new Championship? (Y/N) ");
            String y_n = scanner.next();

            if (!y_n.equalsIgnoreCase("y") && !y_n.equalsIgnoreCase("n")) 
            {
                while (!(y_n.equalsIgnoreCase("y")) && !(y_n.equalsIgnoreCase("n"))) 
                {
                    System.out.println("Please enter Y or N! ");
                    y_n = scanner.next();
                }
            }
            if (y_n.equalsIgnoreCase("n"))
                break;

            clearScreen();

        }
    }

    Scanner scanner = new Scanner(System.in);

    /**
     * This method is awarding the points to the drivers after each race and givig them ranks accordingly.
     * Drivers are first being sorted by time and then by points for the ranking.
     * 
     * @return void,as nothing is being returned within this method.
     */
    public void awardPoints() 
    {
        System.out.println("\n...Awarding points...");
        drivers.sortByTime();
        int c = 1;
        for (int i = 0; i < drivers.getDrivers().size(); i++) {
            if (drivers.getDrivers().get(i).getEligibilty() == 0) {
                continue;
            }
            if (c > 4) {
                break;
            }
        try {
            if (drivers.getDrivers().get(i).getTime() == drivers.getDrivers().get(i + 1).getTime()) {
                System.out.println("Time was equal");
                int no = rng.randomNumGen2(1,2);
                if (no < 2) {
                    setPoints(c, i);
                } else {
                    setPoints(c, i + 1);
                }
                c = c + 2;
                i++;
                continue;
            }
        } catch(Exception e) {
            break;
        }
            setPoints(c, i);
            c++;
        }

        //set ranks
        drivers.sortByPoints();
        for (int i = 0; i < drivers.getDrivers().size(); i++) {
            drivers.getDrivers().get(i).setRanking(i + 1);
        }
    }
    
    /**
     * This method makes the drivers change their tyres to wet tyres if it rains. The probability to change
     * to wet tyres is based on a random numberfor each driver.
     * 
     * @param rainPer and lap are being used in this method to check rain in each lap, and then run the probability
     *   to chnage to wet tyres for each drivers.
     * @return void, as nothing is being returned within this mehtod.
     */
    public void bonusFunction(double rainPer, int lap)
    {

        if (lap == 2) 
        {
            for (int i = 0;i<drivers.getDrivers().size();i++) 
            {
                if (drivers.getDrivers().get(i).getEligibilty() == 0) 
                {
                    continue;
                }
                if (rng.randomNumGen(1,100)) 
                {
                    drivers.getDrivers().get(i).setTyreType("wet");
                    System.out.println("Driver: " + drivers.getDrivers().get(i).getName() + " changed his tyres to Wet Weather Tyres adding 10" +
                            " seconds");
                    drivers.getDrivers().get(i).setTime(drivers.getDrivers().get(i).getTime() + 10);
                }
            }
        }

        boolean isRain = rng.checkForRain(rainPer);
        if (isRain) 
        {
            System.out.println("Rain occured during this lap");
            for (int i = 0;i<drivers.getDrivers().size();i++) 
            {
                if (drivers.getDrivers().get(i).getEligibilty() == 0) 
                {
                    continue;
                }
                if (drivers.getDrivers().get(i).getTyreType().equals("dry"))
                {
                    System.out.println(drivers.getDrivers().get(i).getName() + " got delayed 5 seconds due to dry weather tyres");
                }
            }
        }

    }

    /**
     * This method is used to clear the screen.
     * 
     * @return void, as nothing is returned within this method.
     */
    public void clearScreen() 
    {
        for (int i = 0; i < 50; i++) 
        {
            System.out.println();
        }
    }

    /**
     * This method randomly generates a number to select 1 out of 8 venues. It also ensures that no venue is
     * used twice for the championship
     * 
     * @return int, as the venue has been given int numbers and this method geenrates numbers for the selection
     * of the venue.
     */
    public int chooseVenue() 
    {    
       
        //check if venue has been used before
        while (true)
        {
            if(venues.getVenues().size() < 5) 
            {
                System.out.println("The total number of venues cannot be lesss than 5");
                System.exit(0);
                break;
            }
            System.out.print("\nGenerating a random number between 1-8 to select a venue.. ");
           
            int v = rng.randomNumGen2(1,venues.getVenues().size());
            if (venues.getVenues().get(v - 1).isUsed()) 
            {
                System.out.println("This venue has already been used. Selecting another venue");
                continue;
            }
            venues.getVenues().get(v - 1).setUsed(true);
            return v-1;
        }
        
        return 0;
    }

    /**
     * This method displays the winner of the championship. It displays the winner driver's name and points.
     * 
     * @reyurn void, as scanner class is being used to display the message.
     */
    public void displayChampionshipResult() 
    {
        drivers.sortByPoints();

        System.out.print("*** Press Enter to display championship results *** ");
        scanner.nextLine();

        //to check if the winner has not suffered an unrecoverable fault
        int c = 0;
        while (true)
        {
            if (drivers.getDrivers().get(c).getEligibilty() == 1) 
            {
                System.out.println("\n\nThe Winner is: " + drivers.getDrivers().get(c).getName() + " with " + drivers.getDrivers().get(c).getPoints() + " points");
                break;
            } else 
            {
                c++;
            }
        }
    }

    /**
     * This method displays the result of each race, by displaying the name and points, according
     * to the sorted ranks.
     * 
     * @return void, as scanner class is being used to display the results.
     */
    public void displayResults()
    {
        drivers.sortByPoints();

        System.out.println(" " + " NAME " + "-" + " POINTS ");
        int c = 1;
        for (int i = 0; i < 10; i++) //can we make this 5?
        {
            if (c > 4)
                break;               
            try 
            {
            if (drivers.getDrivers().get(i).getEligibilty() == 0) 
            {
                continue;
            }
            System.out.println((i + 1) + " - " + drivers.getDrivers().get(i).getName() + " - " + drivers.getDrivers().get(i).getPoints());
            c++;
            } catch(Exception e)
            {
                break;
            }
        }
    }

    /**
     * This method asks the user to input the number of races for the championship.
     * The method also ensures that the races are between 3 to 5.
     * 
     * @return int is returned in this method, as user is asked to input the number of races 
     * for the championship.
     */
    public int inputNumOfRaces() 
    {
        int numOfRaces;
        while (true)
        {
            try 
            {
                System.out.println("\n*** Please select the number of races for the Chamionship!(Should be between 3 and 5) *** ");
                Scanner scanner = new Scanner(System.in);
                numOfRaces = scanner.nextInt();
                if (numOfRaces < 3 || numOfRaces > 5) 
                {
                    while (numOfRaces < 3 || numOfRaces > 5) 
                    {
                        System.out.println("The number of races should be between 3 and 5. Please enter again: ");
                        numOfRaces = scanner.nextInt();
                    }
                }
                break;
            } catch (Exception e) 
            {
//                System.out.println("Please only enter an integer!");
                System.out.println(e.getMessage());
            }
        }
        return numOfRaces;

    }

    /**
     * This method is called in every lap of each race to check all the validstions and conditions of the game.
     * It checks the penalties for the drivers, their skills, faults and also the weather.
     * 
     * @param lap and rainper are being used to check all the validations and conditions in each lap, including the 
     * probablity for rain.
     * @return void, as scanner class is being used in this method.
     */
    public void runLap(int lap, double rainPer)
    {
        System.out.println("\n\nLap: " + lap);
        System.out.println("*** Setting Penalties ***");
        drivers.setPenalties();
        System.out.println("*** Using Skills ***");
        drivers.useSkills(lap);
        System.out.println("*** Checking for Faults ***");
        drivers.checkForFaults();
        System.out.println("*** Checking the Weather ***");
        bonusFunction(rainPer, lap);
    }

    /**
     * This method allocating points to the drivers after each race based on their 
     * positions at the end of each race.
     * 
     * @param position and driver are being used are to check the position of each driver after the end of every race.
     * @return void, as switch case is being used here and nothing is being returned within this method.
     */
    public void setPoints(int position, int driver) 
    {
        switch (position)
        {
            case 1:
                drivers.getDrivers().get(driver).setPoints(drivers.getDrivers().get(driver).getPoints() + 8);
                break;
            case 2:
                drivers.getDrivers().get(driver).setPoints(drivers.getDrivers().get(driver).getPoints() + 5);
                break;
            case 3:
                drivers.getDrivers().get(driver).setPoints(drivers.getDrivers().get(driver).getPoints() + 3);
                break;
            case 4:
                drivers.getDrivers().get(driver).setPoints(drivers.getDrivers().get(driver).getPoints() + 1);
                break;
        }
    }

    /**
     * This is one of the main method of this class. It starts the whole game by calling various methods from different 
     * classes. This method starts by asking the user for the number of races and shows the end result and also updates
     * the driver.txt file with the new ranking.
     * 
     * @return void, as scanner class is being used in this method.
     */
    public void startChampionship() 
    {
        int noOfRaces = inputNumOfRaces();
        for (int i = 1; i <= noOfRaces; i++) 
        {
            System.out.println("Race no: " + i);
            int venue = chooseVenue();
            System.out.println(" The Venue for the race is " + venues.getVenues().get(venue).getName());
            startRace(venues.getVenues().get(venue).getAvgTime(), 
                venues.getVenues().get(venue).getNoOfLaps(),
                venues.getVenues().get(venue).getRainPer());
            awardPoints();
            displayResults();

            //Writing the updated ranks to file
            file.updateDrivers(drivers);
        }
        displayChampionshipResult();
    }

    /**
     * This methods asks the user to press enter to start the race. It also sets the drivers
     * time for the racebased on the average time of the venue.
     * 
     * @param avgTime, noOfLaps and rainPer are being used here to assign the average time of the venue to the driver after each race,
     * it is running the number of laps for each race.
     */
    public void startRace(int avgTime, int noOfLaps, double rainPer) 
    {
        
        //refreshing drivers
        for (int i = 0; i<drivers.getDrivers().size(); i++) 
        {
            drivers.getDrivers().get(i).setEligibilty(1);
        }
        
        System.out.print("\n\nPress Enter to start Race: ");
        scanner.nextLine();

        drivers.setRaceTime(0);
        drivers.setRaceTime(avgTime);
        for (int i = 1; i <= noOfLaps; i++) 
        {
            runLap(i, rainPer);
        }
    }

}