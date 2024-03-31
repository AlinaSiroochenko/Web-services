package lt.viko.eif.asiroochenko.restaurantapp.server;

import java.io.*;
import java.net.*;

/**
 * The Server class represents a simple server that sends an XML file to a connected client.
 * It listens for client connections on a specified port and sends the XML file upon connection.
 */
public class Server {

    /**
     * The main method starts the server, listens for client connections, and sends the XML file.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        int port = 8888;

        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server started. Waiting for client...");

            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected.");

            sendXMLFileToClient(clientSocket);

            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Sends the XML file to the connected client.
     *
     * @param clientSocket The socket representing the connected client.
     * @throws IOException If an I/O error occurs while sending the file.
     */
    private static void sendXMLFileToClient(Socket clientSocket) throws IOException {
        File xmlFile = new File("generated.xml");
        byte[] byteArray = new byte[(int) xmlFile.length()];

        FileInputStream fileInputStream = new FileInputStream(xmlFile);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        bufferedInputStream.read(byteArray, 0, byteArray.length);

        OutputStream outputStream = clientSocket.getOutputStream();
        outputStream.write(byteArray, 0, byteArray.length);
        outputStream.flush();

        bufferedInputStream.close();
    }
}
