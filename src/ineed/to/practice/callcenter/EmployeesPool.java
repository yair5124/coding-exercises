package ineed.to.practice.callcenter;

import java.util.LinkedList;

public class EmployeesPool {

    private LinkedList<Respondent> freeResp;
    private LinkedList<Manager> freeManagers;
    private LinkedList<Director> freeDirectors;
    static EmployeesPool INSTANCE = new EmployeesPool();

    private EmployeesPool() {
        freeResp = new LinkedList<Respondent>();
        freeManagers = new LinkedList<Manager>();
        freeDirectors = new LinkedList<Director>();
    }

    Employee getFreeEmployee() {
        Employee free = freeResp.pollFirst();
        if (free == null) free = freeManagers.pollFirst();
        if (free == null) free = freeDirectors.pollFirst();
        return free;
    }

    void addFree(Employee employee) {
        if (employee.getType() == Employee.Type.RESPONDENT) freeResp.addLast((Respondent) employee);
        else if (employee.getType() == Employee.Type.MANAGER) freeManagers.addLast((Manager) employee);
        else if (employee.getType() == Employee.Type.DIRECTOR) freeDirectors.addLast((Director) employee);
    }
}
