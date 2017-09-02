package app.rower;

import app.src.Rank;

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
        this.numberOfTasks = 0;
        this.numberOfBugfixingTasks = 0;
        this.numberOfDevelopmentTasks = 0;
    }

    public void doBugfixing(){
        numberOfTasks++;
        numberOfBugfixingTasks++;
    }

    public void doDeveloping(){
        numberOfTasks++;
        numberOfDevelopmentTasks++;
    }
}
