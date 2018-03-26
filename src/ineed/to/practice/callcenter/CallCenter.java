package ineed.to.practice.callcenter;

public class CallCenter {

    CallCenter(int repsCount, int managersCount, int directorsCount) {
        init(repsCount, managersCount, directorsCount);
    }

    void init(int repsCount, int managersCount, int directorsCount) {
        EmployeesPool pool = EmployeesPool.INSTANCE;
        for (int i = 0; i < repsCount; i++) {
            pool.addFree(new Respondent(i+1));
        }
        for (int i = 0; i < managersCount; i++) {
            pool.addFree(new Manager(i+1));
        }
        for (int i = 0; i < directorsCount; i++) {
            pool.addFree(new Director(i+1));
        }
    }

    Employee dispatchCall() {
        Employee free = EmployeesPool.INSTANCE.getFreeEmployee();
        if (free == null) {
            System.err.println("Ooops, no one can handle the call");
        } else {
            System.out.println("Call handled by " + free.getType() + " no. " + free.getNumber());
        }
        return free;
    }
}
