package Properties;

/* Author: Abdul El Badaoui
 * Student Number: 5745716
 * Description: This class is the Farm class which extends Residential and it has a single attribute and a constructor
 * and it inherits the remaining attributes from the Residential & Property class. The items passed into the
 * constructor are the values which the Farm attribute, and the one it inherited from Residential and Property, will
 * be set to.
 * */

import Buildings.BuildingType;

//class that extends Residential class
public class Farm extends Residential {

    public String cropType;// crop type attribute

    // constructor will pass in parameters which will assign the values of the attributes in the Farm listing
    public Farm(int tax, int price, int lotSize, String location, BuildingType build, boolean sewer, boolean water,
                boolean garage, boolean pool, String cropType) {
        super(tax, price, lotSize, location, build, sewer, water, garage, pool);//the inherited attributes
        super.propType = "farm";//used in search parameters pane to tell it the type of property type
        super.annualPropertyTax = tax;
        super.listPrice = price;
        super.lotSize = lotSize;
        super.location = location;
        super.building = build;
        super.sewer = sewer;
        super.water = water;
        super.garage = garage;
        super.pool = pool;
        this.cropType = cropType;
    }
}
