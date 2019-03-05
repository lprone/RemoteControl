package controller;

import logic.LocalData;
import logic.Server;
import view.RemoteControlView;

import java.io.IOException;

public class RemoteControlController {
    public static void startRemoteControl() {
        final int PORT = 9999;
        try {
            LocalData localData = new LocalData(PORT);
            new Server(PORT);
            new RemoteControlView(localData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
