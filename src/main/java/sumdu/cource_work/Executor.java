package sumdu.cource_work;

import sumdu.cource_work.controller.ExecutionService;
import sumdu.cource_work.controller.ExecutionThreadsService;
import sumdu.cource_work.controller.MainExecuteListenerImpl;
import sumdu.cource_work.view.MainSchemaWindow;
import sumdu.cource_work.view.swing.MainSchemaWindowImpl;

import javax.swing.*;

/**
 * Created by Слава on 15.11.2017.
 */
public class Executor  {

    public static void main(String[] args) {
        MainSchemaWindow  mainSchemaWindow = new MainSchemaWindowImpl("System Modeling");
        ExecutionService executionService = new ExecutionThreadsService();
        MainExecuteListenerImpl mainExecuteListener = new MainExecuteListenerImpl(executionService, mainSchemaWindow);
        mainSchemaWindow.displayWindow();

    }


}
