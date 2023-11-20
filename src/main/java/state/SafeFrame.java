package state;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.HeadlessException;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;

public class SafeFrame extends Frame implements Context {
    private final TextField textClock = new TextField(60);
    private final TextArea textScreen = new TextArea(10, 60);
    private final Button buttonUse = new Button("금고 사용");
    private final Button buttonAlarm = new Button("비상벨");
    private final Button buttonPhone = new Button("일반 통화");
    private final Button buttonExit = new Button("종료");

    private State state = DayState.getInstance();

    public SafeFrame(String title) throws HeadlessException {
        super(title);
        setBackground(Color.lightGray);
        setLayout(new BorderLayout());

        add(textClock, BorderLayout.NORTH);
        textClock.setEditable(false);

        add(textScreen, BorderLayout.CENTER);
        textScreen.setEditable(false);

        Panel panel = new Panel();
        panel.add(buttonUse);
        panel.add(buttonAlarm);
        panel.add(buttonPhone);
        panel.add(buttonExit);

        add(panel, BorderLayout.SOUTH);

        pack();
        setVisible(true);

        buttonUse.addActionListener(e -> state.doUse(this));
        buttonAlarm.addActionListener(e -> state.doAlarm(this));
        buttonPhone.addActionListener(e -> state.doPhone(this));
        buttonExit.addActionListener(e -> System.exit(0));
    }

    @Override
    public void setClock(int hour) {
        String clockMessage = String.format("현재 시간은 %02d:00", hour);
        System.out.println(clockMessage);
        textClock.setText(clockMessage);
        state.doClock(this, hour);
    }

    @Override
    public void changeState(State state) {
        System.out.println(this.state.getDescription() + "에서 " + state.getDescription() + "으로 상태 변경");
        this.state = state;
    }

    @Override
    public void callSecurityCenter(String message) {
        textScreen.append("call! " + message + "\n");
    }

    @Override
    public void recordLog(String message) {
        textScreen.append("record ... " + message + "\n");
    }
}
