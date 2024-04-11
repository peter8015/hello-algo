package cases;

import java.util.Scanner;
import java.util.Random;

public class GuessNumberGame {
    public static void main(String[] args) {
        Random random = new Random();
        int numberToGuess = random.nextInt(100) + 1;  // 生成一个1到100之间的随机数
        boolean guessed = false;

        System.out.println("欢迎来到猜数字游戏！");
        System.out.println("我已经选择了一个1到100之间的数字，请猜猜是多少。");

        Scanner scanner = new Scanner(System.in);

        while (!guessed) {
            System.out.print("请输入你猜测的数字：");
            int guess = scanner.nextInt();

            if (guess < numberToGuess) {
                System.out.println("你猜的数字太小了，再试试吧。");
            } else if (guess > numberToGuess) {
                System.out.println("你猜的数字太大了，再试试吧。");
            } else {
                guessed = true;
                System.out.println("恭喜你！你猜对了！");
            }
        }

        System.out.println("游戏结束！");
    }
}

