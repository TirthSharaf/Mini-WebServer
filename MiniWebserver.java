/*
1. Name: Tirth Sharaf

2. Date: 2022-02-05

3. Java version: 19.0.1.1

4. Precise command-line compilation examples / instructions:
> javac MiniWebserver.java

5. Precise examples / instructions to run this program:
In separate shell windows: To run on localhost
CMD window 1> java MiniWebserver
WebPage> WebAdd.html (client)

6. Full list of files needed for running the program:
 a. MiniWebServer.java
 b. WebAdd.html

7. Notes:
The code is a simple implementation of a multi-threaded HTTP web server in Java. The server listens on port 2540 and
 accepts incoming connections from clients (web browsers). The class "Listenr" extends the "Thread" class and
 is responsible for handling incoming requests from clients. The "run" method of this class is executed when the thread
 is started, which reads the incoming request, processes it, and sends an HTML response back to the client. The "MiniWebserver"
 class is the main class that listens for incoming connections and starts a new "Listenr" thread for each incoming request.
 The "main" method of this class creates a server socket and listens for incoming connections, accepts them and starts a new "ListenrWorker"
 thread for each incoming connection.

 8. Thanks
 Thanks:
https://www.w3schools.com/
Thomas K.
Daniel Persson (https://www.youtube.com/watch?v=KlKVxmeKAzE)
WebConcepts (https://www.youtube.com/watch?v=9J1nJOivdyw)
Also: many YouTube Videos I can't sum it up
And to Dr. Clark Elliot for sharing materials such MyTelnetClient, MyListener and WebResponse for this Assignment

Q.)How MIME-types are used to tell the browser what data is coming.
Ans.)MIME (Multipurpose Internet Mail Extensions) types, or Media Type, are a string identifier used to specify the format of a file. When a browser makes
 a request for a web resource, it includes information about what type of data it wants. The server then sends back
 the resource along with a MIME type in the response header, which tells the browser what type of data it's receiving.
 This allows the browser to correctly handle and display the data.

For example, if the browser requests an image file, the server would send back the image along with a MIME type of "image/jpeg"
or "image/png". The browser then knows to display the image, rather than try to parse it as text or another type of data.

MIME types are important because they ensure that web resources are correctly handled and displayed, which is essential
for a seamless user experience on the web.

Q.)how you would return the contents of requested actual disk files (web pages) of type HTML (text/html)
Ans.)To return the contents of requested actual disk files of type HTML (text/html), one can follow the following steps:

>Open the file: Open the file in reading mode using the appropriate method such as "FileInputStream" or "BufferedReader" in Java.

>Prepare the header: Prepare the header of the response including "HTTP/1.1 200 OK" status code and "Content-Type: text/html" header
indicating that the content is in HTML format. Also, set the "Content-Length" header to the length of the contents of the file in bytes.
>Write the header: Write the header to the output stream using "Out.println()" method in the above code.
>Write the contents: Write the contents of the file to the output stream using the "Out.println()" method or other suitable methods.
>Close the file: Close the file after reading its contents.

Example:-

Out.println("HTTP/1.1 200 OK");
        Out.println("Content-Type: text/html");
        Out.println("Content-Length: " + responseString.length());

Q.)how you would return the contents of requested actual disk files (web pages) of type TEXT (text/plain)
Ans.)To return the contents of requested actual disk files of type HTML (text/plain), one can follow the following steps:

>Open the file: Open the file in reading mode using the appropriate method such as "FileInputStream" or "BufferedReader" in Java.

>Prepare the header: Prepare the header of the response including "HTTP/1.1 200 OK" status code and "Content-Type: text/plain" header
indicating that the content is in HTML format. Also, set the "Content-Length" header to the length of the contents of the file in bytes.
>Write the header: Write the header to the output stream using "Out.println()" method in the above code.
>Write the contents: Write the contents of the file to the output stream using the "Out.println()" method or other suitable methods.
>Close the file: Close the file after reading its contents.

Example:-

Out.println("HTTP/1.1 200 OK");
        Out.println("Content-Type: text/plain");
        Out.println("Content-Length: " + responseString.length());

*/
import java.io.*;// Importing java.io library to handle input and output
import java.net.*; // Importing java.net library to handle sockets and network communication

