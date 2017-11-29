package sumdu.cource_work.controller;

import sumdu.cource_work.model.TaskType;
import sumdu.cource_work.view.MainSchemaWindow;

import java.util.List;
import java.util.Map;

public interface ExecutionService {
    void startService(MainSchemaWindow mainSchemaWindow) throws InterruptedException;
    Map<TaskType, List<Integer>> stopServiceAndGetResult();
}
