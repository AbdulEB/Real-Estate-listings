package GUI;

/* Author: Abdul El Badaoui
 * Student Number: 5745716
 * Description: This class is the a Search Results for Commercial Retail properties, it handles the the search form
 * fields for the commercial retail entries
 * */

import Buildings.*;
import Properties.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ResultsViewCommercialRetail {
    public JPanel SearchResultsStr;// Search Results JPanel for Industry
    //JTextfields (text fields) based on the commercial retail property attributes
    private JTextField taxField;
    private JTextField priceField;
    private JTextField lotSizeField;
    private JTextField cityField;
    private JTextField materialField;
    private JTextField buildingSizeField;
    private JTextField retailTypeField;
    private JTextField shelvesIncludedField;
    private JTextField cashRegistersField;
    private JTextField safeIncludedField;
    // a next and quit button for the frame
    private JButton nextButton;
    private JButton quitButton;

    //constructor that passes the frame and property list retail property
    public ResultsViewCommercialRetail(JFrame frame, ArrayList<Property> retailProperty) {
        //if the list that is passed is empty
        if (retailProperty.size()==0){
            noResults();//returns no results, a method that displays no results
        }
        else{//else statement, if the list contains entries
            /* method that passes a CommercialRetail property that is removed from the beginning of the list;
             * it displays that entries attributes values in the Search Results text fields*/
            showResult((CommercialRetail) retailProperty.remove(0));
        }

        //if next button is clicked
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // if statement that checks if there are still entries in the retailProperty list
                if (retailProperty.size() > 0) {
                    //runs the method that shows the result
                    showResult((CommercialRetail) retailProperty.remove(0));
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

    //show result method that has a commercial retail property passed through
    public void showResult(CommercialRetail str){
        //fills text fields in the retail Search Results with the retail property attributes
        taxField.setText(Integer.toString(str.annualPropertyTax));// fills tax field
        priceField.setText(Integer.toString(str.listPrice));//fills price field
        lotSizeField.setText(Integer.toString(str.lotSize));//fills lot size field
        City city = new City(str.location);//create instance of the city, which passes the location attribute of the property
        cityField.setText(city.getCity());// returns the correct name of the city and fills it to the city text filled
        materialField.setText(str.building.constructionMaterial);// fills the material field
        buildingSizeField.setText(Integer.toString(str.building.size));//fills the building size text field
        retailTypeField.setText(str.retailType);//fills the retail type field
        shelvesIncludedField.setText(((Store)str.building).shelves ? "Yes" : "No");//fills the have shelves text field
        cashRegistersField.setText(((Store)str.building).checkout ? "Yes" : "No");//fills the checkout field
        safeIncludedField.setText(((Store)str.building).safe ? "Yes" : "No");//fills the safe included field
    }

    //the no results method if the property list is empty
    public void noResults(){
        taxField.setText("No more properties to Display");// message to the user that there is no more properties
        // remaining fields are field with empty texts
        priceField.setText(" ");
        lotSizeField.setText(" ");
        cityField.setText(" ");
        materialField.setText(" ");
        buildingSizeField.setText(" ");
        retailTypeField.setText(" ");
        shelvesIncludedField.setText(" ");
        cashRegistersField.setText(" ");
        safeIncludedField.setText(" ");
    }


}
