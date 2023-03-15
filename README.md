# Mini-WebServer
DePaul University CSC 435


Grading:
We will compile and run your MiniWebserver.java program and point to it at http://localhost:2540 from our own copy of WebAdd.html using Firefox.
We will check for plagiarism, and read your code, including the required comments.

Assignment:
This mini-assignment is to familiarize students with the HTTP messages that go back and forth between a web client (browser) and a web server. This is a small assignment. Pedagogical, explanatory comments are required in the code.
During the course of your program development, engage in scholarly discussions of these webserver techniques with your peers on the D2L forums. Save your postings into MiniWebPostings.txt (or .html, or .docx). Two postings are required: questions, answers, comments, annotated links, etc. Submit to D2L (together with .java code), and ALSO concatenate with your .java code for submission to the TII link.
Background reading: Read the full MyWebserver assignment page for background and detailed instructions. I will feel free to ask questions on this background material on the midterm and final exams. Do not write the full MyWebserver code this quarter. Informational only.
Run MyListener.java by pointing a web browser to the socket it presents on localhost (http://localhost:2540/abc) and viewing what the browser is sending. MyListener will be waiting for connections at port 2540.
Run the MyTelnetClient.java program and use it to get a response from a webserver. Connect to a webserver. Submit a web request manually by typing the lines of the request into the console. Then, see what you get back from the webserver. There are sample instructions in the comments of the program. Be careful: TWO carriage-return/linefeeds [blank lines] followed by stop at the end are required. Note that you might only get back an error from the webserver, but if so, this is still a success: you got back a valid response!
Run WebResponse.java by pointing a web browser to it and viewing the response that is sent.
Copy WebResponse.java to MiniWebserver.java.
Add the required HEADER to the Java file. Complete the minor modification tasks specified in the checklist.
Make sure that MiniWebserver.java works with WebAdd.html. (FORM input)
Enter different names and different numbers to see how these are captured in the query string . This is, in fact, just a string that can be read and manipulated in your java server program. This is how form data is sent to webservers as name/value pairs.
Note that the query string appears after a question-mark, name/value pairs are delimited by ampersands (&) and names are linked to their values by equal signs within the name/value pairs.
Answer the questions as comments in your MiniWebserver.java source code.
Submit your .java code to D2L before the server closing deadline.
In the usual way, concatenate the same MiniWebserver.java code with your MinWebPostings file as .docx or .txt (NOT .java) to the TII link for plagiarism checking. There will be high overlap because there is little code for you to write, but your own comments will be original and your postings will be original. You must be under the maximum overlap limit for us to grade your assignment.
For fun, point your MyTelnetClient to port 2540 on localhost so you can talk from the telnet client to your own MiniWebServer listener manually.
Complete the checklist and upload it to D2L along with your WebAdd.html form (given to you), and your commented MiniWebserver.java program. NEVER make false claims on your checklist. Done!
