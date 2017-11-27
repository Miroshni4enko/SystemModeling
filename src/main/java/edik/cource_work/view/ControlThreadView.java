package edik.cource_work.view;

/**
 * Created by Слава on 25.11.2017.
 */
public interface ControlThreadView {
    void setTitle(String string);
    void setTimeOfTaskExe(int timeOfTaskExe);
    void setTimeOfArriveTask(int timeOfArriveTask);
    void setAmountOfTasks(int tasksForExec);
    void setTasksInQueue(int tasksInQueue);
    void setResult(int sumTime, int amountOfTasks);
}
