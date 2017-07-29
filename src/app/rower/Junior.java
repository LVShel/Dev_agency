package app.rower;

import app.Rank;

/**
 * Created by Home on 19.07.2017.
 */
public class Junior extends Rower {
    public static int juniorsNumber = 100;

    public Junior() {}

    public Junior(double experience, int qualification) {
        super(experience, qualification);
        this.position = Rank.JUNIOR;
        this.idNumber = ++juniorsNumber;
    }
}
