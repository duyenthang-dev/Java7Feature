package default_method;

public interface Vehicle {
    int a = 0;
    int getSpeed();
    void applyBreak();
    default void autoPilot() {
        System.out.println("Automatical drive");
    }
}
