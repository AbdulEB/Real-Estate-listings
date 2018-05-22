package GUI;
/* Author: Abdul El Badaoui
 * Student Number: 5745716
 * Description: This class is the a City class that returns the correct name of the city in the search resutls
 * */
public class City {

    private String city;// city parameter

    //constructor that passes an abbreviation of the city name in a String format
    public City(String city){
        // if else if stateent that will set the class global city parameter to the correct name
        if (city.equals("stct")){
            this.city = "St. Catharines";
        }
        else if (city.equals("wlld")){
            this.city = "Welland";
        }
        else if (city.equals("ngfl")){
            this.city = "Niagara Falls";
        }
        else if (city.equals("fter")){
            this.city = "Fort Erie";
        }
    }
    //method to be called to return the city's correct name.
    public String getCity(){
        return city;
    }
}
