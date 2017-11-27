package sumdu.cource_work.view.swing;

import sumdu.cource_work.controller.ExecutionService;
import sumdu.cource_work.model.TaskType;
import sumdu.cource_work.view.InitializeFieldsBox;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import static sumdu.cource_work.model.TaskType.*;

public class MainControlBox extends HorizontalBox implements ActionListener {

    private InitializeFieldsBox initializeFieldsBox;
    private ExecutionService executionService;
    private static final String START_SERVICE = "start";
    private static final String STOP_SERVICE = "stop";

    private JButton startService = new JButton("Start");
    private JButton stopService = new JButton("Stop");

    {
        this.add(startService);
        this.add(stopService);
    }

    public MainControlBox(ExecutionService executionService, InitializeFieldsBox initializeFieldsBox) {
        this.executionService = executionService;
        this.initializeFieldsBox = initializeFieldsBox;
    }

    private  void initActionForButtons(){
        startService.setActionCommand(START_SERVICE);
        stopService.setActionCommand(STOP_SERVICE);
        startService.addActionListener(this);
        stopService.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case START_SERVICE :
                try {
                    Map<TaskType, Integer> initValueMap = initializeFieldsBox.getInitFields();
                    executionService.startService(initValueMap.get(A), initValueMap.get(B), initValueMap.get(C));
                } catch (InterruptedException e1) {
                    JOptionPane.showMessageDialog(null, "Execution exception, please restart app");
                } catch (IllegalArgumentException e1){
                    JOptionPane.showMessageDialog(null, "Some field is empty, please fill it");
                }
                break;

            case STOP_SERVICE :
                    executionService.stopServiceAndGetResult();
                break;
        }
    }
}
