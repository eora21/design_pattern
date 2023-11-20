package state;

public class DayState implements State {
    private static final DayState INSTANCE = new DayState();

    private DayState() {
    }

    public static State getInstance() {
        return INSTANCE;
    }

    @Override
    public void doClock(Context context, int hour) {
        if (hour < 9 || 17 <= hour) {
            context.changeState(NightState.getInstance());
        }
    }

    @Override
    public void doUse(Context context) {
        context.recordLog("금고 사용(주간)");
    }

    @Override
    public void doAlarm(Context context) {
        context.recordLog("비상벨(주간)");
    }

    @Override
    public void doPhone(Context context) {
        context.recordLog("일반 통화(주간)");
    }

    @Override
    public String getDescription() {
        return "[주간]";
    }
}
