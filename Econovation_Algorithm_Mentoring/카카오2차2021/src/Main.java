import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.*;

public class Main {

    public static final String COMMAND_STOP = "STOP";
    public static final String COMMAND_ENTER = "ENTER";
    public static final String COMMAND_EXIT = "EXIT";
    public static final String COMMAND_UP = "UP";
    public static final String COMMAND_DOWN = "DOWN";
    public static final String COMMAND_OPEN = "OPEN";
    public static final String COMMAND_CLOSE = "CLOSE";

    public static final String STATUS_STOPPED = "STOPPED";
    public static final String STATUS_OPENED = "OPENED";
    public static final String STATUS_UPWARD = "UPWARD";
    public static final String STATUS_DOWNWARD = "DOWNWARD";

    public static Call[] jobs;

    public static ArrayList<Locations> locationsArrayList;
    public static ArrayList<Truck> trucksArrayList;

    public static void main(String[] args) {

        // 문제
        String userKey = "tester2";
        int numOfElevators = 4;

        // datas
        ArrayList<Elevator> elevatorList = new ArrayList<>();
        HashMap<Integer, Call> callMap = new HashMap<>();
        ArrayList<Command> commandList = null;

        // 자전거 문제 시작
        int problemId = 1;
        String authKey = start(userKey, problemId, numOfElevators);
        System.out.println("authkey : " + authKey);
        String response = "200";

        //data


        //자전거 문제 알고리즘 풀이 과정
        if (response.equals("200")) {
            int time = 0;

            while (time < 720) {
                time++;
                System.out.println("\n\n---------------timestamp : " + time + "--------------");

                locationsArrayList = new ArrayList<>();
                trucksArrayList = new ArrayList<>();

                connectLocation(authKey, locationsArrayList);
                connectTrucks(authKey, trucksArrayList);

                // System.out.println("남은  Call 개수 :" + callMap.size());
                ArrayList<Command2> command2List = new ArrayList<>();
                Command2 command2 = new Command2();
                command2.setTruckId(0);
                int[] commands = {0};
                command2.setCommand(commands);
                command2List.add(command2);
                System.out.println(command2.getJsonCommandData().toString());

                /*
                for (int i = 0; i < elevatorList.size(); i++) {
                    Elevator elevator = elevatorList.get(i);
//					System.out.println("\nelevator: " + elevator);
                    Command command = generateCommand(elevator, callMap, jobs[i]);
                    commandList.add(command);
                }*/

//				System.out.println("\n***elevator command generator loop end\n");
                // commandList.stream().forEach(c -> System.out.println(c.getJsonCommandData().toString()));
                // System.out.println(" - job list - \n" + Arrays.toString(jobs));

                //action(commandList);

                simulate(command2List, authKey);
                try {
                    Thread.sleep(25); // 40 request per second
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            connectScore(authKey);
            System.out.println("<< FINISHED!! >>");
        }

        // 엘리베이터 문제 풀이 과정
        if (response.equals("250")) {

            jobs = new Call[numOfElevators];

            int time = -1;

            while (true) {
                time++;
                System.out.println("\n\n---------------timestamp : " + time + "--------------");

                elevatorList = new ArrayList<>();
                callMap = new HashMap<>();
                boolean is_finished = onCalls(elevatorList, callMap);

                if (is_finished) {
                    System.out.println("<< FINISHED!! >>");
                    break;
                }

                System.out.println("남은  Call 개수 :" + callMap.size());
                commandList = new ArrayList<>();
//				System.out.println("\n***elevator command generator loop start\n");

                for (int i = 0; i < elevatorList.size(); i++) {
                    Elevator elevator = elevatorList.get(i);
//					System.out.println("\nelevator: " + elevator);
                    Command command = generateCommand(elevator, callMap, jobs[i]);
//					Command command = generateCommand(elevator, callMap, callCounter, jobs[i]);
                    commandList.add(command);
                }

//				System.out.println("\n***elevator command generator loop end\n");
                commandList.stream().forEach(c -> System.out.println(c.getJsonCommandData().toString()));
                System.out.println(" - job list - \n" + Arrays.toString(jobs));

                action(commandList);
                try {
                    Thread.sleep(25); // 40 request per second
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }

    }

    private static String start(String userKey, int problemId, int numOfElevators) {
        System.out.println(">>>> api.start()");
        String response = Connection.getInstance().start(userKey, problemId, numOfElevators);
        return response;
    }

    private static void connectLocation(String authKey, ArrayList<Locations> locationsArrayList) {
        System.out.println(">>>> connect Location");
        JSONObject response = Connection.getInstance().connectLocations(authKey);
        JSONParser parser = new JSONParser();
        try {
            locationsArrayList.addAll(parser.getLocations(response));
            System.out.println("***locationList\n" + locationsArrayList.toString());
            //  callMap.putAll(parser.getCallMapFromOnCalls(responseJson));
//			System.out.println("***callMap\n" + callMap);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private static void connectTrucks(String authKey, ArrayList<Truck> trucksArrayList) {
        System.out.println(">>>> connect Trucks");
        JSONObject response = Connection.getInstance().connectTrucks(authKey);
        JSONParser parser = new JSONParser();
        try {
            trucksArrayList.addAll(parser.getTrucks(response));
            System.out.println("***trucksList\n" + trucksArrayList.toString());

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private static void simulate(ArrayList<Command2> commandList, String authKey) {
        System.out.println("\n\n>>>> api.action()");
        JSONParser parser = new JSONParser();
        JSONArray commandArray = parser.getCommand2JSONArray(commandList);

//		System.out.println(commandArray);
        JSONObject response = Connection.getInstance().simulate(commandArray, authKey);
        try {
            String status = response.getString("status");
            int time = response.getInt("time");
            double failedRequestsCount = response.getDouble("failed_requests_count");
            String distance = response.getString("distance");
            System.out.println("-> Simulate result ");
            System.out.println("status : " + status + " time: " + time + " failedCount : " + failedRequestsCount + " distance : " + distance);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private static void connectScore(String authKey) {
        System.out.println(">>>> connect Score");
        JSONObject response = Connection.getInstance().connectScore(authKey);
        try {
            float score = response.getFloat("score");
            System.out.println("score : " + score);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private static boolean onCalls(ArrayList<Elevator> elevatorList, HashMap<Integer, Call> callMap) {
        System.out.println("\n\n>>>> api.on_calls()");
        JSONObject responseJson = Connection.getInstance().onCalls();
//		System.out.println("onCalls Json Form data : " + responseJson + "\n");
        JSONParser parser = new JSONParser();
        try {
            elevatorList.addAll(parser.getElevatorsFromOnCalls(responseJson));
//			System.out.println("***elevatorList\n" + elevatorList);
            callMap.putAll(parser.getCallMapFromOnCalls(responseJson));
//			System.out.println("***callMap\n" + callMap);

            return responseJson.getBoolean("is_end");
        } catch (JSONException e) {
            e.printStackTrace();
        }


        return false;
    }

    private static Command generateCommand(Elevator elevator, HashMap<Integer, Call> callMap, Call job) {
        Command command = new Command(elevator.getId());

        if (job == null) { // job이 없을 때 FIFO에 따라 최신 job넣어주기
            if (callMap.isEmpty()) { // 할 일도 없으면 STOP
                if (elevator.getStatus().equals(STATUS_OPENED))
                    return new Command(elevator.getId(), COMMAND_CLOSE);
                else
                    return new Command(elevator.getId(), COMMAND_STOP);
            }
            List<Call> calls = new ArrayList<Call>(callMap.values());

            for (int i = 0; i < jobs.length; i++) {
                Call call = jobs[i];
                if (call == null)
                    continue;
                else {
                    int id = call.getId();
                    calls.removeIf(c -> c.getId() == id);
                }
            }
            if (calls.isEmpty())
                if (elevator.getStatus().equals(STATUS_OPENED))
                    return new Command(elevator.getId(), COMMAND_CLOSE);
                else
                    return new Command(elevator.getId(), COMMAND_STOP);

            Collections.sort(calls, compById);
            jobs[elevator.getId()] = calls.get(0);

            job = calls.get(0);
        }

//		System.out.println(elevator.getId()+"의 job =" + job);

        // for next elevator
        callMap.remove(job.getId());
        String status = elevator.getStatus();

        if (elevator.hasPassenger()) { // 탑승 후, 승객이 있을 때
            if (elevator.getFloor() < job.getEnd()) {
                //			up();
                if (status.equals(STATUS_OPENED)) {
                    command.setCommand(COMMAND_CLOSE);
                } else if (status.equals(STATUS_STOPPED)) {
                    command.setCommand(COMMAND_UP);
                } else {
                    command.setCommand(COMMAND_UP);
                }

            } else if (elevator.getFloor() > job.getEnd()) {
                //			down();
                if (status.equals(STATUS_OPENED)) {
                    command.setCommand(COMMAND_CLOSE);
                } else if (status.equals(STATUS_STOPPED)) {
                    command.setCommand(COMMAND_DOWN);
                } else {
                    command.setCommand(COMMAND_DOWN);
                }

            } else { // 현재층이면

                if (status.equals(STATUS_UPWARD) || status.equals(STATUS_DOWNWARD)) {
                    command.setCommand(COMMAND_STOP);
                } else if (status.equals(STATUS_STOPPED)) {
                    command.setCommand(COMMAND_OPEN);
                } else if (status.equals(STATUS_OPENED)) {
                    command.setCommand(COMMAND_EXIT);
                    int[] callIds = new int[1];
                    callIds[0] = job.getId();
                    command.setCall_ids(callIds);
                    jobs[elevator.getId()] = null; // 일 마침
                }
            }


        } else { // 승객이 없을 때
            if (elevator.getFloor() < job.getStart()) {
                //			up();
                if (status.equals(STATUS_OPENED)) {
                    command.setCommand(COMMAND_CLOSE);
                } else if (status.equals(STATUS_STOPPED)) {
                    command.setCommand(COMMAND_UP);
                } else {
                    command.setCommand(COMMAND_UP);
                }

            } else if (elevator.getFloor() > job.getStart()) {
                //			down();
                if (status.equals(STATUS_OPENED)) {
                    command.setCommand(COMMAND_CLOSE);
                } else if (status.equals(STATUS_STOPPED)) {
                    command.setCommand(COMMAND_DOWN);
                } else {
                    command.setCommand(COMMAND_DOWN);
                }

            } else { // 현재층이면

                if (status.equals(STATUS_UPWARD) || status.equals(STATUS_DOWNWARD)) {
                    command.setCommand(COMMAND_STOP);
                } else if (status.equals(STATUS_STOPPED)) {
                    command.setCommand(COMMAND_OPEN);
                } else if (status.equals(STATUS_OPENED)) {
                    command.setCommand(COMMAND_ENTER);

                    int[] callIds = new int[1];
                    callIds[0] = job.getId();
                    command.setCall_ids(callIds);
                }
            }
        }

        return command;
    }

    private static void action(ArrayList<Command> commandList) {
        System.out.println("\n\n>>>> api.action()");
        JSONParser parser = new JSONParser();
        JSONArray commandArray = parser.getCommandsJSONArray(commandList);

//		System.out.println(commandArray);
        Connection.getInstance().action(commandArray);
    }

    private static Comparator<Call> compById = new Comparator<Call>() {
        public int compare(Call c1, Call c2) {
            return c1.getId() - c2.getId();
        }
    };

}
