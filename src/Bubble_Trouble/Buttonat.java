package Bubble_Trouble;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public  class Buttonat extends JButton implements ActionListener {

        private int rezultati_i_sakt;
        private Player p;
        private String o;
        private Kuizi k ;


    public Buttonat(int rezultati_i_sakt,String operatori,Player player,Kuizi kuizi) {
        super("");
        p=player;
        k=kuizi;
        addActionListener(this);

        this.rezultati_i_sakt=rezultati_i_sakt;
        setFocusable(false);
        o=operatori;
    }
    public  void actionPerformed(ActionEvent event)
    {


          if (Integer.parseInt(getText().trim())==rezultati_i_sakt)
          {
              setBackground(Color.green);
              if (o=="+" && k.getMundsit_per_mbledhje()==1)
              { p.shtoJetet(1);
                 k.setMundsit_per_mbledhje();}
              else {
                  if (k.getMundsit_per_shumzim()==1 && o=="*") {
                      p.shtoJetet(3);
                      k.setMundsit_per_shumzimn();
                  }
              }
          }
          else {
               setBackground(Color.red);
               if (o=="+")
               {
                   k.setMundsit_per_mbledhje();
               }
               else {
                  k.setMundsit_per_shumzimn();
               }
          }

      }

}
