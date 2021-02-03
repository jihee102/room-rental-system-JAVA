import exceptions.PropertyException;
import org.json.JSONArray;
import org.json.JSONObject;
import properties.Apartment;
import properties.Property;
import properties.Room;
import properties.StudentHouse;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class PropertyAdmin {
    private ArrayList<Property> properties = new ArrayList<>();

    public PropertyAdmin(){};

    public Property findPropertyByAddress(String address){
        for(Property p:properties){
            if(p.getAddress().equals(address)){
                return p;
            }
        }
        return null;
    }

    public Property findStudentHouseByName(String name){
        for(Property p : properties){
            if(p instanceof StudentHouse){
                if(((StudentHouse) p).getStudentHouseName().equals(name)){
                    return p;
                }
            }
        }
        return null;
    }

    public void addStudentHouse(String pStudentHouseName, String pAddress) throws PropertyException {
        if(findPropertyByAddress(pAddress) != null){
            throw new PropertyException("Student house already exists.");
        }
        StudentHouse sh = new StudentHouse(pStudentHouseName,pAddress);
        properties.add(sh);
    }

    public void addApartment(String pAddress, int pArea) throws PropertyException{
        if(findPropertyByAddress(pAddress)!=null){
            throw new PropertyException("Apartment already exists.");
        }
        Apartment ap = new Apartment(pAddress,pArea);
        properties.add(ap);
    }

    public void addStudentHouseRooms(String houseName, int rNumber, String rInhabitant, int rRentalPrice ) throws PropertyException {
        Property s = findStudentHouseByName(houseName);
        if(s != null){
            if(s instanceof StudentHouse){
                if(((StudentHouse) s).findRoomByNumber(rNumber)==null){
                    ((StudentHouse) s).addRooms(rNumber,rInhabitant,rRentalPrice);
                }else{
                    throw new PropertyException("The room number is already exists.");
                }
            }else {
                throw new PropertyException("Only student house can be registered the rooms");
            }

        }else{
            throw new PropertyException("Student house not found");
        }
    }

    public void loadFile(String studentHouseName, String file) throws PropertyException, IOException {
        String jsonString = new String(Files.readAllBytes(Paths.get(file)));
        JSONArray jsonArray = new JSONArray(jsonString);
        for (int i = 0; i <jsonArray.length() ; i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            addStudentHouseRooms(studentHouseName,jsonObject.getInt("room"),jsonObject.getString("inhabitant"),jsonObject.getInt("price"));
        }
    }

    public String printStudentHouseLargestRevenue(){
        String output = "The student house with the largest revenue is: \n";
        ArrayList<StudentHouse> studentHouses = new ArrayList<>();
        for(Property p :properties){
            if(p instanceof StudentHouse){
                studentHouses.add((StudentHouse) p);
            }
        }
        StudentHouse largeRevenue = studentHouses.get(0);
        for(StudentHouse s : studentHouses){
            if(largeRevenue.getRevenue() < s.getRevenue()){
                largeRevenue = s;
            }
        }
        output += largeRevenue.toString();
        return output;
    }

    public String printProperties(){
        String output ="Overview of all properties \n";
        for(Property p :properties){
            output+= p+"\n";
        }
        return output;
    }


}
