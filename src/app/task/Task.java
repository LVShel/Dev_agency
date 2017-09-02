package app.task;

import app.Project;
import app.src.TaskType;
import app.rower.Rower;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by Home on 19.07.2017.
 */
public abstract class Task {
    private String projectName;
    private TaskType taskType;
    private LocalDate startDate;
    private LocalDate endDate;
    private int storyPoints;
    private int taskId;
    private static int leadsNumber = 1000;

    public Task(String projectName, LocalDate startDate, LocalDate endDate, int storyPoints) {
        this.projectName = projectName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.storyPoints = storyPoints;
        taskId = ++leadsNumber;
    }

    public Task() {
    }

    public abstract void execute(Project project);

    public static int getLeadsNumber() {
        return leadsNumber;
    }

    public TaskType getTaskType() {
        return taskType;
    }

    public void setTaskType(TaskType taskType) {
        this.taskType = taskType;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public int getStoryPoints() {
        return storyPoints;
    }

    public void setStoryPoints(int storyPoints) {
        this.storyPoints = storyPoints;
    }

    public String getID() {
        return "TSK".concat(String.valueOf(getTaskId()));
    }

    public String getProjectName() {
        return projectName;
    }

    public int getTaskId() {
        return taskId;
    }
}
