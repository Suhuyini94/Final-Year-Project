package frames;

import ConnectorP.Performcollection;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import java.sql.SQLException;

public class Appsettings extends JFrame {
boolean appsetdone=false;
    Signup signup;
    login logs;
    ClassLoader cl = this.getClass().getClassLoader();
    URL dirr1 = cl.getResource("frames/icons/stack.png");
    ImageIcon icon7 = new ImageIcon(dirr1);
    Image minuss = icon7.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT);
    ImageIcon stac = new ImageIcon(minuss);
    CardLayout card;
    JPanel pan;
    JPanel pan1;
    JButton submit;

    private Performcollection controller;




    Appsettings() throws Exception {

        super("Institution Setup");

        /**  ***********  IMPORT PAGES ****************************************************************/

        signup=new Signup();
        logs=new login();
        controller = new Performcollection();
        controller.getAllusers();


        ClassLoader cl = this.getClass().getClassLoader();
        card = new CardLayout();
        pan1 = new JPanel(card);



        pan1.setBackground(new Color(3, 148, 252));



        pan1.add(signup, "signup");

        add(pan1, BorderLayout.CENTER);
        setIconImage(stac.getImage());
        card.show(pan1,"signup");

        if(controller.getAllusers().size() >0){

               logs.setSize(600,500);
               logs.setVisible(true);
                logs.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                this.setVisible(false);

        }

    }

}