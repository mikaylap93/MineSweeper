import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MineBoxButton extends JToggleButton {
    boolean isBomb;
    boolean hasNoBombs;
    int surroundingBombsTotal;

    MineBoxButton(MineBox mineBox){
        this.isBomb = mineBox.isBomb;
        this.hasNoBombs = mineBox.hasNoBombs;
        this.surroundingBombsTotal = mineBox.bombTotal;
        addMouseListener(mouseListener);
    }

    MouseListener mouseListener = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
            if(SwingUtilities.isLeftMouseButton(e)){
                if(isBomb){
                    setText("☹");
                    JOptionPane.showMessageDialog(null,"You Loose ☹");
                }
                else if(hasNoBombs){
                    setVisible(false);

                }else if(MapPattern.boxesClickedCounter == 90){
                    JOptionPane.showMessageDialog(null," ֍ You Win! ֍");
                }
                else {
                    setText(String.valueOf(surroundingBombsTotal));
                }

            }else if(SwingUtilities.isRightMouseButton(e)){
                setForeground(Color.RED);
                setText("⚑");
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {}
        @Override
        public void mouseReleased(MouseEvent e) {}
        @Override
        public void mouseEntered(MouseEvent e) {}
        @Override
        public void mouseExited(MouseEvent e) {}
    };
}
