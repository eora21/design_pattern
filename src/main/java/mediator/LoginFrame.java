package mediator;

import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends Frame implements ActionListener, Mediator {
    private ColleagueCheckbox checkGuest;
    private ColleagueCheckbox checkLogin;
    private ColleagueTextField textUser;
    private ColleagueTextField textPass;
    private ColleagueButton buttonOk;
    private ColleagueButton buttonCancel;

    public LoginFrame(String title) throws HeadlessException {
        super(title);
        setBackground(Color.lightGray);
        setLayout(new GridLayout(4, 2));
        createColleagues();
        add(checkGuest);
        add(checkLogin);
        add(new Label("Username:"));
        add(textUser);
        add(new Label("Password:"));
        add(textPass);
        add(buttonOk);
        add(buttonCancel);
        colleagueChanged();
        pack();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.toString());
        System.exit(0);
    }

    @Override
    public void createColleagues() {
        CheckboxGroup checkboxGroup = new CheckboxGroup();
        checkGuest = new ColleagueCheckbox("Guest", checkboxGroup, true);
        checkLogin = new ColleagueCheckbox("Login", checkboxGroup, false);

        textUser = new ColleagueTextField("", 10);
        textPass = new ColleagueTextField("", 10);
        textPass.setEchoChar('*');

        buttonOk = new ColleagueButton("OK");
        buttonCancel = new ColleagueButton("Cancel");

        checkGuest.setMediator(this);
        checkLogin.setMediator(this);
        textUser.setMediator(this);
        textPass.setMediator(this);
        buttonOk.setMediator(this);
        buttonCancel.setMediator(this);

        checkGuest.addItemListener(checkGuest);
        checkLogin.addItemListener(checkLogin);
        textUser.addTextListener(textUser);
        textPass.addTextListener(textPass);
        buttonOk.addActionListener(this);
        buttonCancel.addActionListener(this);
    }

    @Override
    public void colleagueChanged() {
        if (checkGuest.getState()) {
            textUser.setColleagueEnabled(false);
            textPass.setColleagueEnabled(false);
            buttonOk.setColleagueEnabled(true);
            return;
        }

        textUser.setColleagueEnabled(true);
        userPassChanged();
    }

    private void userPassChanged() {
        if (textUser.getText().isEmpty()) {
            textPass.setColleagueEnabled(false);
            buttonOk.setColleagueEnabled(false);
            return;
        }

        textPass.setColleagueEnabled(true);

        if (textPass.getText().isEmpty()) {
            buttonOk.setColleagueEnabled(false);
            return;
        }

        buttonOk.setColleagueEnabled(true);
    }
}
