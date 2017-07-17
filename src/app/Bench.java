package app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Home on 08.07.2017.
 */
public class Bench {
    List<Rower> rowers = new ArrayList<>();

    public void addRower(Rank position, double experience, int qualification) {
      rowers.add(new Rower(position, experience, qualification));
    }

    /**
     * Searches the list of rowers in the class Bench for the quantity of rowers that is
     * specified while initializing a new project using the stream with filter and collector
     * algorithms. Before calling this method, the list must be sorted into descending order
     * according to the position and qualification of rowers using RowersComparator class as a
     * comparator in the Collections.sort() parameters. Otherwise, there is no
     * guarantee that the most qualified rowers will join the project instead of leaving on the bench.
     * If the list doesn't contain precise quantity of rowers of any rank, that is required by project,
     * the NotEnoughRowers exception will be thrown to the runtime.
     * */

    public void assignRowers(Project project, Rank rank) throws NotEnoughRowersException{
        List<Rower> rowersList = getRowers().stream().filter(r->rank.equals(r.getPosition())).limit(project.getLimit(rank)).collect(Collectors.toList());
        if(countRowers(rank) < project.getLimit(rank)){
            throw new NotEnoughRowersException("NOT ENOUGH SENIORS ON THE BENCH!!! " + "(" + countRowers(rank) + " LEFT" + ")");
        }
        project.getRowersOnProject().addAll(rowersList);
        getRowers().removeAll(rowersList);
    }

    public long countRowers(Rank rank){
        return getRowers().stream().filter(r->rank.equals(r.getPosition())).count();
    }


    public List<Rower> getRowers() {
        return rowers;
    }
}
