package state;

public interface Context {
    void setClock(int hour);

    void changeState(State state);

    void callSecurityCenter(String message);

    void recordLog(String message);
}
