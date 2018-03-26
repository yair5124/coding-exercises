package ineed.to.practice.elevator;

public class Application {

    public static void main(String... args) {
        Controller controller = new Controller(2, 10);
        controller.registerCall(0, 5);
        controller.registerCall(2, 10);
        controller.registerCall(3, 0);
        controller.registerCall(1, 0);
        controller.registerCall(4, 6);
        controller.registerCall(6, 8);
        controller.run();
    }
}
