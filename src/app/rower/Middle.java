package app.rower;

import app.Rank;

/**
 * Created by Home on 19.07.2017.
 */
public class Middle extends Rower {
    public static int middlesNumber = 200;

    public Middle() {}

    public Middle(double experience, int qualification) {
        super(experience, qualification);
        this.position = Rank.MIDDLE;
        this.idNumber = ++middlesNumber;
    }

    public void createBugs() {
        // do refactoring
    }
}
