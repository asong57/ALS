import java.util.ArrayList;

public class Elevator {
    private int id;
    private int floor;
    private ArrayList<Call> passengers;
    private String status;

    public Elevator(){

    }

    public Elevator(int id, int floor, ArrayList<Call> passengers, String status) {
        this.id = id;
        this.floor = floor;
        this.passengers = passengers;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public ArrayList<Call> getPassengers() {
        return passengers;
    }

    public void setPassengers(ArrayList<Call> passengers) {
        this.passengers = passengers;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean hasPassenger() {
        if (passengers == null)
            return false;
        else if (passengers.size() == 0)
            return false;
        return true;
    }
}
