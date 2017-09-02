package app;

/**
 * Created by Home on 09.07.2017.
 */
public class CTO {

    public static void main(String[] args) {
        Manager manager = new Manager("Leo");
        manager.initRowers();
        manager.initProjects();
        manager.startProjects();
        manager.initTasks();
        manager.getReport();
      

    }
}
