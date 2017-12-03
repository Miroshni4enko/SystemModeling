package sumdu.cource_work.controller;

import sumdu.cource_work.model.TaskType;
import sumdu.cource_work.view.MainSchemaWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.Map;

public class MainExecuteListenerImpl implements MainActionListener{
    private volatile ExecutionService executionService;
    private MainSchemaWindow mainSchemaWindow;

    public MainExecuteListenerImpl(ExecutionService executionService, MainSchemaWindow mainSchemaWindow) {
        this.executionService = executionService;
        this.mainSchemaWindow = mainSchemaWindow;
        mainSchemaWindow.setMainActionListener(this);

    }

    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case MainActionListener.START_SERVICE :
                    run();
                break;

            case MainActionListener.STOP_SERVICE :
                executionService.stopServiceAndGetResult();
            break;
        }
    }
    void run() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    executionService.startService(mainSchemaWindow);
                } catch (InterruptedException e1) {
                    JOptionPane.showMessageDialog(null, "Execution exception, please restart app");
                } catch (IllegalArgumentException e1){
                    JOptionPane.showMessageDialog(null, "Some field is empty, please fill it");
                }
            }
        });
        thread.start();
    }
}
