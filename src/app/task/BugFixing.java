package app.task;

import app.Project;
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
       if(project.countRowers(Rank.JUNIOR)>=1){
           if(project.findRower(Rank.JUNIOR).getNumberOfTasks() < project.getMaxTasksForOneRower()){
               project.findRower(Rank.JUNIOR).doBugfixing();
           }
       }
       else if(project.countRowers(Rank.JUNIOR) < 1 & project.countRowers(Rank.MIDDLE) >= 1){
           project.findRower(Rank.MIDDLE).doBugfixing();
       }
       else if(project.countRowers(Rank.JUNIOR) < 1 & project.countRowers(Rank.MIDDLE) < 1 & project.countRowers(Rank.SENIOR) >=1){
           project.findRower(Rank.SENIOR).doBugfixing();
       }
       else System.out.println("NOT ENOUGH ROWERS FOR BUG FIXING!");
    }


}
