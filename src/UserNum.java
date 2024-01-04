import java.util.Scanner;

public class UserNum {

    private String userNum = "";
    public String getUserNum(){
        System.out.print("숫자를 입력해주세요: ");
        Scanner input = new Scanner(System.in);
        do {
            this.userNum = checkError(input, this.userNum);
            if(this.userNum.charAt(0) == this.userNum.charAt(1) || this.userNum.charAt(0) == this.userNum.charAt(2)
                    || this.userNum.charAt(1) == this.userNum.charAt(2)){
                System.out.println("서로다른 3자리 수를 입력하세요!");
            }
        }while (this.userNum.charAt(0) == this.userNum.charAt(1) || this.userNum.charAt(0) == this.userNum.charAt(2)
                || this.userNum.charAt(1) == this.userNum.charAt(2));
        return userNum;
    }
    public String checkError(Scanner input, String userInput) throws ArrayIndexOutOfBoundsException{
        try{
            if(input.hasNextInt()) {
                userInput = input.nextLine();
                if (userInput.length() != 3) {
                    throw new ArrayIndexOutOfBoundsException("3자리 숫자가 아닙니다!");
                }
            }else if(!input.hasNextInt()){
                if(userInput.length() != 3){
                    throw new ArrayIndexOutOfBoundsException("숫자가 아닙니다! 3자리 숫자를 입력해주세요!");
                }
            }
            /*
            if를 사용하면 input값을 두번 받게 된다 하지만 else if를 사용하게 되면 값을 한번만 받는다.
            if(input.hasNext() && !input.hasNextInt()){
                if(userInput.length() != 3){
                    throw new ArrayIndexOutOfBoundsException("숫자가 아닙니다! 3자리 숫자를 입력해주세요!");
                }
            }
            */
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }
        return userInput;
    }
}
