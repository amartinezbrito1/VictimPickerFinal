import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.*;

public class VictimPicker {

    private ArrayList<Victim> victims;
    private ArrayList<Victim> pickedToday;
    private ArrayList<Victim> absentToday;

    public VictimPicker() {
        this.victims = new ArrayList<>();
        this.pickedToday = new ArrayList<>();
        this.absentToday = new ArrayList<>();
    }

    public void loadList(List<Victim> victims) {
        this.victims.addAll(victims);
    }

    public ArrayList<Victim> chooseTwo() {
        victims.sort(Comparator.comparingInt(Victim::getNumberOfPicks));
        Random random = new Random();
        ArrayList<Victim> chosen = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            int index = random.nextInt(victims.size());
            chosen.add(victims.get(index));
            pickedToday.add(victims.get(index));
        }
        return chosen;
    }

    public void markAbsent(Victim absentVictim) {
        absentToday.add(absentVictim);
        absentVictim.getAbsences().add(new Date());
    }

    public void score(int points) {
        for (Victim victim : pickedToday) {
            victim.setScore(victim.getScore() + points);
            victim.setLastPicked(new Date());
            victim.setNumberOfPicks(victim.getNumberOfPicks() + 1);
        }
        // Clear pickedToday for next round
        pickedToday.clear();
    }

    public ArrayList<Victim> getVictims() {
        return victims;
    }
}
