package sumdu.cource_work.view.swing;

import sumdu.cource_work.controller.MainActionListener;
import sumdu.cource_work.view.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;


public class MainSchemaWindowImpl extends JFrame implements MainSchemaWindow {

    private Box mainBox = Box.createVerticalBox();
    private InitializeAmountOfTasksImpl initializeFields = new InitializeAmountOfTasksImpl();
    private InitializeLimitsOfTasksBox initializeLimitsOfTasksBox = new InitializeLimitsOfTasksBox();
    private InitializeTimeExecution initTimeExe = new InitializeTimeExecution();
    private ActionListener actionListener;
    private ControlThreadViewImpl controlThreadViewA = new ControlThreadViewImpl();;
    private ControlThreadViewImpl controlThreadViewB = new ControlThreadViewImpl();;
    private ControlThreadViewImpl controlThreadViewC = new ControlThreadViewImpl();;

    public MainSchemaWindowImpl(String title) throws HeadlessException {
        super(title);

    }

    public void setMainActionListener(MainActionListener actionListener) {
        this.actionListener = actionListener;
    }

    public ControlThreadView getViewForA(){
        return controlThreadViewA;
    }

    public ControlThreadView getViewForB(){
        return controlThreadViewB;
    }

    public ControlThreadView getViewForC(){
        return controlThreadViewC;
    }

    public void displayWindow() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainBox.setBorder(new EmptyBorder(20,20,20,20));

        mainBox.add(controlThreadViewA);
        mainBox.add(Box.createVerticalStrut(17));

        mainBox.add(controlThreadViewB);
        mainBox.add(Box.createVerticalStrut(17));

        mainBox.add(controlThreadViewC);
        mainBox.add(Box.createVerticalStrut(17));

        mainBox.add(initTimeExe);
        mainBox.add(Box.createVerticalStrut(17));
        /*mainBox.add(initializeFields);
        mainBox.add(Box.createVerticalStrut(17));
        mainBox.add(initializeLimitsOfTasksBox);*/
        Box mainControlBox = new MainControlBox(actionListener);
        mainBox.add(Box.createVerticalStrut(17));
        mainBox.add(mainControlBox);
       // JPanel p = new FonPanel();
        JPanel p = new JPanel();
        p.add(mainBox);
        setContentPane(p);
        pack();

        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void closeWindow(){
        setVisible(false);
        dispose();
    }

    @Override
    public InitializeAmountOfTasks getInitializedFields() {
        return initializeFields;
    }

    @Override
    public InitializeLimitsOfTasks getInitializedLimitFields() {
        return initializeLimitsOfTasksBox;
    }

    @Override
    public InitTimeExe getInitTimeExeView() {
        return initTimeExe;
    }

}