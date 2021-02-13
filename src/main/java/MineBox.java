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
    double columnAsDouble;
    int column;


    MineBox(double mineBoxLocation, boolean isBomb) {
        this.mineBoxLocation = mineBoxLocation;
        row = (int)mineBoxLocation;

        String locationAsString = String.valueOf(this.mineBoxLocation);
        int indexOfDecimal = locationAsString.indexOf(".");

        row = Integer.parseInt(locationAsString.substring(0, indexOfDecimal));
        columnAsDouble = Double.parseDouble(locationAsString.substring(indexOfDecimal))*10;
        column = (int)columnAsDouble;
        //System.out.println(row+"-"+column);


        identifySurroundingMineBlockLocations();

        this.isBomb  = isBomb;
        bombTotal = calculateSurroundingBombs(this);
        if(calculateSurroundingBombs(this) == 0){
            hasNoBombs = true;
        }

    }

    public void setBomb(boolean bomb) {
        isBomb = bomb;
    }

    private void identifySurroundingMineBlockLocations() {

        if (row > 1) rowAboveExists = true;
        if (row < 9) rowBelowExists = true;
        if (column > 1) columnToLeftExists = true;
        if (column < 9) columnToRightExists = true;

        if (rowAboveExists) northLocation = ((row - 1) + (column/10.0));
        if (rowAboveExists && columnToRightExists) northEastLocation = ((row - 1) + ((column+1)/10.0));
        if (columnToRightExists) eastLocation = ((row) + ((column+1)/10.0));
        if (columnToRightExists && rowBelowExists) southEastLocation = ((row + 1) + (column+1)/10.0);
        if (rowBelowExists) southLocation = ((row + 1) + (column/10.0));
        if (rowBelowExists && columnToLeftExists) southWestLocation = ((row + 1) + ((column - 1)/10.0));
        if (columnToLeftExists) westLocation = ((row) + (column - 1)/10.0);
        if (columnToLeftExists && rowAboveExists) northWestLocation = ((row -1) + (column-1)/10.0);

    }

    static int calculateSurroundingBombs(MineBox mineBox) {
        int total = 0;

        if (mineBox.northLocation!=-1.0&& MapPattern.boxIsBomb(mineBox.northLocation)) {total++;}
        if (mineBox.northEastLocation !=-1.0&& MapPattern.boxIsBomb(mineBox.northEastLocation)) {total++;}
        if (mineBox.eastLocation!=-1.0&& MapPattern.boxIsBomb(mineBox.eastLocation)) {total++;}
        if (mineBox.southEastLocation!=-1.0&& MapPattern.boxIsBomb(mineBox.southEastLocation)) {total++;}
        if (mineBox.southLocation!=-1.0&& MapPattern.boxIsBomb(mineBox.southLocation)) {total++;}
        if (mineBox.southWestLocation!=-1.0&& MapPattern.boxIsBomb(mineBox.southWestLocation)) {total++;}
        if (mineBox.westLocation!=-1.0&& MapPattern.boxIsBomb(mineBox.westLocation)) {total++;}
        if (mineBox.northWestLocation!=-1.0&& MapPattern.boxIsBomb(mineBox.northWestLocation)) {total++;}

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


