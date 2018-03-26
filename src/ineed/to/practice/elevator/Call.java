package ineed.to.practice.elevator;

public class Call {

    private int origin;
    private int target;
    private Elevator.State state;

    public Call(int origin, int target) {
        this.origin = origin;
        this.target = target;
        this.state = origin < target ? Elevator.State.UP : Elevator.State.DOWN;
    }

    public int getOrigin() {
        return origin;
    }

    public int getTarget() {
        return target;
    }

    public Elevator.State getState() {
        return state;
    }
}
