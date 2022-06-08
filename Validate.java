import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Validate {
    private static int PinNumber;
    private static int CustomerNumber;

    public static int getPinNumber() {
        return PinNumber;
    }

    public static void setPinNumber(int pinNumber) {
        PinNumber = pinNumber;
    }

    public static int getCustomerNumber() {
        return CustomerNumber;
    }

    public static void setCustomerNumber(int customerNumber) {
        CustomerNumber = customerNumber;
    }

    ABC_ATM abc = new ABC_ATM();
    static Scanner menuInput = new Scanner(System.in);
    static HashMap<Integer, Integer> data = new HashMap<Integer, Integer>();

    public static  void getLogin() throws IOException {
     int x =1;
     do{
         try{
            data.put(101010, 20202);
            data.put(102030, 22222);

            System.out.println("Welcome to the ATM Project");
             System.out.println("Enter your customer number");
              setCustomerNumber(menuInput.nextInt());
               System.out.println("Enter your PIN number");
                setPinNumber(menuInput.nextInt());
            }
            catch(Exception e) {
                System.out.println("\n" + "Invalid Character(s) . Only Numbers." + "\n");
                x=2;
            }
                int cn = getCustomerNumber(); int pn = getPinNumber();
                 if(data.containsKey(cn) && data.get(cn) == pn) {
                   ABC_ATM.select(); 
                }
                    else{
                        System.out.println("\n" + "Wrong Customer Number or Pin Number");
                    }
                }
                while(x==1);
     }

     public static void main(String[] args) throws IOException {
        getLogin();
     }
}
