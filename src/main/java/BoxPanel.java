import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class BoxPanel extends JPanel {


    BoxPanel(){
       setLayout(new MigLayout("wrap 9"));
       setBorder(new LineBorder(Color.BLACK));

       for(int i = 1; i<10; i++){
           for(int j = 1; j<10; j++){
               MineBoxButton mineBoxButton = new MineBoxButton(MainFrame.mapPattern.gameGrid[i][j]);
               mineBoxButton.setContentAreaFilled(true);
               add(mineBoxButton,"grow");
           }
       }


       //add(new JLabel("Test"));


    }

}
