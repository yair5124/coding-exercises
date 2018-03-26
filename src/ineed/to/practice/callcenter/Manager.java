package ineed.to.practice.callcenter;

public class Manager extends Employee {

    protected Manager(int number) {
        super(number);
    }

    public final Type getType() {
        return Type.MANAGER;
    }
}
