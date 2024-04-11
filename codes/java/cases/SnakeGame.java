package cases;

/**
 * @author zhanghaibing
 * @date 2024-04-10
 */
import java.util.*;

public class SnakeGame {
    public static final int WIDTH = 20;
    public static final int HEIGHT = 10;

    public static void main(String[] args) {
        Snake snake = new Snake();
        Fruit fruit = new Fruit();
        boolean[][] grid = new boolean[HEIGHT][WIDTH];
        boolean gameOver = false;

        while (!gameOver) {
            // 清空网格d
            for (int i = 0; i < HEIGHT; i++) {
                Arrays.fill(grid[i], false);
            }

            // 放置蛇和果实在网格上
            for (int segment : snake.getSegments()) {
                int y = segment / WIDTH;
                int x = segment % WIDTH;
                grid[y][x] = true;
            }
            int y = fruit.getLocation() / WIDTH;
            int x = fruit.getLocation() % WIDTH;
            grid[y][x] = true;

            // 打印游戏界面
            for (int i = 0; i < HEIGHT; i++) {
                for (int j = 0; j < WIDTH; j++) {
                    System.out.print(grid[i][j] ? "# " : ". ");
                }
                System.out.println();
            }

            // 处理输入
            Scanner scanner = new Scanner(System.in);
            System.out.print("输入移动方向 (w上, a左, s下, d右)：");
            String input = scanner.nextLine().toLowerCase();

            // 更新游戏状态
            snake.move(input, WIDTH, HEIGHT);  // 移动蛇
            if (snake.hasCollided() || snake.isOutOfBounds(WIDTH, HEIGHT)) {
                gameOver = true;
            } else if (snake.eat(fruit)) {
                fruit.respawn(WIDTH * HEIGHT);  // 重新放置果实
                snake.grow();  // 蛇增长一节
            }
        }

        System.out.println("游戏结束！你的得分是：" + snake.getScore());
    }
}

class Snake {
    private LinkedList<Integer> segments = new LinkedList<>();
    private int dx, dy;
    private int score;

    public Snake() {
        segments.add(44);
        segments.add(43);
        segments.add(42);
        dx = 1;
        dy = 0;
        score = 0;
    }

    public LinkedList<Integer> getSegments() {
        return segments;
    }

    public int getScore() {
        return score;
    }

    public void move(String direction, int width, int height) {
        // 修改蛇头位置
        int head = segments.getFirst();
        int newHead = head + dy * width + dx;
        segments.addFirst(newHead);

        // 删除尾部（如果没有吃到果实）
        if (segments.size() > score + 3) {
            segments.removeLast();
        }

        // 根据方向设置蛇头的增量
        switch (direction) {
            case "w":
                dy = -1; dx = 0;
                break;
            case "s":
                dy = 1; dx = 0;
                break;
            case "a":
                dy = 0; dx = -1;
                break;
            case "d":
                dy = 0; dx = 1;
                break;
        }
    }

    public boolean hasCollided() {
        int head = segments.getFirst();
        for (int i = 1; i < segments.size(); i++) {
            if (segments.get(i) == head) {
                return true;  // 蛇头和蛇身碰撞
            }
        }
        return false;
    }

    public boolean isOutOfBounds(int width, int height) {
        int head = segments.getFirst();
        return head < 0 || head >= width * height;  // 蛇头超出边界
    }

    public boolean eat(Fruit fruit) {
        int head = segments.getFirst();
        return head == fruit.getLocation();  // 吃到果实
    }

    public void grow() {
        score++;
    }
}

class Fruit {
    private int location;

    public Fruit() {
        this.location = 60;
    }

    public int getLocation() {
        return location;
    }

    public void respawn(int maxLocation) {
        Random random = new Random();
        location = random.nextInt(maxLocation);
    }
}

