package logic;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class LocalData {
    private String host;
    private String ip;
    private int port;

    public LocalData(int port) throws UnknownHostException {
        InetAddress inetAddress = InetAddress.getLocalHost();
        this.host = inetAddress.getHostName();
        this.ip = inetAddress.getHostAddress();
        this.port = port;
    }

    public String getHost() {
        return host;
    }

    public String getIp() {
        return ip;
    }

    public int getPort() {
        return port;
    }

    @Override
    public String toString() {
        return "LocalData{" +
                "host='" + host + '\'' +
                ", ip='" + ip + '\'' +
                ", port=" + port +
                '}';
    }
}