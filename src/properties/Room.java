package properties;

public class Room {
    private int roomNumber;
    private String inhabitant;
    private int rentalPrice;

    public Room(int rNumber, String rInhabitant, int rRentalPrice ){
        this.roomNumber = rNumber;
        this.inhabitant = rInhabitant;
        this.rentalPrice = rRentalPrice;
    }

    public int getRentalPrice() {
        return rentalPrice;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public String getInhabitant() {
        return inhabitant;
    }

    @Override
    public String toString(){
        return "Room "+roomNumber+" rented to "+inhabitant+ "with price "+rentalPrice;
    }
}
