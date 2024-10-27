package frames;

import ConnectorP.Performcollection;
import database.User;
import database.collections;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.Stack;

public class login extends JFrame {
    boolean appsetdone=false;
    Signup signup;
    login logs;
    JLabel logo;
    JComboBox accounttype;
    DefaultComboBoxModel typeaccount;
    JLabel intro;
    JTextField lastname;
    JLabel lastnamel;
    public Stack<User> myuser;

    JLabel accounttypel;
    JTextField username;
    JLabel usernamel;
    JPasswordField passwordField;
    JPasswordField comfirmpass;
    JLabel passl;
    JLabel comfirml;
    JButton submit;
    JButton Continue;
    Performcollection controller;
    public Stack<User> getmylogd(){
        return myuser;
    }
    public void addlogs(User u){
      myuser.push(u);
    }
    login() throws Exception {
        super("Panel Login");
myuser=new Stack<>();
        ClassLoader cl = this.getClass().getClassLoader();
        URL dirr1 = cl.getResource("frames/icons/userss.png");
        ImageIcon icon7 = new ImageIcon(dirr1);
        Image minuss = icon7.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT);
        ImageIcon uicon = new ImageIcon(minuss);
GridBagLayout gridl=new GridBagLayout();
setLayout(gridl);
        /**  ***********  IMPORT PAGES ****************************************************************/
        controller = new Performcollection();

        GridBagConstraints grid=new GridBagConstraints();

        Resuables utils=new Resuables();

        intro=new JLabel("Login Window");
        utils.lables(intro,new Color(6, 60, 69));
        accounttype=new JComboBox();
        accounttype.setPreferredSize(new Dimension(220,30));
        submit=new JButton("Sign In");
        logo=new JLabel("");
        logo.setIcon(uicon);
        username=new JTextField(20);
        usernamel=new JLabel("Username") ;
        passwordField=new JPasswordField(20);
        comfirmpass=new JPasswordField(20);
        passl=new JLabel("Password");
        comfirml=new JLabel("Comfirm Password");
        GridBagLayout gb=new GridBagLayout();
        setLayout(gb);
        grid.anchor=GridBagConstraints.FIRST_LINE_START;
        grid.insets=new Insets(0,0,20,0);
        grid.gridx=1;
        grid.gridy=0;
        add(logo,grid);

        setBackground(new Color(201, 235, 240));
        grid.gridx=0;
        grid.gridy=1;
        add(usernamel,grid);
        grid.gridx=2;
        add(username,grid);
        grid.gridy=2;
        grid.gridx=0;
        add(passl,grid);
        grid.gridx=2;
        add(passwordField,grid);







        grid.gridy=4;
        grid.gridx=0;
        add(submit,grid);



        utils.Field(username);

        utils.Field(comfirmpass);
        utils.Field(passwordField);
        utils.buttdesign(submit);
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usern=username.getText();
                char [] passf= passwordField.getPassword();

                String passw=new String(passf);

                if(!passw.isEmpty()) {


                    try {

                        controller.loginP(usern,passw);
                        if(controller.getlogU().size() >0){

                            for(User u:controller.getlogU()){

                                addlogs(new User(u.getId(),u.getFirstname(),u.getLastname(),u.getUsername(),u.getAccount()));


                            }
                            MainFrame main=new MainFrame(myuser);
                            main.setSize(1200,700);
                            main.setVisible(true);
                            main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                            main.addlogs(myuser);
                            collections DB=new collections();




                            Window window = SwingUtilities.windowForComponent(submit);
                            if (window instanceof JFrame) {
                                JFrame frame = (JFrame) window;
                                frame.dispose();

                            }

                        }
                        else {
                            JOptionPane.showMessageDialog(null,"Permission denied");
                        }




                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                }


                    else {
                        JOptionPane.showMessageDialog(null,"Wrong credentials");

                    }
                    }





        });

    }


}