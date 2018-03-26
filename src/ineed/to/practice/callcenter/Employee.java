package ineed.to.practice.callcenter;

public abstract class Employee {

    enum Type { RESPONDENT, MANAGER, DIRECTOR }

    private int number;

    protected Employee(int number) {
        this.number = number;
    }
    abstract Type getType();

    protected int getNumber() {
        return this.number;
    }

    protected void endCall() {
        EmployeesPool.INSTANCE.addFree(this);
    }
}
