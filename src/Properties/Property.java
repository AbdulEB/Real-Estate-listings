package Properties;

/* Author: Abdul El Badaoui
 * Student Number: 5745716
 * Description: This class is the Property and it only has attributes that all properties will have.
 * */
import Buildings.BuildingType;

public class Property {

    public int annualPropertyTax;
    public int listPrice;
    public int lotSize;
    public String location;
    public String propType;// classes that Property will be extended to, propType won't be passed through a constructor
    public BuildingType building;

}
