package app;

import java.util.Comparator;

/**
 * Created by Home on 09.07.2017.
 */
public class RowersComparator implements Comparator<Rower> {

    public int compare(Rower a, Rower b){
        int i = a.getPosition().toString().compareTo(b.getPosition().toString());
        if (i != 0){
            return i;
        }

        return Integer.compare(a.getQualification(), b.getQualification());
    }

}
