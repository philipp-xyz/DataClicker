package main.dataclicker.minigames.dataSnake.gui;

import main.dataclicker.minigames.dataSnake.Handler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Gui {

    private JFrame frame;
    private Canvas canvas;

    private String title;
    private int width, height;

    private Handler handler;


    public Gui(String title, int width, int height, Handler handler) {
        this.title = title;
        this.width = width;
        this.height = height;

        this.handler = handler;

        init();

    }

    public void init() {
        frame = new JFrame(title);
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setResizable(true);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.addWindowListener(exitListener);
        //frame.setLayout(new GridLayout(1, 1, 0, 0));

        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width, height));
        canvas.setMaximumSize(new Dimension(width, height));
        canvas.setMinimumSize(new Dimension(width, height));
        canvas.setFocusable(false);

        frame.add(canvas);
        frame.pack();

    }

    WindowListener exitListener = new WindowAdapter() {

        @Override
        public void windowClosing(WindowEvent e) {
            int confirm = JOptionPane.showOptionDialog(
                    null,"Sind Sie sich sicher das Sie die Anwendung wirklich beenden wollen?",
                    "Halt! Stop! JETZT REDE ICH!!!", JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null, null, null);
            if (confirm == 0) {
                handler.getGame().stop();
                frame.dispose();
            }
        }
    };


    public Canvas getCanvas() {
        return canvas;
    }

    public JFrame getFrame() {
        return frame;
    }


}
