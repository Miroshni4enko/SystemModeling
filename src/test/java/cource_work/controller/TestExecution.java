package cource_work.controller;

import edik.cource_work.controller.ExecutionThreadsService;
import edik.cource_work.model.TaskType;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * Created by Слава on 19.11.2017.
 */

public class TestExecution {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutionThreadsService executionThreadsService = new ExecutionThreadsService();
        executionThreadsService.startService(5,4,3);
        TimeUnit.SECONDS.sleep(10);
        executionThreadsService.addTasksOfType(1, TaskType.B);
        Map<TaskType, List<Integer>> map = executionThreadsService.getResult();
        System.out.println(map);
    }
}
