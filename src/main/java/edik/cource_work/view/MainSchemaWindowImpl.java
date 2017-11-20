package edik.cource_work.view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;


public class MainSchemaWindowImpl extends JFrame implements MainSchemaWindow {
    private JTextField addField;
    private JButton addButton;
    private JTextField removeField;
    private JButton removeButton;

    public JButton getAddButton() {
        return addButton;
    }

    public JButton getRemoveButton() {
        return removeButton;
    }

    public JTextField getAddField() {
        return addField;
    }

    public JTextField getRemoveField() {
        return removeField;
    }

    public MainSchemaWindowImpl(String title) throws HeadlessException {
        super(title);
    }


    public void displayWindow() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Box box1 = Box.createHorizontalBox();
        addButton = new JButton("Add:");
        addField = new JTextField(15);
        box1.add(addButton);
        box1.add(Box.createHorizontalStrut(27));
        box1.add(addField);

        Box box2 = Box.createHorizontalBox();
        removeButton = new JButton("Remove:");
        removeField = new JTextField(15);
        box2.add(removeButton);
        box2.add(Box.createHorizontalStrut(6));
        box2.add(removeField);

        Box box3 = Box.createHorizontalBox();

        Box mainBox = Box.createVerticalBox();

        mainBox.setBorder(new EmptyBorder(190,112,130,112));
        mainBox.add(box1);
        mainBox.add(Box.createVerticalStrut(12));
        mainBox.add(box2);
        mainBox.add(Box.createVerticalStrut(17));
        mainBox.add(box3);
        JPanel p = new FonPanel();
        p.add(mainBox);
        setContentPane(p);
        pack();

        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void closeWindow(){
        setVisible(false);
        dispose();
    }
}