package ineed.to.practice.callcenter;

public class Director extends Employee {

    protected Director(int number) {
        super(number);
    }

    public final Type getType() {
        return Type.DIRECTOR;
    }
}
