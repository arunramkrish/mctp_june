package mypackage;

public class HelloPackage {
    public static void main(String[] args) {
        //step 1: get the name from user
        String name = getUserName();
        
        //step 2: greet the user with his / her name
        System.out.println("Hello " + name);
    }
    
    private static String getUserName() {
        System.out.print("Please Enter your name :");
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        String name = scanner.nextLine();
        
        return name;
    }
}