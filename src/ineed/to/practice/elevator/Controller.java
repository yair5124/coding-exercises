package ineed.to.practice.elevator;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Controller {

    private int topFloor;
    private int elevatorCount;
    private List<Elevator> elevators;
    private LinkedList<Call> callQueue;

    public Controller(int elevatorsCount, int topFloor) {
        this.elevatorCount = elevatorsCount;
        this.topFloor = topFloor;
        this.elevators = new ArrayList<Elevator>(elevatorsCount);
        for (int i = 0; i < elevatorsCount; i++) {
            this.elevators.add(new Elevator(0));
        }
        this.callQueue = new LinkedList<Call>();
    }

    void run() {
        while (callQueue.size() > 0) {
          Elevator available = getAvailableElevator(callQueue.peekFirst());
          if (available != null) {
              available.handleCall(callQueue.pollFirst());
         }
      }
    }

    void registerCall(int origin, int target) {
        Call call = new Call(origin, target);
        callQueue.addLast(call);
    }

    private Elevator getAvailableElevator(Call call) {
        for (Elevator elev: this.elevators) {
            if (elev.canHandle(call)) {
                return elev;
            }
        }
        return null;
    }
}
