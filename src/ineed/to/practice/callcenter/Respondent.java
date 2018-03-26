package ineed.to.practice.callcenter;

public class Respondent extends Employee {

    protected Respondent(int number) {
        super(number);
    }

    public final Type getType() {
        return Type.RESPONDENT;
    }
}
