package app.task;

import app.Project;
import app.rower.Junior;
import app.rower.Rower;
import app.src.Rank;

import java.time.LocalDate;

/**
 * Created by Home on 31.07.2017.
 */
public class BugFixing extends Task {
    public BugFixing(String projectName, LocalDate startDate, LocalDate endDate, int storyPoints) {
        super(projectName, startDate, endDate, storyPoints);
    }

    @Override
    public void execute(Project project) {
        Rower junior = project.findRower(Rank.JUNIOR);
        Rower middle = project.findRower(Rank.MIDDLE);
        Rower senior = project.findRower(Rank.SENIOR);
       if(junior != null){
           junior.doBugfixing();
       }
       if(junior == null & middle != null){
           middle.doBugfixing();
       }
       if(junior == null & middle == null & senior != null){
           senior.doBugfixing();
       }
       if(junior == null & middle == null & senior == null){
           System.out.println("NOT ENOUGH ROWERS FOR BUG FIXING!");
       }
    }


}
