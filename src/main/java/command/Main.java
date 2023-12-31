package command;

import command.command.MacroCommand;
import command.drawer.ColorCommand;
import command.drawer.DrawCanvas;
import command.drawer.DrawCommand;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Main extends JFrame {
    private final MacroCommand history = new MacroCommand();
    private final DrawCanvas canvas = new DrawCanvas(400, 400, history);
    private final JButton colorRedButton = new JButton("Red");
    private final JButton colorGreenButton = new JButton("Green");
    private final JButton clearButton = new JButton("Clear");
    private final JButton undoButton = new JButton("Undo");

    public Main(String title) throws HeadlessException {
        super(title);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        canvas.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                DrawCommand drawCommand = new DrawCommand(canvas, e.getPoint());
                history.append(drawCommand);
                drawCommand.execute();
            }
        });

        clearButton.addActionListener(e -> {
            history.clear();
            canvas.repaint();
        });

        colorRedButton.addActionListener(e -> {
            ColorCommand colorCommand = new ColorCommand(canvas, Color.RED);
            history.append(colorCommand);
            colorCommand.execute();
        });

        colorGreenButton.addActionListener(e -> {
            ColorCommand colorCommand = new ColorCommand(canvas, Color.GREEN);
            history.append(colorCommand);
            colorCommand.execute();
        });

        undoButton.addActionListener(e -> {
            history.undo();
            canvas.repaint();
        });

        Box buttonBox = new Box(BoxLayout.X_AXIS);
        buttonBox.add(clearButton);
        buttonBox.add(colorRedButton);
        buttonBox.add(colorGreenButton);
        buttonBox.add(undoButton);

        Box mainBox = new Box(BoxLayout.Y_AXIS);
        mainBox.add(buttonBox);
        mainBox.add(canvas);
        getContentPane().add(mainBox);

        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        new Main("Command Pattern Sample");
    }
}
