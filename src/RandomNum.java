public class RandomNum {
    int comNum1 = 0;
    int comNum2 = 0;
    int comNum3 = 0;
    public String comNum(){
        comNum1 = ((int)(Math.random()*9) + 1);
        do {
            comNum2 = ((int)(Math.random()*9) + 1);
        } while(comNum2 == 0 || comNum1 == comNum2);
        do {
            comNum3 = ((int)(Math.random()*9) + 1);
        }while(comNum3 == 0 || comNum1 == comNum3 || comNum2 == comNum3);
        return "" + comNum1 + comNum2 + comNum3;
    }
}
