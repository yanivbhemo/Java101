package chat.system;
import java.net.*;
import java.io.*;

public class ServerApplication
{
    public static void main(String args[])
    {
        ServerSocket server = null;
        MessageBoard mb = new MessageBoard();
        try
        {
            server = new ServerSocket(2080,5);
        }
        catch(IOException e)
        {
        }
        Socket socket = null;
        ClientDescriptor client = null;
        ConnectionProxy connection = null;

        while(true)
        {
            try
            {
                socket = server.accept();
                connection =new ConnectionProxy(socket);
                client = new ClientDescriptor(connection.ReadNickName());
                connection.addConsumer(client);
                client.addConsumer(mb);
                mb.addConsumer(connection);
                mb.consume(" ~ " + client.getNickname() + " Has joined the chat" + " ~");
                connection.start(); //Declare a run command in connectionProxy class
            }
            catch(IOException e)
            {
                e.printStackTrace();
                if(connection!=null)
                    connection.CloseConnection();
                System.exit(1);
            }
        }
    }
}
