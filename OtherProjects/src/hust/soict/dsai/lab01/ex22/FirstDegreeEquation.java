package hust.soict.dsai.lab01.ex22;

import javax.swing.JOptionPane;
public class FirstDegreeEquation {
    public static void main(String[] args) {
        String strA, strB;
        String strResult;
        
        strA = JOptionPane.showInputDialog(null,
            "Please input the first coefficient: ","Input the coefficients",
            JOptionPane.INFORMATION_MESSAGE);
        double numA = Double.parseDouble(strA);

        strB = JOptionPane.showInputDialog(null,
            "Please input the second coefficient: ","Input the coefficients",
            JOptionPane.INFORMATION_MESSAGE);
        double numB = Double.parseDouble(strB); 

        if (numA == 0) { 
            if (numB == 0) {
                strResult = "Infinite solution";
            } else {
                strResult = "No solution";
            }
        } else {
            strResult = "Unique solution: x = " + (-numB / numA);
        } 


        JOptionPane.showMessageDialog(null, strResult, "Result", JOptionPane.INFORMATION_MESSAGE);
        
        System.exit(0);
    }
}