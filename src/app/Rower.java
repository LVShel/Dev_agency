package app;

/**
 * Created by Home on 08.07.2017.
 */
public class Rower implements Employee{
    private Rank position;
    private double experience;
    private int qualification;
    private int idNumber;
    private static int rowersNumber = 0;

    public Rower(double experience, int qualification) {
        this.experience = experience;
        this.qualification = qualification;
        if(experience >= 3.0)setPosition(Rank.SENIOR);
        else if(experience >=2.0 && experience<3.0)setPosition(Rank.MIDDLE);
        else if(experience < 2.0)setPosition(Rank.JUNIOR);
        idNumber = ++rowersNumber;
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
        return getPosition().toString().substring(0,3).concat(String.valueOf(idNumber));
    }
}
