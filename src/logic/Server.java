package logic;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

import static java.awt.event.KeyEvent.VK_LEFT;
import static java.awt.event.KeyEvent.VK_RIGHT;

public class Server {

    public Server(int port) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
        server.createContext("/", new Home());
        server.setExecutor(null);
        server.start();
    }

    static class Home implements HttpHandler {

        private String HOME;

        public Home() throws IOException {
            this.HOME = Page.getHome();
        }

        @Override
        public void handle(HttpExchange httpExchange) throws IOException {

            switch (httpExchange.getRequestURI().toString()) {
                case "/":
                    break;
                case "/next":
                    try {
                        executeAction(VK_RIGHT);
                    } catch (AWTException e) {
                        e.printStackTrace();
                    }
                    break;
                case "/back":
                    try {
                        executeAction(VK_LEFT);
                    } catch (AWTException e) {
                        e.printStackTrace();
                    }
                    break;
            }
            httpExchange.sendResponseHeaders(200, HOME.length());
            OutputStream os = httpExchange.getResponseBody();
            os.write(HOME.getBytes());
            os.close();
        }

        private void executeAction(int action) throws AWTException {
            Robot r = new Robot();
            r.keyPress(action);
        }
    }
}