import java.io.*;
import java.util.*;

 /**
  * The ListOfVenues class 
  * 
  * @author Muhammad Ibrahim
  * @version 1.0 (31.May.2019)
  
  * This ListOfVenues class is used to create an Arraylist of type Venue which will hold the names of all the venues in the venues.txt file 
  * and also hold the other factors that are assigned to each venue.
    
    
    
  */
 
 
    

public class ListOfVenues {

    private ArrayList<Venue> venues;

    public ListOfVenues() 
    {
        
    }
/**
 * This is the accessor method for the ArrayList of venues.
 * 
 * @return ArrayList of Venue, where the list of venues is stored from the txt file.
 */
    public ArrayList<Venue> getVenues()
    {
        return venues;
    }

    public void setVenues(ArrayList<Venue> venues) 
    {
        this.venues = venues;
    }
    
    
    /**
     * This method stores all the data read by FileIO class from venues.txt into an ArrayList.
     * 
     * @param console is being used to read the data from the :venues.txt" file.
     * @return void, nothing is being returned within this method.
     */
    public void createVenueList(Scanner console) 
    {
        
        venues = new ArrayList ();
        
        
        while (console.hasNextLine()) //Will return true and keep going on and cover every line in the file
            {
                String line = console.nextLine(); //Reads the lines in the file line by line
                String[] values = line.split(",");

                //We need team object
                Venue venue = new Venue();
                venue.setName(values[0]);
                venue.setNoOfLaps(Integer.parseInt(values[1]));
                venue.setAvgTime(Integer.parseInt(values[2]));
                venue.setRainPer(Integer.parseInt(values[3]));
                //How do we add this team to the array list?
                venues.add(venue);
            }
            
         
}}
