package app.task;

import app.Project;
import app.rower.Rower;
import app.src.Rank;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by Home on 31.07.2017.
 */
public class Development extends Task {

    public Development(String projectName, LocalDate startDate, LocalDate endDate, int storyPoints) {
        super(projectName, startDate, endDate, storyPoints);
    }


    @Override
    public void execute(Project project) {
        if(project.countRowers(Rank.MIDDLE)>=1){
            project.findRower(Rank.MIDDLE).doDeveloping();
        }
        else if(project.countRowers(Rank.MIDDLE) < 1 & project.countRowers(Rank.SENIOR) >= 1){
            project.findRower(Rank.SENIOR).doDeveloping();
        }
        else System.out.println("NOT ENOUGH ROWERS FOR DEVELOPMENT!");
    }


}
