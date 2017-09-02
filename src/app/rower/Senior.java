package app.rower;

import app.src.Rank;

/**
 * Created by Home on 19.07.2017.
 */
public class Senior extends Rower {
    public static int seniorsNumber = 300;

    public Senior() {}

    public Senior(double experience, int qualification) {
        super(experience, qualification);
        this.position = Rank.SENIOR;
        this.idNumber = ++seniorsNumber;
        this.numberOfTasks = 0;
        this.numberOfBugfixingTasks = 0;
        this.numberOfDevelopmentTasks = 0;
        this.numberOfRefactoringTasks = 0;
    }

    public void doBugfixing(){
        numberOfTasks++;
        numberOfBugfixingTasks++;
    }

    public void doDeveloping(){
        numberOfTasks++;
        numberOfDevelopmentTasks++;
    }

    public void doRefactoring(){
        numberOfTasks++;
        numberOfRefactoringTasks++;
    }
}
