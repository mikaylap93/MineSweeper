import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame{
    static MapPattern mapPattern = new MapPattern();

    MainFrame(){

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        int height =  Toolkit.getDefaultToolkit().getScreenSize().height;
        int width = Toolkit.getDefaultToolkit().getScreenSize().width;
        Dimension halfScreen = new Dimension(width/3,height/2);
        setTitle("MineBoxes");
        add(new BoxPanel(),BorderLayout.CENTER);
        setPreferredSize(halfScreen);
        pack();

        setLocationRelativeTo(null);
        setVisible(true);

    }

    public static void main(String[] args){
        new MainFrame();

    }

}
