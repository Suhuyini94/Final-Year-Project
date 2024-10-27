package frames;

import ConnectorP.Performcollection;
import database.Attendancemodel;
import database.collections;
import database.StudentModel;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class TakeAttendance extends JPanel implements  ActionListener {


    public collections DB;
    public DefaultTableModel model;


   public JTable table;


    public JButton addbtn;
    public JTextField search;
    public JComboBox searchcategory;
    public DefaultComboBoxModel catemodel;
    public JComboBox namebox;
    public DefaultComboBoxModel namemodel;
    public JLabel sortname;

    private Performcollection control;

    private JPanel Toppanel;
    private JPanel centerpanel;
    private DefaultComboBoxModel modelvender;
    private JComboBox byvender;
    private JButton todaysalebtn;
    private JTextField dateTextField;
    private JButton datePickerButton;
    private JButton markattendance;

    public Font robotoFont;
    public JLabel targetname;
    private JDialog dialog;
    private JLabel sortlabel;
    private JLabel searchbycate;
    public JLabel targetnl;
    private JLabel searchbtv;
    private Resuables reus;

    public String  namen;
    public Integer nameid;
    public Integer course;
    public Integer contactn;
    public Integer department;
    public Integer level;




    public TakeAttendance() throws Exception {

        reus=new Resuables();

        robotoFont = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("fonts/RobotoCondensed-Regular.ttf"));


        searchbycate = new JLabel("By Course");
        searchbtv = new JLabel("Search by Suppliers");
        dateTextField = new JTextField(10);
        datePickerButton = new JButton("Choose Date");
        markattendance=new JButton("Mark Attendance");
        sortname=new JLabel("Sort By Name");

        collections DB = new collections();
targetnl=new JLabel("Student name");

        modelvender = new DefaultComboBoxModel();
        searchcategory = new JComboBox();
        searchcategory.setPreferredSize(new Dimension(150, 30));


        catemodel = new DefaultComboBoxModel();
        searchcategory.setModel(catemodel);
        byvender = new JComboBox();
        byvender.setPreferredSize(new Dimension(150, 30));
        byvender.setModel(modelvender);


namebox=new JComboBox();
namemodel=new DefaultComboBoxModel();
namebox.setModel(namemodel);
        namebox.setPreferredSize(new Dimension(150, 30));

        model=new DefaultTableModel(0,0);
        model.addColumn("ID");
        model.addColumn("student name");
        model.addColumn("CONTACT");
        model.addColumn("COURSE");
        model.addColumn("Department");
        model.addColumn("Level");
        model.addColumn("Identity Status");
        table=new JTable(model);


        control = new Performcollection();
        GridBagLayout gb = new GridBagLayout();
        GridBagLayout tg = new GridBagLayout();
        Toppanel = new JPanel(new FlowLayout());
        centerpanel = new JPanel(gb);
        BorderLayout bl = new BorderLayout();
        setLayout(bl);

        setBackground(new Color(223, 242, 239));
        BorderLayout tbl = new BorderLayout();


/**   adding Jpanels left and right   ----------------------------------------------------------------   */
        add(Toppanel, BorderLayout.NORTH);

        Toppanel.setPreferredSize(new Dimension(200, 100));
        add(centerpanel, BorderLayout.CENTER);
        addbtn = new JButton("ReFresh");
        targetname=new JLabel("N/A");
Toppanel.add(targetnl);
Toppanel.add(targetname);
targetname.setBorder(new EmptyBorder(0,0,0,50));
        Toppanel.add(markattendance);



        reus.buttdesign(markattendance);
        Toppanel.add(addbtn);

searchbycate.setBorder(new EmptyBorder(0,100,0,0));
        Toppanel.add(searchbycate);
        Toppanel.add(searchcategory);

        Toppanel.add(sortname);
        Toppanel.add(namebox);

        Toppanel. setBackground(new Color(211, 219, 214));
        setBorder(new EmptyBorder(10, 10, 10, 10));
        addbtn.setForeground(new Color(54, 96, 247));
        reus.buttdesign(addbtn);

        reus.buttdesign(datePickerButton);
        reus.lables(searchbycate,new Color(54, 96, 247));
        reus.lables(sortname,new Color(54, 96, 247));

reus.lables(targetnl,new Color(54, 96, 247));


        DB.connect();
        DB.Load_data_v();
        model.setRowCount(0);

        for (Map.Entry<String, StudentModel> ind : DB.GetStudents().entrySet()) {
            String identityStatus = ind.getValue().getIdentity().isEmpty() ? "Not Enrolled" :"Enrolled" ;
            model.addRow(new Object[]{ind.getValue().getId(),ind.getKey(),
                  ind.getValue().getContact(),ind.getValue().getCourse() ,ind.getValue().getCompany(),
                     ind.getValue().getLevel(),identityStatus});
        }



/**     ALIGNING LABLES IN LEFT PANEL---------------------------------------------------------------------*/



        Performcollection controller = new Performcollection();




/*** --------------------------------------------------------------------------------------------------------- */





markattendance.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        DB.AttendanceRecord.clear();
        DB.addRecord(new Attendancemodel(nameid,namen,course,contactn,department,level));
        for(Attendancemodel m:DB.AttendanceRecord){
            try {
                DB.connect();
                DB.TakeAttendance();
                String message="Attendance taken for "+ namen +" Course "+ course;
                JOptionPane.showMessageDialog(null,message);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }

        }
    }
});


        table.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTable source = (JTable)evt.getSource();
                int row = table.rowAtPoint(evt.getPoint());
                int col = table.columnAtPoint(evt.getPoint());
                int id= Integer.parseInt(source.getModel().getValueAt(row,0)+"");
                String name=source.getModel().getValueAt(row,1)+"";
                int contac= Integer.parseInt(source.getModel().getValueAt(row,2)+"");
                int cours= Integer.parseInt(source.getModel().getValueAt(row,3)+"");
                int departmen= Integer.parseInt(source.getModel().getValueAt(row,4)+"");
                int courlevel= Integer.parseInt(source.getModel().getValueAt(row,5)+"");

                if (row >= 0 && col >= 0) {
                    targetname.setText(name);
                    namen=name;
                    nameid=id;
                    course=cours;
                    contactn=contac;
                    department=departmen;
                    level=courlevel;







                }
            }
        });













        table.setDefaultRenderer(Object.class,new RoundedBorderTableCellRenderer());
        table.getTableHeader().setDefaultRenderer(new CustomTableHeaderRenderer());

        centerpanel.setLayout(tbl);

        setBackground(new Color(211, 219, 214));




        Border bd = new EmptyBorder(50, 50, 50, 50);


        JScrollPane spt = new JScrollPane(table);
        spt.setBorder(bd);
        centerpanel.add(spt, BorderLayout.CENTER);
    }














    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.print("ok button working");
    }

    public void ldesign(JButton b) {
        b.setBackground(new Color(156, 121, 252));
        b.setPreferredSize(new Dimension(320, 50));
        b.setBorder(new RoundedBorder(20));
        b.setOpaque(false);
        b.setFocusPainted(false);

    }


    private static class RoundedBorder implements Border {

        private int radius;


        RoundedBorder(int radius) {
            this.radius = radius;
        }


        public Insets getBorderInsets(Component c) {
            return new Insets(this.radius + 1, this.radius + 1, this.radius + 2, this.radius);
        }


        public boolean isBorderOpaque() {
            return true;
        }


        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            g.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
        }

    }


    private class RoundedBorderTableCellRenderer extends DefaultTableCellRenderer {

        private final Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
        private final int borderRadius = 10;

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                       boolean hasFocus, int row, int column) {
            Component rendererComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);


            setOpaque(true);
            setForeground(Color.DARK_GRAY);
            setBackground(new Color(211, 219, 214));
            setFont(robotoFont.deriveFont(Font.BOLD, 12f));

            setHorizontalAlignment(CENTER);
            // Set the rounded border for the ce
            // ll renderer component
            ((JComponent) rendererComponent).setBorder(new EmptyBorder(5, 5, 5, 5));

            return rendererComponent;
        }
    }


    private class CustomTableHeaderRenderer extends JLabel implements TableCellRenderer {

        public CustomTableHeaderRenderer() {
            setOpaque(true);
            setForeground(Color.WHITE);
            setBackground(Color.GRAY);
            setHorizontalAlignment(CENTER);
            setFont(robotoFont.deriveFont(Font.BOLD, 13f));
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                       boolean hasFocus, int row, int column) {
            setText(value.toString());
            return this;
        }
    }










}


