import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame{
    static MapPattern mapPattern = new MapPattern();

    MainFrame(){
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        int height =  Toolkit.getDefaultToolkit().getScreenSize().height;
        int width = Toolkit.getDefaultToolkit().getScreenSize().width;
        Dimension customScreen = new Dimension((width*5)/29,(height*5)/17);
        setTitle("MineBoxes");
        JMenuBar jMenuBar = new JMenuBar();
        JMenuItem newGame = new JMenuItem("New Game");
        JMenu game = new JMenu("Game");
        game.add(newGame);
        jMenuBar.add(game);
        add(jMenuBar,BorderLayout.NORTH);
        //add(new ScorePanel(),BorderLayout.SOUTH);
        add(new BoxPanel(),BorderLayout.CENTER);
        setPreferredSize(customScreen);
        pack();

        setLocationRelativeTo(null);
        setVisible(true);

    }

    public static void main(String[] args){
        new MainFrame();

    }

}
