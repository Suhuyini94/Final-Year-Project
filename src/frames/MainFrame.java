package frames;

import ConnectorP.Performcollection;
import database.User;
import database.collections;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import java.util.Stack;

public class MainFrame extends JFrame implements MouseListener {
    public Stack<User> myuser;

    ClassLoader cl= this.getClass().getClassLoader();
    URL dirr1=cl.getResource("frames/icons/doc.png");
    ImageIcon icon7=new ImageIcon(dirr1);
    Image minuss = icon7.getImage().getScaledInstance(40 ,40, Image.SCALE_DEFAULT);
    ImageIcon stac=new ImageIcon(minuss);
    CardLayout card;
    JPanel pan;
    JPanel pan1;
    JPanel pan2;

    collections database;







    JLabel lb1;
    JLabel userf;
    JLabel userl;
    JLabel Dashbord;
    JLabel lb2;
    JLabel lb3;
    JLabel lb4;
    JLabel lb5;
    JLabel lb6;
    JLabel spacc;
    JLabel spacc1;
    Resuables resuables;
    JLabel spacc2;
    JLabel spacc3;
    JLabel spacc4;
    Border borderl;
    Border margin;
    JLabel issuer;
    public Stack<User> addlogs(Stack u){
        this.myuser=u;
        return myuser;
    }
    private Performcollection controller;
    MainFrame(Stack userd) throws Exception {
        super("Attendance Monitor");

        /**  ***********  IMPORT PAGES ****************************************************************/
resuables=new Resuables();

        Resuables utils=new Resuables();
        ClassLoader cl = this.getClass().getClassLoader();
        URL dirr1 = cl.getResource("frames/icons/userss.png");
        ImageIcon icon7 = new ImageIcon(dirr1);
        Image minuss = icon7.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT);
        ImageIcon uicon = new ImageIcon(minuss);



        myuser=new Stack<>();
        database=new collections();
        newStudent vendorp=new newStudent();

        viewBill_p viewb=new viewBill_p();

        ViewAttendanceRecord viewattendance=new ViewAttendanceRecord();

        LecturesP lecturesPanel=new LecturesP();
        DepartmentP departmentPanel=new DepartmentP();
        TakeAttendance studentPanel=new TakeAttendance();
        courseP coursePanel=new courseP();
      controller=new Performcollection();

        pan =new JPanel(   new FlowLayout(FlowLayout.CENTER));
        pan2 =new JPanel();
        card =new CardLayout();
        pan1 =new JPanel(card);
        /** label tabs*/
        spacc=new JLabel("           ");
        spacc1=new JLabel("           ");
        spacc2=new JLabel("           ");
        spacc3=new JLabel("           ");
        spacc4=new JLabel("           ");
        issuer=new JLabel("");
        issuer.setIcon(uicon);
userf=new JLabel("");
userl=new JLabel("");
Dashbord=new JLabel("My Dashboard");

myuser=userd;

for(User u:myuser)
{
    System.out.println(u.getAccount());

    userl.setText(u.getFirstname());
    userf.setText(u.getLastname());
}







        lb1=new JLabel("  Students Enrollment",JLabel.LEFT);
        lb2=new JLabel("  Take Attendance",JLabel.CENTER);
        lb3=new JLabel("Attendance Report",JLabel.CENTER);
        lb4=new JLabel("Department",JLabel.CENTER);
        lb5=new JLabel("Courses",JLabel.CENTER);
        lb6=new JLabel("Lectures",JLabel.CENTER);



        borderl=BorderFactory.createMatteBorder(1,1,1,1,new Color(204, 200, 207 ));
        margin = new EmptyBorder(10,10,10,10);
        lb1.addMouseListener(this);
        lb2.addMouseListener(this);
        lb3.addMouseListener(this);
        lb4.addMouseListener(this);
        lb5.addMouseListener(this);
        lb6.addMouseListener(this);
        lb1.setForeground(Color.WHITE);
        lb1.setBorder( new CompoundBorder(borderl,margin));
        lb2.setForeground(Color.WHITE);
        lb3.setForeground(Color.WHITE);
        lb1.setBorder(new EmptyBorder(0,30,0,30));
        lb2.setBorder(new EmptyBorder(0,30,0,30));
        lb3.setBorder(new EmptyBorder(0,30,0,30));
        lb4.setBorder(new EmptyBorder(0,30,0,30));
        lb5.setBorder(new EmptyBorder(0,30,0,30));
        lb6.setBorder(new EmptyBorder(0,30,0,30));
        setLayout(new BorderLayout());
        pan.add(issuer);
pan.add(userf);
        pan.add(spacc);
pan.add(userl);


        pan.add(lb1);
        pan.add(lb2);
        pan.add(lb3);
        pan.add(lb4);
        pan.add(lb5);
        pan.add(lb6);



        pan.setBackground(utils.getpanalcolor());

        add(pan,BorderLayout.PAGE_START);
        pan1.add(vendorp,"pan1");
        pan1.add(viewattendance,"pan3");
        pan1.add(studentPanel,"pan2");
        pan1.add(departmentPanel,"pan4");
        pan1.add(coursePanel,"pan5");
        pan1.add(lecturesPanel,"pan6");




