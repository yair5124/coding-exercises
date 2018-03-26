package ineed.to.practice.callcenter;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String... args) {
        CallCenter cc = new CallCenter(5,2,1);
        List<Employee> handlers = new ArrayList<Employee>();
        handlers.add(cc.dispatchCall());
        handlers.add(cc.dispatchCall());
        handlers.add(cc.dispatchCall());
        handlers.remove(2).endCall();
        handlers.add(cc.dispatchCall());
        handlers.add(cc.dispatchCall());
        handlers.add(cc.dispatchCall());
        handlers.add(cc.dispatchCall());
        handlers.add(cc.dispatchCall());
        handlers.add(cc.dispatchCall());
        handlers.add(cc.dispatchCall());
    }
}
