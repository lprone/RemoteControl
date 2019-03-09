package controller;

import logic.LocalData;
import logic.Server;
import view.RemoteControlView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;

public class RemoteControlController {
    public static void startRemoteControl() {
        final int PORT = 9999;
        try {
            LocalData localData = new LocalData(PORT);
            registerRemoteControl(localData);
            new Server(PORT);
            new RemoteControlView(localData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void registerRemoteControl(LocalData localData) {
        String urlS = "http://lprone.com.ar/remoteControl/api.php";
        String paramStr = "url=<url>";

        final String paramValue = "http://" + localData.getIp() + ":" + localData.getPort();

        String data = paramStr.replaceAll("<url>", paramValue);
        try {
            URL url = new URL(urlS);
            URLConnection conn = url.openConnection();
            conn.setDoOutput(true);
            OutputStreamWriter writer = new OutputStreamWriter(conn.getOutputStream());
            writer.write(data);
            writer.flush();
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            writer.close();
            reader.close();
        } catch (Exception ignored) {
        }
    }
}
