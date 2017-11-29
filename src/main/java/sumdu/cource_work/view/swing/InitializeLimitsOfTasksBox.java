package sumdu.cource_work.view.swing;

import sumdu.cource_work.model.TaskType;
import sumdu.cource_work.view.InitializeLimitsOfTasks;

import javax.swing.*;
import java.awt.*;
import java.util.EnumMap;
import java.util.Map;

import static sumdu.cource_work.model.TaskType.A;
import static sumdu.cource_work.model.TaskType.B;
import static sumdu.cource_work.model.TaskType.C;

public class InitializeLimitsOfTasksBox extends HorizontalBox implements InitializeLimitsOfTasks {
    private JTextField initLimitOfTaskAField = new JTextField(4);
    private JTextField initLimitOfTaskBField = new JTextField(4);
    private JTextField initLimitOfTaskCField = new JTextField(4);

    {
        this.add(new Label(" Init A lim:"));
        this.add(initLimitOfTaskAField);
        this.add(Box.createHorizontalStrut(50));
        this.add(new Label(" Init B lim:"));
        this.add(initLimitOfTaskBField);
        this.add(Box.createHorizontalStrut(50));
        this.add(new Label(" Init C lim:"));
        this.add(initLimitOfTaskCField);
    }


    @Override
    public Map<TaskType, Integer> getInitLimitsOfTasks() throws IllegalArgumentException {
        if (initLimitOfTaskAField.getText().trim().equals("") || initLimitOfTaskBField.getText().trim().equals("")
                || initLimitOfTaskCField.getText().trim().equals("") ){
            throw new IllegalArgumentException();
        }
        Map<TaskType, Integer> mapValues = new EnumMap<TaskType, Integer>(TaskType.class);
        mapValues.put(A, Integer.valueOf(initLimitOfTaskAField.getText()));
        mapValues.put(B, Integer.valueOf(initLimitOfTaskBField.getText()));
        mapValues.put(C, Integer.valueOf(initLimitOfTaskCField.getText()));
        return mapValues;
    }
}
