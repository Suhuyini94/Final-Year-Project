package frames;
import ConnectorP.Performcollection;
import database.User;
import database.collections;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Signup  extends JPanel {
    JTextField firstname;
    public Font robotoFont;

    JLabel firstnamel;
    JComboBox accounttype;
    DefaultComboBoxModel typeaccount;
    JLabel intro;
    JTextField lastname;
    JLabel lastnamel;


    JLabel accounttypel;
    JTextField username;
    JLabel usernamel;
    JPasswordField passwordField;
    JPasswordField comfirmpass;
    JLabel passl;
    JLabel comfirml;
    JButton submit;
    JButton Continue;
    JLabel numberUsers;
    JLabel registeredcount;
    Performcollection controller;


    Signup() throws Exception {

controller=new Performcollection();
        collections db=new collections();




        Resuables utils=new Resuables();

        robotoFont = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("fonts/RobotoCondensed-Regular.ttf"));
        intro=new JLabel("Setup Your new Instutition");
        intro.setFont(robotoFont.deriveFont(Font.BOLD,20f));
        accounttype=new JComboBox();
        accounttype.setPreferredSize(new Dimension(220,30));
        submit=new JButton("Register");
        Continue=new JButton("Continue");
        numberUsers=new JLabel("Number of Registered Users");
        firstname=new JTextField(20);
        firstnamel=new JLabel("Firstname");
      lastname=new   JTextField(20);
      lastnamel=new  JLabel("Lastname");
     accounttypel=new JLabel("Account Type");
     typeaccount=new DefaultComboBoxModel();
     typeaccount.addElement("Administrator");
        typeaccount.addElement("Lecturer");
        accounttype.setModel(typeaccount);
     username=new JTextField(20);
     usernamel=new JLabel("Username") ;
     passwordField=new JPasswordField(20);
     comfirmpass=new JPasswordField(20);
     passl=new JLabel("Password");
     comfirml=new JLabel("Comfirm Password");
        registeredcount=new JLabel("0");
     GridBagLayout gb=new GridBagLayout();
     setLayout(gb);
     GridBagConstraints grid=new GridBagConstraints();
        grid.anchor=GridBagConstraints.FIRST_LINE_START;
        grid.insets=new Insets(0,0,20,0);
     grid.gridx=0;
     grid.gridy=0;
     add(intro,grid);

        setBackground(new Color(201, 235, 240));
        setFont(robotoFont.deriveFont(Font.BOLD,12f));











        grid.gridx=0;
        grid.gridy=1;
        add(firstnamel,grid);
        grid.gridx=2;
        add(firstname,grid);




        grid.gridy=2;
        grid.gridx=0;
        add(lastnamel,grid);
        grid.gridx=2;
        add(lastname,grid);


        grid.gridy=3;
        grid.gridx=0;
        add(usernamel,grid);
        grid.gridx=2;
        add(username,grid);



        grid.gridy=4;
        grid.gridx=0;
        add(accounttypel,grid);
        grid.gridx=2;
        add(accounttype,grid);

        grid.gridy=5;
        grid.gridx=0;
        add(passl,grid);
        grid.gridx=2;
        add(passwordField,grid);


        grid.gridy=6;
        grid.gridx=0;
        add(comfirml,grid);
        grid.gridx=2;
        add(comfirmpass,grid);


        grid.gridy=7;
        grid.gridx=0;
        add(submit,grid);
        grid.gridy=8;
        grid.gridx=0;
        add(Continue,grid);
        grid.gridy=9;
        grid.gridx=0;
        add(numberUsers,grid);
        grid.gridy=9;
        grid.gridx=1;
        add(registeredcount,grid);
        utils.Field(firstname);
        utils.Field(lastname);
        utils.Field(username);

        utils.Field(comfirmpass);
        utils.Field(passwordField);
utils.buttdesign(Continue);
utils.buttdesign(submit);
        utils.lables(firstnamel,new Color(6, 60, 69));
        utils.lables(lastnamel,new Color(6, 60, 69));
        utils.lables(usernamel,new Color(6, 60, 69));
        utils.lables(accounttypel,new Color(6, 60, 69));  utils.lables(passl,new Color(6, 60, 69));
        utils.lables(comfirml,new Color(6, 60, 69));
        utils.lables(numberUsers,new Color(6, 60, 69));
        accounttype.setSelectedItem("Administrator");
registeredcount.setText(String.valueOf(controller.getAllusers().size()));

if(controller.getAllusers().size()<1){
    Continue.setEnabled(false);
}else {
    Continue.setEnabled(true);
}
Continue.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        login   logs = null;
        try {
            logs = new login();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        try {

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        logs.setSize(600,500);
        logs.setVisible(true);
        logs.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Window window = SwingUtilities.windowForComponent(Continue);
        if (window instanceof JFrame) {
            JFrame frame = (JFrame) window;
            frame.dispose();
        }

    }
});
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                   String fn=firstname.getText();
                   String ln=lastname.getText();
                   String usern=username.getText();
                   String accountn=(String) accounttype.getSelectedItem();
                 char [] passf= passwordField.getPassword();
                    char [] passc= comfirmpass.getPassword();
                 String passw=new String(passf);
                    String passwc=new String(passc);

                    if(!passwc.isEmpty()){
                        if(passwc.matches(passw)){
                            controller.getusers().clear();


                         controller.adduserC(new User(fn,ln,usern,accountn,passw));
                       registeredcount.setText(String.valueOf(controller.getAllusers().size()));
                       if(accountn.matches("Administrator")){
                           Continue.setEnabled(true);
                       }


                            JOptionPane.showMessageDialog(null,"Account registered");
                        }else {
                            JOptionPane.showMessageDialog(null,"Password doest match");
                        }

                    }

                 System.out.println(passw);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }




            }
        });


    }



    private String encryptPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] encodedHash = digest.digest(password.getBytes(StandardCharsets.UTF_8));

            StringBuilder hexString = new StringBuilder();
            for (byte b : encodedHash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

}
