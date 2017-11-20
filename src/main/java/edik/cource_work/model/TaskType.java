package edik.cource_work.model;

/**
 * Created by Слава on 18.11.2017.
 */
public enum TaskType {
    A (3, 1),
    B (3, 1),
    C (4, 1);

    private int time;
    private int diff;

    TaskType(int time, int diff) {
        this.time = time;
        this.diff = diff;
    }

    public int getTime() {
        return (int) ((time - diff) +  (Math.random() * ((time + diff) - (time - diff))));
    }
}
