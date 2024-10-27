package frames;

import ConnectorP.Performcollection;
import com.toedter.calendar.JCalendar;
import database.Attendancemodel;
import database.collections;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.List;

public class ViewAttendanceRecord extends JPanel implements  ActionListener {


    public collections DB;
    public DefaultTableModel model;


    JTable table;


    public JButton addbtn;
    public JTextField search;
    public JComboBox searchcategory;
    public DefaultComboBoxModel catemodel;

    private Performcollection control;

    private JPanel Toppanel;
    private JPanel centerpanel;
    private DefaultComboBoxModel modelvender;
    private JComboBox byvender;
    private JButton todayrecord;
    private JTextField dateTextField;
    private JButton datePickerButton;
    public Font robotoFont;
    private JDialog dialog;
    private JLabel sortlabel;
    private JLabel searchbycate;
    private JLabel searchbtv;
    private Resuables reus;
    private List<Attendancemodel> filterAttendace;

    private void showDatePicker() {


        dialog = new JDialog();
        final JCalendar calendar = new JCalendar();
        calendar.setTodayButtonVisible(true);
        calendar.getDayChooser().addPropertyChangeListener("day", e -> {
            Calendar selectedDate = calendar.getCalendar();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String pickd = sdf.format(selectedDate.getTime());
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

            filterAttendace.clear();

            try {
                collections DB=new collections();
                DB.connect();
                DB.Load_attendace();
                for (Attendancemodel m: DB.AttendanceRecord) {
                    if (m.getDateD().toLocalDate().format(formatter).equals(pickd)) {
                        filterAttendace.add(new Attendancemodel(m.getID(),
                                m.getIdstudent(),
                                m.getName(),m.getCourse(),
                                m.getContact(),m.getDepartment()
                                ,m.getCourlevel(),
                                m.getDateD()));

                    }
                }


                model.setRowCount(0);
                for (Attendancemodel u :filterAttendace) {
                    model.addRow(new Object[]{
                            u.getID(),
                            u.getIdstudent(),
                            u.getName(),
                            u.getCourse(),
                            u.getContact(),
                            u.getDepartment(),
                            u.getCourlevel(),
                            u.getDateD()

                    });
                }

            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }

        });

        dialog.getContentPane().add(calendar);
        dialog.pack();
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }



    public List<Attendancemodel> getfilter() {
        return filterAttendace;
    }

    public ViewAttendanceRecord() throws Exception {

reus=new Resuables();
        filterAttendace = new ArrayList<>();
        robotoFont = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("fonts/RobotoCondensed-Regular.ttf"));

        sortlabel = new JLabel("Sort by");
        searchbycate = new JLabel("Search by Course");
        searchbtv = new JLabel("Search by Student");
        dateTextField = new JTextField(10);
        datePickerButton = new JButton("Choose Date");

        datePickerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showDatePicker();
            }
        });

        collections DB = new collections();


        modelvender = new DefaultComboBoxModel();
        searchcategory = new JComboBox();
        searchcategory.setPreferredSize(new Dimension(150, 30));

        catemodel = new DefaultComboBoxModel();
        searchcategory.setModel(catemodel);
        byvender = new JComboBox();
        byvender.setPreferredSize(new Dimension(150, 30));
        byvender.setModel(modelvender);
        todayrecord = new JButton("Today");
        model = new DefaultTableModel(0, 0);
        model.addColumn("Record ID");
        model.addColumn("student ID");
        model.addColumn("student name");
        model.addColumn("CONTACT");
        model.addColumn("COURSE");
        model.addColumn("Department");
        model.addColumn("Level");
        model.addColumn("DATE");
        table = new JTable(model);


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
        addbtn = new JButton("Reload");


        Toppanel.add(addbtn);
        Toppanel.add(sortlabel);
        Toppanel.add(todayrecord);
        Toppanel.add(datePickerButton);
        Toppanel.add(searchbycate);
        Toppanel.add(searchcategory);
        Toppanel. setBackground(new Color(211, 219, 214));

        setBorder(new EmptyBorder(10, 10, 10, 10));
        addbtn.setForeground(new Color(54, 96, 247));
reus.buttdesign(addbtn);
reus.buttdesign(todayrecord);
reus.buttdesign(datePickerButton);
reus.lables(sortlabel,new Color(54, 96, 247));
reus.lables(searchbycate,new Color(54, 96, 247));

/**     ALIGNING LABLES IN LEFT PANEL---------------------------------------------------------------------*/


        Performcollection controller = new Performcollection();




/*** --------------------------------------------------------------------------------------------------------- */


        table.setDefaultRenderer(Object.class,new RoundedBorderTableCellRenderer());
        table.getTableHeader().setDefaultRenderer(new CustomTableHeaderRenderer());

        centerpanel.setLayout(tbl);

        setBackground(new Color(211, 219, 214));
        todayrecord.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LocalDate currentDate = LocalDate.now();
filterAttendace.clear();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                String formattedDate = currentDate.format(formatter);

                try {
                    for (Attendancemodel m: DB.AttendanceRecord) {

                        if (m.getDateD().toLocalDate().format(formatter).equals(formattedDate)) {
                            filterAttendace.add(new Attendancemodel(m.getID(),m.getIdstudent(),m.getName(),m.getCourse(),m.getContact(),m.getDepartment(),m.getCourlevel(),m.getDateD()));

                        }

                    }
                    ;

                    model.setRowCount(0);
                    for (Attendancemodel u :filterAttendace) {
                        model.addRow(new Object[]{
                                u.getID(),
                                u.getIdstudent(),
                                u.getName(),
                                u.getCourse(),
                                u.getContact(),
                                u.getDepartment(),
                                u.getCourlevel(),
                                u.getDateD()

                        });
                    }

                }catch (Exception ex) {
                    throw new RuntimeException(ex);
                }


            }
        });




        DB.connect();
        DB.Load_attendace();
        model.setRowCount(0);
        for (Attendancemodel u :DB.AttendanceRecord ) {
            model.addRow(new Object[]{
                    u.getID(),
                    u.getIdstudent(),
                    u.getName(),
                  u.getCourse(),
                    u.getContact(),
                    u.getDepartment(),
                    u.getCourlevel(),
                    u.getDateD()

            });
        }


/****                *********************                         ***/



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


