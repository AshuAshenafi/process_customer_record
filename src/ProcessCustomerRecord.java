

import java.text.DecimalFormat;
import java.util.Scanner;

import static java.lang.String.format;

public class ProcessCustomerRecord {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);


        String cust_name;
        double purch_amount;
        int tax_code;
        boolean cont = true;
        double tax_percent = 0;
        int tax_percents[] = {0, 3, 5, 7};


        double sales_tax;
        double total_amount_due;

        System.out.print("Enter Customer's name: ");
        cust_name = input.nextLine();

        System.out.print("Enter Purchase amount: ");
        purch_amount = input.nextDouble();

        do{
            System.out.print("Enter Tax Code (0 for 0%, 1 for 3%, 2 for 5% or 3 for 7%): ");
            tax_code = input.nextInt();
            if(tax_code >= 0 && tax_code <= 3){
                for(int i = 0; i < 4; i++){
                    if(i == tax_code){
                        tax_percent = tax_percents[i];
                        cont = false;
                    }
                }
            }
            else{
                System.out.print("you entered wrong value. Please try again?\n***********************\n");
            }

        }while(cont == true);

        DecimalFormat df = new DecimalFormat("#.##");
        sales_tax = purch_amount * tax_percent / 100;
        String st = format("%.2f", sales_tax);
        total_amount_due = sales_tax + purch_amount;
        String tad = format("%.2f", total_amount_due);
        String pa = format("%.2f", purch_amount);

        // output

        System.out.println("===============================================================================================");
        System.out.println(format("%1s %30s %10s %30s %20s ", "|", "Customer's name: ", "|", cust_name, "|"));
        System.out.println(format("%1s %30s %10s %30s %20s ", "|", "", "|", "" , "|"));
        System.out.println("-----------------------------------------------------------------------------------------------");
        System.out.println(format("%1s %30s %10s %30s %20s ", "|", "Purchase amount: ", "|", pa, "|"));
        System.out.println(format("%1s %30s %10s %30s %20s ", "|", "Sales tax(" + tax_percent + "%):", "|", st, "|"));
        System.out.println("-----------------------------------------------------------------------------------------------");
        System.out.println(format("%1s %30s %10s %30s %20s ", "|", "Total amount due: ", "|", tad, "|"));
        System.out.println("===============================================================================================");


    }
}
