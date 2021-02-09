import javax.swing.*;
import java.awt.*;

public class BoxPanel extends JPanel {


    BoxPanel(){
       setLayout(new GridLayout(10,10));
       for(int i = 0; i<10; i++){
           for(int j = 0; j<10; j++){
               add(MainFrame.mapPattern.gameGrid[i][j]);
           }
       }

    }

}
