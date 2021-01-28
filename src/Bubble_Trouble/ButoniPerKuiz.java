package Bubble_Trouble;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButoniPerKuiz extends JButton implements ActionListener {

    private Kuizi k;

    public ButoniPerKuiz(String my_label, Kuizi kuizi) {
        super(my_label);
        addActionListener(this);
        k = kuizi;

    }

    public void actionPerformed(ActionEvent event) {
        k.shfaqeKuizin();
    }

    public void setKuizi(Kuizi kuizi) {
        k = kuizi;
    }
}
