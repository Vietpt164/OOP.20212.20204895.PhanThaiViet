package hust.soict.dsai.lab01.ex22;

import javax.swing.JOptionPane;
import java.lang.Math;
public class TwoDoubleNumbers {
    public static void main(String[] args) {
        String strNum1, strNum2;
        String strQuotient = "";
        
        strNum1 = JOptionPane.showInputDialog(null,
            "Please input the first number: ","Input the first number",
            JOptionPane.INFORMATION_MESSAGE);
        double num1 = Double.parseDouble(strNum1);

        strNum2 = JOptionPane.showInputDialog(null,
            "Please input the second number: ","Input the second number",
            JOptionPane.INFORMATION_MESSAGE);
        double num2 = Double.parseDouble(strNum2); 

        double sum = num1 + num2, dif = Math.abs(num1 - num2),
               product = num1*num2;
        if (num2 == 0) { 
            strQuotient = "Invalid divisor!";
        } else {
            strQuotient = Double.toString(num1/num2);
        } 


        JOptionPane.showMessageDialog(null, "Sum: " + sum 
            +"\nDifference: " + dif + "\nProduct: " + product
            + "\nQuotient: " + strQuotient,
            "Results", JOptionPane.INFORMATION_MESSAGE);
        
        System.exit(0);
    }
}