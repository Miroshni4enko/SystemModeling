package sumdu.cource_work.view.swing;

import sumdu.cource_work.view.ControlThreadView;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Слава on 25.11.2017.
 */
public class ControlThreadViewImpl extends HorizontalBox implements ControlThreadView {
    private JLabel titleLabel = new JLabel();
    private JLabel tasksInQueueLabel = new JLabel();
    private JLabel tasksOfExeLabel = new JLabel();
    private JLabel timeOfTaskExeLabel = new JLabel();
    private JLabel timeOfArriveTaskLabel = new JLabel();
    private JLabel resultLabel = new JLabel();
    {
        this.add(new Label(" Tasks for exe:"));
        this.add(tasksOfExeLabel);
        this.add(new Label(" Arrive Time:"));
        this.add(timeOfArriveTaskLabel);
        this.add(new Label(" Task in Queue:"));
        this.add(timeOfArriveTaskLabel);
        this.add(new Label(" Exe Time:"));
        this.add(timeOfArriveTaskLabel);
        this.add(new Label(" Result:"));
        this.add(timeOfArriveTaskLabel);
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
