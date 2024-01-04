public class CheckNum {
    private String comNum = "";
    private String userNum = "";
    private int strike = 0;
    private int ball = 0;
    public void checkNum(){
        RandomNum ran = new RandomNum();
        UserNum user = new UserNum();
        this.comNum = ran.comNum();
        do{
            this.userNum = user.getUserNum();
            this.strike = countStrike(this.comNum, this.userNum);
            this.ball = countBall(this.comNum, this.userNum);
            message(this.strike, this.ball);
            this.strike = 0;
            this.ball = 0;
        }while (!this.comNum.equals(this.userNum));
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
    public int countStrike(String comNum, String userNum){
        if(comNum.charAt(0) == userNum.charAt(0)){
            strike += 1;
        }
        if(comNum.charAt(1) == userNum.charAt(1)){
            strike += 1;
        }
        if(comNum.charAt(2) == userNum.charAt(2)){
            strike += 1;
        }
        return strike;
    }
    public int countBall(String comNum, String userNum){
        if(comNum.charAt(0) != userNum.charAt(0) &&
                (comNum.charAt(0) == userNum.charAt(1) || comNum.charAt(0) == userNum .charAt(2))){
            ball += 1;
        }
        if(comNum.charAt(1) != userNum.charAt(1) &&
                (comNum.charAt(1) == userNum.charAt(0) || comNum.charAt(1) == userNum.charAt(2))){
            ball += 1;
        }
        if(comNum.charAt(2) != userNum .charAt(2) &&
                (comNum.charAt(2) == userNum.charAt(0) || comNum.charAt(2) == userNum.charAt(1))){
            ball += 1;
        }
        return ball;
    }
    public void message(int strike, int ball){
        if(strike > 0 && ball > 0) {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
        if(strike > 0 && ball == 0){
            System.out.println(strike + "스트라이크");
        }
        if(ball > 0 && strike == 0){
            System.out.println(ball + "볼");
        }
    }
}
