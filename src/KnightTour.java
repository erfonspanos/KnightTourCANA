
public class KnightTour {

    // Define o tamanho do tabuleiro (pode alterar o tamanho se necessário)
    private static final int N = 8;

    // Todos os movimentos possíveis do cavalo no eixo x e y
    private static final int[] moveX = {2, 1, -1, -2, -2, -1, 1, 2};
    private static final int[] moveY = {1, 2, 2, 1, -1, -2, -2, -1};

    // Cria o tabuleiro com matriz NxN
    private int[][] tabuleiro;

    public KnightTour() {
        tabuleiro = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                tabuleiro[i][j] = -1; // Inicializa o tabuleiro com -1 (indicando que nao foi visitado)
            }
        }
    }

    private boolean isValid(int x, int y) {
        return (x >= 0 && x < N && y >= 0 && y < N && tabuleiro[x][y] == -1);
    }

    public void printSolution() {
        System.out.println("\nSolução do Passeio do Cavalo (" + N + "x" + N + "):");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                    System.out.printf("%2d ", tabuleiro[i][j]);
            }
            System.out.println(); // Nova linha para cada linha do tabuleiro
        }
        System.out.println("------------------------------------");
    }


    private boolean solveKnightTourUtil(int currentX, int currentY, int moveCount) {
        int nextX, nextY;

        tabuleiro[currentX][currentY] = moveCount - 1;

        if (moveCount == N * N) {
            return true;
        }

        for (int k = 0; k < 8; k++) {
            nextX = currentX + moveX[k];
            nextY = currentY + moveY[k];

            if (isValid(nextX, nextY)) {
                if (solveKnightTourUtil(nextX, nextY, moveCount + 1)) {
                    return true;
                }
            }
        }

        tabuleiro[currentX][currentY] = -1;
        return false;
    }

    public boolean solveKnightTour(int startX, int startY) {
        if (!solveKnightTourUtil(startX, startY, 1)) {
            System.out.println("Solução não existe para o tabuleiro " + N + "x" + N + "começando em (" + startX + "," + startY + ")");
            return false;
        } else {
            System.out.println("Solução encontrada para o tabuleiro " + N + "x" + N + "começando em (" + startX + "," + startY + ")");

        }
        return true;
    }

    public static void main(String[] args) {
        KnightTour knight = new KnightTour();

        knight.solveKnightTour(0, 0);

        knight.printSolution();
    }
}
