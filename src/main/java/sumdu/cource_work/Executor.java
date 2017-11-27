package sumdu.cource_work;

import sumdu.cource_work.view.MainSchemaWindow;
import sumdu.cource_work.view.swing.MainSchemaWindowImpl;

/**
 * Created by Слава on 15.11.2017.
 */
public class Executor {
    public static void main(String[] args) {
        MainSchemaWindow  mainSchemaWindow = new MainSchemaWindowImpl("System Modeling");
        mainSchemaWindow.displayWindow();
    }


}
