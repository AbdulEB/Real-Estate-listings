package GUI;

/* Author: Abdul El Badaoui
 * Student Number: 5745716
 * Description: This class is the a Search Results for Residential properties, it handles the the search form
 * fields for the Residential entries
 * */

import Properties.*;
import Buildings.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ResultsViewResidential {
    public JPanel SearchResultsRes;// Search Results JPanel for residential
    //JTextfields (text fields) based on the residential property attributes
    private JTextField taxField;
    private JTextField priceField;
    private JTextField lotSizeField;
    private JTextField cityField;
    private JTextField materialField;
    private JTextField buildingSizeField;
    private JTextField sewerField;
    private JTextField waterField;
    private JTextField garageField;
    private JTextField poolField;
    private JTextField bedroomsField;
    private JTextField bathroomsField;
    private JTextField basementField;
    private JTextField houseTypeField;
    // a next and quit button for the frame
    private JButton nextButton;
    private JButton quitButton;

    //constructor that passes the frame and property list residential property
    public ResultsViewResidential(JFrame frame, ArrayList<Property> residentialProperty) {
        //if the list that is passed is empty
        if (residentialProperty.size()==0){
            noResults();//returns no results, a method that displays no results
        }
        else{//else statement, if the list contains entries
            /* method that passes a Residential property that is removed from the beginning of the list;
             * it displays that entries attributes values in the Search Results text fields*/
            showResult((Residential) residentialProperty.remove(0));
        }

        //if next button is clicked
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // if statement that checks if there are still entries in the residentialProperty list
                if (residentialProperty.size() > 0) {
                    //runs the method that shows the result
                    showResult((Residential) residentialProperty.remove(0));
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
                frame.dispose();//closes the frame
            }
        });
    }

    //show result method that has a residential property passed through
    public void showResult(Residential res){
        //fills text fields in the residential Search Results with the residential property attributes
        taxField.setText(Integer.toString(res.annualPropertyTax));// fills tax field
        priceField.setText(Integer.toString(res.listPrice));//fills price field
        lotSizeField.setText(Integer.toString(res.lotSize));//fills lot size field
        City city = new City(res.location);//create instance of the city, which passes the location attribute of the property
        cityField.setText(city.getCity());// returns the correct name of the city and fills it to the city text filled
        materialField.setText(res.building.constructionMaterial);// fills the material field
        buildingSizeField.setText(Integer.toString(res.building.size));//fills the building size text field
        sewerField.setText((res.sewer) ? "Yes" : "No");//fills the in city sewer text field
        waterField.setText((res.water) ? "Yes" : "No");//fills the in the city water text field
        garageField.setText((res.garage) ? "Yes" : "No");//fills the has garage text field
        poolField.setText((res.pool) ? "Yes" : "No");//fills the has pool text field
        bedroomsField.setText(Integer.toString(((House)res.building).bedrooms));//fills the number of bedrooms text field
        bathroomsField.setText(Integer.toString(((House)res.building).bathrooms));//fills the number of bathrooms text field
        basementField.setText(((House)res.building).bsmt ? "Yes" : "No");//fills that if has basement text field
        houseTypeField.setText(((House)res.building).houseType);//fills the type of house text field

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
        sewerField.setText(" ");
        waterField.setText(" ");
        garageField.setText(" ");
        poolField.setText(" ");
        bedroomsField.setText(" ");
        bathroomsField.setText(" ");
        basementField.setText(" ");
        houseTypeField.setText(" ");
    }
}
