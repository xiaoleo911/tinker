package socket;

public class SocketThread {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Server server = new Server();
        Client client = new Client();
        server.start();
        client.start();
    }

}
