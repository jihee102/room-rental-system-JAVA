package properties;

public abstract class Property {
    private String address;
    private int number;
    private static int count =1;

    public Property(String pAddress){
        this.address = pAddress;
        this.number = count;
        count++;
    }

    public int getNumber() {
        return number;
    }

    public String getAddress() {
        return address;
    }



    public String toString(){
        return number+") "+address;
    }
}
