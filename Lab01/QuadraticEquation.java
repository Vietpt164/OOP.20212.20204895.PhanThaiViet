import javax.swing.*;
import java.lang.Math;
public class QuadraticEquation {
    public static void main(String[] args) {
        JTextField strA = new JTextField();
        JTextField strB = new JTextField();
        JTextField strC = new JTextField();

        Object[] coefficients = {
            "Input A:", strA, 
            "Input B:", strB,
            "Input C:", strC,
        };
        JOptionPane.showConfirmDialog(null, coefficients, "Input coefficients!" , JOptionPane.OK_CANCEL_OPTION);

        double a = Double.parseDouble(strA.getText());
        double b = Double.parseDouble(strB.getText());
        double c = Double.parseDouble(strC.getText());
        double delta = b * b - 4.0 * a * c;
        if (a == 0) {
            JOptionPane.showMessageDialog(null, "Wrong input!", "Message", JOptionPane.INFORMATION_MESSAGE);
        } else {
            if (delta < 0){
                JOptionPane.showMessageDialog(null, "Roots are not real!", "Result", JOptionPane.INFORMATION_MESSAGE);
            } else if (delta == 0) {
                double r1 = -b / (2.0 * a);  
                JOptionPane.showMessageDialog(null, "The root is " + r1, "Result", JOptionPane.INFORMATION_MESSAGE);
            } else {
                double r1 = (-b + Math.pow(delta, 0.5)) / (2.0 * a);  
                double r2 = (-b - Math.pow(delta, 0.5)) / (2.0 * a);  
                JOptionPane.showMessageDialog(null, "The roots are " + r1 + " and " + r2, "Result", JOptionPane.INFORMATION_MESSAGE);
            }
        }

    }
}