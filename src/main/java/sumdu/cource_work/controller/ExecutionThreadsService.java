package sumdu.cource_work.controller;

import sumdu.cource_work.model.ExecutionThread;
import sumdu.cource_work.model.InitThreads;
import sumdu.cource_work.model.TaskType;
import sumdu.cource_work.view.MainSchemaWindow;

import java.util.*;
import java.util.concurrent.*;

import static sumdu.cource_work.model.TaskType.*;

/**
 * Created by Слава on 18.11.2017.
 */
public class ExecutionThreadsService implements ExecutionService {
    public final static int AMOUNT_PERMIT_FOR_PARALLEL_THREAD = 0; // for A and B we  need no permits
    public final static int AMOUNT_PERMIT_FOR_THREAD_WITH_CONDITION = 2;// when A and B tasks do release permit C get 2 permit
    private ExecutorService executorService = Executors.newFixedThreadPool(6);
    private InitThreads initThreads;
    private List<Future<List<Integer>>> list;

    public void startService(int amountOfTaskA, int amountOfTaskB, int amountOfTaskC, MainSchemaWindow mainSchemaWindow) throws InterruptedException {
        initThreads = new InitThreads(amountOfTaskA, amountOfTaskB, amountOfTaskC, mainSchemaWindow);
        Map<TaskType, ExecutionThread>  threadsMap =  initThreads.createExecutionThreads();
        list = executorService.invokeAll(Arrays.asList(threadsMap.get(A),
                                                       threadsMap.get(B),
                                                       threadsMap.get(C)));
    }

    public Map<TaskType, List<Integer>> stopServiceAndGetResult()  {
        Map<TaskType, List<Integer>> resultMap = new EnumMap<TaskType, List<Integer>>(TaskType.class);
        initThreads.stopAllThreads();
        try {
            resultMap.put(A , list.get(0).get());
            resultMap.put(B , list.get(1).get());
            resultMap.put(C , list.get(2).get());
            executorService.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return resultMap;
    }

    public void addTasksOfType(int amount, TaskType taskType){
        System.out.printf("add task");
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
