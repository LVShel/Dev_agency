package app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Home on 08.07.2017.
 */
public class Manager implements Employee{
    private String name;
    private int idNumber;
    private static int managersNumber = 0;

    Bench bench = new Bench();
    List<Project> projects = new ArrayList<>();

    public Manager(String name) {
        this.name = name;
        idNumber = ++managersNumber;
    }

    public void initProjects(){
        String line = "";
        try(BufferedReader in = new BufferedReader(new FileReader("C:\\Users\\Home\\IdeaProjects\\GALLEY\\src\\app\\ListOfProjects"))) {
            while ((line = in.readLine()) != null) {
                String parts[] = line.split("\\s");
                projects.add(new Project(parts[1], Integer.valueOf(parts[3]), Integer.valueOf(parts[5]), Integer.valueOf(parts[7])));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void startProjects() {
        for(Project project : projects){
            try {
                project.assignRowers(bench);
            } catch (NotEnoughRowersException e) {
                e.printStackTrace();
            }
            System.out.println("Project Manager: " + getName() + "(" + "ID: " + getID() + ")");
            project.printRowersOnProject();
        }
    }

    public void initRowers(){
        String line = "";
        try(BufferedReader in = new BufferedReader(new FileReader("C:\\Users\\Home\\IdeaProjects\\GALLEY\\src\\app\\ListOfRowers"))) {
            while ((line = in.readLine()) != null) {
                String parts[] = line.split("\\s");
                bench.addRower(Rank.valueOf(parts[0].toUpperCase()), Double.valueOf(parts[1]), Integer.valueOf(parts[2]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sortBench(){
        Collections.sort(bench.getRowers(), new RowersComparator().reversed());
    }

    public void printAllBench() {
        System.out.println("ROWERS LEFT ON THE BENCH: " + bench.getRowers().size());
        for(Rower rower: bench.getRowers()){
        System.out.println(rower.getPosition() + ": " + "Experience: " +   rower.getExperience() + "  "
                + "Qualification: " + rower.getQualification() + " ID: " + rower.getID());
        }
    }

    @Override
    public String getID() {
        return "Mng".concat(String.valueOf(getIdNumber()));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }
}
