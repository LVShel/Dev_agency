package app;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Home on 08.07.2017.
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

    public void assignRowersToProject(Bench bench) throws NotEnoughRowersException {
        long countsen = bench.getRowers().stream().filter(r->Rank.SENIOR.equals(r.getPosition())).count(); // Better to create getRowers(Position p, quantity q) method in Bench class 
        long countMid = bench.getRowers().stream().filter(r->Rank.MIDDLE.equals(r.getPosition())).count();
        long countJun = bench.getRowers().stream().filter(r->Rank.JUNIOR.equals(r.getPosition())).count();

        if(countsen < getSeniorsNeed()){
            throw new NotEnoughRowersException("NOT ENOUGH SENIORS ON THE BENCH!!! " + "(" + countsen + " LEFT" + ")");
        }
        else if(countMid < getMiddlesNeed()){
            throw new NotEnoughRowersException("NOT ENOUGH MIDDLES ON THE BENCH!!! " + "(" + countMid + " LEFT" + ")");
        }
        else if(countJun < getJuniorsNeed()){
            throw new NotEnoughRowersException("NOT ENOUGH JUNIORS ON THE BENCH!!! " + "(" + countJun + " LEFT" + ")");
        }


        List<Rower> seniorsList = bench.getRowers().stream().filter(r->Rank.SENIOR.equals(r.getPosition())).limit(getSeniorsNeed()).collect(Collectors.toList());
        List<Rower> middlesList = bench.getRowers().stream().filter(r->Rank.MIDDLE.equals(r.getPosition())).limit(getMiddlesNeed()).collect(Collectors.toList());
        List<Rower> juniorsList = bench.getRowers().stream().filter(r->Rank.JUNIOR.equals(r.getPosition())).limit(getJuniorsNeed()).collect(Collectors.toList());

        rowersOnProject.addAll(seniorsList);
        rowersOnProject.addAll(middlesList);
        rowersOnProject.addAll(juniorsList);
        bench.getRowers().removeAll(seniorsList);
        bench.getRowers().removeAll(middlesList);
        bench.getRowers().removeAll(juniorsList);
    }

    public void printRowersOnProject() { // override toString() instead
        System.out.println("ON PROJECT: " + "'" + getName() + "'" + " are " + rowersOnProject.size() + " rowers: ");
        for(Rower rower : rowersOnProject){
            System.out.println(rower.getPosition()+" "+ "Experience: " + rower.getExperience() + "  "
                       + "Qualification: " + rower.getQualification());
        }
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
