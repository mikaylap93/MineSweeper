import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

public class ScorePanel extends JPanel {

    ScorePanel(){
        setLayout(new MigLayout());

        add(new JLabel("0 sec"),"dock east");


    }
}
