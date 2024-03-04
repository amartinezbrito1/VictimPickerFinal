import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.Timer;
import java.text.SimpleDateFormat;
public class VictimPicker extends JPanel implements VolunteerInterface {

    private JButton pickButton = new JButton("Pick Two Victims");
    private ArrayList<Victim> victims;
    private ArrayList<Victim> pickedToday;
    private ArrayList<Victim> absentToday;
    private Timer timer;

    private int timerSeconds = 60;

    private VolunteerInterface volunteerInterface;

    public VictimPicker() {
        this.victims = new ArrayList<>();
        this.pickedToday = new ArrayList<>();
        this.absentToday = new ArrayList<>();

        pickButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pickTwoVictims();
            }
        });

        timer = new Timer();
    }



    private void pickTwoVictims() {
        ArrayList<Victim> chosen = new ArrayList<>();
        victims.sort(Comparator.comparingInt(Victim::getNumberOfPicks));
        Random random = new Random();

        for (int i = 0; i < 2; i++) {
            int index = random.nextInt(victims.size());
            chosen.add(victims.get(index));
            pickedToday.add(victims.get(index));
        }


    }

    public void startTimer() {
      //  timer.wait();
    }

    public void stopTimer() {
        //timer.stop();
    }

    public void score(int points) {
        for (Victim victim : pickedToday) {
            victim.setScore(victim.getScore() + points);
            victim.setLastPicked(new Date());
            victim.setNumberOfPicks(victim.getNumberOfPicks() + 1);
        }
    }

    public void markAbsent(Victim absentVictim) {
        absentToday.add(absentVictim);
        absentVictim.getAbsences().add(new Date());
    }

    public void loadList(List<Victim> victims) {
        this.victims.addAll(victims);
    }

    public ArrayList<Victim> getVictims() {
        return victims;
    }

    @Override
    public void displayChoseVictims(ArrayList<Victim> chosenVictims) {

    }

    @Override
    public void updateTimer(int remainingSeconds) {

    }


    public ArrayList<Victim> chooseTwo() {
        victims.sort(Comparator.comparingInt(Victim::getNumberOfPicks));
        Random random = new Random();
        ArrayList<Victim> chosen =  new ArrayList<>();
        for(int i=0;i< 2;i++)
        {
            int index = random.nextInt(victims.size());
            chosen.add(victims.get(index));
            pickedToday.add(victims.get(index));

        }
        return chosen;
    }
}
