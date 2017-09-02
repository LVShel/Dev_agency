package app;

import app.rower.Rower;
import app.src.NotEnoughRowersException;
import app.src.Rank;
import app.src.RowersComparator;
import app.src.TaskType;
import app.task.Task;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * Created by Home on 08.07.2017.
 */
public class Manager implements Employee{
    private String name;
    private int idNumber;
    private static int managersNumber = 0;

    Bench bench = new Bench();
    List<Project> projects = new ArrayList<>();
    TeamLead teamLead = new TeamLead("Batman", projects);

    public Manager(String name) {
        this.name = name;
        idNumber = ++managersNumber;
    }

    public void initRowers(){
        String line = "";
        try(BufferedReader in = new BufferedReader(new FileReader("C:\\Users\\Home\\IdeaProjects\\GALLEY\\src\\app\\src\\ListOfRowers"))) {
            while ((line = in.readLine()) != null) {
                String parts[] = line.split("\\s");//exception
                bench.addRower(Rank.valueOf(parts[0].toUpperCase()), Double.valueOf(parts[1]), Integer.valueOf(parts[2]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println("Wrong listOfRowers format. Use space to split line!");
        }
    }

    public void initProjects(){
        String line = "";
        try(BufferedReader in = new BufferedReader(new FileReader("C:\\Users\\Home\\IdeaProjects\\GALLEY\\src\\app\\src\\ListOfProjects"))) {
            while ((line = in.readLine()) != null) {
                String parts[] = line.split("\\s");
                projects.add(new Project(parts[1], Integer.valueOf(parts[3]), Integer.valueOf(parts[5]), Integer.valueOf(parts[7]), Integer.valueOf(parts[9])));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println("Wrong listOfProjects format. Use space to split line!");
        }
    }

    public void startProjects() {
        for(Project project : projects){
            try {
                sortBench();
                bench.assignRowers(project, Rank.SENIOR);
                bench.assignRowers(project, Rank.MIDDLE);
                bench.assignRowers(project, Rank.JUNIOR);
            } catch (NotEnoughRowersException e) {
                e.printStackTrace();
            }
        }
    }

    public void initTasks(){
        String line = "";
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        try(BufferedReader in = new BufferedReader(new FileReader("C:\\Users\\Home\\IdeaProjects\\GALLEY\\src\\app\\src\\ListOfTasks"))) {
            while ((line = in.readLine()) != null) {
                String parts[] = line.split("\\s");
                teamLead.addTask(parts[0], TaskType.valueOf(parts[1].toUpperCase()), LocalDate.parse(parts[2], format), LocalDate.parse(parts[3], format), Integer.valueOf(parts[4]));
            }
            teamLead.executeTasks();
        } catch (IOException e) {
            e.printStackTrace();
        }catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println("Wrong listOfTasks format. Use space to split line!");
        }
    }

    public void getReport() {
        for (Project project : projects) {
            System.out.println("Project Manager: " + getName() + "(" + "ID: " + getID() + ")");
            project.printRowersOnProject();
        }
        printAllBench();
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

    public Bench getBench() {
        return bench;
    }

    public List<Project> getProjects() {
        return projects;
    }
}
