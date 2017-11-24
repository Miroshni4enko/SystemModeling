package edik.cource_work.model;

/**
 * Created by Слава on 18.11.2017.
 */
public enum TaskType {
    A (5, 1, 1, 0),
    B (5, 1, 1, 0),
    C (5, 1, 1, 0);

    private int taskTime;
    private int taskDiff;
    private int arriveTime;
    private int arriveDiff;

    TaskType(int taskTime, int taskDiff, int arriveTime, int arriveDiff) {
        this.taskTime = taskTime;
        this.taskDiff = taskDiff;
        this.arriveTime = arriveTime;
        this.arriveDiff = arriveDiff;
    }

    public  int getTaskTime() {
        return getTime(taskTime, taskDiff);
    }

    public  int getArriveTime() {
        return getTime(arriveTime, arriveDiff);
    }

    private int getTime(int time, int diff) {
        return (int) ((time - diff) +  (Math.random() * ((time + diff) - (time - diff))));
    }
}
