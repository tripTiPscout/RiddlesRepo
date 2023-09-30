package bg.codexio.riddles.rabbit;

public class RabbitsBusiness {

    private static int GROUPS_COUNT = 0;

    public static void main(String[] args) {

        int[][] areaOfGardens = {
                {0,1,1,0,0,1,1,0,0,0},
                {0,1,1,0,0,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,1},
                {0,1,1,0,1,1,0,1,1,1},
                {0,1,1,0,1,1,0,1,1,1}
        };

        if (areGardensSquare(areaOfGardens)) {
            int jumps = GROUPS_COUNT;
            System.out.printf("The rabbit needs to jump %d times to eat all the carrots.\n", jumps);
        } else {
            System.out.println("Gardens are not squared.");
        }
    }

    public static boolean areGardensSquare(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 1) {
                    int groupSize = findGroupSize(matrix, i, j);
                    GROUPS_COUNT++;
                    if (groupSize < 4 || !isSquare(groupSize)) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    public static int findGroupSize(int[][] matrix, int i, int j) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        if (i < 0 || i >= rows || j < 0 || j >= cols || matrix[i][j] == 0) {
            return 0;
        }

        matrix[i][j] = 0; // Mark as visited

        int size = 1;
        //dfs (backtracking)
        size += findGroupSize(matrix, i + 1, j);
        size += findGroupSize(matrix, i - 1, j);
        size += findGroupSize(matrix, i, j + 1);
        size += findGroupSize(matrix, i, j - 1);

        return size;
    }

    public static boolean isSquare(int size) {
        int sqrt = (int) Math.sqrt(size);
        return sqrt * sqrt == size;
    }
}
