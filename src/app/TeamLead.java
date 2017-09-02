package app;

import app.src.TaskType;
import app.task.BugFixing;
import app.task.Development;
import app.task.Refactoring;
import app.task.Task;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Home on 30.07.2017.
 */
public class TeamLead implements Employee {
    private String name;
    private int idNumber;
    private static int leadsNumber = 500;
    private List<Task> tasks = new ArrayList<>();
    private List<Project> projects;

    public TeamLead(String name, List<Project> projects){
        this.projects = projects;
        this.name = name;
        idNumber = ++leadsNumber;
    }

    public void addTask(String projectName, TaskType taskType, LocalDate startDate, LocalDate endDate, int storyPoints){
        switch (taskType) {
            case DEVELOPMENT:
                tasks.add(new Development(projectName, startDate, endDate, storyPoints));
                break;
            case BUGFIXING:
                tasks.add(new BugFixing(projectName, startDate, endDate, storyPoints));
                break;
            case REFACTORING:
                tasks.add(new Refactoring(projectName, startDate, endDate, storyPoints));
                break;
                default:
                    System.out.println("THERE IS NO SUCH TASK TYPE");
        }
    }

    public void executeTasks(){
        for(Task task : tasks){
            int projectIndex = getProjectByName(task.getProjectName());
            task.execute(projects.get(projectIndex));
        }
    }

    public int getProjectByName(String name){
        int index  = 0;
        for(Project project : projects){
            if(project.getName().equalsIgnoreCase(name)){
               index = projects.indexOf(project);
            }
        }
        return index;
    }

    @Override
    public String getID() {
        return "TL".concat(String.valueOf(getIdNumber()));
    }

    public String getName() {
        return name;
    }

    public int getIdNumber() {
        return idNumber;
    }

    public List<Task> getTasks() {
        return tasks;
    }
}
