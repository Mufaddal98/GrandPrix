
import java.io.*;
import java.sql.Driver;
import java.util.*;

 /**
  * The FileIO class 
  * 
  * @author Muhammad Ibrahim
  * @version 1.0 (31.May.2019)
  * 
  * This FileIO class serves an important function of making our code as reusable as possible
  * while taking maximum use of object oriented programming techniques.
  * This class is responsible to read the two files (drivers.txt and venues.txt)
  * without having us write all this file reading code in their respective classes. Using this class 
  * we have done all the file reading and writing and refreshing in one place.
    
  */
    

public class FileIO 
{

    public FileIO() 
    {
    }
   
    /**
     * This method is reading the list of drivers from the "drivers.txt" file.
     * 
     * @param drivers to read the name of each driver.
     * @return void, nothing is returned within this method.
     */
    public void readDrivers(ListOfDrivers drivers) 
    {
        String fileName = "drivers.txt";
        FileReader fileReader = null; // why null?
        try 
        {
            fileReader = new FileReader(fileName); // why not writing FileReader here?
            Scanner console = new Scanner(fileReader);          

            drivers.createList(console); // ?
            
        } catch (FileNotFoundException e)
        {
            System.out.println(e.getMessage()); //is e.getmessage built in?
        } finally 
        {
            try 
            {
                fileReader.close();
            } catch (IOException e) 
            {
                e.printStackTrace(); // ?
            }
        }
    }

    /**
     * This method reads the list of venues from the "venue.txt" file.
     * 
     * @param venues is being used to store the list of venues after reading it from the :venues.txt" file.
     * @return void, nothing is being returned within this method.
     */
    public void readVenues(ListOfVenues venues) 
    {
        String fileName = "venues.txt";

        FileReader fileReader = null;
        try 
        {
            fileReader = new FileReader(fileName);
            Scanner console = new Scanner(fileReader);

            venues.createVenueList(console);

        } catch (FileNotFoundException e) 
        {
            System.out.println(e.getMessage());
        } finally 
        {
            try {
                fileReader.close();
            } catch (IOException e)
            {
                e.printStackTrace();
            }
        }

    }
    
    /**
     * This method refreshes the drivers.txt file so that it contains the default values everytime we run our code.
     * 
     * @param No parameters are used in this method.
     * @return void, nothing is being returned within this method.
     */

    public void refreshDrivers() 
    {
        PrintWriter write = null;
        try 
        {
            String fileName = "drivers.txt";
            write = new PrintWriter(fileName);

            write.println("Brendon Hartley,1,braking,1,0\n" +
                    "Sebastian Vettel,2,cornering,1,0\n" +
                    "Kamui Kobiyashi,3,overtaking,1,0\n" +
                    "Daniel Ricciardo,4,cornering,1,0\n" +
                    "Jules Bianchi,5,cornerning,1,0" 
                    //"Erlich,5,overtaking,1,0\n"+
                    //"Barney,5,braking,1,0\n"+
                    //"Ron,5,cornerirng,1,0\n"+
                    //"Ben,5,overtaking,1,0"
            );

        } catch (IOException e) 
        {
            System.out.println(e.getMessage());
        } finally
        {
            write.close();
        }
    }
    
    /**
     * This method is writing the updated ranks of the drivers in the "drivers.txt" file after the end of
     * every championship.
     * 
     * @param drivers is being used in this method to store their ranks according to their ranks after
     * each race and championship.
     * @return void, nothing is being returned within this method,
     */
    public void updateDrivers(ListOfDrivers drivers) 
    {
        PrintWriter write = null;
        try 
        {
            String fileName = "drivers.txt";
            write = new PrintWriter(fileName);

            drivers.printDriversToFile(write); // not writing right, do we need a for loop like last code?

        } 
        catch (IOException e) 
        {
            System.out.println(e.getMessage());
        } 
        finally 
        {
            write.close();
        }
    }

}
