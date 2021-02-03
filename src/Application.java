import exceptions.PropertyException;
import properties.Apartment;

import java.io.IOException;

public class Application {

    public static void main(String[] args) {
        /**
         * Possible errors are:
         *  - A duplicate name for a property should result in an error
         *  - Errors reading the input files (In this case the files are ok, but maybe in the future we will use a wrong file)
         */

        //TODO: Create an instance of the PropertyAdministration class
        PropertyAdmin admin = new PropertyAdmin();

        //TODO: Create instances of the following appartments and add them to the propertyadministration
        try{
            admin.addApartment("One Infinity Loop",95);
            admin.addApartment("1600 Amphitheatre Parkway", 65);
            admin.addApartment("One Microsoft Way", 45);
        } catch (PropertyException e) {
            System.out.println(e);
        }
        //An appartment with address One Infinity Loop, with a surface of 95.
        //An appartment with address 1600 Amphitheatre Parkway, with a surface of 65
        //An appartment with address One Microsoft Way, with a surface of 45

        //TODO: Create instances of the following studenthouses and add them to the propertyadministration
        try{
            admin.addStudentHouse("Java Programmer House","500 Oracle Parkway");
            admin.addStudentHouse("IBM Fans","One New Orchard Road");
        } catch (PropertyException e) {
            System.out.println(e);
        }
        //A studenthouse with the address 500 Oracle Parkway and the name Java Programmer House
        //A studenthouse with the address One New Orchard Road and with the name IBM Fans

        //TODO: Read the rooms for the Java Programmer House from the file programmerhouse.json
        try{
            admin.loadFile("Java Programmer House","programmerhouse.json");
            admin.loadFile("IBM Fans","ibmfans.json");
        } catch (IOException e) {
            System.out.println(e);
        } catch (PropertyException e) {
            System.out.println(e);
        }
        //TODO: Read the rooms for the IBM Fans from the file ibmfans.json

        //TODO: Print the library (Using toString from your MediaLibrary)
        System.out.println(admin.printProperties());

        //TODO: Print the name of the studenthouse with the largest revenue
        System.out.println(admin.printStudentHouseLargestRevenue());
    }
}
