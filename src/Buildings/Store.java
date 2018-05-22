package Buildings;
/* Author: Abdul El Badaoui
 * Student Number: 5745716
 * Description: This class is the Store class which extends Building Type and it has attributes and a constructor
 * which will be called upon to create instance of the Store. The items passed into the constructor are the values
 * which the Store attributes, and the one it inherited from building type, will be set to.
 * */

//class that extends BuildingTYpe class
public class Store extends BuildingType {

    public boolean shelves;//the attribute that tells if shelves are available
    public boolean checkout;//the attribute that tells if there are cahs registers
    public boolean safe;// the attribute which tells that if a safe is available

    //constructor will pass in parameters which will assign the values of the attributes in the Store listing
    public Store(int sqft, String material, boolean shelves, boolean checkout, boolean safe){
        super.constructionMaterial=material;
        super.size=sqft;
        this.shelves=shelves;
        this.checkout=checkout;
        this.safe=safe;
    }


}
