import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        CheckNum checkNum = new CheckNum();
        Scanner input = new Scanner(System.in);
        int userChoice = 1;
        System.out.println("숫자 야구 게임을 시작합니다.");
        do{
            checkNum.checkNum();
            userChoice = input.nextInt();
        }while (userChoice == 1);
    }
}