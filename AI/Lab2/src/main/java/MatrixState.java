public class MatrixState {
    public int columns, rows;
    public Point startingPoint;
    public Point destinationPoint;
    public Point currentPoint;
    public int[][] matrix;

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

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public boolean isFinal(Point currentPoint){
        if (currentPoint == this.destinationPoint)
            return true;
        return false;
    }

    public void transition(Point nextPoint){
        if(matrix[nextPoint.x][nextPoint.y] != 1)
            this.currentPoint = nextPoint;
    }






    // public boolean isInside(){}
}
