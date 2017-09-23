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
        Rower middle = project.findRower(Rank.MIDDLE);
        Rower senior = project.findRower(Rank.SENIOR);
        if(middle != null){
            middle.doDeveloping();
        }
        if(middle == null & senior != null){
            senior.doDeveloping();
        }
        if(middle == null & senior == null){
            System.out.println("NOT ENOUGH ROWERS FOR DEVELOPING!");
        }
    }


}
