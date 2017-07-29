package app.rower;

import app.Rank;

/**
 * Created by Home on 19.07.2017.
 */
public class Senior extends Rower {
    public static int seniorsNumber = 300;

    public Senior() {}

    public Senior(double experience, int qualification) {
        super(experience, qualification);
        this.position = Rank.SENIOR;
        this.idNumber = ++seniorsNumber;
    }

    public void doRefactoring() {
        // do refactoring
    }

    public void doCodeReview() {
        // do refactoring
    }
}
