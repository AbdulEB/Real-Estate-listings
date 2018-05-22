package com.company;

/* Author: Abdul El Badaoui
 * Student Number: 5745716
 * Description: This class is the main class of the program and it is the class that runs the whole program. The
 * program's objective is to take in and read a text file of real estate properties that are available for lease/sale
 * within the Niagara Region and abstract the available listings based on the property type and building type, and
 * their attributes. The search criteria of the available listings will be based on the location, max price the buyer
 * is willing to pay and lastly is the property type.
 * */

import Buildings.*;
import Properties.*;
import GUI.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner fileInput; // scanner to read the text file
    static ArrayList<Property> listOfProperties = new ArrayList<>(); // arraylist that holds all available properties

    public static void main(String[] args) {
        // try-catch block  incase the file is not in the correct directory, the program will throw an exception error
        try {
            //reads in the text file
            fileInput = new Scanner(new FileInputStream(new File("Real Estate Input.txt")));
            // a while loop to go through the text file and add the entries
            while(fileInput.hasNext()){
                /*new instance of the build type is created, which is returned from the method buildType() which the
                * initial attributes are added */
                BuildingType build= buildType();
                /*the instance build is added the to listOfProperties after it is passed through the method
                * propertyType() to attain the remaining attributes*/
                listOfProperties.add(propertyType(build));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //starts the GUI and passes the available list of the listings
        new GUIHandler(listOfProperties);



    }

    //a method that adds the attributes based on the building type of the property
    public static BuildingType buildType(){
        //initialize the result Building Type to return from where the method is called
        BuildingType result = null;
        char type = fileInput.next().charAt(0);// the characater to check the type of Building of the property

        //if statement, that is if building type is s, then the building is a store
        if (type =='s'){
            /*the result is then set as a store instance and the scanner reads in the store building type attributes
            * and passes them to the constructor*/
            result = new Store(fileInput.nextInt(), fileInput.next(), (fileInput.next().charAt(0)=='y'),
                    (fileInput.next().charAt(0)=='y'), (fileInput.next().charAt(0)=='y'));
        }// else if statement, that is if building type is f, then the building is a factory
        else if (type =='f'){
            /*the result is then set as a factory instance and the scanner reads in the factory building type attributes
             * and passes them to the constructor*/
            result = new Factory(fileInput.nextInt(), fileInput.next(), (fileInput.next().charAt(0)=='y'),
                    (fileInput.next().charAt(0)=='y'), (fileInput.next().charAt(0)=='y'));
        }// else if statement, that is if building type is h, then the building is a house
        else if (type =='h'){
            /*the result is then set as a house instance and the scanner reads in the house building type attributes
             * and passes them to the constructor*/
            result = new House(fileInput.nextInt(), fileInput.next(), fileInput.next(), fileInput.nextInt(),
                    fileInput.nextInt(), (fileInput.next().charAt(0)=='y'));
        }
        return result; //returns the building type instance after its initial attributed is gathered

    }

    //a method that adds the remaining attributes based on the building type of the property being passed to the method
    public static Property propertyType(BuildingType build){
        //initialize the result Property to return from where the method is called and added to the list of properties
        Property result = null;
        char propType = fileInput.next().charAt(0); // character to check for the property type

        //if statement, that is if property type is r, then the property is residential
        if (propType == 'r'){
            /*the result is then set as a residential instance and the scanner reads in the residential property type
             * remaining attributes and passes them to the constructor*/
            result = new Residential(fileInput.nextInt(), fileInput.nextInt(), fileInput.nextInt(), fileInput.next(),
                    build, (fileInput.next().charAt(0)=='y'), (fileInput.next().charAt(0)=='y'),
                    (fileInput.next().charAt(0)=='y'), (fileInput.next().charAt(0)=='y'));
        }//else if statement, that is if property type is i, then the property is commercial industrial
        else if (propType=='i'){
            /*the result is then set as a commercial industrial instance and the scanner reads in the commercial
             * industrial property type remaining attributes and passes them to the constructor*/
            result = new CommercialIndustrial(fileInput.nextInt(), fileInput.nextInt(), fileInput.nextInt(),
                    fileInput.next(), build, fileInput.next());
        }//else if statement, that is if property type is s, then the property is commercial retail
        else if (propType=='s'){
            /*the result is then set as a commercial retail instance and the scanner reads in the commercial
             * retail property type remaining attributes and passes them to the constructor*/
            result = new CommercialRetail(fileInput.nextInt(), fileInput.nextInt(), fileInput.nextInt(),
                    fileInput.next(), build, fileInput.next());
        }//else if statement, that is if property type is f, then the property is a farm
        else if (propType=='f'){
            /*the result is then set as a farm instance and the scanner reads in the farm
             *  property type remaining attributes and passes them to the constructor*/
            result = new Farm(fileInput.nextInt(), fileInput.nextInt(), fileInput.nextInt(), fileInput.next(), build,
                    (fileInput.next().charAt(0)=='y'), (fileInput.next().charAt(0)=='y'),
                    (fileInput.next().charAt(0)=='y'), (fileInput.next().charAt(0)=='y'), fileInput.next());
        }
        //returns the property instant from where the method is called and which is added to the list of properties
        return result;

    }
}
