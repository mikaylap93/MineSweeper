import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MineBoxButton extends JToggleButton {

    MineBoxButton(String name){
        setName(name);
        addMouseListener(mouseListener);
    }

    MouseListener mouseListener = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
            if(SwingUtilities.isLeftMouseButton(e)){
                if(getName().equals("B")){
                    setText("☹");
                    JOptionPane.showMessageDialog(null,"You Loose ☹");
                }
                else if(getName().equals("")){
                    setVisible(false);

                }else if(MapPattern.boxCounter == 90){
                    JOptionPane.showMessageDialog(null," ֍ You Win! ֍");
                }
                else {
                    setText(getName());
                }

            }else if(SwingUtilities.isRightMouseButton(e)){
                setText("⚐");
            }

        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    };
}
