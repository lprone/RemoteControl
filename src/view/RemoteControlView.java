package view;

import logic.LocalData;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.awt.Toolkit;

public class RemoteControlView extends JFrame {
    public RemoteControlView(LocalData localData) {
        setLayout(new GridLayout(4, 1));
        setTitle("Remote Control");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource("remote-control.png")));

        JLabel runningLabel = new JLabel("Server running", SwingConstants.CENTER);
        JLabel ipLabel = new JLabel("IP Address:- " + localData.getIp(), SwingConstants.CENTER);
        JLabel hostNameLabel = new JLabel("Host Name:- " + localData.getHost(), SwingConstants.CENTER);
        JLabel portLabel = new JLabel("Service Port:- " + localData.getPort(), SwingConstants.CENTER);

        add(runningLabel);
        add(ipLabel);
        add(hostNameLabel);
        add(portLabel);

        setVisible(true);
        setLocationRelativeTo(null);
    }
}