import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Command {
    private int elevator_id;
    private String command;
    private int[] call_ids;

    public Command(int elevator_id, String command, int[] call_ids) {
        this.elevator_id = elevator_id;
        this.command = command;
        this.call_ids = call_ids;
    }

    public Command(int elevator_id) {
        this.elevator_id = elevator_id;
    }

    public Command(int elevator_id, String command) {
        this.elevator_id = elevator_id;
        this.command = command;
    }

    public int getElevator_id() {
        return elevator_id;
    }

    public void setElevator_id(int elevator_id) {
        this.elevator_id = elevator_id;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public int[] getCall_ids() {
        return call_ids;
    }

    public void setCall_ids(int[] call_ids) {
        this.call_ids = call_ids;
    }


    public JSONObject getJsonCommandData() {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("elevator_id", elevator_id);
            jsonObject.put("command", command);
            if (call_ids!= null)
                jsonObject.put("call_ids", call_ids);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return jsonObject;
    }
}