        add(pan1,BorderLayout.CENTER);
        setIconImage(stac.getImage());

resuables.lables(userf,new Color(227, 227, 227));


        resuables.lables(userl,new Color(106, 0, 133));
        resuables.lables(Dashbord,new Color(106, 0, 133));
        resuables.lables(lb1,new Color(106, 0, 133));
        resuables.lables(lb2,new Color(106, 0, 133));
        resuables.lables(lb3,new Color(106, 0, 133));
        resuables.lables(lb4,new Color(106, 0, 133));
        resuables.lables(lb5,new Color(106, 0, 133));
        resuables.lables(lb6,new Color(106, 0, 133));


userf.setForeground(Color.white);
        userl.setForeground(Color.white);
        Dashbord.setForeground(Color.white);

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getSource()==lb1){
            lb1.setBorder(new CompoundBorder(borderl,margin));
            lb1.setForeground(new Color(92, 75, 105));
            lb2.setForeground(new Color(106, 0, 133));
            lb3.setForeground(new Color(106, 0, 133));
            lb5.setForeground(new Color(106, 0, 133));
            lb6.setForeground(new Color(106, 0, 133));
            lb4.setForeground(new Color(106, 0, 133));
            lb4.setBorder(margin);
            lb2.setBorder(margin);
            lb3.setBorder(margin);

            lb5.setBorder(margin);
            lb6.setBorder(margin);
            card.show(pan1,"pan1");




        }

        else if(e.getSource()==lb2){
            lb2.setBorder(new CompoundBorder(borderl,margin));
            lb2.setForeground(new Color(92, 75, 105));
            lb1.setForeground(new Color(106, 0, 133));
            lb3.setForeground(new Color(106, 0, 133));
            lb5.setForeground(new Color(106, 0, 133));
            lb6.setForeground(new Color(106, 0, 133));
            lb1.setBorder(margin);
            lb3.setBorder(margin);
            lb5.setBorder(margin);
            lb6.setBorder(margin);
            lb4.setForeground(new Color(106, 0, 133));
            lb4.setBorder(margin);
            card.show(pan1,"pan2");

        }
        else if(e.getSource()==lb3){
            lb3.setBorder(new CompoundBorder(borderl,margin));
            lb3.setForeground(new Color(92, 75, 105));
            lb1.setForeground(new Color(106, 0, 133));
            lb2.setForeground(new Color(106, 0, 133));
            lb5.setForeground(new Color(106, 0, 133));
            lb6.setForeground(new Color(106, 0, 133));
            lb4.setForeground(new Color(106, 0, 133));
            lb4.setBorder(margin);
            try {
                controller.connect();
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }





            lb2.setBorder(margin);
            lb1.setBorder(margin);

            lb5.setBorder(margin);
            lb6.setBorder(margin);
            card.show(pan1,"pan3");
        }

        else if(e.getSource()==lb4){
            lb1.setForeground(new Color(106, 0, 133));
            lb3.setForeground(new Color(106, 0, 133));
            lb2.setForeground(new Color(106, 0, 133));
            lb6.setForeground(new Color(106, 0, 133));
            lb4.setForeground(new Color(92, 75, 105));
            lb4.setBorder(new CompoundBorder(borderl,margin));
            lb2.setBorder(margin);
            lb3.setBorder(margin);
            lb5.setForeground(new Color(106, 0, 133));
            lb5.setBorder(margin);
            lb1.setBorder(margin);
            lb6.setBorder(margin);
            card.show(pan1,"pan4");
        }
        else if(e.getSource()==lb5){
            lb1.setForeground(new Color(106, 0, 133));
            lb3.setForeground(new Color(106, 0, 133));
            lb2.setForeground(new Color(106, 0, 133));
            lb6.setForeground(new Color(106, 0, 133));
            lb5.setForeground(new Color(92, 75, 105));
            lb5.setBorder(new CompoundBorder(borderl,margin));
            lb2.setBorder(margin);
            lb3.setBorder(margin);
            lb4.setForeground(new Color(106, 0, 133));
            lb4.setBorder(margin);
            lb1.setBorder(margin);
            lb6.setBorder(margin);
            card.show(pan1,"pan5");
        }
        else if(e.getSource()==lb6){
            lb1.setForeground(new Color(106, 0, 133));
            lb3.setForeground(new Color(106, 0, 133));
            lb5.setForeground(new Color(106, 0, 133));
            lb2.setForeground(new Color(106, 0, 133));
            lb6.setBorder(new CompoundBorder(borderl,margin));
            lb6.setForeground(new Color(92, 75, 105));
            lb4.setForeground(new Color(106, 0, 133));
            lb4.setBorder(margin);
            lb2.setBorder(margin);
            lb3.setBorder(margin);

            lb5.setBorder(margin);
            lb1.setBorder(margin);
            card.show(pan1,"pan6");

        }








    }
    @Override

    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
    public void actions(){
        System.out.print("okkk");

    }
}
