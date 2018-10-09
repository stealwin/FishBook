import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * Created by Viacheslav on 24.09.2018.
 */
public class FileCopyHigh implements ActionListener {
    //Доделать!!!
    JPanel windowContent;
    JPanel browsePanel;
    JLabel copyFrom;
    JLabel copyTo;
    JTextField txtCopyFrom;
    JTextField txtCopyTo;
    JButton BrowseCopyFrom;
    JButton BrowseCopyTo;
    JButton copyButton;
    JFileChooser browse;
    JFrame frame2;

    FileCopyHigh() {
        windowContent = new JPanel();
        browsePanel = new JPanel();
        copyFrom = new JLabel("CopyFrom");
        copyTo = new JLabel("CopyTo");
        txtCopyFrom = new JTextField();
        txtCopyTo = new JTextField();
        BrowseCopyFrom = new JButton("Browse");
        BrowseCopyFrom.addActionListener(this);
        BrowseCopyTo = new JButton("Browse");
        BrowseCopyTo.addActionListener(this);
        copyButton = new JButton("Copy");
        browse = new JFileChooser();
        BorderLayout b1 = new BorderLayout();
        GridLayout g1 = new GridLayout(3, 3);
        windowContent.setLayout(g1);
        windowContent.add(copyFrom);
        windowContent.add(txtCopyFrom);
        windowContent.add(BrowseCopyFrom);
        windowContent.add(copyTo);
        windowContent.add(txtCopyTo);
        windowContent.add(BrowseCopyTo);


        windowContent.add(copyButton);

        browsePanel.setLayout(b1);
        browsePanel.add(browse,"Center");
        frame2 = new JFrame();
        frame2.setContentPane(browsePanel);
        frame2.pack();
        frame2.setVisible(false);

        JFrame frame = new JFrame();
        frame.setContentPane(windowContent);
        frame.pack();
        frame.setVisible(true);


    }


    public void actionPerformed(ActionEvent e) {
     JButton clickedButton = (JButton)e.getSource();

        browse.addActionListener(this);

        if (clickedButton==BrowseCopyFrom){
            frame2.setVisible(true);
            browse.setApproveButtonText("Opa4a");
            File f= browse.getSelectedFile();
            browse.accept(f);



            String str=f.toString();

            txtCopyFrom.setText(str);

        }
        if (clickedButton==BrowseCopyTo){
            frame2.setVisible(true);
           // txtCopyTo.setText(str);

        }

    }


    public static void main(String[] args) {
    FileCopyHigh proj = new FileCopyHigh();
    }
}