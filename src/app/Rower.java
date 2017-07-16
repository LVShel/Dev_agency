package app;

/**
 * Created by Home on 08.07.2017.
 */
public class Rower {
    private Rank position;
    private double experience;
    private int qualification;

    public Rower(double experience, int qualification) { // CR: add Rank parameter to constructor. There is no so tight relation between experience and position in real life
        this.experience = experience;
        this.qualification = qualification;
        if(experience >= 3.0)setPosition(Rank.SENIOR);
        else if(experience >=2.0 && experience<3.0)setPosition(Rank.MIDDLE);
        else if(experience < 2.0)setPosition(Rank.JUNIOR);
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
}
