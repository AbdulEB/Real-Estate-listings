package Buildings;
/* Author: Abdul El Badaoui
 * Student Number: 5745716
 * Description: This class is the Factory class which extends Building Type and it has attributes and a constructor
 * which will be called upon to create instance of the Factory. The items passed into the constructor are the values
 * which the Factory attributes, and the one it inherited from building type, will be set to.
 * */

//class that extends BuildingTYpe class
public class Factory extends BuildingType{

    public boolean crane;// the has crane attribute
    public boolean equipment;// equipment included attribute
    public boolean railAccess;// is there rail access attribute

    //constructor will pass in parameters which will assign the values of the attributes in the factory listing
    public Factory(int sqft, String material, boolean crane, boolean equipment, boolean railAccess){
        super.constructionMaterial=material;
        super.size=sqft;
        this.crane=crane;
        this.equipment=equipment;
        this.railAccess=railAccess;
    }
}
