package primitives;

public class PrimitivesDemo {
    public static void main(String[] args) {
        //demo arithmetic
        demoArithmetic();
        
        //demo boolean & logical 
        demoBooleanLogical();
        
        //demo characters
        demoCharacters();
    }
    
    /**
        This method demonstrates Arithmetic operatos and expressions
    */
    private static void demoArithmetic() {
        short myShort = 678; //takes 2 bytes
        int myInt = 123456; //takes 4 bytes
        long myLong = 4657890876L; //takes 8 bytes
        
        //primitives are converted to string when printed along with string
        System.out.println("Values " + myShort + myInt + myLong);
        System.out.println(myShort + myInt + myLong);
        
        myInt = myShort;//can assign smaller value type to bigger value
        myLong = myInt;
        myLong++; //this is => myLong = myLong + 1
        myLong--;
        myInt = myInt * myShort;
        System.out.println("Long value:" + myLong);
        
        float myFloat = 4.5F; //4 bytes
        double myDouble = 100.7; //8 bytes
        System.out.println("sum of decimals:" + (myFloat + myDouble));
        
    }
    
    private static void demoBooleanLogical() {
        boolean condition1 = true;
        boolean condition2 = !condition1;
        
        boolean orOperator = condition1 || condition2;
        boolean andOperator = condition1 && orOperator;
        
        System.out.println("And result " + andOperator);
    }
    
    private static void demoCharacters() {
        char a = 'A';
        char special = '\'';
        
        System.out.println("" + a + special);
        
        byte myByte = 35;
        System.out.println(myByte);
    }
}









