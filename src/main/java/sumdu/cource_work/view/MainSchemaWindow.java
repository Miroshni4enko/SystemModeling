package sumdu.cource_work.view;

import sumdu.cource_work.controller.MainActionListener;

/**
 * Created by Слава on 15.11.2017.
 */
public interface MainSchemaWindow {
    void displayWindow();
    void closeWindow();
    InitializeAmountOfTasks getInitializedFields();
    InitializeLimitsOfTasks getInitializedLimitFields();
    InitTimeExe getInitTimeExeView();
    void setMainActionListener(MainActionListener mainActionListener);
    ControlThreadView getViewForA();
    ControlThreadView getViewForB();
    ControlThreadView getViewForC();
}
