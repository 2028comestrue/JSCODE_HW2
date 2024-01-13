public class RandomNum {

    private int comNum1;
    private int comNum2;
    private int comNum3;

    public String comNum() {
        generateComputerNum();
        for (; comNum1 == comNum2; ) {
            this.comNum2 = generateNumber();
        }
        for (; comNum1 == comNum3 || comNum2 == comNum3; ) {
            comNum3 = generateNumber();
        }
        return "" + this.comNum1 + this.comNum2 + this.comNum3;
    }

    private int generateNumber() {
        return ((int) (Math.random() * 9) + 1);
    }

    private void generateComputerNum() {
        this.comNum1 = generateNumber();
        this.comNum2 = generateNumber();
        this.comNum3 = generateNumber();
    }
    /*왜 함수를 분리해서 작성하면 중복되는 숫자가 나오는 걸까?
    private void checkSecondNum(int comNum1, int comNum2){
        for (; comNum1 == comNum2; ) {
            comNum2 = generateNumber();
        }
    }
    private void checkThirdNum(int comNum1, int comNum2, int comNum3){
        for (; comNum1 == comNum3 || comNum2 == comNum3; ) {
            comNum3 = generateNumber();
        }
    }*/
}
