package frames;


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

public class fingerprintenroll extends JFrame {
    boolean appsetdone = false;

    JLabel logo;
    JLabel actionmonitor;
    JButton start;
    JButton continuebtn;


    JLabel intro;
    JLabel showfinder;
    JPanel leftpanel;
    JPanel rightpanel;



    JLabel actioncount ;



    JButton submit;



    fingerprintenroll() throws Exception {
        super("Enroll Fingerprint");

        ClassLoader cl = this.getClass().getClassLoader();
        URL dirr1 = cl.getResource("frames/icons/userss.png");
        ImageIcon icon7 = new ImageIcon(dirr1);
        Image minuss = icon7.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT);
        ImageIcon uicon = new ImageIcon(minuss);

        /**  ***********  IMPORT PAGES ****************************************************************/
leftpanel=new JPanel();
        rightpanel=new JPanel();
BorderLayout bl=new BorderLayout();
setLayout(bl);
add(leftpanel,BorderLayout.WEST);
add(rightpanel,BorderLayout.CENTER);
        GridBagLayout gridl = new GridBagLayout();
        GridBagLayout gridr = new GridBagLayout();
        GridBagConstraints grid = new GridBagConstraints();
        GridBagConstraints gridright = new GridBagConstraints();
        rightpanel.setLayout(gridr);
leftpanel.setLayout(gridl);
leftpanel.setPreferredSize(new Dimension(300,200));
leftpanel.setBackground(Color.gray);
leftpanel.setBackground(Color.white);
        Resuables utils = new Resuables();
        logo=new JLabel("");
        logo.setIcon(uicon);
        intro = new JLabel("Record Identity");
        actioncount=new JLabel("Attempt Count 0");
        showfinder=new JLabel("Position your thumb well");
        submit=new JButton("continue");
        logo=new JLabel("");
actioncount=new JLabel("Actions monitor");
start=new JButton("Start");
        continuebtn=new JButton("Continue");
        logo.setIcon(uicon);
        utils.lables(intro, new Color(6, 60, 69));
        grid.anchor = GridBagConstraints.FIRST_LINE_START;
        grid.insets = new Insets(0, 0, 20, 0);
        grid.gridx = 0;
        grid.gridy = 0;
        leftpanel.add(logo, grid);

        setBackground(new Color(201, 235, 240));


        grid.gridy = 2;

        leftpanel.add(intro, grid);




        grid.gridy = 4;
        leftpanel.add(actioncount, grid);
        grid.gridy = 6;
        leftpanel.add(showfinder, grid);



        utils.buttdesign(submit);
        utils.buttdesign(start);
        utils.buttdesign(continuebtn);








        gridright.anchor = GridBagConstraints.FIRST_LINE_START;
        gridright.insets = new Insets(0, 0, 20, 0);
        gridright.gridx = 0;
        gridright.gridy = 0;
        rightpanel.add(actioncount, gridright);
        gridright.gridy = 5;
        rightpanel.add(start, gridright);
        gridright.gridy = 8;
        rightpanel.add(continuebtn, gridright);

    }
}








