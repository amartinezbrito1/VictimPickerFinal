import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class AllVictimsPanel extends JPanel {
    private ArrayList<VictimPanel> victims;
    private int counter;

    public AllVictimsPanel(){
        this.setPreferredSize(new Dimension(800, 800));
        this.counter = 0;

        victims = new ArrayList<VictimPanel>();

        while(counter < 2) {
            victims.add(new VictimPanel(""));
            counter++;
        }

        for(VictimPanel victimPanel: victims){
            this.add(victimPanel);
        }

        this.setVisible(true);
    }

    public void setVictimNames(ArrayList<String> names) {
        int i = 0;

        for (String name : names) {
            victims.get(i).setName(name);
            i++;
        }
    }

    public void setVictimsIcon(){
        int i = 0;

        for(VictimPanel victim:victims){
            victim.setVictimIcon();
        }
    }
}
