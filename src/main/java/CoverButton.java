import javax.swing.*;
import java.util.ArrayList;

public class CoverButton extends JButton implements Killer{
    static ArrayList<Murdered> murdereds = new ArrayList<>();

    CoverButton(String x) {
        setName(x);
        //setOpaque(true);
        //setBorder(BorderFactory.createLineBorder(Color.BLACK));
        //setBackground(Color.LIGHT_GRAY);
        addActionListener(e -> {
            setEnabled(false);
            //setBackground(Color.DARK_GRAY);
            MapPattern.boxCounter++;
            setText(getName());
            if(MapPattern.boxCounter == 90){
                JOptionPane.showMessageDialog(null,"YOU WIN!");
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
            if(getName().equals("B")){

                JOptionPane.showMessageDialog(null,"YOU LOOSE ☹");
                kill();
            }
        });

    }

    @Override
    public void addMurdered(Murdered murdered) {
        murdereds.add(murdered);
    }

    @Override
    public void removeMurdered(Murdered murdered) {
        murdereds.add(murdered);
    }

    @Override
    public void kill() {
        for(Murdered murdered: murdereds){
            murdered.die();
        }
    }
}
