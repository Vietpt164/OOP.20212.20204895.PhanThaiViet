package hust.soict.dsai.lab01.ex22;

import javax.swing.*;

public class SystemFirstDegreeEquations {
    public static void main(String[] args) {
        JTextField strA11 = new JTextField();
        JTextField strA12 = new JTextField();
        JTextField strA21 = new JTextField();
        JTextField strA22 = new JTextField();
        JTextField strB1 = new JTextField();
        JTextField strB2 = new JTextField();

        Object[] coefficients = {
            "Input a11:", strA11, "Input a12:", strA12,"Input a21:", strA21,
            "Input a22:", strA22,"Input b1:", strB1,"Input b2:", strB2,
        };
        JOptionPane.showConfirmDialog(null, coefficients, "Input coefficients!" , JOptionPane.OK_CANCEL_OPTION);

        double a11 = Double.parseDouble(strA11.getText());
        double a12 = Double.parseDouble(strA12.getText());
        double a21 = Double.parseDouble(strA21.getText());
        double a22 = Double.parseDouble(strA22.getText());
        double b1 = Double.parseDouble(strB1.getText());
        double b2 = Double.parseDouble(strB2.getText());

        String result;
        if (a11/a21 == a12/a22) {
            if (b1/b2 == a11/a21) {
                result = "Infinitely many solutions";
            } else {
                result = "No solution";
            }
        } else {
            double det = (a11 * a22 - a21 * a12);
            double x = (a22 * b1  - a12 * b2) / det;
            double y = (a11 * b2 - a21 * b1) / det; 
            result = "x = " + x + "\ny = " + y;
        }
        
        JOptionPane.showMessageDialog(null, result, "Result", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
}