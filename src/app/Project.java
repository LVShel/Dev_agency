package app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Home on 08.07.2017.
 */
public class Project {
    public String name;
    public int seniors;
    public int middles;
    public int juniors;

    List<Rower> rowersOnProject = new ArrayList<>();

    public Project(String name, int seniors, int middles, int juniors) {
        this.name = name;
        this.seniors = seniors;
        this.middles = middles;
        this.juniors = juniors;
    }


    public void assignRowersToProject(Bench bench) {
        List<Rower> seniorsList = bench.getRowers().stream().filter(r->"Senior".equals(r.getPosition())).limit(getSeniors()).collect(Collectors.toList());
        List<Rower> middlesList = bench.getRowers().stream().filter(r->"Middle".equals(r.getPosition())).limit(getMiddles()).collect(Collectors.toList());
        List<Rower> juniorsList = bench.getRowers().stream().filter(r->"Junior".equals(r.getPosition())).limit(getJuniors()).collect(Collectors.toList());

        rowersOnProject.addAll(seniorsList);
        rowersOnProject.addAll(middlesList);
        rowersOnProject.addAll(juniorsList);
        bench.getRowers().removeAll(seniorsList);
        bench.getRowers().removeAll(middlesList);
        bench.getRowers().removeAll(juniorsList);
    }

    public void printRowersOnProject() {
        System.out.println("ON PROJECT: " + "'" + getName() + "'" + " are " + rowersOnProject.size() + " rowers: ");
        for (int i = 0; i < rowersOnProject.size(); i++) {
                System.out.println(rowersOnProject.get(i).getPosition()+" "+ "Experience: " + rowersOnProject.get(i).getExperience() + "  "
                        + "Qualification: " + rowersOnProject.get(i).getQualification());

        }
    }

    public List<Rower> getRowersOnProject() {
        return rowersOnProject;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSeniors() {
        return seniors;
    }

    public void setSeniors(int seniors) {
        this.seniors = seniors;
    }

    public int getMiddles() {
        return middles;
    }

    public void setMiddles(int middles) {
        this.middles = middles;
    }

    public int getJuniors() {
        return juniors;
    }

    public void setJuniors(int juniorss) {
        this.juniors = juniors;
    }
}
