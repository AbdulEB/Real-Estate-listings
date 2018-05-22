package GUI;

/* Author: Abdul El Badaoui
 * Student Number: 5745716
 * Description: This class is the a Search Results for Commercial Industry properties, it handles the the search form
 * fields for the commerical industry entries
 * */

import Buildings.*;
import Properties.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ResultsViewCommercialIndustrial {
    public JPanel SearchResultsInd;// Search Results JPanel for Industry
    //Jtextfields (text fields) based on the commercial industry property attributes
    private JTextField taxField;
    private JTextField priceField;
    private JTextField lotSizeField;
    private JTextField cityField;
    private JTextField materialField;
    private JTextField buildingSizeField;
    private JTextField industryTypeField;
    private JTextField craneIncludedField;
    private JTextField equipmentIncludedField;
    private JTextField railAccessField;
    // a next and quit button for the frame
    private JButton nextButton;
    private JButton quitButton;

    //constructor that passes the frame and property list industrial property
    public ResultsViewCommercialIndustrial(JFrame frame, ArrayList<Property> industryProperty){
        //if the list that is passed is empty
        if (industryProperty.size()==0){
            noResults();//returns no results, a method that displays no results
        }
        else{//else statement, if the list contains entries
            /* method that passes a CommercialIndustrial property that is removed from the beginning of the list;
             * it displays that entries attributes values in the Search Results text fields*/
            showResult((CommercialIndustrial) industryProperty.remove(0));
        }

        //if next button is clicked
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // if statement that checks if there are still entries in the industryProperty list
                if (industryProperty.size() > 0) {
                    //runs the method that shows the result
                    showResult((CommercialIndustrial) industryProperty.remove(0));
                }
                else{//in case the list is empty
                    noResults();//runs the no result method
                }
            }
        });
        //if quit button is pressed
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();//close the frame
            }
        });
    }
    //show result method that has a commercial industry property passed through
    public void showResult(CommercialIndustrial ind){
        //fills text fields in the industry Search Results with the industry property attributes
        taxField.setText(Integer.toString(ind.annualPropertyTax));// fills tax field
        priceField.setText(Integer.toString(ind.listPrice));//fills price field
        lotSizeField.setText(Integer.toString(ind.lotSize));//fills lot size field
        City city = new City(ind.location);//create instance of the city, which passes the location attribute of the property
        cityField.setText(city.getCity());// returns the correct name of the city and fills it to the city text filled
        materialField.setText(ind.building.constructionMaterial);// fills the material field
        buildingSizeField.setText(Integer.toString(ind.building.size));//fills the building size text field
        industryTypeField.setText(ind.industryType);//fills the industry type field
        craneIncludedField.setText(((Factory)ind.building).crane ? "Yes" : "No");//fills the crane field attribute
        equipmentIncludedField.setText(((Factory)ind.building).equipment ? "Yes" : "No");//fills the equipment text field
        railAccessField.setText(((Factory)ind.building).railAccess ? "Yes" : "No");//fills the rail access field

    }

    //the no results method if the property list is empty
    public void noResults(){
        taxField.setText("No more Properties to Display");// message to the user that there is no more properties
        // remaining fields are field with empty texts
        priceField.setText(" ");
        lotSizeField.setText(" ");
        cityField.setText(" ");
        materialField.setText(" ");
        buildingSizeField.setText(" ");
        industryTypeField.setText(" ");
        craneIncludedField.setText(" ");
        equipmentIncludedField.setText(" ");
        railAccessField.setText(" ");
    }


}
