import java.util.AbstractMap;
import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

public class MapPattern {
    HashMap<Integer,Integer> bombMap = new HashMap<>();
    HashMap<Integer,Integer> bombMapCopy = new HashMap<>();
    CoverButton[][] gameGrid = new CoverButton[10][10];
    static int boxCounter = 0;

    MapPattern(){
        bombMap.put(1,1);
        bombMapCopy.put(1,1);
        for(int i = 0; i < 10; i++){
            addBomb();
        }

        bombMap.forEach((k,v) ->System.out.println(k+":"+v));

        for(int i =0; i<10; i++){
            for(int j = 0; j<10; j++){
                gameGrid[i][j] = new CoverButton("-");
            }
        }

        bombMap.forEach((k,v)-> gameGrid[k][v].setName("B"));
        setNumberSquares();



    }

    synchronized void addBomb(){

            bombMapCopy.forEach((k,v)-> {
                AbstractMap.SimpleEntry<Integer, Integer> gridPoint = createRandomGridPoint();
                if(k.equals(gridPoint.getKey())&& v.equals(gridPoint.getValue())){
                    gridPoint = createRandomGridPoint();
                }else bombMap.put(gridPoint.getKey(),gridPoint.getValue());
            });

            bombMapCopy.clear();
            bombMapCopy.putAll(bombMap);
    }

    void setNumberSquares(){
        //i is row j is column
        //-1j is left +1j is right
        //-1i is up +1i is down
        for(int i =0; i<10; i++) {
            for (int j = 0; j < 10; j++) {
                int bombTotal = 0;

                if(i>1) {
                    //North
                    if (gameGrid[i-1][j].getName().equals("B")) {
                        bombTotal++;
                    }
                }
                if(j>1) {
                    //West
                    if (gameGrid[i][j-1].getName().equals("B")) {
                        bombTotal++;
                    }
                }
                if(j<9) {
                    //East
                    if (gameGrid[i][j+1].getName().equals("B")) {
                        bombTotal++;
                    }
                }
                if(i<9) {
                    //South
                    if (gameGrid[i+1][j].getName().equals("B")) {
                        bombTotal++;
                    }
                }
                if (i>1 && j>1) {
                    //NORTHWEST
                    if (gameGrid[i-1][j-1].getName().equals("B")) {
                        bombTotal++;
                    }
                }
                if(i>1 && j<9) {
                    //NORTHEAST
                    if (gameGrid[i - 1][j + 1].getName().equals("B")) {
                        bombTotal++;
                    }
                }
                if (i<9 && j<9) {
                    //SOUTHEAST
                    if (gameGrid[i+1][j+1].getName().equals("B")) {
                        bombTotal++;
                    }
                }
                if(i<9 && j>1) {
                    //SOUTHWEST
                    if (gameGrid[i+1][j-1].getName().equals("B")) {
                        bombTotal++;
                    }
                }

                if(!(gameGrid[i][j].getName().equals("B"))) {
                    if(bombTotal>0) gameGrid[i][j].setName(String.valueOf(bombTotal));
                    else gameGrid[i][j].setName("");
                }
            }

        }
    }

    AbstractMap.SimpleEntry<Integer,Integer> createRandomGridPoint(){
        Integer randomX = ThreadLocalRandom.current().nextInt(1,10);
        Integer randomY = ThreadLocalRandom.current().nextInt(1,10);

        return (new AbstractMap.SimpleEntry<>(randomX,randomY));
    }

    public HashMap<Integer, Integer> getBombMap() {
        return bombMap;
    }
}
