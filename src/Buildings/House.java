package Buildings;
/* Author: Abdul El Badaoui
 * Student Number: 5745716
 * Description: This class is the House class which extends Building Type and it has attributes and a constructor
 * which will be called upon to create instance of the House. The items passed into the constructor are the values
 * which the House attributes, and the one it inherited from building type, will be set to.
 * */

//class that extends BuildingTYpe class
public class House extends BuildingType{

    public String houseType;//the house type attribute
    public int bedrooms;// the attribute which will tell the number of bedrooms
    public int bathrooms;// the attribute which will tell the number of bathrooms
    public boolean bsmt;//the basement attribute which tells if there is a basement

    //constructor will pass in parameters which will assign the values of the attributes in the house listing
    public House(int sqft, String material, String houseType,int bedrooms, int bathrooms, boolean bsmt){
        super.constructionMaterial=material;
        super.size=sqft;
        this.houseType=houseType;
        this.bedrooms=bedrooms;
        this.bathrooms=bathrooms;
        this.bsmt=bsmt;
    }



}
