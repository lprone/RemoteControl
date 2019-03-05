package logic;

@SuppressWarnings("SpellCheckingInspection")
class Pages {
    static final String HOME =
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

}