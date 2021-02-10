import javax.swing.*;
import java.awt.*;

public class ScorePanel extends JPanel {

    ScorePanel(){
        setLayout(new GridLayout(2,2));
        add(new JLabel("Score:"));
        add(new JLabel("Time:"));


    }
}
