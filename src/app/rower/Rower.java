package app.rower;

import app.Employee;
import app.Rank;

/**
 * Created by Home on 08.07.2017.
 */
public class Rower implements Employee {
    protected Rank position;
    private double experience;
    private int qualification;
    protected int idNumber;

    public Rower() {}

    public Rower(double experience, int qualification) {
        this.experience = experience;
        this.qualification = qualification;
    }


    public double getExperience() {
        return experience;
    }

    public int getQualification() {
        return qualification;
    }


    public Rank getPosition() {
        return position;
    }

    public void setPosition(Rank position) {
        this.position = position;
    }

    @Override
    public String getID() {
        return getPosition().toString().substring(0,3).concat("-").concat(String.valueOf(idNumber));
    }
}
