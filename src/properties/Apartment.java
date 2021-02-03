package properties;

public class Apartment extends Property{
    private int area;

    public Apartment(String pAddress, int pArea){
        super(pAddress);
        this.area = pArea;
    }

    public int getArea() {
        return area;
    }

    @Override
    public  String toString(){
        return super.toString()+" with surface area "+area;
    }
}