class Listenr extends Thread {  // Class that extends the Thread class, it will handle the incoming requests
    Socket sock; // Socket to communicate with the client
    Listenr (Socket soc) {sock = soc;}  // Constructor to initialize the socket

    public void run(){  // Overridden run method, will execute when the thread is started
        PrintStream out = null; // Output stream to send the response to the client
        BufferedReader in = null; // Input stream to read the request from the client
        try {
            out = new PrintStream(sock.getOutputStream()); // Creating the output stream
            in = new BufferedReader // Creating the input stream
                    (new InputStreamReader(sock.getInputStream()));

            String query = in.readLine().split(" ")[1]; // Reading the first line of the request to get the query string

            if (query.equals("/favicon.ico")) { // Checking if the query is for favicon.ico, if yes then just close the socket and return
                sock.close();
                return;
            }

            System.out.println("Received query string: " + query);

            String name = "", num1 = "", num2 = ""; // Variables to hold the name, num1, num2 and sum of num1 and num2
            int sum = 0;

            if (!query.equals("/")) { // Check if the query is not just "/"
                String[] params = query.split("\\?")[1].split("&");  // Splitting the query string to get the parameters
                name = params[0].split("=")[1];
                num1 = params[1].split("=")[1];
                num2 = params[2].split("=")[1];

                sum = Integer.parseInt(num1) + Integer.parseInt(num2); // Calculating the sum of num1 and num2
            }

            MiniWebserver.i++; // Incrementing the request counter

            System.out.println("Sending the HTML Reponse now: " +
                    Integer.toString(MiniWebserver.i) + "\n" );
            // Creating the HTML response to be sent to the client
            String HTMLResponse = "<html> <h1> Hello " + name + "!</h1>" +
                    "<p><p> <hr> <p>" +
                    // Displaying the sum of the two numbers
                    "<p>The sum of " + num1 + " and " + num2 + " is " + sum + "</p>" +
                    // Displaying the number of requests
                    "<p> Number of Requests: " + MiniWebserver.i + "</p>" +
                    // Adding a form to allow the user to input their name and two numbers
                    "<form action='http://localhost:2540/' method='get'>" +
                    "<input type='text' name='name' placeholder='Name' value='" + name + "'>" +
                    "<br><br>" +
                    "<input type='text' name='num1' placeholder='Number 1' value='" + num1 + "'>" +
                    "<br><br>" +
                    "<input type='text' name='num2' placeholder='Number 2' value='" + num2 + "'>" +
                    "<br><br>" +
                    // Submit button to send the form data to the server
                    "<input type='submit' value='Submit'>" +
                    "</form>" +
                    "</html>";


            // Sending the HTML response to the client
            out.println("HTTP/1.1 200 OK");// HTTP response status code indicating success
            out.println("Connection: close");// Sending a header to indicate that the connection will be closed after the response is sent
            int Len = HTMLResponse.length();// Length of the HTML response
            out.println("Content-Length: " + Integer.toString(Len));// Sending the length of the HTML response in the header
            out.println("Content-Type: text/html \r\n\r\n");// Indicating that the response body contains HTML
            out.println(HTMLResponse);// Sending the HTML response
            sock.close();// Closing the socket connection

        } catch (IOException x) { // Handling the IOException error if there's a connection reset
            System.out.println("Error: Connection reset. Listening again...");
        } catch (NumberFormatException nfe) { // Handling the NumberFormatException error if the number format in the query string is invalid
            System.out.println("Error: Invalid number format in query string");
        }
    }
}
public class MiniWebserver { // Class to handle incoming connections from clients (web browsers)

    static int i = 0; // counter to keep track of the number of requests

    public static void main(String a[]) throws IOException {
        int q_len = 6; // maximum length of the queue for incoming connections
        int port = 2540; // port number to listen on
        Socket sock;

        ServerSocket servsock = new ServerSocket(port, q_len);// create the server socket

        System.out.println("Running Tirth's WebResponse at port  2540.");
        System.out.println("Pointing Firefox browser to http://localhost:2540/xyz.\n");

        while (true) { // Listen for incoming connections indefinitely
            sock = servsock.accept(); // wait for an incoming connection
            new Listenr (sock).start(); // create a new thread to handle the request
        }
    }
}
