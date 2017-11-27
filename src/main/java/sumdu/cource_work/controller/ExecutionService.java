package sumdu.cource_work.controller;

import sumdu.cource_work.model.TaskType;

import java.util.List;
import java.util.Map;

public interface ExecutionService {
    void startService(int amountOfTaskA, int amountOfTaskB, int amountOfTaskC) throws InterruptedException;
    Map<TaskType, List<Integer>> stopServiceAndGetResult();
}
