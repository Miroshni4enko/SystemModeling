package edik.cource_work.model;

import edik.cource_work.model.ExecutionThread;
import edik.cource_work.model.TaskType;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.Semaphore;

import static edik.cource_work.controller.ExecutionThreadsService.*;

/**
 * Created by Слава on 19.11.2017.
 */
public class InitThreads {
    private final Semaphore semaphore = new Semaphore(2, true);
    private int amountOfTaskA;
    private int amountOfTaskB;
    private int amountOfTaskC;
    private Map<TaskType, ExecutionThread> threadsMap = new EnumMap<TaskType, ExecutionThread>(TaskType.class);;

    public InitThreads(int amountOfTaskA, int amountOfTaskB, int amountOfTaskC) {
        this.amountOfTaskA = amountOfTaskA;
        this.amountOfTaskB = amountOfTaskB;
        this.amountOfTaskC = amountOfTaskC;
    }

    public void setAmountOfTaskA(int amountOfTaskA) {
        this.amountOfTaskA = amountOfTaskA;
    }

    public void setAmountOfTaskB(int amountOfTaskB) {
        this.amountOfTaskB = amountOfTaskB;
    }

    public void setAmountOfTaskC(int amountOfTaskC) {
        this.amountOfTaskC = amountOfTaskC;
    }

    public int getAmountOfTaskA() {
        return amountOfTaskA;
    }

    public int getAmountOfTaskB() {
        return amountOfTaskB;
    }

    public int getAmountOfTaskC() {
        return amountOfTaskC;
    }

    public void addAmountOfTaskA(int amountOfTaskA) {
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
    }

    public Map<TaskType, ExecutionThread> createExecutionThreads() {
        threadsMap.put(TaskType.A, new ExecutionThread(semaphore, AMOUNT_PERMIT_FOR_PARALLEL_THREAD, amountOfTaskA, TaskType.A));
        threadsMap.put(TaskType.B, new ExecutionThread(semaphore, AMOUNT_PERMIT_FOR_PARALLEL_THREAD, amountOfTaskB,  TaskType.B));
        threadsMap.put(TaskType.C, new ExecutionThread(semaphore, AMOUNT_PERMIT_FOR_THREAD_WITH_CONDITION, amountOfTaskC, TaskType.C));
        return threadsMap;
    }

    public void stopAllThreads() {
        for(ExecutionThread execThread: threadsMap.values()){
            execThread.stop();
        }
    }
}
