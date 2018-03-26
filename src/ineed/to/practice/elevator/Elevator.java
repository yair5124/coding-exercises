package ineed.to.practice.elevator;

import java.util.*;

public class Elevator {

    public enum State {UP, DOWN, STAND}

    private int current;
    private Set<Integer> targets;
    private State state;

    public Elevator(int current) {
        this.current = current;
        this.targets = new TreeSet<Integer>();
        this.state = State.STAND;
    }

    public void handleCall(Call call) {
        this.targets.add(call.getTarget());
        this.current = call.getOrigin(); // move to start floor
        System.out.println("Starting from floor " + this.current);
        for (Iterator<Integer> iterator = targets.iterator(); iterator.hasNext(); ) {
            int target = iterator.next();
            this.state = this.current < target ? State.UP : State.DOWN;
            if (this.state == State.UP) {
                for (int floor = this.current+1; floor <= target; floor++) {
                    progress(floor);
                }
            } else {
                for (int floor = this.current-1; floor >= target; floor--) {
                    progress(floor);
                }
            }
            this.current = target;
            iterator.remove();
        }
        this.state = State.STAND;
    }

    private void progress(int floor) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Reached floor " + floor);
    }

    public boolean canHandle(Call call) {
        switch (this.state) {
            case STAND:
                return true;
            case UP:
                return (this.current <= call.getOrigin() && call.getOrigin() < call.getTarget());
            case DOWN:
                return (this.current >= call.getOrigin() && call.getOrigin() > call.getTarget());
        }
        return false;
    }

}
