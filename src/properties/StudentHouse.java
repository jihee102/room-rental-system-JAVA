package properties;

import java.util.ArrayList;

public class StudentHouse extends Property {
    private String studentHouseName;
    private ArrayList<Room> rooms = new ArrayList<>();

    public StudentHouse(String pStudentHouseName, String pAddress){
        super(pAddress);
        this.studentHouseName = pStudentHouseName;
    }

    public String getStudentHouseName() {
        return studentHouseName;
    }

    public void addRooms(int rNumber, String rInhabitant, int rRentalPrice){
        Room r = new Room(rNumber,rInhabitant,rRentalPrice);
        rooms.add(r);
    }

    public Room findRoomByNumber(int num){
        for(Room room:rooms){
            if(room.getRoomNumber()==num){
                return room;
            }
        }
        return null;
    }

    public int getRevenue(){
        int sum = 0;
        for(Room r :rooms){
            sum += r.getRentalPrice();
        }
        return sum;
    }

    @Override
    public String toString(){
        String output = "";
        output+= super.toString()+ " with name "+studentHouseName +" and total revenue "+getRevenue()+": \n";
        if(rooms.size() !=0){
            for(Room r:rooms){
                output += r+"\n";
            }
        }
        return output;
    }


}
