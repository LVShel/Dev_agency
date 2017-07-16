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

    public Rower(Rank position, double experience, int qualification) {
        this.position = position;
        this.experience = experience;
        this.qualification = qualification;
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
        return getPosition().toString().substring(0,3).concat("-").concat(String.valueOf(idNumber));
    }
}
