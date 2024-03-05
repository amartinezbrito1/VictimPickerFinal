import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class VictimPanel extends JPanel{
    private JLabel victim1;
    private JLabel text;

    private String name;
    private static int victim_num = 0;
    private ImageIcon mugshot;

    public VictimPanel(String name){
        victim_num++;
        this.setPreferredSize(new Dimension(300,800));
        this.setBackground(Color.WHITE);
        if(name == "")
            this.name = "Victim " + String.valueOf(victim_num);
        else{
            this.name = name;
        }


        JButton button1 = new JButton("Mark Absent");
        JButton button2 = new JButton("Volunteer");
        JButton button3 = new JButton("Score");

        text = new JLabel(this.name, SwingConstants.CENTER);
        text.setPreferredSize(new Dimension(300,50));
        text.setFont(new Font("Arial", Font.PLAIN, 18));



        try {
            BufferedImage scalable_image = ImageIO.read(new File("anonymous_victim.png"));

            Image image = scalable_image.getScaledInstance(300, 300, Image.SCALE_DEFAULT);

            mugshot = new ImageIcon(image);


            victim1 = new JLabel(mugshot);
            victim1.setIconTextGap(15);

            button1.setPreferredSize(new Dimension(300,100));
            button2.setPreferredSize(new Dimension(300,100));
            button3.setPreferredSize(new Dimension(300,100));

            button1.setEnabled(false);
            button3.setEnabled(false);


            this.add(victim1);
            this.add(text);
            this.add(button1);
            this.add(button2);
            this.add(button3);

            this.setVisible(true);
        }
        catch (IOException e){
            e.printStackTrace();
        }


    }

    public void setName(String name){
        text.setText(name);
    }

    public void setVictimIcon(){
        try {
            BufferedImage scalable_image = ImageIO.read(new File("crying.png"));

            Image image = scalable_image.getScaledInstance(300, 300, Image.SCALE_DEFAULT);

            ImageIcon victim_face = new ImageIcon(image);

            victim1.setIcon(victim_face);
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
