package frames;

import ConnectorP.Performcollection;
import database.collections;
import database.departmentmodel;
import database.StudentModel;

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
import java.sql.SQLException;
import java.util.Map;

public class DepartmentP extends JPanel implements  ActionListener{
    Resuables designl;

    public Font robotoFont;


    public JTextField departmenth;


    JTable table;

    public JLabel logo;

    public JTextField departmentn;

    DefaultTableModel model;

    public collections DB;
    public JLabel departmentname;
    public JLabel departmenthead;


    public JPanel display;








    public JButton addbtn;




    private Performcollection control;
    public JPanel lpanel;
    public JPanel rpanel;
    public JTextField country;



    public DepartmentP() throws Exception {
        ClassLoader cl= this.getClass().getClassLoader();

        designl=new Resuables();
        /*    fonts  **/

        robotoFont = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("fonts/RobotoCondensed-Regular.ttf"));

        departmenth=new JTextField();

        departmentn=new JTextField();
        model=new DefaultTableModel();

        collections DB=new collections();
        model=new DefaultTableModel(0,0);
        model.addColumn("ID");
        model.addColumn("Department");
        model.addColumn("Head of Department");


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
        addbtn=new JButton("Add Department");
        departmentname=new JLabel("Department Name");
        departmenthead=new JLabel("Department Head");





/** fonts **/
        departmentname.setFont(robotoFont.deriveFont(Font.BOLD,15f));
        departmenthead.setFont(robotoFont.deriveFont(Font.BOLD,15f));




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
        lpanel.add(departmentname,gbl);
        gbl.gridy=8;
        lpanel.add(departmentn,gbl);
        gbl.gridy=9;

        lpanel.add(departmenthead,gbl);
        gbl.gridy=10;
        lpanel.add(departmenth,gbl);
        gbl.gridy=11;




        gbl.gridy=20;
        lpanel.add(addbtn,gbl);




/*** --------------------------------------------------------------------------------------------------------- */
        setBackground(new Color(211, 219, 214));

        designl.Field(departmentn);
        designl.Field(departmenth);

        lpanel.setOpaque(false);
        rpanel.setOpaque(false);


        lpanel.setForeground(new Color(170, 169, 176));
        rpanel.setForeground(new Color(170, 169, 176));

        rpanel.setLayout(tbl);
        DB.connect();
        DB.Load_data_v();
        model.setRowCount(0);
        for (Map.Entry<String, departmentmodel> ind : DB.GetDepartments().entrySet()) {

            model.addRow(new Object[]{ind.getValue().getId(), ind.getKey(),
                    ind.getValue().gethead()});
        }

/********** Actions *************************************************************/


        addbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name;
                String departmenthi;

                try {

                    name = departmentn.getText().trim();
                    departmenthi = departmenth.getText().trim();



                    Performcollection control = new Performcollection();
                    try {
                        control.connect();
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                    DB.GetStudents().clear();
                    DB.AddDepartment(name, new departmentmodel(departmenthi));
                    try {
                        DB.connect();
                        DB.save_To_database_department();
                        DB.connect();
                        DB.Load_data_departmentrecord();
                        model.setRowCount(0);
                        for (Map.Entry<String, departmentmodel> ind : DB.GetDepartments().entrySet()) {
                            model.addRow(new Object[]{ind.getValue().getId(), ind.getKey(),
                                    ind.getValue().gethead()
});
                        }


                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                    for (Map.Entry<String, StudentModel> indes : DB.GetStudents().entrySet()) {

                    }
                } catch (
                        Exception ee
                ) {
                    JOptionPane.showMessageDialog(null, ee);
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