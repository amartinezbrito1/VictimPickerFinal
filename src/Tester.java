import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Tester extends JFrame {

    public static void main(String[] args) {

        JFrame mainframe = new JFrame("Victim Picker Group Project");
        mainframe.setDefaultCloseOperation(EXIT_ON_CLOSE);



        Victim victim1 = new Victim("Abraham", 1);
        Victim victim2 = new Victim("Albert", 2);
        Victim victim3 = new Victim("michael", 3);
        Victim victim4 = new Victim("fabrice", 2);
        Victim victim5 = new Victim("heather", 1);


        VictimPicker victimPicker = new VictimPicker();
        VolunteerInterface volunteerInterface = new VolunteerInterface() {
            @Override
            public void displayChoseVictims(ArrayList<Victim> chosenVictims) {
                System.out.println("Chosen victims:");
                for (Victim victim : chosenVictims) {
                    System.out.println("- " + victim.getName());
                }
            }

            @Override
            public void updateTimer(int remainingSeconds) {
                System.out.println("Time remaining: " + remainingSeconds + " seconds");
            }
        };
        VictimPickerGUI victimPickerGUI = new VictimPickerGUI(victimPicker, volunteerInterface);
        victimPickerGUI.setPreferredSize(new Dimension(1000,1000));
        mainframe.getContentPane().add(victimPickerGUI);
        mainframe.pack();
        mainframe.setVisible(true);

        // Load victims
        victimPicker.loadList(Arrays.asList(victim1, victim2, victim3, victim4, victim5));


        //victimPickerGUI.pickButton.doClick();
        victimPickerGUI.markAbsentButton.doClick();

        // Award points
        victimPicker.score(5);

        System.out.println("\nFinal victim list:");
        printVictimList(victimPicker.getVictims());
    }

    private static void printVictimList(ArrayList<Victim> victims) {
        for (Victim victim : victims) {
            System.out.println("- " + victim.getName() + " (section: " + victim.getSection() + ", score: " + victim.getScore() + ", numberOfPicks: " + victim.getNumberOfPicks() + ")");
        }
    }
}
