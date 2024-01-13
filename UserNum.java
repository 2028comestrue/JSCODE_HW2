import java.util.Scanner;

public class UserNum {

    private String userNum;

    public String getUserNum() {
        System.out.print("숫자를 입력해주세요: ");
        Scanner input = new Scanner(System.in);
        this.userNum = "000";
        //왜 초기값을 위에서 private String userNum = "";처럼 설정하면 안되는거지?
        for (; charAvailable(this.userNum, 0, 1, 2); ) {
            this.userNum = checkError(input, this.userNum);
        }
        return this.userNum;
    }

    private boolean charAvailable(String userNum, int first, int second, int third) {
        if (userNum.length() != 3) {
            return true;
        }
        return userNum.charAt(first) == userNum.charAt(second)
            || userNum.charAt(first) == userNum.charAt(third)
            || userNum.charAt(second) == userNum.charAt(third);
    }

    private String checkError(Scanner input, String userInput)
        throws ArrayIndexOutOfBoundsException {
        try {
            return inputValue(input, userInput);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
        return userInput;
    }

    private String inputValue(Scanner input, String userInput) {
        if (input.hasNextInt()) {
            return hasNextInt(input, userInput);
        }
        return dontHasNextInt(input, userInput);
    }

    private String dontHasNextInt(Scanner input, String userInput) {
        if (!input.hasNextInt()) {
            userInput = input.nextLine();
            throw new ArrayIndexOutOfBoundsException("숫자가 아닙니다! 3자리 숫자를 입력해주세요!");
        }
        return userInput;
    }

    private String hasNextInt(Scanner input, String userInput) {
        userInput = input.nextLine();
        if (userInput.length() != 3) {
            throw new ArrayIndexOutOfBoundsException("3자리 숫자가 아닙니다!");
        }
        return userInput;
    }
}

//hasNextInt(input, userInput)은 왜 인풋 값을 두번 받는가?
    /*private String hasNextInt(Scanner input, String userInput) {
        if (input.hasNextInt()) {
            userInput = input.nextLine();
            if (userInput.length() != 3) {
                throw new ArrayIndexOutOfBoundsException("3자리 숫자가 아닙니다!");
            }
            return userInput;
        }
        return userInput;
    }*/

//checkError이나 error이나 결국에 userInput에 this.userNum이 저장되는데 왜 결과는 다르게 나오는거지?
    /*
    private void error(Scanner input, String userInput)
        throws ArrayIndexOutOfBoundsException {
        try {
            if (input.hasNextInt()) {
                userInput = input.nextLine();
                if (userInput.length() != 3) {
                    throw new ArrayIndexOutOfBoundsException("3자리 숫자가 아닙니다!");
                }
            } else if (!input.hasNextInt()) {
                if (userInput.length() != 3) {
                    throw new ArrayIndexOutOfBoundsException("숫자가 아닙니다! 3자리 숫자를 입력해주세요!");
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }
}
*/
    /*
        do {
            this.userNum = checkError(input, this.userNum);
            if(charAvailable(this.userNum, 0, 1, 2)){
                System.out.println("서로다른 3자리 수를 입력하세요!");
            }
        }while (charAvailable(this.userNum, 0, 1, 2));

    public String getUserNum() {
        System.out.print("숫자를 입력해주세요: ");
        Scanner input = new Scanner(System.in);
        do {
            this.userNum = checkError(input, this.userNum);
            if (charAvailable(this.userNum, 0, 1, 2)) {
                System.out.println("서로다른 3자리 수를 입력하세요!");
            }
        } while (charAvailable(this.userNum, 0, 1, 2));
        return userNum;
    }

    public String checkError(Scanner input, String userInput)
        throws ArrayIndexOutOfBoundsException {
        try {
            if (input.hasNextInt()) {
                hasNextInt(input, userInput);
                return userInput;
            }
            if (!input.hasNextInt()) {
                hasNext(input, userInput);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
        return userInput;
    }

    private void hasNextInt(Scanner input, String userInput) {
        userInput = input.nextLine();
        if (userInput.length() != 3) {
            throw new ArrayIndexOutOfBoundsException("3자리 숫자가 아닙니다!");
        }
    }

    private void hasNext(Scanner input, String userInput) {
        userInput = input.nextLine();
        if (userInput.length() != 3) {
            throw new ArrayIndexOutOfBoundsException("숫자가 아닙니다! 3자리 숫자를 입력해주세요!");
        }
    }

    private boolean charAvailable(String userNum, int first, int second, int third) {
            return userNum.charAt(first) == userNum.charAt(second)
            || userNum.charAt(first) == userNum.charAt(third)
            || userNum.charAt(second) == userNum.charAt(third)
            || userNum.charAt(first) == 0 || userNum.charAt(second) == 0
            || userNum.charAt(third) == 0;
    }
}*/

    /*private String userNum = "000";

    public String getUserNum() {
        System.out.print("숫자를 입력해주세요: ");
        Scanner input = new Scanner(System.in);
        this.userNum = input.next();
        checkError(input, this.userNum);
        return this.userNum;
    }

    private boolean charAvailable(String userNum, int first, int second, int third) {
        return userNum.charAt(first) == userNum.charAt(second)
            || userNum.charAt(first) == userNum.charAt(third)
            || userNum.charAt(second) == userNum.charAt(third)
            || userNum.charAt(first) == 0 || userNum.charAt(second) == 0
            || userNum.charAt(third) == 0;
    }

    /*private String checkError(Scanner input, String userInput)
        throws ArrayIndexOutOfBoundsException {
        try {
            checkHasNextInt(input, userInput);
            checkHasNext(input, userInput);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
        return userInput;
    }
    public String checkError(Scanner input, String userInput) throws ArrayIndexOutOfBoundsException {
        try {
            if (input.hasNextInt()) {
                userInput = input.nextLine();
                if (userInput.length() != 3) {
                    throw new ArrayIndexOutOfBoundsException("3자리 숫자가 아닙니다!");
                }
            } else if (!input.hasNextInt()) {
                if (userInput.length() != 3) {
                    throw new ArrayIndexOutOfBoundsException("숫자가 아닙니다! 3자리 숫자를 입력해주세요!");
                }
            }

            if를 사용하면 input값을 두번 받게 된다 하지만 else if를 사용하게 되면 값을 한번만 받는다.
            if(input.hasNext() && !input.hasNextInt()){
                if(userInput.length() != 3){
                    throw new ArrayIndexOutOfBoundsException("숫자가 아닙니다! 3자리 숫자를 입력해주세요!");
                }
            }

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
        return userInput;
    }
    private String checkHasNextInt(Scanner input, String userInput){
        if (input.hasNextInt()) {
            if (userInput.length() != 3) {
                throw new ArrayIndexOutOfBoundsException("3자리 숫자가 아닙니다!");
            }
        }
        return userInput;
    }
    private void checkHasNext(Scanner input, String userInput){
        if (!input.hasNextInt()) {
            throw new ArrayIndexOutOfBoundsException("숫자가 아닙니다! 3자리 숫자를 입력해주세요!");
        }
    }

}*/
