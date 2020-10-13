public class MatrixState {
    int columns, rows;
    Point startingPoint;
    Point destinationPoint;
    Point currentPoint;
    int[][] matrix;

    public MatrixState(int columns, int rows) {
        this.columns = columns;
        this.rows = rows;
    }

    public MatrixState() {
    }

    public void init() {
        /* creating borders */
        for(int i = 0; i <= columns+1; i++ ){
            matrix[i][0] = 1;
            matrix[i][rows+1] = 1;
        }
        for(int j = 0; j <= rows+1; j++ ){
            matrix[0][j] = 1;
            matrix[columns+1][j] = 1;
        }
        /* the rest of the initialization */
        for(int i = 1; i <= columns; i++)
            for(int j = 1; j <= rows; j++){
                matrix[i][j] = 0;
            }
    }


    public Point getStartingPoint() {
        return startingPoint;
    }

    public void setStartingPoint(Point startingPoint) {
        this.startingPoint = startingPoint;
    }

    public Point getDestinationPoint() {
        return destinationPoint;
    }

    public void setDestinationPoint(Point destinationPoint) {
        this.destinationPoint = destinationPoint;
    }
    public Point getCurrentPoint() {
        return currentPoint;
    }

    public void setCurrentPoint(Point currentPoint) {
        this.currentPoint = currentPoint;
    }

    public boolean isFinal(Point currentPoint){
        if (currentPoint == this.destinationPoint)
            return true;
        return false;
    }

    public void transition(Point nextPoint){
        this.currentPoint = nextPoint;
    }






    // public boolean isInside(){}
}
