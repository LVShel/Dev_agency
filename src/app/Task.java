package app;

import app.rower.Rower;

import java.time.LocalDate;

/**
 * Created by Home on 19.07.2017.
 */
public class Task {
private TaskType taskType;
private LocalDate startDate;
private LocalDate endDate;
private int storyPoints;

    public Task(TaskType taskType, LocalDate startDate, LocalDate endDate, int storyPoints) {
        this.taskType = taskType;
        this.startDate = startDate;
        this.endDate = endDate;
        this.storyPoints = storyPoints;
    }

    public TaskType getTaskType() {
        return taskType;
    }

    public void execute(Rower rower) {

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
}
