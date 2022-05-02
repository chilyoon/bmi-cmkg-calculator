package com.company;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.text.*;


public class Main extends JFrame {
    Container c;
    JLabel lbKG, lblHT;
    JTextField txtKg, txtcm;
    JComboBox cbFt, cbln;
    JPanel p1, p2, p3;
    JButton btnSubmit;

    Main() {
        c = getContentPane();
        c.setLayout(new BoxLayout(c, BoxLayout.Y_AXIS));
        p1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        lbKG = new JLabel("" + "Weight in Kg :");
        txtKg = new JTextField(10);
        p1.add(lbKG);
        p1.add(txtKg);
        c.add(p1);

        p2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        lblHT = new JLabel("" + "Height in cm :");
        txtcm = new JTextField(10);
        p2.add(lblHT);
        p2.add(txtcm);
        c.add(p2);

        p3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnSubmit = new JButton("Calculate");
        p2.add(btnSubmit);
        c.add(p3);
        btnSubmit.addActionListener(new L1());
    }


class L1 implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        if (txtKg.getText().equals("") || txtcm.getText().equals("")) {
            JOptionPane.showMessageDialog(c, "Weight or Height should not be blank");
            txtKg.requestFocus();
            txtcm.requestFocus();
        } else {
            try {
                double weight = Double.parseDouble(txtKg.getText());
                double height = Double.parseDouble(txtcm.getText());
                if (weight <= 0 || height <= 0) {
                    JOptionPane.showMessageDialog(c, "Weight or Height should be greater than 0(Seriously Do you weight or height" +
                            "negavtive?)");
                    txtKg.setText("");
                    txtcm.setText("");
                    txtKg.requestFocus();
                    txtcm.requestFocus();
                }
                else {
                	
                	double m = height / 100;	// 1m = 100cm
                    double bmi = weight / (m * m);


                    String msg;
                    if (bmi < 18.5) msg = "You are underweight";
                    else if (bmi >= 18.5 & bmi < 25) msg = "  Congratulations! .You are normal. Keep up the good work!";
                    else if (bmi >= 25 && bmi < 30) msg = "You are overweight";
                    else msg = "You are Obese";


                    NumberFormat nf = NumberFormat.getInstance();
                    nf.setMaximumFractionDigits(2);
                    String bmis = nf.format(bmi);


                    JOptionPane.showMessageDialog(c, "BMI=" + bmis + msg);
                    txtKg.setText("");
                    txtcm.setText("");

                }
            }

            catch(NumberFormatException error){
                JOptionPane.showMessageDialog(c,"Enter proper weight");
                txtKg.setText("");
                txtcm.setText("");
                txtKg.requestFocus();
                txtcm.requestFocus();
            }
        }
    }
}

    public static void main(String[] args) {
        Main b= new Main();
        b.setSize(300,250);
        b.setVisible(true);
        b.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        b.setTitle("Dope BMI Calculator");
        b.setLocation(300,300);
        b.setResizable(false);
    }

}
