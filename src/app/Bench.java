package app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Home on 08.07.2017.
 */
public class Bench {
    List<Rower> rowers = new ArrayList<>();

    public void addRower(Rank position, double experience, int qualification) {
      rowers.add(new Rower(position, experience, qualification));
    }

    public long countRowers(Rank rank){
        return getRowers().stream().filter(r->rank.equals(r.getPosition())).count();
    }


    public List<Rower> getRowers() {
        return rowers;
    }
}
