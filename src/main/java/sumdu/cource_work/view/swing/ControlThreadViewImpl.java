package sumdu.cource_work.view.swing;

import sumdu.cource_work.view.ControlThreadView;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Слава on 25.11.2017.
 */
public class ControlThreadViewImpl extends HorizontalBox implements ControlThreadView {
    private JTextField titleLabel = new JTextField(2);
    private JTextField tasksInQueueLabel = new JTextField(2);
    private JTextField tasksOfExeLabel = new JTextField(2);
    private JTextField timeOfTaskExeLabel = new JTextField(2);
    private JTextField timeOfArriveTaskLabel = new JTextField(2);
    private JTextField resultLabel = new JTextField(12);
    {
        titleLabel.setEditable(false);
        tasksInQueueLabel.setEditable(false);
        tasksOfExeLabel.setEditable(false);
        timeOfTaskExeLabel.setEditable(false);
        timeOfArriveTaskLabel.setEditable(false);
        resultLabel.setEditable(false);
        this.add(titleLabel);
        this.add(new Label(" Tasks for exe:"));
        this.add(tasksOfExeLabel);
        this.add(new Label(" Arrive Time:"));
        this.add(timeOfArriveTaskLabel);
        this.add(new Label(" Task in Queue:"));
        this.add(tasksInQueueLabel);
        this.add(new Label(" Exe Time:"));
        this.add(timeOfTaskExeLabel);
        this.add(new Label(" Result:"));
        this.add(resultLabel);
    }


    public void setTitle(String string) {
        titleLabel.setText(string);
    }

    public void setTimeOfTaskExe(int timeOfTaskExe) {
        timeOfTaskExeLabel.setText(String.valueOf(timeOfTaskExe));
    }

    public void setTimeOfArriveTask(int timeOfArriveTask) {
        timeOfArriveTaskLabel.setText(String.valueOf(timeOfArriveTask));
    }

    public void setAmountOfTasks(int tasksForExec) {
        tasksOfExeLabel.setText(String.valueOf(tasksForExec));
    }

    public void setTasksInQueue(int tasksInQueue) {
        tasksInQueueLabel.setText(String.valueOf(tasksInQueue));
    }

    public void setResult(int sumTime, int amountOfTasks) {
        resultLabel.setText(" allTime:" + sumTime + " tasks:" + amountOfTasks);
    }
}
