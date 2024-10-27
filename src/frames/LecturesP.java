package frames;

import ConnectorP.Performcollection;
import database.User;
import database.collections;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class LecturesP extends JPanel implements  ActionListener{
    Resuables designl;
    public JLabel venl;
    public Font robotoFont;

    JTable table;

    public JLabel logo;

    DefaultTableModel model;

    public collections DB;


    public JPanel display;



    JTextField firstname;


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
    JLabel courselable;
    JTextField course;













    public JButton addbtn;




    private Performcollection control;
    public JPanel lpanel;
    public JPanel rpanel;



    public LecturesP() throws Exception {
        ClassLoader cl= this.getClass().getClassLoader();

        designl=new Resuables();
        /*    fonts  **/

        robotoFont = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("fonts/RobotoCondensed-Regular.ttf"));


        model=new DefaultTableModel();

        collections DB=new collections();
        model=new DefaultTableModel(0,0);

        model.addColumn("Firstname");
        model.addColumn("Lastname");
        model.addColumn("Username");
        model.addColumn("Course");
        table=new JTable(model);

        table.setDefaultRenderer(Object.class,new RoundedBorderTableCellRenderer());
        table.getTableHeader().setDefaultRenderer(new CustomTableHeaderRenderer());
        table.setBorder(new RoundedBorder(20));

        refresh();

        URL dirr=cl.getResource("frames/icons/shop.png");
        ImageIcon icon6=new ImageIcon(dirr);
        Image adds = icon6.getImage().getScaledInstance(60 ,50, Image.SCALE_DEFAULT);
        ImageIcon log=new ImageIcon(adds);

        logo=new JLabel();
        logo.setIcon(log);
        addbtn=new JButton("Add Lecturer");






        firstname=new JTextField();
        firstnamel=new JLabel("Firstname");
        lastname=new   JTextField();
        lastnamel=new  JLabel("Lastname");
        accounttypel=new JLabel("Account Type");
        typeaccount=new DefaultComboBoxModel();
        username=new JTextField();
        usernamel=new JLabel("Username") ;
        passwordField=new JPasswordField();
        comfirmpass=new JPasswordField();
        passl=new JLabel("Password");
        comfirml=new JLabel("Comfirm Password");
        courselable=new JLabel("Course");
        course =new JTextField();



/** fonts **/














        ldesign(addbtn);
        control=new Performcollection();
        GridBagLayout gb=new GridBagLayout();
        GridBagLayout tg=new GridBagLayout();
        rpanel=new JPanel(tg);
        lpanel=new JPanel(gb);
        BorderLayout bl=new BorderLayout();
        setLayout(bl);

        setBackground(new Color(211, 219, 214));

        BorderLayout tbl=new BorderLayout();


/**   adding Jpanels left and right   ----------------------------------------------------------------   */
        add(lpanel,BorderLayout.WEST);

        lpanel.setPreferredSize(new Dimension(300,300));
        add(rpanel,BorderLayout.CENTER);


        rpanel. setBackground(new Color(211, 219, 214));

        rpanel.setPreferredSize(new Dimension(880,500));


        lpanel.setBorder(new CompoundBorder(new EmptyBorder(10,10,10,10),new RoundedBorder(10)));



/**     ALIGNING LABLES IN LEFT PANEL---------------------------------------------------------------------*/

        GridBagConstraints gbl=new GridBagConstraints();
        gbl.anchor=GridBagConstraints.FIRST_LINE_START;


        gbl.gridy=7;
        lpanel.add(firstnamel,gbl);
        gbl.gridy=8;
        lpanel.add(firstname,gbl);
        gbl.gridy=9;

        lpanel.add(lastnamel,gbl);
        gbl.gridy=10;
        lpanel.add(lastname,gbl);
        gbl.gridy=11;

        lpanel.add(usernamel,gbl);
        gbl.gridy=12;
        lpanel.add(username,gbl);
        gbl.gridy=13;
        lpanel.add(courselable,gbl);

        gbl.gridy=14;
        lpanel.add(course,gbl);
        gbl.gridy=15;

        lpanel.add(passl,gbl);
        gbl.gridy=17;
        lpanel.add(passwordField,gbl);
        gbl.insets=new Insets(10,0,10,0);




        gbl.gridy=18;

        gbl.insets=new Insets(10,0,0,0);
        lpanel.add(comfirml,gbl);

        gbl.gridy=19;

        lpanel.add(comfirmpass,gbl);
        gbl.gridy=20;
        lpanel.add(addbtn,gbl);




/*** --------------------------------------------------------------------------------------------------------- */
        setBackground(new Color(211, 219, 214));

        designl.Field(firstname);
        designl.Field(lastname);
        designl.Field(username);
        designl.Field(course);
        designl.Field(passwordField);
        designl.Field(comfirmpass);
        designl.buttdesign(addbtn);
        designl.lables(firstnamel,new Color(6, 60, 69));
        designl.lables(lastnamel,new Color(6, 60, 69));
        designl.lables(usernamel,new Color(6, 60, 69));
        designl.lables(courselable,new Color(6, 60, 69));
        designl.lables(comfirml,new Color(6, 60, 69));
        lpanel.setOpaque(false);
        rpanel.setOpaque(false);


        lpanel.setForeground(new Color(170, 169, 176));
        rpanel.setForeground(new Color(170, 169, 176));

        rpanel.setLayout(tbl);
        DB.connect();
        DB.getlectures();
        model.setRowCount(0);
        for (User lecturer: DB.getlectu()) {


            model.addRow(new Object[]{lecturer.getFirstname(), lecturer.getLastname(),
                    lecturer.getUsername(),lecturer.getcourse()});
        }

/********** Actions *************************************************************/



        addbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
Performcollection controller=new Performcollection();
                try {
                    String fn=firstname.getText();
                    String ln=lastname.getText();
                    String usern=username.getText();
                    Integer cours= Integer.parseInt(course.getText());

                    char [] passf= passwordField.getPassword();
                    char [] passc= comfirmpass.getPassword();
                    String passw=new String(passf);
                    String passwc=new String(passc);
                    if(!passwc.isEmpty()){
                        if(passwc.matches(passw)){
                            controller.getusers().clear();
                            controller.adduserC(new User(fn,ln,usern,"Lecturer",passw,cours));
                            DB.connect();
                            DB.getlectures();
                            model.setRowCount(0);
                            for (User lecturer: DB.getlectu()) {

                                model.addRow(new Object[]{lecturer.getFirstname(), lecturer.getLastname(),
                                        lecturer.getUsername(),lecturer.getcourse()});
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

        /***  RIGHT PANEL DESIGN TABLE  **/
        Border bd=new EmptyBorder(50,50,50,50);


        table.setBorder(bd);
        JScrollPane spt=new JScrollPane(table);
        spt.setBorder(bd);
        rpanel.add(spt,BorderLayout.CENTER);
    }




    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.print("ok button working");
    }





    private class RoundedBorderTableCellRenderer extends DefaultTableCellRenderer {

        private final Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
        private final int borderRadius = 10;

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                       boolean hasFocus, int row, int column) {
            Component rendererComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);


            setOpaque(true);
            setForeground(new Color(57, 60, 61));
            setBackground(new Color(211, 219, 214));
            setFont(robotoFont.deriveFont(Font.BOLD,12f));

            setHorizontalAlignment(CENTER);
            // Set the rounded border for the ce
            // ll renderer component
            ((JComponent) rendererComponent).setBorder(BorderFactory.createEmptyBorder());

            return rendererComponent;
        }
    }



    private class CustomTableHeaderRenderer extends JLabel implements TableCellRenderer {

        public CustomTableHeaderRenderer() {
            setOpaque(true);
            setForeground(Color.WHITE);
            setBackground(Color.GRAY);
            setHorizontalAlignment(CENTER);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                       boolean hasFocus, int row, int column) {
            setText(value.toString());
            return this;
        }
    }
    public void design(JTextField P){
        P.setPreferredSize(new Dimension(230,30));
        Border borderd= BorderFactory.createMatteBorder(0, 0, 3, 0, new Color(102, 237, 237));

        P.setBorder(borderd);
        P.setBackground(new Color(223, 242, 239));
    }
    private static class RoundedBorder implements Border {

        private int radius;


        RoundedBorder(int radius) {
            this.radius = radius;
        }


        public Insets getBorderInsets(Component c) {
            return new Insets(this.radius+1, this.radius+1, this.radius+2, this.radius);
        }


        public boolean isBorderOpaque() {
            return true;
        }


        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            g.drawRoundRect(x, y, width-1, height-1, radius, radius);
        }

    }
    public void refresh(){
        model.fireTableDataChanged();

    }
    public void ldesign(JButton b){
        b.setBackground(new Color(156, 121, 252));
        b.setPreferredSize(new Dimension(220,30));
        b.setBorder(new RoundedBorder(20));
        b.setOpaque(false);
        b.setFocusPainted(false);
    }
}