import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame{
    static MapPattern mapPattern = new MapPattern();
    GameDifficulty gameDifficulty;

    MainFrame(GameDifficulty gameDifficulty){
        this.gameDifficulty = gameDifficulty;
        //setLayout(new GridLayout(1,1));
        setLayout(new MigLayout("fill, insets 0 0 0 0"));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("MineBoxes");
        //setPreferredSize(new Dimension(250,300));

        JMenuBar jMenuBar = new JMenuBar();
        JMenu gameMenu = new JMenu("Game");
        JMenuItem easyGame = new JMenuItem("Easy");
        easyGame.addActionListener(e -> {
            new MainFrame(GameDifficulty.EASY);
            dispose();
        });
        JMenuItem mediumGame = new JMenuItem("Medium");
        mediumGame.addActionListener(e ->{
            new MainFrame(GameDifficulty.MEDIUM);
            dispose();
        });
        JMenuItem hardGame = new JMenuItem("Hard");
        hardGame.addActionListener(e ->{
            new MainFrame(GameDifficulty.HARD);
            dispose();
        });
        JMenuItem insane = new JMenuItem("Insane");
        insane.addActionListener(e->{
            new MainFrame(GameDifficulty.INSANE);
            dispose();
        });

        gameMenu.add(easyGame);
        gameMenu.add(mediumGame);
        gameMenu.add(hardGame);
        gameMenu.add(insane);

        jMenuBar.add(gameMenu);
        add(jMenuBar,"north");

        //add(new ScorePanel(),"dock north");
        add(new BoxPanel(),"grow");
        add(new ScorePanel(),"south");
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

    }

    public static void main(String[] args){
        new MainFrame(GameDifficulty.EASY);

    }

}
