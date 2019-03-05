/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mainApp;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;

import static java.awt.event.KeyEvent.VK_LEFT;
import static java.awt.event.KeyEvent.VK_RIGHT;


/**
 * @author lprone
 */
public class RemoteControl {

    public static void main(String[] args) throws Exception {

        InetAddress inetAddress = InetAddress.getLocalHost();
        final int PORT = 9999;

        System.out.println("Server running");
        System.out.println("IP Address:- " + inetAddress.getHostAddress());
        System.out.println("Host Name:- " + inetAddress.getHostName());
        System.out.println("Service Port:- " + PORT);

        HttpServer server = HttpServer.create(new InetSocketAddress(PORT), 0);
        server.createContext("/", new Root());
        server.setExecutor(null);
        server.start();
    }

    static class Root implements HttpHandler {

        private static final String HOME =
                "<!DOCTYPE html>\n" +
                        "<html>\n" +
                        "   <head>\n" +
                        "      <style>\n" +
                        "         .button {\n" +
                        "           background-color: #4CAF50; /* Green */\n" +
                        "           border: none;\n" +
                        "           color: white;\n" +
                        "           padding: 200px;\n" +
                        "           text-align: center;\n" +
                        "           text-decoration: none;\n" +
                        "           display: inline-block;\n" +
                        "           font-size: 36px;\n" +
                        "           margin: 4px 2px;\n" +
                        "           cursor: pointer;\n" +
                        "         }\n" +
                        "         \n" +
                        "         .buttonRounded {border-radius: 12px;}\n" +
                        "      </style>\n" +
                        "   </head>\n" +
                        "   <body>\n" +
                        "      <script>\n" +
                        "         function goBack() {\n" +
                        "         var xhttp = new XMLHttpRequest();\n" +
                        "         xhttp.open(\"GET\", \"back\", true);\n" +
                        "         xhttp.send();\n" +
                        "         }\n" +
                        "         function goNext() {\n" +
                        "         var xhttp = new XMLHttpRequest();\n" +
                        "         xhttp.open(\"GET\", \"next\", true);\n" +
                        "         xhttp.send();\n" +
                        "         }\n" +
                        "      </script>\n" +
                        "\t  <center>\n" +
                        "         <button class=\"button buttonRounded\" type=\"button\" onclick=\"goBack()\">Back</button>\n" +
                        "         <button class=\"button buttonRounded\" type=\"button\" onclick=\"goNext()\">Next</button>\n" +
                        "\t  </center>\n" +
                        "   </body>\n" +
                        "</html>";

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

//<!DOCTYPE html>
//<html>
//   <head>
//      <style>
//         .button {
//           background-color: #4CAF50; /* Green */
//           border: none;
//           color: white;
//           padding: 200px;
//           text-align: center;
//           text-decoration: none;
//           display: inline-block;
//           font-size: 36px;
//           margin: 4px 2px;
//           cursor: pointer;
//         }
//
//         .buttonRounded {border-radius: 12px;}
//      </style>
//   </head>
//   <body>
//      <script>
//         function goBack() {
//         var xhttp = new XMLHttpRequest();
//         xhttp.open("GET", "back", true);
//         xhttp.send();
//         }
//         function goNext() {
//         var xhttp = new XMLHttpRequest();
//         xhttp.open("GET", "next", true);
//         xhttp.send();
//         }
//      </script>
//	  <center>
//         <button class="button buttonRounded" type="button" onclick="goBack()">Back</button>
//         <button class="button buttonRounded" type="button" onclick="goNext()">Next</button>
//	  </center>
//   </body>
//</html>