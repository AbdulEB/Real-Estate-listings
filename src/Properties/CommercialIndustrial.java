package Properties;

/* Author: Abdul El Badaoui
 * Student Number: 5745716
 * Description: This class is the Commercial Industrial class which extends Property and it has a single attribute
 * and a constructor and it inherits the remaining attributes from the Property class. The items passed into the
 * constructor are the values which the Commercial Industrial attribute, and the one it inherited from Property, will
 * be set to.
 * */

import Buildings.BuildingType;

//class that extends Property class
public class CommercialIndustrial extends Property {

    public String industryType;//industry type attribute

    // constructor will pass in parameters which will assign the values of the attributes in the Commercial Industrial
    // listing
    public CommercialIndustrial(int tax, int price, int lotSize, String location, BuildingType build,
                                String industryType){
        super.propType = "commindust";//used in search parameters pane to tell it the type of property type
        super.annualPropertyTax = tax;
        super.listPrice = price;
        super.lotSize = lotSize;
        super.location = location;
        this.building = build;
        this.industryType = industryType;
    }
}
