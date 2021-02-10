public class MineBox {
    double mineBoxLocation;
    boolean isBomb;
    boolean hasNoBombs;

    double northLocation;
    double northEastLocation;
    double eastLocation;
    double southLocation;
    double southEastLocation;
    double southWestLocation;
    double westLocation;
    double northWestLocation;

    boolean rowAboveExists;
    boolean rowBelowExists;
    boolean columnToLeftExists;
    boolean columnToRightExists;

    int bombTotal;

    MineBox(double mineBoxLocation, boolean isBomb) {
        this.mineBoxLocation = mineBoxLocation;
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

        int row = (int) mineBoxLocation;
        int column = String.valueOf(mineBoxLocation).charAt(2);

        if (row > 1) rowAboveExists = true;
        if (row < 10) rowBelowExists = true;
        if (column > 1) columnToLeftExists = true;
        if (column < 10) columnToRightExists = true;

        if (rowAboveExists) northLocation = (((row - 1) * 10) + (column)) / 10.0;
        if (rowAboveExists && columnToRightExists) northEastLocation = (((row - 1) * 10) + (column + 1)) / 10.0;
        if (columnToRightExists) eastLocation = (((row) * 10) + column + 1) / 10.0;
        if (columnToRightExists && rowBelowExists) southEastLocation = (((row + 1) * 10) + (column)) / 10.0;
        if (rowBelowExists) southLocation = (((row + 1) * 10) + (column)) / 10.0;
        if (rowBelowExists && columnToLeftExists) southWestLocation = (((row - 1) * 10) + (column + 1)) / 10.0;
        if (columnToLeftExists) westLocation = (((row) * 10) + (column - 1)) / 10.0;
        if (columnToLeftExists && rowAboveExists) northWestLocation = (((row + 1) * 10) + (column)) / 10.0;
    }

    int calculateSurroundingBombs() {
        int total = 0;
        if (MapPattern.boxIsBomb(northLocation)) bombTotal++;
        if (MapPattern.boxIsBomb(northEastLocation)) bombTotal++;
        if (MapPattern.boxIsBomb(eastLocation)) bombTotal++;
        if (MapPattern.boxIsBomb(southEastLocation)) bombTotal++;
        if (MapPattern.boxIsBomb(southLocation)) bombTotal++;
        if (MapPattern.boxIsBomb(southWestLocation)) bombTotal++;
        if (MapPattern.boxIsBomb(westLocation)) bombTotal++;
        if (MapPattern.boxIsBomb(northWestLocation)) bombTotal++;
        if (MapPattern.boxIsBomb(northLocation)) bombTotal++;

        return total;

    }
}


