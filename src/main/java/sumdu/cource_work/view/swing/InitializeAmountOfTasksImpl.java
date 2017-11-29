package sumdu.cource_work.view.swing;

import sumdu.cource_work.model.TaskType;
import sumdu.cource_work.view.InitializeAmountOfTasks;

import javax.swing.*;
import java.awt.*;
import java.util.EnumMap;
import java.util.Map;

import static sumdu.cource_work.model.TaskType.A;
import static sumdu.cource_work.model.TaskType.B;
import static sumdu.cource_work.model.TaskType.C;

public class InitializeAmountOfTasksImpl extends HorizontalBox implements InitializeAmountOfTasks {

    private JTextField initNumOfTaskAField = new JTextField(4);
    private JTextField initNumOfTaskBField = new JTextField(4);
    private JTextField initNumOfTaskCField = new JTextField(4);

    {
        this.add(new Label(" Init A:"));
        this.add(initNumOfTaskAField);
        this.add(Box.createHorizontalStrut(50));
        this.add(new Label(" Init B:"));
        this.add(initNumOfTaskBField);
        this.add(Box.createHorizontalStrut(50));
        this.add(new Label(" Init C:"));
        this.add(initNumOfTaskCField);
    }

    public InitializeAmountOfTasksImpl() {
    }

    @Override
    public Map<TaskType, Integer> getInitAmountOfTasks() throws IllegalArgumentException{
        if (initNumOfTaskAField.getText().trim().equals("") || initNumOfTaskBField.getText().trim().equals("")
                || initNumOfTaskCField.getText().trim().equals("") ){
            throw new IllegalArgumentException();
        }
        Map<TaskType, Integer> mapValues = new EnumMap<TaskType, Integer>(TaskType.class);
        mapValues.put(A, Integer.valueOf(initNumOfTaskAField.getText()));
        mapValues.put(B, Integer.valueOf(initNumOfTaskBField.getText()));
        mapValues.put(C, Integer.valueOf(initNumOfTaskCField.getText()));
        return mapValues;
    }

}
