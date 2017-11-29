package sumdu.cource_work.view.swing;

import sumdu.cource_work.controller.MainActionListener;

import javax.swing.*;
import java.awt.event.ActionListener;

public class MainControlBox extends HorizontalBox  {

    private final ActionListener actionListener;


    private JButton startService = new JButton("Start");
    private JButton stopService = new JButton("Stop");

    {
        this.add(startService);
        this.add(Box.createHorizontalStrut(50));
        this.add(stopService);
    }

    public MainControlBox(ActionListener actionListener) {
        this.actionListener = actionListener;
        initActionForButtons();
    }

    private  void initActionForButtons(){
        startService.setActionCommand(MainActionListener.START_SERVICE);
        stopService.setActionCommand(MainActionListener.STOP_SERVICE);
        startService.addActionListener(actionListener);
        stopService.addActionListener(actionListener);
    }

}
