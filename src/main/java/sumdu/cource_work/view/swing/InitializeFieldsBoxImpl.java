package sumdu.cource_work.view.swing;

import sumdu.cource_work.model.TaskType;
import sumdu.cource_work.view.InitializeFieldsBox;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EnumMap;
import java.util.Map;

public class InitializeFieldsBoxImpl extends HorizontalBox implements InitializeFieldsBox {

    private JTextField initNumOfTaskAField = new JTextField(4);
    private JTextField initNumOfTaskBField = new JTextField(4);
    private JTextField initNumOfTaskCField = new JTextField(4);

    {
        this.add(new Label(" Init A:"));
        this.add(initNumOfTaskAField);
        this.add(new Label(" Init B:"));
        this.add(initNumOfTaskBField);
        this.add(new Label(" Init C:"));
        this.add(initNumOfTaskCField);
    }

    public InitializeFieldsBoxImpl() {
    }

    @Override
    public Map<TaskType, Integer> getInitFields() throws IllegalArgumentException{
        if (initNumOfTaskAField.getText().trim().equals("") || initNumOfTaskBField.getText().trim().equals("")
                || initNumOfTaskCField.getText().trim().equals("") ){
            throw new IllegalArgumentException();
        }
        Map<TaskType, Integer> mapValues = new EnumMap<TaskType, Integer>(TaskType.class);

        return mapValues;
    }
}
