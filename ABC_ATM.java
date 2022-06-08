
import java.util.Scanner;
import java.text.DecimalFormat;

public class ABC_ATM {
    public static int twoThousands, fiveHundreds, twoHundreds, hundreds, fifties, withdraw_amount = 0;
    public static int totalAmount;
    static Scanner sc = new Scanner(System.in);
    static DecimalFormat moneyFormat = new DecimalFormat(" '$' ###,##0.00");

    public static void depositeAmount() {
        System.out.println("please add the no. of currencies!");
        System.out.println("Enter the no. of 2000s:");
        twoThousands += sc.nextInt();
        System.out.println("Enter the no. of 500s:");
        fiveHundreds += sc.nextInt();
        System.out.println("Enter the no. of 200s:");
        twoHundreds += sc.nextInt();
        System.out.println("Enter the no. of 100s:");
        hundreds += sc.nextInt();
        if (twoThousands < 0 || fiveHundreds < 0 || twoHundreds < 0 || hundreds < 0) {
            System.out.println("Incorrect deposit amount");
        } else if (twoThousands == 0 && fiveHundreds == 0 && twoHundreds == 0 && hundreds == 0) {
            System.out.println("Deposit amount cannot be zero");
        } else {
            int total_2000s = twoThousands * 2000;
            int total_500s = fiveHundreds * 500;
            int total_200s = twoHundreds * 200;
            int total_100s = hundreds * 100;
            totalAmount = total_2000s + total_500s + total_200s + total_100s;

            System.out.println("Balance: 2000s=" + twoThousands + ", 500s=" + fiveHundreds + ", 200s=" + twoHundreds
                    + ", 100s=" + hundreds + ", Total=" + moneyFormat.format(totalAmount));

        }
        System.out.println("=============================");
        System.out.println("Any further operation ?");
        System.out.println("=============================");
        select();
    }

    public static void withdrawAmount() {
        int no_2000s = 0, no_500s = 0, no_200s = 0, no_100s = 0;

        System.out.println("Please enter the amount to withdraw!");
        withdraw_amount = sc.nextInt();
        int rem_amount = totalAmount - withdraw_amount;

        if (withdraw_amount <= totalAmount) {
            if (withdraw_amount >= 2000) {
                no_2000s = withdraw_amount / 2000;
                withdraw_amount %= 2000;
            }
            if (withdraw_amount >= 500) {
                no_500s = withdraw_amount / 500;
                withdraw_amount %= 500;
            }
            if (withdraw_amount >= 200) {
                no_200s = withdraw_amount / 200;
                withdraw_amount %= 200;

            }
            if (withdraw_amount >= 100) {
                no_100s = withdraw_amount / 100;
                withdraw_amount %= 100;
            }

            int rem_2000s = twoThousands - no_2000s;
            int rem_500s = fiveHundreds - no_500s;
            int rem_200s = twoHundreds - no_200s;
            int rem_100s = hundreds - no_100s;

            if(no_2000s == 0){
                if(no_500s == 0){
                    if(no_200s == 0){
                        if(no_100s == 0){
                            System.out.println("Incorrect or insufficient funds");
                        }
                        else{
                            System.out.println("Dispensed: 100s= " + no_100s);
                        }
                    }
                    else{
                        System.out.println("Dispensed: 200="+ no_200s+ ", 100s= " + no_100s);
                    }
                }else{
                    System.out.println("Dispensed: 500s= " + no_500s +", 200s= " + no_200s + ", 100s= " + no_100s);
                }
            }else{
                System.out.println("Dispensed: 2000s= " + no_2000s + ", 500s= " + no_500s + ", 200s= " + no_200s + ", 100s= "+no_100s);
            }
           
            System.out.println("Balance: 2000s=" + rem_2000s + ", 500s=" + rem_500s + ", 200s=" + rem_200s + ", 100s="
                    + rem_100s + ", Total=" + moneyFormat.format(rem_amount));
            totalAmount = rem_amount;
            twoThousands = rem_2000s;
            fiveHundreds = rem_500s;
            twoHundreds = rem_200s;
            hundreds = rem_100s;

            System.out.println("=============================");
            System.out.println("Any further operation ?");
            System.out.println("=============================");
            select();

        } else {
            System.out.println("Incorrect or insufficient funds");
        }
    }

    public static void select() {
        System.out.println("Please select the prefered option!\n 1. Deposite Amount \n 2. Withdraw Amount \n 3. Exit");
        int opt = sc.nextInt();

        switch (opt) {
            case 1:
                depositeAmount();
                break;
            case 2:
                withdrawAmount();
                break;
            case 3:
                System.exit(0);
            default:
                System.out.println("Invalid selection!");
        }
    }

    public static void main(String[] args) {

        select();
        }
}
