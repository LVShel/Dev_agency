package app.rower;

import app.Employee;
import app.src.Rank;
import app.task.Task;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Home on 08.07.2017.
 */
public class Rower implements Employee {
    protected Rank position;
    private double experience;
    private int qualification;
    protected int idNumber;
    protected int numberOfTasks;
    protected int numberOfBugfixingTasks;
    protected int numberOfRefactoringTasks;
    protected int numberOfDevelopmentTasks;

    public Rower() {}

    public Rower(double experience, int qualification) {
        this.experience = experience;
        this.qualification = qualification;
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


    public double getExperience() {
        return experience;
    }

    public int getQualification() {
        return qualification;
    }

    public int getNumberOfTasks() {
        return numberOfTasks;
    }

    public int getNumberOfBugfixingTasks() {
        return numberOfBugfixingTasks;
    }

    public int getNumberOfRefactoringTasks() {
        return numberOfRefactoringTasks;
    }

    public int getNumberOfDevelopmentTasks() {
        return numberOfDevelopmentTasks;
    }

    public Rank getPosition() {
        return position;
    }

    public void setPosition(Rank position) {
        this.position = position;
    }

    @Override
    public String getID() {
        return getPosition().toString().substring(0,3).concat("-").concat(String.valueOf(idNumber));
    }
}
