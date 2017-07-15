package app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Home on 08.07.2017.
 */
public class Manager {
    Bench bench = new Bench();
    List<Project> projects = new ArrayList<>();

    public void initProject(){
        projects.add(new Project("AVAL BANK", 1, 2, 1));
        projects.add(new Project("PRIVAT BANK", 2, 2, 0));
    }

    public void startProjects(){
        for(Project project : projects){
            project.assignRowersToProject(bench);
            project.printRowersOnProject();
        }
    }

    public void initRower(){
        bench.addRower(3.0, 56);
        bench.addRower(2.5, 65);
        bench.addRower(2.1, 55);
        bench.addRower(3.5, 10);
        bench.addRower(4.5, 80);
        bench.addRower(1.8, 50);
        bench.addRower(2.3, 77);
        bench.addRower(5.5, 99);
        bench.addRower(1.1, 37);
        bench.addRower(5.1, 88);
        bench.addRower(2.7, 88);
        bench.addRower(2.4, 88);
        bench.addRower(4.1, 88);
        bench.addRower(6.1, 97);
        bench.addRower(8.1, 99);
        bench.addRower(2.1, 71);
        bench.addRower(2.1, 64);
        bench.addRower(2.1, 61);
        bench.addRower(2.1, 74);
        bench.addRower(2.6, 67);
        bench.addRower(1.1, 10);
        bench.addRower(1.1, 11);
        bench.addRower(1.1, 12);
        bench.addRower(1.1, 13);
        bench.addRower(1.1, 14);
        bench.addRower(1.1, 15);
        bench.addRower(1.1, 17);
        bench.addRower(1.1, 20);
        bench.addRower(1.1, 22);
        bench.addRower(1.1, 24);
    }

    public void sortBench(){
        Collections.sort(bench.getRowers(), new RowersComparator().reversed());
    }

    public void printAllBench() {
        System.out.println("ROWERS LEFT ON THE BENCH: ");
        for (int i = 0; i < bench.getRowers().size(); i++) {
            System.out.println(bench.getRowers().get(i).getPosition() + ": " + "Experience: " +   bench.getRowers().get(i).getExperience() + "  " + "Qualification: "+ bench.getRowers().get(i).getQualification());
        }
    }

}
