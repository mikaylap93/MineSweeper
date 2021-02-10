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
        }

        @Override
        public void mousePressed(MouseEvent e) {
            if (SwingUtilities.isLeftMouseButton(e)) {
                if (isBomb) {
                    setText("☹");
                    JOptionPane.showMessageDialog(null, "You Loose ☹");
                } else if (!hasNoBombs) {
                    setText(String.valueOf(surroundingBombsTotal));
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
}
