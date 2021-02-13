import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.ImageObserver;
import java.io.IOException;
import java.io.InputStream;

public class MineBoxButton extends JToggleButton {
    boolean isBomb;
    boolean hasNoBombs;
    int surroundingBombsTotal;
    MineBox mineBox;
    Image bomb = new ImageIcon(getClass().getResource("/OGMineBomb.png")).getImage();
    Image scaleBomb = bomb.getScaledInstance(15,15,2);
    ImageIcon bombImageIcon = new ImageIcon(scaleBomb);

    MineBoxButton(MineBox mineBox){
        this.mineBox = mineBox;
        this.isBomb = mineBox.isBomb;
        this.hasNoBombs = mineBox.hasNoBombs;
        this.surroundingBombsTotal = mineBox.bombTotal;
        setPreferredSize(new Dimension(30,30));
        //setContentAreaFilled(true);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setMargin(new Insets(0,0,0,0));
        addMouseListener(mouseListener);
        setBorder(BorderFactory.createRaisedBevelBorder());


    }

    MouseListener mouseListener = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
        }

        @Override
        public void mousePressed(MouseEvent e) {
            if (SwingUtilities.isLeftMouseButton(e)) {
                if (isBomb) {

                    setIcon(bombImageIcon);

                    JOptionPane.showMessageDialog(null, "You Loose ☹");
                } else if (!hasNoBombs) {
                    setForeground(getBoxColor(surroundingBombsTotal));
                    setText(String.valueOf(surroundingBombsTotal));
                    setBorder(BorderFactory.createEmptyBorder());
                    //setEnabled(false);
                }
            }
            if (SwingUtilities.isRightMouseButton(e)) {
                setForeground(Color.RED);
                setText("⚑");
            }
        }
        @Override
        public void mouseReleased(MouseEvent e) {
            if (SwingUtilities.isLeftMouseButton(e)) {
                if (hasNoBombs) {
                    setVisible(false);
                }
                if (MapPattern.boxesClickedCounter == 90) {
                    JOptionPane.showMessageDialog(null, " ֍ You Win! ֍");
                }
            }
        }
        @Override
        public void mouseEntered(MouseEvent e) {}
        @Override
        public void mouseExited(MouseEvent e) {}
    };

    void triggerSurroundingEmptyBoxes(){
        //if(MineBox.calculateSurroundingBombs()==0){}
    }
    Color getBoxColor(int boxNumber){

        if(boxNumber==1){
            return Color.BLUE;
        }
        if(boxNumber==2){
            return Color.GREEN;
        }
        if(boxNumber==3){
            return Color.RED;
        }
        return Color.BLACK;
    }
}
