package cases;

/**
 * @author zhanghaibing
 * @date 2024-04-10
 */
import java.util.*;

public class GomokuGame {
    private char[][] board; // 棋盘
    private int rows;
    private int cols;
    private char currentPlayerMark; // 当前玩家标记

    public GomokuGame(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        board = new char[rows][cols];
        currentPlayerMark = 'X';
        initializeBoard();
    }

    // 初始化棋盘
    public void initializeBoard() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                board[i][j] = '-';
            }
        }
    }

    // 打印棋盘
    public void printBoard() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    // 玩家落子
    public boolean placeMark(int row, int col) {
        if (row >= 0 && row < rows && col >= 0 && col < cols) {
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
    public boolean isGameOver(int row, int col) {
        if (checkHorizontal(row, col) || checkVertical(row, col) || checkDiagonals(row, col)) {
            return true; // 有玩家获胜
        }
        return false;
    }

    // 检查水平方向是否有五子连珠
    private boolean checkHorizontal(int row, int col) {
        int count = 0;
        for (int c = 0; c < cols; c++) {
            if (board[row][c] == currentPlayerMark) {
                count++;
                if (count == 5) {
                    return true;
                }
            } else {
                count = 0;
            }
        }
        return false;
    }

    // 检查垂直方向是否有五子连珠
    private boolean checkVertical(int row, int col) {
        int count = 0;
        for (int r = 0; r < rows; r++) {
            if (board[r][col] == currentPlayerMark) {
                count++;
                if (count == 5) {
                    return true;
                }
            } else {
                count = 0;
            }
        }
        return false;
    }

    // 检查对角线是否有五子连珠
    private boolean checkDiagonals(int row, int col) {
        // 左上到右下
        int count = 0;
        for (int i = -4; i <= 4; i++) {
            int r = row + i;
            int c = col + i;
            if (r >= 0 && r < rows && c >= 0 && c < cols) {
                if (board[r][c] == currentPlayerMark) {
                    count++;
                    if (count == 5) {
                        return true;
                    }
                } else {
                    count = 0;
                }
            }
        }
        // 右上到左下
        count = 0;
        for (int i = -4; i <= 4; i++) {
            int r = row + i;
            int c = col - i;
            if (r >= 0 && r < rows && c >= 0 && c < cols) {
                if (board[r][c] == currentPlayerMark) {
                    count++;
                    if (count == 5) {
                        return true;
                    }
                } else {
                    count = 0;
                }
            }
        }
        return false;
    }

    // 运行游戏
    public void runGame() {
        Scanner input = new Scanner(System.in);
        while (true) {
            printBoard();
            System.out.println("玩家 " + currentPlayerMark + "，请输入要落子的位置 (行 列)：");
            int row = input.nextInt();
            int col = input.nextInt();
            if (placeMark(row, col)) {
                if (isGameOver(row, col)) {
                    printBoard();
                    System.out.println("恭喜，玩家 " + currentPlayerMark + " 获胜！");
                    break;
                }
                changePlayer();
            }
        }
    }

    public static void main(String[] args) {
        GomokuGame game = new GomokuGame(15, 15); // 创建一个15x15的五子棋游戏
        game.runGame();
    }
}

