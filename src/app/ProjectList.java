package app;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Home on 09.07.2017.
 */
public class ProjectList {


    List<Project> projects = new ArrayList<>();

    public void addProject(String name, int seniors, int middles, int juniors){
        projects.add(new Project(name, seniors, middles, juniors));
    }

    public List<Project> getProjects() {
        return projects;
    }
}
