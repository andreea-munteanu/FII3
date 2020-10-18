public class BackTracking {

    int[] visited = new int[500];
    int[] directionX = {0, 1, 0, -1};
    int[] directionY = {-1, 0, 1, 0};
    MatrixState matrixState;

    private boolean isSafe(int x, int y)
    {
        return matrixState.matrix[x][y] != 1;
    }

    // if not a valid position, return false
    private boolean isValid(int x, int y)
    {
        return (x < matrixState.rows && y < matrixState.columns && x >= 0 && y >= 0);
    }

    // Find Shortest Possible Route in a Matrix mat from source cell (0, 0)
    // to destination cell (x, y)

    // 'min_dist' stores length of longest path from source to destination
    // found so far and 'dist' maintains length of path from source cell to
    // the current cell (i, j)

    public int[] findPath(int x, int y)
    {
        // if destination is found, return visited
        if (matrixState.isFinal(matrixState.currentPoint))
        {
            return visited;
        }

        // set (i, j) cell as visited
        matrixState.matrix[x][y] = 1;
        System.out.println("aici");

        for (int contor = 0; contor < 4; contor++){
            if (isValid(matrixState.currentPoint.x+directionX[contor], matrixState.currentPoint.y+directionY[contor]) &&
                isValid(matrixState.currentPoint.x+directionX[contor],matrixState.currentPoint.y+directionY[contor]))
                System.out.println("aici find");
                findPath(matrixState.currentPoint.x+directionX[contor],matrixState.currentPoint.y+directionY[contor]);
        }

        // Backtrack - Remove (i, j) from visited matrix
        matrixState.matrix[x][y] = 0;

        return visited;
    }

}
