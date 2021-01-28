package Bubble_Trouble;

import javax.swing.*;

public class Kuizi extends JFrame  {

    private int a,b;
    private int opsioni_i_sakt;
    private int opsionet_tjera[]=new int[3];
    private JLabel label1=new JLabel();
    private JLabel label2=new JLabel();
    private int rez_mbledhja;
    private int rez_shumzimi;
    private Buttonat[] butonat_per_mbledhje;
    private int mundsit_per_mbledhje=1;            // Sa her ka drejt lojtari me provu zgjidhjen
    private Buttonat[] butonat_per_shumzim;
    private   int mundsit_per_shumzim=1;

    public Kuizi(Player player)
    {
        setSize(850,400);
        setLocation(200,200);
        setLayout(null);
        a= (int)(Math.random()*10);
        b= (int)(Math.random()*10);
        rez_mbledhja=a+b;
        label1.setText(a+" + "+b+" =");
        label1.setBounds(180,100,50,20);
        add(label1);
        butonat_per_mbledhje=new Buttonat[4];
         inicializo_butonat(butonat_per_mbledhje,a+b,"+",20,player);
         inicializo_opsionet(butonat_per_mbledhje,a+b,20);
        a= (int)(Math.random()*10);
        b= (int)(Math.random()*10);
        butonat_per_shumzim=new Buttonat[4];
        inicializo_butonat(butonat_per_shumzim,a*b,"*",480,player);
        inicializo_opsionet(butonat_per_shumzim,a*b,100);
        rez_shumzimi=a*b;
        label2.setText(a+" * "+b+" =");
        label2.setBounds(620,100,50,20);
        add(label2);
        setVisible(false);

    }
    public void inicializo_butonat(Buttonat button[],int rezultati_i_sakt,String operatori,int piknisja,Player player)
    {
        for (int i=0;i<4;i++)
        {
            button[i]=new Buttonat(rezultati_i_sakt,operatori,player,this);
            button[i].setBounds(piknisja+80*i,300,90,40);
            add(button[i]);
        }
    }
    public void inicializo_opsionet(Buttonat []buttons,int rezultati,int max)
    {
      int zgjidhja_e_sakt=(int)(Math.random()*4);
      int []zgjedhjet_e_gabuara=new int[3];
      for (int i=0;i<4;i++)
      {
          if (i==zgjidhja_e_sakt)
          {
              buttons[zgjidhja_e_sakt].setText(""+rezultati);
          }
          else { int vlera_e_butonit=(int)(max*Math.random());
               if (vlera_e_butonit==rezultati)
                   vlera_e_butonit++;
              buttons[i].setText(""+vlera_e_butonit);
          }
      }
    }
    public void shfaqeKuizin()
    {
        setVisible(true);
    }
       public void setMundsit_per_mbledhje()
       {
           mundsit_per_mbledhje--;
       }
       public int getMundsit_per_mbledhje()
       {return mundsit_per_mbledhje;}

       public void setMundsit_per_shumzimn()
       {
           mundsit_per_shumzim--;
       }
       public int getMundsit_per_shumzim()
       { return mundsit_per_shumzim;}
}
