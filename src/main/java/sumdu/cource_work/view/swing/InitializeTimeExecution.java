package sumdu.cource_work.view.swing;

import sumdu.cource_work.view.InitTimeExe;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Слава on 05.12.2017.
 */
public class InitializeTimeExecution extends  HorizontalBox implements InitTimeExe {
    private JTextField initTimeExe = new JTextField(4);
    {
        this.add(Box.createHorizontalStrut(200));
        this.add(new Label(" Init time execution:"));
        this.add(initTimeExe);
        this.add(Box.createHorizontalStrut(200));
    }

    @Override
    public int getExeTime() {
        if (initTimeExe.getText().trim().equals("")){
            throw new IllegalArgumentException();
        }
        return Integer.parseInt(initTimeExe.getText());
    }
}
