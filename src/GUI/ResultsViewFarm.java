package GUI;

/* Author: Abdul El Badaoui
 * Student Number: 5745716
 * Description: This class is the a Search Results for Farm properties, it handles the the search form
 * fields for the farm entries
 * */

import Buildings.*;
import Properties.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ResultsViewFarm {
    public JPanel SearchResultsFarm;// Search Results JPanel for farm
    //JTextfields (text fields) based on the farm property attributes
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
    private JTextField cropField;
    // a next and quit button for the frame
    private JButton nextButton;
    private JButton quitButton;

    //constructor that passes the frame and property list farm property
    public ResultsViewFarm(JFrame frame, ArrayList<Property> farmProperty){
        //if the list that is passed is empty
        if (farmProperty.size()==0){
            noResults();//returns no results, a method that displays no results
        }
        else{//else statement, if the list contains entries
            /* method that passes a Farm property that is removed from the beginning of the list;
             * it displays that entries attributes values in the Search Results text fields*/
            showResult((Farm) farmProperty.remove(0));
        }

        //if next button is clicked
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // if statement that checks if there are still entries in the farmProperty list
                if (farmProperty.size() > 0) {
                    //runs the method that shows the result
                    showResult((Farm) farmProperty.remove(0));
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

    //show result method that has a farm property passed through
    public void showResult(Farm farm){
        //fills text fields in the farm Search Results with the farm property attributes
        taxField.setText(Integer.toString(farm.annualPropertyTax));// fills tax field
        priceField.setText(Integer.toString(farm.listPrice));//fills price field
        lotSizeField.setText(Integer.toString(farm.lotSize));//fills lot size field
        City city = new City(farm.location);//create instance of the city, which passes the location attribute of the property
        cityField.setText(city.getCity());// returns the correct name of the city and fills it to the city text filled
        materialField.setText(farm.building.constructionMaterial);// fills the material field
        buildingSizeField.setText(Integer.toString(farm.building.size));//fills the building size text field
        sewerField.setText((farm.sewer) ? "Yes" : "No");//fills the in city sewer text field
        waterField.setText((farm.water) ? "Yes" : "No");//fills the in the city water text field
        garageField.setText((farm.garage) ? "Yes" : "No");//fills the has garage text field
        poolField.setText((farm.pool) ? "Yes" : "No");//fills the has pool text field
        bedroomsField.setText(Integer.toString(((House)farm.building).bedrooms));//fills the number of bedrooms text field
        bathroomsField.setText(Integer.toString(((House)farm.building).bathrooms));//fills the number of bathrooms text field
        basementField.setText(((House)farm.building).bsmt ? "Yes" : "No");//fills that if has basement text field
        houseTypeField.setText(((House)farm.building).houseType);//fills the type of house text field
        cropField.setText(farm.cropType);//fills the type of crop text field
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
        cropField.setText(" ");
    }
}
