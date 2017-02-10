package com.company;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.text.*;


public class Main extends JFrame {
    Container c;
    JLabel lbKG, lblFt, lblln, lblHT;
    JTextField txtKg;
    JComboBox cbFt, cbln;
    JPanel p1, p2, p3;
    JButton btnSubmit;

    Main() {
        c = getContentPane();
        c.setLayout(new BoxLayout(c, BoxLayout.Y_AXIS));
        p1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        lbKG = new JLabel("" +
                "Weight in Kg:");
        txtKg = new JTextField(10
        );
        p1.add(lbKG);
        p1.add(txtKg);
        c.add(p1);

        p2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        String[] ft = {"1", "2", "3", "4", "5", "6", "7"};
        String[] in = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11"};
        lblHT = new JLabel("Height");
        cbFt = new JComboBox(ft);
        cbln = new JComboBox(in);
        lblFt = new JLabel("Foot");
        lblln = new JLabel("Inch");
        p2.add(lblHT);
        p2.add(lblFt);
        p2.add(lblln);
        p2.add(cbFt);
        p2.add(cbln);
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
        if (txtKg.getText().equals("")) {
            JOptionPane.showMessageDialog(c, "Weight should not be blank");
            txtKg.requestFocus();
        } else {
            try {
                double weight = Double.parseDouble(txtKg.getText());
                if (weight <= 0) {
                    JOptionPane.showMessageDialog(c, "Weight should be greater than 0(Seriously Do you weight " +
                            "negavtive?)");
                    txtKg.setText("");
                    txtKg.requestFocus();
                }
                else {
                    Object ftitem = cbFt.getSelectedItem();
                    String ft = (String) ftitem;
                    int foot = Integer.parseInt(ft);

                    Object lnitem = cbln.getSelectedItem();
                    String ln = (String) ftitem;
                    int Inches = Integer.parseInt(ln);


                    //convert FT to inches
                    while (foot > 0) {
                        Inches += 12;
                        foot--;
                    }
                    double height = Inches * 2.54;

                    double bmi = weight / (height * height);
                    bmi = bmi * 10000;


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
                    cbFt.setSelectedItem("1");
                    cbln.setSelectedItem("0");


                }
            }

            catch(NumberFormatException error){
                JOptionPane.showMessageDialog(c,"Enter proper weight");
                txtKg.setText("");
                txtKg.requestFocus();;
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
