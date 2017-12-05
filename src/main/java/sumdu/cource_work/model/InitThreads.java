package sumdu.cource_work.model;

import sumdu.cource_work.view.ControlThreadView;
import sumdu.cource_work.view.MainSchemaWindow;

import java.util.EnumMap;
import java.util.Map;
import java.util.concurrent.Semaphore;

import static sumdu.cource_work.controller.ExecutionThreadsService.*;
import static sumdu.cource_work.model.TaskType.*;

/**
 * Created by Слава on 19.11.2017.
 */
public class InitThreads {
    private final Semaphore semaphore = new Semaphore(0, true);

    private Map<TaskType, ExecutionThread> threadsMap = new EnumMap<TaskType, ExecutionThread>(TaskType.class);
    private MainSchemaWindow mainSchemaWindow;

    public InitThreads(MainSchemaWindow mainSchemaWindow) {
        this.mainSchemaWindow = mainSchemaWindow;
    }


    /*public void addAmountOfTaskA(int amountOfTaskA) {
        this.amountOfTaskA = amountOfTaskA;
        threadsMap.get(TaskType.A).addTasksToQueue(amountOfTaskA);
    }

    public void addAmountOfTaskB(int amountOfTaskB) {
        this.amountOfTaskB = amountOfTaskB;
        threadsMap.get(TaskType.B).addTasksToQueue(amountOfTaskB);
    }

    public void addAmountOfTaskC(int amountOfTaskC) {
        this.amountOfTaskC = amountOfTaskC;
        threadsMap.get(TaskType.C).addTasksToQueue(amountOfTaskC);
    }*/

    public Map<TaskType, ExecutionThread> createExecutionThreads() {
        Map<TaskType, Integer> initValueMap = new EnumMap<>(TaskType.class);
        initValueMap.put(A, 3); // mainSchemaWindow.getInitializedFields().getInitAmountOfTasks();
        initValueMap.put(B, 3);
        initValueMap.put(C, 5);

        Map<TaskType, Integer> initLimitValueMap = new EnumMap<>(TaskType.class);//mainSchemaWindow.getInitializedLimitFields().getInitLimitsOfTasks();
        initLimitValueMap.put(A, 3);
        initLimitValueMap.put(B, 3);
        initLimitValueMap.put(C, 3);

        threadsMap.put(A, new ExecutionThread(semaphore, AMOUNT_PERMIT_FOR_PARALLEL_THREAD, initValueMap.get(A), initLimitValueMap.get(A), A, mainSchemaWindow.getViewForA()));
        threadsMap.put(B, new ExecutionThread(semaphore, AMOUNT_PERMIT_FOR_PARALLEL_THREAD, initValueMap.get(B), initLimitValueMap.get(B), B, mainSchemaWindow.getViewForB()));
        threadsMap.put(C, new ExecutionThread(semaphore, AMOUNT_PERMIT_FOR_THREAD_WITH_CONDITION, initValueMap.get(C), initLimitValueMap.get(B), C, mainSchemaWindow.getViewForC()));
        return threadsMap;
    }

    public void stopAllThreads() {
        for(ExecutionThread execThread: threadsMap.values()){
            execThread.stop();
        }
    }
}
