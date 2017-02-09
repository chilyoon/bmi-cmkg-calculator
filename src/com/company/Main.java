package com.company;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.text.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }
}

class B1 extends JFrame{
    Container c;
    JLabel lbKG,lblFt,lblln,lblHT;
    JTextField txtKg;
    JComboBox cbFt,cbln;
    JPanel p1,p2,p3;
    JButton btnSubmit;

    B1(){
        c=getContentPane();
        c.setLayout(new BoxLayout(c,BoxLayout.Y_AXIS));
        p1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        lbKG=new JLabel("" +
                "Weight in Kg:");
        txtKg= new JTextField(10
        );
        p1.add(lbKG);
        p1.add(txtKg);
        c.add(p1);

        p2= new JPanel(new FlowLayout(FlowLayout.LEFT));
        String[]ft={"1","2","3","4","5","6","7"};
        String[]in={"0","1","2","3","4","5","6","7","8","9","10","11"};
        lblHT= new JLabel("Height");
        cbFt= new JComboBox(ft);
        cbln= new JComboBox(in);
        lblFt= new JLabel("Foot");
        lblln= new JLabel("Inch");
        p2.add(lblHT);
        p2.add(lblFt);
        p2.add(lblln);
        p2.add(cbFt);
        p2.add(cbln);
        c.add(p2);

        p3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnSubmit= new JButton("Calculate");
        p2.add(btnSubmit);
        c.add(p3);
    }
}
