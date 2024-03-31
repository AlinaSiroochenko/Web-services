package lt.viko.eif.asiroochenko.restaurantapp.server;

import java.io.*;
import java.net.*;

/**
 * The Client class represents a simple client that connects to a server and receives an XML file.
 * It connects to the server specified by the server name and port, receives the XML file, and saves it locally.
 */
public class Client {

    /**
     * The main method connects to the server, receives the XML file, and saves it locally.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        String serverName = "localhost";
        int port = 8888;

        try {
            System.out.println("Connecting to server...");

            Socket clientSocket = new Socket(serverName, port);
            System.out.println("Connected to server.");

            receiveXMLFileFromServer(clientSocket);

            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Receives the XML file from the connected server and saves it locally.
     *
     * @param clientSocket The socket representing the connection to the server.
     * @throws IOException If an I/O error occurs while receiving the file.
     */
    private static void receiveXMLFileFromServer(Socket clientSocket) throws IOException {
        byte[] byteArray = new byte[1024];
        InputStream inputStream = clientSocket.getInputStream();
        FileOutputStream fileOutputStream = new FileOutputStream("received.xml");
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);

        int bytesRead;
        while ((bytesRead = inputStream.read(byteArray, 0, byteArray.length)) != -1) {
            bufferedOutputStream.write(byteArray, 0, bytesRead);
        }

        bufferedOutputStream.close();
    }
}
