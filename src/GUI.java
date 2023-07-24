
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javafx.scene.layout.Border;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Administrator
 */
public class GUI {

    JFrame fr;
    JPanel panBtn, panTf;
    JButton[] btnArr;
    JTextField tfMain, tfSub;
    btnHandler hnd;
    String[] txt;
    Border blackline;
    int btnNo;

    public GUI() {
        initGUI();
    }

    public void initGUI() {
        fr = new JFrame("CALCULATOR");
        fr.setLayout(new BorderLayout());

        panBtn = new JPanel();
        panBtn.setLayout(new GridLayout(4, 5));
        panTf = new JPanel();
        panTf.setLayout(new GridLayout(2, 1));
        panTf.setSize(90, 70);
        panBtn.setBorder(BorderFactory.createLineBorder(java.awt.Color.darkGray, 1));
        //panBtn.setBorder(BorderFactory.createLineBorder(java.awt.Color.BLACK, 0));
        hnd = new btnHandler(this);
        txt = new String[]{"7", "8", "9", "C", "←", "4", "5", "6", "×", "÷", "1", "2", "3", "-", "+", "+/-", "0", ".", "=", "CE"};
        tfMain = new JTextField(40);
        tfMain.setBorder(null);
        tfMain.setBackground(Color.LIGHT_GRAY);
        tfMain.setHorizontalAlignment(JTextField.RIGHT);
        tfMain.setSize(5, 5);
        tfMain.setEditable(false);
        tfMain.setFont(new Font("Arial", Font.BOLD, 40));
        tfSub = new JTextField(40);
        tfSub.setBorder(null);
        tfSub.setHorizontalAlignment(JTextField.RIGHT);
        tfSub.setEditable(false);
        tfSub.setFont(new Font("Arial", Font.PLAIN, 18));
        //tfSub.setBackground(java.awt.Color.lightGray);

        panTf.add(tfSub);
        panTf.add(tfMain);
        tfMain.setText("0");
        tfSub.setBackground(Color.lightGray);
        btnArr = new JButton[20];
        for (int i = 0; i < txt.length; i++) {
            
            btnArr[i] = new JButton(txt[i]);
            btnArr[i].setFont(new Font("Arial", Font.PLAIN, 25));
            btnArr[i].setActionCommand(txt[i]);
           
           btnArr[i].addActionListener((ActionListener) hnd);
            if ( i==0||i == 1 || i == 2 || i == 5 || i == 6 || i == 7 || i == 10 || i ==11||i==12||i==15||i==16||i==17)
                btnArr[i].setBackground(java.awt.Color.white);
            panBtn.add(btnArr[i]);
        }
        fr.add(panTf, BorderLayout.NORTH);
        fr.add(panBtn, BorderLayout.CENTER);
        fr.setSize(450, 500);
        fr.setLocationRelativeTo(null);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setVisible(true);
        fr.setResizable(false);
    }

}