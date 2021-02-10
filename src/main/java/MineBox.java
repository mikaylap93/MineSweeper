public class MineBox {
    double mineBoxLocation;
    boolean isBomb;
    boolean hasNoBombs;

    double northLocation = -1.0;
    double northEastLocation = -1.0;
    double eastLocation = -1.0;
    double southLocation = -1.0;
    double southEastLocation = -1.0;
    double southWestLocation = -1.0;
    double westLocation = -1.0;
    double northWestLocation = -1.0;

    boolean rowAboveExists;
    boolean rowBelowExists;
    boolean columnToLeftExists;
    boolean columnToRightExists;

    int bombTotal;

    int row;
    double columnLocation;
    int column;

    MineBox(double mineBoxLocation, boolean isBomb) {
        this.mineBoxLocation = mineBoxLocation;
        row = (int)mineBoxLocation;
        columnLocation = (mineBoxLocation-row)*10;
        column = (int) columnLocation;

        identifySurroundingMineBlockLocations();

        this.isBomb  = isBomb;
        bombTotal = calculateSurroundingBombs();
        if(calculateSurroundingBombs() == 0){
            hasNoBombs = true;
        }

    }

    public void setBomb(boolean bomb) {
        isBomb = bomb;
    }

    private void identifySurroundingMineBlockLocations() {




        if (row > 1) rowAboveExists = true;
        if (row < 10) rowBelowExists = true;
        if (column > 1) columnToLeftExists = true;
        if (column < 10) columnToRightExists = true;

        if (rowAboveExists) northLocation = ((row - 1) + (column/10.0));
        if (rowAboveExists && columnToRightExists) northEastLocation = ((row - 1) + ((column+1)/10.0));
        if (columnToRightExists) eastLocation = ((row) + ((column+1)/10.0));
        if (columnToRightExists && rowBelowExists) southEastLocation = ((row + 1) + (column/10.0));
        if (rowBelowExists) southLocation = ((row + 1) + (column/10.0));
        if (rowBelowExists && columnToLeftExists) southWestLocation = ((row - 1) + ((column + 1)/10.0));
        if (columnToLeftExists) westLocation = ((row) + (column - 1)/10.0);
        if (columnToLeftExists && rowAboveExists) northWestLocation = ((row + 1) + (column)/10.0);

    }

    int calculateSurroundingBombs() {
        int total = 0;

        if (northLocation!=-1.0&& MapPattern.boxIsBomb(northLocation)) {total++;}
        if (northEastLocation !=-1.0&& MapPattern.boxIsBomb(northEastLocation)) {total++;}
        if (eastLocation!=-1.0&& MapPattern.boxIsBomb(eastLocation)) {total++;}
        if (southEastLocation!=-1.0&& MapPattern.boxIsBomb(southEastLocation)) {total++;}
        if (southLocation!=-1.0&& MapPattern.boxIsBomb(southLocation)) {total++;}
        if (southWestLocation!=-1.0&& MapPattern.boxIsBomb(southWestLocation)) {total++;}
        if (westLocation!=-1.0&& MapPattern.boxIsBomb(westLocation)) {total++;}
        if (northWestLocation!=-1.0&& MapPattern.boxIsBomb(northWestLocation)) {total++;}
        if (northLocation!=-1.0&& MapPattern.boxIsBomb(northLocation)) {total++;}

        //System.out.println(total);

        return total;

    }

    @Override
    public String toString() {
        return (mineBoxLocation+"("+row+","+column+")--isBomb:"+isBomb+":"
                +"N("+northLocation+","+MapPattern.boxIsBomb(northLocation)+
                ") NE("+northEastLocation+","+MapPattern.boxIsBomb(northEastLocation)+
                ") E"+eastLocation+ ","+MapPattern.boxIsBomb(eastLocation)+
                ") SE(" +southEastLocation+ ","+MapPattern.boxIsBomb(southEastLocation)+
                ") S("+southLocation+ ","+MapPattern.boxIsBomb(southLocation)+
                ") SW("+southWestLocation+ ","+MapPattern.boxIsBomb(southWestLocation)+
                ") W("+westLocation+ ","+MapPattern.boxIsBomb(westLocation)+
                ") NW("+northWestLocation+ ","+MapPattern.boxIsBomb(northWestLocation)+
                ")"+" surroundingBombs:"+bombTotal);
    }
}


