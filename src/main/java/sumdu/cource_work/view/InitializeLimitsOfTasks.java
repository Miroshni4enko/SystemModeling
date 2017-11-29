package sumdu.cource_work.view;

import sumdu.cource_work.model.TaskType;

import java.util.Map;

public interface InitializeLimitsOfTasks {
    Map<TaskType, Integer> getInitLimitsOfTasks() throws IllegalArgumentException;
}
