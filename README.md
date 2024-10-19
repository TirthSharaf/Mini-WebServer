## MiniWebServer - A Simple HTTP Server in Java

This project implements a MiniWebServer to demonstrate basic HTTP message handling between a web client (browser) and a web server. The server is capable of processing HTTP requests and handling form data sent via GET requests.

# Project Overview:

• MiniWebserver.java: The main file that implements the web server. It listens for connections on port 2540 and responds to HTTP requests from a web client, such as a browser or telnet client.

• WebAdd.html: A simple HTML form that sends form data (name and numbers) to the MiniWebServer for processing. The form data is passed to the server as query parameters in the URL.

• The goal of this project is to help students understand how a basic web server processes HTTP requests and interacts with clients, as well as familiarize them with query strings and name/value pairs sent via forms.


# Key Features:

• HTTP Request Handling: The server processes HTTP GET requests and sends back responses based on the request.

• Query String Parsing: Form data sent via WebAdd.html is processed as a query string, with name/value pairs delimited by ampersands (&).

• Form Interaction: The project includes an HTML form that allows users to input data (names and numbers), which is then sent to the server and displayed in the browser.

• Console Interaction: In addition to using a web browser, a telnet client can be used to manually submit web requests and see server responses.

# Technical Details:

• Developed in Java, this project makes use of basic sockets to listen for connections and respond to HTTP requests.

• The server runs on localhost:2540, making it accessible via a web browser or a telnet client.

• GET Request Handling: The server processes GET requests and extracts the query string from the request URL to display the form data in the response.

• The query string is parsed and converted into key-value pairs that are processed by the server.

# How to Run the Project:

• Compile the Java file using: javac MiniWebserver.java

• Run the server: Start the MiniWebServer by executing: java MiniWebserver

• Access the server via browser: Open a web browser (preferably Firefox) and navigate to: http://localhost:2540

• Submit form data:
 Use the WebAdd.html form to input different names and numbers.
 The form data is sent to the server as a query string, and the server will respond by displaying the processed data.

• Using Telnet for manual requests: Open a terminal and run: telnet localhost 2540

• Manually submit an HTTP request by typing:
 GET /?person=John&num1=4&num2=5 HTTP/1.1
 Host: localhost
(Make sure to include two carriage returns after the request.)

• Check the server response: The server will respond with the processed form data, either via the web browser or telnet client.

# Custom Modifications:

• Added comments throughout MiniWebserver.java explaining how the server processes requests and responds with the appropriate data.

• Enhanced the error handling and response formatting to provide better feedback when invalid or incomplete requests are submitted.

# Learning Outcomes:

• By completing this project, I gained hands-on experience in:

• Understanding basic HTTP message exchanges between a web client and server.
• Handling GET requests and form data in a Java-based server.
• Using sockets to manage client-server communication.
• Exploring how form data is passed as query strings and processed in server-side code.
