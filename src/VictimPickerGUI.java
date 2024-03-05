import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class VictimPickerGUI extends JPanel {

    private VictimPicker victimPicker;
    private VolunteerInterface volunteerInterface;
    private VictimPickerGUI here;

    private AllVictimsPanel all_victims;

    private ArrayList<String> victim_names;
    private String victim_name;

    JButton pickButton;
    private JTextField volunteerField;
    JButton markAbsentButton;
    private JLabel timerLabel;
    private JTextField victimToMarkField;

    private Timer timer;
    private int timerSeconds = 60;

    public VictimPickerGUI(VictimPicker victimPicker, VolunteerInterface volunteerInterface) {
        here = this;
        //arbitrarily set the size of the main panel (victim picker) so that we have an idea of how to place the other panels it contains.
        this.setPreferredSize(new Dimension(1200, 1000));

        this.victimPicker = victimPicker;
        this.volunteerInterface = volunteerInterface;
        this.all_victims = new AllVictimsPanel();
        this.victim_names = new ArrayList<String>();

        pickButton = new JButton("Pick Two Victims");
        volunteerField = new JTextField(10);
        markAbsentButton = new JButton("Mark Absent");
        timerLabel = new JLabel("Time Remaining: 00:60"); // Initial display
        victimToMarkField = new JTextField(10);


        pickButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                victim_names.clear();

                ArrayList<Victim> chosen = victimPicker.chooseTwo();
                for(Victim chosen_victim: chosen){
                     victim_name = chosen_victim.getName();
                     victim_names.add(victim_name);
                     all_victims.setVictimNames(victim_names);
                     all_victims.setVictimsIcon();
                }
                volunteerInterface.displayChoseVictims(chosen); // Update UI
                startTimer();
            }
        });

        markAbsentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        // Timer setup
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timerSeconds--;
                updateTimerLabel();
                if (timerSeconds == 0) {
                    stopTimer();
                    // Handle timer expiration
                    System.out.println("time is up bu");
                }
            }
        });

        this.add(all_victims);

        this.add(pickButton);
        this.add(volunteerField);
        this.add(markAbsentButton);
        this.add(timerLabel);
        this.add(victimToMarkField);

        this.setVisible(true);

    }

    private void startTimer() {
        timerSeconds = 60; // Reset timer duration
        updateTimerLabel();
        timer.start();
    }

    private void stopTimer() {
        timer.stop();
    }

    private void updateTimerLabel() {
        int minutes = timerSeconds / 60;
        int seconds = timerSeconds % 60;
        timerLabel.setText(String.format("Time Remaining: %02d:%02d", minutes, seconds));
    }

    //search for victim by name
    private Victim findVictimByName(String victimName) {
        for (Victim victim : victimPicker.getVictims()) {
            if (victim.getName().equalsIgnoreCase(victimName)) {
                return victim;
            }
        }
        return null;
    }


}
