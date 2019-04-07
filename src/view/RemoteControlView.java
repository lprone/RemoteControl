package view;

import logic.LocalData;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.awt.Toolkit;

public class RemoteControlView extends JFrame {
    public RemoteControlView(LocalData localData, String qrCodeName) {
        JPanel labels =  new JPanel();

        setLayout(new GridLayout(2, 1));
        labels.setLayout(new GridLayout(4, 1));
        setTitle("Remote Control");
        setSize(350, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource("remote-control.png")));

        ImageIcon qrImage = new ImageIcon(qrCodeName);

        JLabel runningLabel = new JLabel("Server running", SwingConstants.CENTER);
        JLabel ipLabel = new JLabel("IP Address:- " + localData.getIp(), SwingConstants.CENTER);
        JLabel hostNameLabel = new JLabel("Host Name:- " + localData.getHost(), SwingConstants.CENTER);
        JLabel portLabel = new JLabel("Service Port:- " + localData.getPort(), SwingConstants.CENTER);
        JLabel qrLabel = new JLabel(qrImage, SwingConstants.CENTER);

        labels.add(runningLabel);
        labels.add(ipLabel);
        labels.add(hostNameLabel);
        labels.add(portLabel);

        add(labels);
        add(qrLabel);

        setVisible(true);
        setLocationRelativeTo(null);
    }
}