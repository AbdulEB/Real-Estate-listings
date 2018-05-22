package Properties;

/* Author: Abdul El Badaoui
 * Student Number: 5745716
 * Description: This class is the Residential class which extends Property and it has a four attributes and a
 * constructor and it inherits the remaining attributes from the Property class. The items passed into the
 * constructor are the values which the Residential attribute, and the one it inherited from Property, will be set to.
 * */

import Buildings.BuildingType;

//class that extends Property class
public class Residential extends Property {

    public boolean sewer;//attribute if the property is on the city sewer
    public boolean water;//attribute if the property is on the city water
    public boolean garage;//attribute if the property has a garage
    public boolean pool;//attribute if the property has a pool

    // constructor will pass in parameters which will assign the values of the attributes in the Residential listing
    public Residential(int tax, int price, int lotSize, String location, BuildingType build, boolean sewer,
                       boolean water, boolean garage, boolean pool){
        super.propType = "residential";//used in search parameters pane to tell it the type of property type
        super.annualPropertyTax = tax;
        super.listPrice = price;
        super.lotSize = lotSize;
        super.location = location;
        this.building = build;
        this.sewer = sewer;
        this.water = water;
        this.garage = garage;
        this.pool  =pool;
    }

}
