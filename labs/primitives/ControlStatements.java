package primitives;

public class ControlStatements {
    public static void main(String[] args) {
        //demo if
        boolean condition1 = true;
        boolean condition2 = false;
        int _i = 5;
        
        if ((condition1) && (!condition2)) {
            System.out.println("Inside if");
        } else if (condition2) {
            System.out.println("Inside else if");
        } else if (_i == 5) {
            System.out.println("Inside else");
        }
        
        //demo switch
        switch (_i) {
            case 1:
            case 2:
            case 3:
                System.out.println("Num less than 3");
                break;
            case 4:
                break;
            default:
                System.out.println("num gt than 4");
                break;
        }
        
        //demo for-loop
        for (int i=0;i<5;i++) {
            System.out.println("value of i " + i);
        }
        
        //demo while
        while ((_i <= 5) && (_i > 0)) {
            _i--;
            System.out.println("while : " + _i);
            if (_i == 2) {
                break;
            }
        }
        
        //demo do...while
        do {
            _i++;
            System.out.println("Do while : " + _i);
        } while (_i <= 5);
    }
}