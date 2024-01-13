import java.util.Scanner;

public class Main {

    //private static int userChoice = 1;
    public static void main(String[] args) {
        CheckNum checkNum = new CheckNum();
        Scanner input = new Scanner(System.in);
        System.out.println("숫자 야구 게임을 시작합니다.");
        int userChoice = 1;
        for (; userChoice == 1; ) {
            checkNum.checkNum();
            userChoice = input.nextInt();
        }
    }
}