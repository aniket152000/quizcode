import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class OnlineTest extends JFrame implements ActionListener
{
    JLabel l;
    JRadioButton jb[]=new JRadioButton[5];
    JButton b1,b2;
    ButtonGroup bg;
    int count=0,current=0,x=1,y=1,now=0;
    int m[]=new int[10];
    OnlineTest(String s)
    {
        super(s);
        l=new JLabel();
        add(l);
        bg=new ButtonGroup();
        for(int i=0;i<5;i++)
        {
            jb[i]=new JRadioButton();
            add(jb[i]);
            bg.add(jb[i]);
        }
        b1=new JButton("Next");
        b2=new JButton("Bookmark");
        b1.addActionListener(this);
        b2.addActionListener(this);
        add(b1);add(b2);
        set();
        l.setBounds(30,40,450,20);
        jb[0].setBounds(50,80,100,20);
        jb[1].setBounds(50,110,100,20);
        jb[2].setBounds(50,140,100,20);
        jb[3].setBounds(50,170,100,20);
        b1.setBounds(100,240,100,30);
        b2.setBounds(270,240,100,30);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocation(250,100);
        setVisible(true);
        setSize(600,350);
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==b1)
        {
            if(check())
                count=count+1;
            current++;
            set();
            if(current==9)
            {
                b1.setEnabled(false);
                b2.setText("Result");
            }
        }
        if(e.getActionCommand().equals("Bookmark"))
        {
            JButton bk=new JButton("Bookmark"+x);
            bk.setBounds(480,20+30*x,100,30);
            add(bk);
            bk.addActionListener(this);
            m[x]=current;
            x++;
            current++;
            set();
            if(current==9)
                b2.setText("Result");
            setVisible(false);
            setVisible(true);
        }
        for(int i=0,y=1;i<x;i++,y++)
        {
            if(e.getActionCommand().equals("Bookmark"+y))
            {
                if(check())
                    count=count+1;
                now=current;
                current=m[y];
                set();
                ((JButton)e.getSource()).setEnabled(false);
                current=now;
            }
        }

        if(e.getActionCommand().equals("Result"))
        {
            if(check())
                count=count+1;
            current++;
            //System.out.println("correct ans="+count);
            JOptionPane.showMessageDialog(this,"correct ans="+count);
            System.exit(0);
        }
    }
    void set()
    {
        jb[4].setSelected(true);
        if(current==0)
        {
            l.setText("Que1:  Who invented Computer?");
            jb[0].setText("charles babbage");jb[1].setText("Nikola tesla");jb[2].setText("edison");jb[3].setText("albert einstien");
        }
        if(current==1)
        {
            l.setText("Que2:1024 Kilobytes is equal to?");
            jb[0].setText("1 TB");jb[1].setText("1GB");jb[2].setText("1MB");jb[3].setText("100MB");
        }
        if(current==2)
        {
            l.setText("Que3:  Brain of computer is?");
            jb[0].setText("keyboard");jb[1].setText("CPU");jb[2].setText("Mouse");jb[3].setText("speakers");
        }
        if(current==3)
        {
            l.setText("Que4: How many Cricket world cups does India have?");
            jb[0].setText("one");jb[1].setText("two");jb[2].setText("three");jb[3].setText("four");
        }
        if(current==4)
        {
            l.setText("Que5: WWhich is the longest river on the earth?");
            jb[0].setText("Ganga");jb[1].setText("yamuna");jb[2].setText("Amazon");jb[3].setText("Nile");
        }
        if(current==5)
        {
            l.setText("Que6:  Smallest state of India is?");
            jb[0].setText("Kerala");jb[1].setText("Maharastra");jb[2].setText("Goa");jb[3].setText("Sikkim");
        }
        if(current==6)
        {
            l.setText("Que7: National animal of India? ");
            jb[0].setText("Tiger");jb[1].setText("Lion");jb[2].setText("Cow");
            jb[3].setText("Elephant");
        }
        if(current==7)
        {
            l.setText("Que8: When do we celebrate our Independence Day?");
            jb[0].setText("26 jan");jb[1].setText("15 Aug");jb[2].setText("16 Aug");
            jb[3].setText("17 Aug");
        }
        if(current==8)
        {
            l.setText("Que9: Who is the founder of Microsoft?");
            jb[0].setText("Steve Jobs");jb[1].setText("Bill Gates");jb[2].setText("Elon Musk");jb[3].setText("Larry Page");
        }
        if(current==9)
        {
            l.setText("Que10:  In which direction does the sun rise?");
            jb[0].setText("North");jb[1].setText("South");jb[2].setText("East");
            jb[3].setText("West");
        }
        l.setBounds(30,40,450,20);
        for(int i=0,j=0;i<=90;i+=30,j++)
            jb[j].setBounds(50,80+i,200,20);
    }
    boolean check()
    {
        if(current==0)
            return(jb[0].isSelected());
        if(current==1)
            return(jb[2].isSelected());
        if(current==2)
            return(jb[1].isSelected());
        if(current==3)
            return(jb[1].isSelected());
        if(current==4)
            return(jb[3].isSelected());
        if(current==5)
            return(jb[2].isSelected());
        if(current==6)
            return(jb[0].isSelected());
        if(current==7)
            return(jb[3].isSelected());
        if(current==8)
            return(jb[1].isSelected());
        if(current==9)
            return(jb[2].isSelected());
        return false;
    }
    public static void main(String s[])
    {
        new OnlineTest("Test your Knowledge");
    }
}














