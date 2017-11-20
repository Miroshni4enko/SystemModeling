package cource_work;

import cource_work.view.MainSchemaWindow;
import cource_work.view.MainSchemaWindowImpl;

/**
 * Created by Слава on 15.11.2017.
 */
public class Executor {
    public static void main(String[] args) {
        MainSchemaWindow mainSchemaWindow = new MainSchemaWindowImpl("System Modeling");
        mainSchemaWindow.displayWindow();
    }


}
