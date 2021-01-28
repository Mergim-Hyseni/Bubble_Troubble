package Bubble_Trouble;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExitButton extends JButton implements ActionListener {

    public ExitButton(String n)
    {
        super(n);
        addActionListener(this);

    }
    public static void main(String[] args) {

    }
    public void actionPerformed(ActionEvent a)
    {
        System.exit(0);
    }

}
