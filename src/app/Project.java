package app;

import app.rower.Rower;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents parameters of a Project, contains list of Rowers that had been assigned
 * to this project as well as methods that allow to perform operations over this list
 * using the class instance. The List<>Rowers</> rowersOnProject remains empty until project manager
 * will initiate rowers to the project using specified class Manager method. Then usually
 * method assignRowers(...) would be called from the method startProjects() of the class Manager.
 * It is also possible to obtain neat console representation of the rowers list using method
 * printRowersOnProject().
 */
public class Project {
    public String name;
    public int seniorsNeed;
    public int middlesNeed;
    public int juniorsNeed;

    List<Rower> rowersOnProject = new ArrayList<>();

    public Project(String name, int seniorsNeed, int middlesNeed, int juniorsNeed) {
        this.name = name;
        this.seniorsNeed = seniorsNeed;
        this.middlesNeed = middlesNeed;
        this.juniorsNeed = juniorsNeed;
    }

    public void printRowersOnProject() {
        System.out.println("ON PROJECT: " + "'" + getName() + "'" + " are " + rowersOnProject.size() + " rowers: ");
        for(Rower rower : rowersOnProject){
            System.out.println(rower.getPosition()+" "+ "Experience: " + rower.getExperience() + "  "
                       + "Qualification: " + rower.getQualification());
        }
    }

    public long getLimit(Rank rank){
        long limit = 0;
        if(rank == Rank.SENIOR){
            limit = getSeniorsNeed();
        }
        if(rank == Rank.MIDDLE){
            limit = getMiddlesNeed();
        }
        if(rank == Rank.JUNIOR){
            limit = getJuniorsNeed();
        }
        return limit;
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

    public int getSeniorsNeed() {
        return seniorsNeed;
    }

    public void setSeniorsNeed(int seniorsNeed) {
        this.seniorsNeed = seniorsNeed;
    }

    public int getMiddlesNeed() {
        return middlesNeed;
    }

    public void setMiddlesNeed(int middlesNeed) {
        this.middlesNeed = middlesNeed;
    }

    public int getJuniorsNeed() {
        return juniorsNeed;
    }

    public void setJuniorsNeed(int juniorsNeed) {
        this.juniorsNeed = juniorsNeed;
    }

}
