import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class MapPattern {

    static ArrayList<Double> bombList = new ArrayList<>();
    MineBox[][] gameGrid = new MineBox[10][10];
    static int boxesClickedCounter = 0;

    MapPattern() {

        for (int i = 0; i <= 10; i++) {
            addBomb();
        }

        bombList.forEach(System.out::println);

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {

                double location = i+(j/10.0);
                gameGrid[i][j] = new MineBox(location,boxIsBomb(location));
            }
        }
    }

    synchronized void addBomb() {
        double bomb = createRandomGridDouble();
        if(!bombList.contains(bomb)){
            bombList.add(bomb);
        }else addBomb();
    }

    double createRandomGridDouble(){
        int randomX = ThreadLocalRandom.current().nextInt(1,11);
        int randomY = ThreadLocalRandom.current().nextInt(1,11);
        return randomX+(randomY/10.0);
    }

    static boolean boxIsBomb(double blockLocation){
        return bombList.contains(blockLocation);
    }
}
