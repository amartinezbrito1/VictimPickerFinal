import java.util.*;
import java.lang.*;

public class Victim {

    private String name;
    private int section;
    private int score;
    private Date lastPicked;
    private ArrayList<Date> absences;
    private int numberOfPicks;

    public int getSection() {
        return section;
    }

    public void setSection(int section) {
        this.section = section;
    }

    public int getNumberOfPicks() {
        return numberOfPicks;
    }

    public void setNumberOfPicks(int numberOfPicks) {
        this.numberOfPicks = numberOfPicks;
    }

    public ArrayList<Date> getAbsences() {
        return absences;
    }

    public void setAbsences(ArrayList<Date> absences) {
        this.absences = absences;
    }


    public Date getLastPicked() {
        return lastPicked;
    }

    public void setLastPicked(Date lastPicked) {
        this.lastPicked = lastPicked;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Victim(String name, int section) {
        this.name = name;
        this.section = section;
        this.score = 0;
        this.lastPicked = null;
        this.absences = new ArrayList<>();
        this.numberOfPicks = 0;

    }
}
