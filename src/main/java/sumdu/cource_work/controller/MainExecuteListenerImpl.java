package sumdu.cource_work.controller;


import sumdu.cource_work.view.MainSchemaWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

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
        final java.util.Timer timer = new Timer();
        final TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                try {
                    executionService.stopServiceAndGetResult();
                    JOptionPane.showMessageDialog(null, "Time over!");
                } catch (IllegalArgumentException e1){
                    JOptionPane.showMessageDialog(null, "Some field is empty, please fill it");
                }
            }
        };


        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                timer.schedule(timerTask,TimeUnit.SECONDS.toMillis(mainSchemaWindow.getInitTimeExeView().getExeTime()));
            }
        });
        System.out.println((TimeUnit.SECONDS.toMillis(mainSchemaWindow.getInitTimeExeView().getExeTime())));
        Thread thread1 = new Thread(new Runnable() {
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
        thread1.start();
    }

}
