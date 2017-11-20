package edik.cource_work.controller;

import edik.cource_work.model.ExecutionThread;
import edik.cource_work.model.InitThreads;
import edik.cource_work.model.TaskType;

import java.util.*;
import java.util.concurrent.*;

import static edik.cource_work.model.TaskType.*;

/**
 * Created by Слава on 18.11.2017.
 */
public class ExecutionThreadsService {
    public final static int AMOUNT_PERMIT_FOR_PARALLEL_THREAD = 1;
    public final static int AMOUNT_PERMIT_FOR_THREAD_WITH_CONDITION = 2;
    private ExecutorService executorService = Executors.newFixedThreadPool(3);
    private InitThreads initThreads;
    private Future<List<Integer>> futureOfA;
    private Future<List<Integer>> futureOfB;
    private Future<List<Integer>> futureOfC;

    public void startService(int amountOfTaskA, int amountOfTaskB, int amountOfTaskC) {
        initThreads = new InitThreads(amountOfTaskA, amountOfTaskB, amountOfTaskC);
        Map<TaskType, ExecutionThread>  threadsMap =  initThreads.createExecutionThreads();
        futureOfA = executorService.submit(threadsMap.get(A));
        futureOfB = executorService.submit(threadsMap.get(B));
        futureOfC = executorService.submit(threadsMap.get(C));
    }

    public Map<TaskType, List<Integer>> getResult()  {
        Map<TaskType, List<Integer>> resultMap = new EnumMap<TaskType, List<Integer>>(TaskType.class);
        initThreads.stopAllThreads();
        try {
            resultMap.put(A ,futureOfA.get());
            resultMap.put(B ,futureOfB.get());
            resultMap.put(C ,futureOfC.get());
            executorService.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return resultMap;
    }

    public void addTasksOfType(int amount, TaskType taskType){
        switch (taskType){
            case A: initThreads.addAmountOfTaskA(amount);
                break;
            case B: initThreads.addAmountOfTaskB(amount);
                break;
            case C: initThreads.addAmountOfTaskC(amount);
                break;
        }
    }
}
