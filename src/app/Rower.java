package app;

/**
 * Created by Home on 08.07.2017.
 */
public class Rower {
    private String position;
    private double experience;
    private int qualification;

    public Rower(double experience, int qualification) {
        this.experience = experience;
        this.qualification = qualification;
        if(experience >= 3.0)setPosition("Senior");
        else if(experience >=2.0 && experience<3.0)setPosition("Middle");
        else if(experience < 2.0)setPosition("Junior");
    }

    public double getExperience() {
        return experience;
    }

    public int getQualification() {
        return qualification;
    }

    public String getPosition() {
        return position;
    }

    private void setPosition(String position) {
        this.position = position;
    }
}
