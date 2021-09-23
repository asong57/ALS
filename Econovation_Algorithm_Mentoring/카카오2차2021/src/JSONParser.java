import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class JSONParser {

    public ArrayList<Locations> getLocations(JSONObject responseJson) {
        ArrayList<Locations> locationsList = new ArrayList<>();

        try {
            JSONArray locations = responseJson.getJSONArray("locations");
            for (int i = 0; i < locations.length(); i++) {
                JSONObject data = locations.getJSONObject(i);

                Locations location = new Locations();
                location.setId(data.getInt("id"));
                location.setLocatedBikesCount(data.getInt("located_bikes_count"));

                locationsList.add(location);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return locationsList;
    }

    public ArrayList<Truck> getTrucks(JSONObject responseJson) {
        ArrayList<Truck> trucksList = new ArrayList<>();

        try {
            JSONArray trucks = responseJson.getJSONArray("trucks");
            for (int i = 0; i < trucks.length(); i++) {
                JSONObject data = trucks.getJSONObject(i);

                Truck truck = new Truck();
                truck.setId(data.getInt("id"));
                truck.setLocationId(data.getInt("location_id"));
                truck.setLoadedBikesCount(data.getInt("loaded_bikes_count"));

                trucksList.add(truck);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return trucksList;
    }


    public ArrayList<Elevator> getElevatorsFromOnCalls(JSONObject responseJson) {
        ArrayList<Elevator> elevatorList = new ArrayList<>();

        try {
            JSONArray elevators = responseJson.getJSONArray("elevators");
            for (int i = 0; i < elevators.length(); i++) {
                JSONObject data = elevators.getJSONObject(i);

                JSONArray passengerdatas = data.getJSONArray("passengers");
                ArrayList<Call> passengers = new ArrayList<>();
                for (int j = 0; j < passengerdatas.length(); j++) {
                    JSONObject passengerData = passengerdatas.getJSONObject(j);
                    Call call = new Call();
                    call.setId(passengerData.getInt("id"));
                    call.setTimestamp(passengerData.getInt("timestamp"));
                    call.setStart(passengerData.getInt("start"));
                    call.setEnd(passengerData.getInt("end"));
                    passengers.add(call);
                }

                Elevator elevator = new Elevator();
                elevator.setId(data.getInt("id"));
                elevator.setFloor(data.getInt("floor"));
                elevator.setStatus(data.getString("status"));
                elevator.setPassengers(passengers);
                elevatorList.add(elevator);
            }


        } catch (JSONException e) {
            e.printStackTrace();
        }


        return elevatorList;
    }

    public HashMap<Integer, Call> getCallMapFromOnCalls(JSONObject responseJson) {
        HashMap<Integer, Call> callMap = new HashMap<>();

        try {
            JSONArray calls = responseJson.getJSONArray("calls");

            for (int i = 0; i < calls.length(); i++) {
                JSONObject data = calls.getJSONObject(i);
                Call call = new Call();
                call.setId(data.getInt("id"));
                call.setTimestamp(data.getInt("timestamp"));
                call.setStart(data.getInt("start"));
                call.setEnd(data.getInt("end"));
                if (!callMap.containsKey(call.getId())) { // 포함하지 않고 있다면 추가
                    callMap.put(call.getId(), call);
                }
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return callMap;
    }

    public JSONArray getCommandsJSONArray(ArrayList<Command> commandList) {
        JSONArray commandArray = new JSONArray();
        for (Command command : commandList) {
            commandArray.put(command.getJsonCommandData());
        }

        return commandArray;
    }

    public JSONArray getCommand2JSONArray(ArrayList<Command2> commandList) {
        JSONArray commandArray = new JSONArray();
        for (Command2 command : commandList) {
            commandArray.put(command.getJsonCommandData());
        }

        return commandArray;
    }

}
