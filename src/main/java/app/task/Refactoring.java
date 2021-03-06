package app.task;

import app.Project;
import app.rower.Rower;
import app.src.Rank;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by Home on 31.07.2017.
 */
public class Refactoring extends Task {
    public Refactoring(String projectName, LocalDate startDate, LocalDate endDate, int storyPoints) {
        super(projectName, startDate, endDate, storyPoints);
    }


    @Override
    public void execute(Project project){
        Rower senior = project.findRower(Rank.SENIOR);
        if(senior != null){
            senior.doRefactoring();
        }
        else{
            System.out.println("NOT ENOUGH SENIORS FOR REFACTORING!");
        }
    }


}
