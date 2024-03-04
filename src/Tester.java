import java.util.ArrayList;
import java.lang.*;
import java.util.Arrays;

public class Tester {

    public static void main(String[] args) {
        Victim victim1 = new Victim("Abraham",1 );
        Victim victim2 = new Victim("Albert",2 );
        Victim victim3 = new Victim("michael",3 );
        Victim victim4 = new Victim("fabrice",2 );
        Victim victim5 = new Victim("heather",1 );

        VictimPicker picker = new VictimPicker();
        picker.loadList(Arrays.asList(victim1, victim2,victim3,victim4,victim5));


        System.out.println("Initial victim list:");
        printVictimList(picker.getVictims());

        //choose two victims
        ArrayList<Victim> chosen = picker.chooseTwo();
        System.out.println("\nChosen victims:");
        printVictimList(chosen);

        //  absent
        picker.markAbsent(victim4);
        System.out.println("\nMarked bear absent.");

        //choose two victims fabrice shouldn't be
        chosen = picker.chooseTwo();
        System.out.println("\nChosen victims after marking student absent:");
        printVictimList(chosen);

        //points
        picker.score(5);
        System.out.println("\nAwarded 5 points to chosen victims:");
        printVictimList(picker.getVictims());

        // print
        System.out.println("\nVictims with absences:");
        for (Victim victim : picker.getVictims()) {
            if (!victim.getAbsences().isEmpty()) {
                System.out.println("- " + victim.getName() + " (absences: " + victim.getAbsences().size() + ")");
            }
        }
    }

    private static void printVictimList(ArrayList<Victim> victims) {
        for (Victim victim : victims) {
            System.out.println("- " + victim.getName() + " (section: " + victim.getSection() + ", score: " + victim.getScore() + ", numberOfPicks: " + victim.getNumberOfPicks() + ")");
        }
    }

}

