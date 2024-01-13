public class CheckNum {

    private String comNum = "";
    private String userNum = "";
    private int strike = 0;
    private int ball = 0;

    public void checkNum() {
        RandomNum ran = new RandomNum();
        UserNum user = new UserNum();
        this.comNum = ran.comNum();
        checkInput(user, this.comNum);
        resetMessage();
    }

    private void resetMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    private void checkInput(UserNum user, String comNum) {
        for (; !comNum.equals(this.userNum); ) {
            this.userNum = user.getUserNum();
            this.strike = countStrike(comNum, this.userNum);
            this.ball = countBall(comNum, this.userNum);
            message(this.strike, this.ball);
            reset();
        }
    }

    private void reset() {
        this.strike = 0;
        this.ball = 0;
    }

    private int countStrike(String comNum, String userNum) {
        for (int i = 0; i < 3; i++) {
            if (comNum.charAt(i) == userNum.charAt(i)) {
                strike += 1;
            }
        }
        return strike;
    }

    private int countBall(String comNum, String userNum) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i != j) {
                    checkBall(comNum, userNum, i, j);
                }
            }
        }
        return ball;
    }

    private void checkBall(String comNum, String userNum, int i, int j) {
        if (comNum.charAt(i) != userNum.charAt(i) &&
            (comNum.charAt(i) == userNum.charAt(j))) {
            ball += 1;
        }
    }

    private void message(int strike, int ball) {
        if (strike > 0 && ball > 0) {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
        if (strike > 0 && ball == 0) {
            System.out.println(strike + "스트라이크");
        }
        if (ball > 0 && strike == 0) {
            System.out.println(ball + "볼");
        }
    }
}
