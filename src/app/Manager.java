package app;

import app.rower.Rower;
import app.src.NotEnoughRowersException;
import app.src.Rank;
import app.src.RowersComparator;
import app.src.TaskType;
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
    private Bench bench = new Bench();
    private List<Project> projects = new ArrayList<>();
    private TeamLead teamLead = new TeamLead("Batman", projects);

    public Manager(String name) {
        this.name = name;
        idNumber = ++managersNumber;
    }

    public void initRowers(){
        String line;
        try(BufferedReader in = new BufferedReader(new FileReader("C:\\Users\\Home\\IdeaProjects\\GALLEY\\src\\app\\src\\ListOfRowers"))) {
            while ((line = in.readLine()) != null) {
                String row[] = line.split("\\s");
                Rank position = Rank.valueOf(row[0].toUpperCase());
                double experience = Double.valueOf(row[1]);
                int qualification = Integer.valueOf(row[2]);
                bench.addRower(position, experience, qualification);
            }
        } catch (IOException e) {
            bench.getRowers().clear();
            e.printStackTrace();
        }catch (ArrayIndexOutOfBoundsException e) {
            bench.getRowers().clear();
            e.printStackTrace();
            System.out.println("Wrong listOfRowers format. Use space to split line!");
        }
    }

    public void initProjects(){
        String line;
        try(BufferedReader in = new BufferedReader(new FileReader("C:\\Users\\Home\\IdeaProjects\\GALLEY\\src\\app\\src\\ListOfProjects"))) {
            while ((line = in.readLine()) != null) {
                String row[] = line.split("\\s");
                String name = row[1];
                int seniorsNeed = Integer.valueOf(row[3]);
                int middlesNeed = Integer.valueOf(row[5]);
                int juniorsNeed = Integer.valueOf(row[7]);
                int maxTasksForOneRower = Integer.valueOf(row[9]);
                projects.add(new Project(name, seniorsNeed, middlesNeed, juniorsNeed, maxTasksForOneRower));
            }
        } catch (IOException e) {
            e.printStackTrace();
            projects.clear();
        }catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            projects.clear();
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
        String line;
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        try(BufferedReader in = new BufferedReader(new FileReader("C:\\Users\\Home\\IdeaProjects\\GALLEY\\src\\app\\src\\ListOfTasks"))) {
            while ((line = in.readLine()) != null) {
                String row[] = line.split("\\s");
                String projectName = row[0];
                TaskType taskType = TaskType.valueOf(row[1].toUpperCase());
                LocalDate startDate = LocalDate.parse(row[2], format);
                LocalDate endDate = LocalDate.parse(row[3], format);
                int storyPoints = Integer.valueOf(row[4]);
                teamLead.addTask(projectName, taskType, startDate, endDate, storyPoints);
            }
            teamLead.executeTasks();
        } catch (IOException e) {
            e.printStackTrace();
            teamLead.getTasks().clear();
        }catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            teamLead.getTasks().clear();
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

    private void sortBench(){
        Collections.sort(bench.getRowers(), new RowersComparator().reversed());
    }

    private void printAllBench() {
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
