package GUI;

/* Author: Abdul El Badaoui
 * Student Number: 5745716
 * Description: This class is the GUI Handler class, and it's jobs is to handle all the forms and classes in the
 * GUI package and navigate the user's choice in inputs and button clicked to the associated forms respectively
 * */
import Properties.*;

import javax.swing.*;
import java.util.ArrayList;


public class GUIHandler {
    //frame to be used for the whole program, which manages the JPanels and the contents it contains
    public static JFrame frame;
    // the property list that will be duplicated from the listOfproperty that is passed throught the constructor
    public static ArrayList<Property> propertyList;
    public static SearchView search;//SearchView instant which will be used through the whole class

    //constructor that passes the complete list of available properties
    public GUIHandler(ArrayList<Property> propertyList){
        this.propertyList =propertyList;//duplicates the list
        frame = new JFrame("SearchView");//frame is initialized
        search = new SearchView(frame);// search instant is initialized
        frame.setContentPane(search.SearchParameter);// the JPanel from the search instant is set in frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//close operation if closed
        frame.pack();//set frame to size
        frame.setVisible(true);//set visibility of the frame


    }

    /*method that passes the search parameter inputs from the SearchVIew form after the Search button is clicked. The
    * method will use the parameters to sort out the property list to desired property list*/
    public static void searchCriteria( String city, int maxPrice, String propertyType){
        //new array list is created and initialized by running a method to acquire the desired list entries
        ArrayList<Property> desiredProperties = feasiableProperties( city, maxPrice, propertyType, propertyList);

        /* if statement that checks the propertyType search parameter is residential,
         * in order to run the if statements command*/
        if (propertyType.equals("residential")){
            //initialize an instant of the ResultsViewResidential form; passes frame and the desiredProperty list
            ResultsViewResidential residentialResults = new ResultsViewResidential(frame, desiredProperties);
            //frame is set content pane to the residential search result JPanel
            frame.setContentPane(residentialResults.SearchResultsRes);
            frame.pack();// repacks frame
            frame.validate();//validates frame

        }/* else if statement that checks the propertyType search parameter is farm,
         * in order to run the else if statements command*/
        else if (propertyType.equals("farm")){
            //initialize an instant of the ResultsViewFarm form; passes frame and the desiredProperty list
            ResultsViewFarm farmResults = new ResultsViewFarm(frame, desiredProperties);
            //frame is set content pane to the farm search result JPanel
            frame.setContentPane(farmResults.SearchResultsFarm);
            frame.pack(); //repacks frame
            frame.validate();//validates frame

        }/* else if statement that checks the propertyType search parameter is commercial retail,
         * in order to run the else if statements command*/
        else if (propertyType.equals("commretail")){
            //initialize an instant of the ResultsViewCommercialRetail form; passes frame and the desiredProperty list
            ResultsViewCommercialRetail retailResults = new ResultsViewCommercialRetail(frame, desiredProperties);
            //frame is set content pane to the farm search result JPanel
            frame.setContentPane(retailResults.SearchResultsStr);
            frame.pack();//repacks frame
            frame.validate();//validates frame

        }/* else if statement that checks the propertyType search parameter is commercial Industry,
         * in order to run the else if statements command*/
        else if (propertyType.equals("commindust")){
        //initialize an instant of the ResultsViewCommercialIndustrial form; passes frame and the desiredProperty list
            ResultsViewCommercialIndustrial industryResults = new ResultsViewCommercialIndustrial(frame, desiredProperties);
            //frame is set content pane to the farm search result JPanel
            frame.setContentPane(industryResults.SearchResultsInd);
            frame.pack();//repacks frame
            frame.validate();//validates frame
        }


    }

    //Array list method that will return the list of feasible properties that meet the search criteria
    public static ArrayList<Property> feasiableProperties(String city, int maxPrice, String propertyType,
                                                   ArrayList<Property> fullListing){
        ArrayList<Property> result = new ArrayList<>();// the resulted list that will be return
        //for loop that will go through the whole list to check every entry
        for (int i = 0; i<fullListing.size(); i++){
            //if statement that that check each entry if it meets the user's search requirements
            if (fullListing.get(i).listPrice<= maxPrice && fullListing.get(i).location.equals(city)
                    && fullListing.get(i).propType.equals(propertyType)){
                result.add(fullListing.get(i));//entry is added to result if met requirements
            }
        }
        return  result;//return the resulted list
    }


}
