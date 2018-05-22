package GUI;

/* Author: Abdul El Badaoui
 * Student Number: 5745716
 * Description: This class is the a Search Parameter class where the first JPanel will be displayed for the user
 * to enter his/her search parameters
 * */
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchView {
    public JPanel SearchParameter;// Search Parameter JPanel
    public JTextField cityField;//Search Parameter for the city user is looking for city Field
    public JTextField maxPriceField;// Search Parameter for the max price the user is willing to pay field
    public JTextField propTypeField;// Search paramety of the type of property the user is searching for
    private String city;// city string parameter
    private int maxPrice;//max price int parameter
    private String propType;// property type string parameter
    // a search and quit button for the frame
    private JButton searchButton;
    private JButton quitButton;

    //constructor that passes the frame
    public SearchView(JFrame frame) {
        //if the search button is pressed
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //if statements that checks if all fields are entered before the search is button does its job
                if (!cityField.getText().isEmpty() && !maxPriceField.getText().isEmpty() &&
                        !propTypeField.getText().isEmpty()){
                    city = cityField.getText();//set the city to user input
                    maxPrice = Integer.parseInt(maxPriceField.getText());// set the max price to the user input
                    propType = propTypeField.getText();//set the property to the user input
                    // calls the method in the GUIHandler class to process the user's entry
                    GUIHandler.searchCriteria(city, maxPrice, propType);
                }
            }
        });
        //if quit button is entered
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();//closes the frame
            }
        });
    }

}
