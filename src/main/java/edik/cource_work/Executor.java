package edik.cource_work;

import edik.cource_work.view.MainSchemaWindow;
import edik.cource_work.view.MainSchemaWindowImpl;

/**
 * Created by Слава on 15.11.2017.
 */
public class Executor {
    public static void main(String[] args) {
        MainSchemaWindow  mainSchemaWindow = new MainSchemaWindowImpl("System Modeling");
        mainSchemaWindow.displayWindow();
    }


}
