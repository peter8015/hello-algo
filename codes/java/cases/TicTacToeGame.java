package cases;

/**
 * @author zhanghaibing
 * @date 2024-04-10
 */
import java.util.Scanner;

public class TicTacToeGame {
    private char[][] board;
    private char currentPlayerMark;

    public TicTacToeGame() {
        board = new char[3][3];
        currentPlayerMark = 'X';
        initializeBoard();
    }

    // 初始化棋盘
    public void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    // 打印棋盘
    public void printBoard() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    // 玩家落子
    public boolean placeMark(int row, int col) {
        if (row >= 0 && row < 3 && col >= 0 && col < 3) {
            if (board[row][col] == '-') {
                board[row][col] = currentPlayerMark;
                return true;
            }
        }
        return false;
    }

    // 切换玩家
    public void changePlayer() {
        if (currentPlayerMark == 'X') {
            currentPlayerMark = 'O';
        } else {
            currentPlayerMark = 'X';
        }
    }

    // 检查游戏是否结束
    public boolean isGameOver() {
        return (checkRowsForWin() || checkColumnsForWin() || checkDiagonalsForWin() || checkForDraw());
    }

    // 检查行是否获胜
    private boolean checkRowsForWin() {
        for (int i = 0; i < 3; i++) {
            if (checkRowCol(board[i][0], board[i][1], board[i][2])) {
                return true;
            }
        }
        return false;
    }

    // 检查列是否获胜
    private boolean checkColumnsForWin() {
        for (int i = 0; i < 3; i++) {
            if (checkRowCol(board[0][i], board[1][i], board[2][i])) {
                return true;
            }
        }
        return false;
    }

    // 检查对角线是否获胜
    private boolean checkDiagonalsForWin() {
        return ((checkRowCol(board[0][0], board[1][1], board[2][2])) || (checkRowCol(board[0][2], board[1][1], board[2][0])));
    }

    // 检查无人胜出
    private boolean checkForDraw() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    // 检查一行或一列是否完全相同
    private boolean checkRowCol(char c1, char c2, char c3) {
        return ((c1 != '-') && (c1 == c2) && (c2 == c3));
    }

    // 运行游戏
    public void runGame() {
        Scanner input = new Scanner(System.in);
        while (!isGameOver()) {
            printBoard();
            System.out.println("玩家 " + currentPlayerMark + "，请输入要落子的位置 (行 列)：");
            int row = input.nextInt();
            int col = input.nextInt();
            if (placeMark(row, col)) {
                changePlayer();
            }
        }
        printBoard();
        if (checkForDraw()) {
            System.out.println("游戏结束，平局！");
        } else {
            changePlayer();
            System.out.println("恭喜，玩家 " + currentPlayerMark + " 获胜！");
        }
    }

    public static void main(String[] args) {
        TicTacToeGame game = new TicTacToeGame();
        game.runGame();
    }
}

