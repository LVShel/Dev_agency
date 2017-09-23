package app.src;

import app.rower.Junior;
import app.rower.Middle;
import app.rower.Rower;
import app.rower.Senior;

/**
 * Created by Home on 19.07.2017.
 */
public class RowerFactory {

    public Rower getInstance(Rank rank) {
        switch (rank) {

            case JUNIOR:
                return new Junior();
            case MIDDLE:
                return new Middle();
            case SENIOR:
                return new Senior();
            default:
                return new Rower();

        }
    }
}
