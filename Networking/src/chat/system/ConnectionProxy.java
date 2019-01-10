package chat.system;

import java.io.*;
import java.net.*;

public class ConnectionProxy extends Thread implements interfaces.StringConsumer, interfaces.StringProducer
{
    private Socket socket;
    private InputStream is = null;
    private DataInputStream dis = null;
    private OutputStream os = null;
    private DataOutputStream dos = null;

    private ClientDescriptor client;

    public void addConsumer(interfaces.StringConsumer sc){
        //Receives a client and add him into the chat
        this.client = (ClientDescriptor) sc;
        System.out.println(client.getNickname());
    }
    public void removeConsumer(interfaces.StringConsumer sc){

    }
    public void consume(String str){
        //This function will receive string input and send using writeUTF to the socket
        try{
            dos.writeUTF(str);
        }
        catch (IOException e){
            System.out.println("Problem at ConnectionProxy class - 'Consume method' (code: 401)");
            e.printStackTrace();
        }
    }

    @Override
    public void run(){
        while(true) {
            try {
                String msg = dis.readUTF();
                this.client.consume(msg);
            } catch (IOException e) {
                System.out.println("Problem at ConnectionProxy class - 'Run method' (code: 402)");
                e.printStackTrace();
            }
        }
    }

    public ConnectionProxy(Socket socket){
        this.socket = socket;
        try{
            this.is = socket.getInputStream();
            this.dis = new DataInputStream(is);
            this.os = socket.getOutputStream();
            this.dos = new DataOutputStream(os);
        }
        catch (IOException e)
        {
            System.out.println("Problem at ConnectionProxy class (code: 400)");
            e.printStackTrace();
        }
    }

    public void setClient(ClientDescriptor client) {
        this.client = client;
    }

    public String ReadNickName(){
        try{
            return this.dis.readUTF();
        }
        catch (IOException e)
        {
            e.printStackTrace();
            return "Error: no nickname received";
        }
    }

    public boolean SocketAlive(){
        return this.socket.isConnected();
    }

    public void CloseConnection(){
        if(is!=null)
        {
            try{is.close();}catch(IOException e){e.printStackTrace();}
        }
        if(os!=null)
        {
            try{os.close();}catch(IOException e){e.printStackTrace();}
        }
        if(dis!=null)
        {
            try{dis.close();}catch(IOException e){e.printStackTrace();}
        }
        if(dos!=null)
        {
            try{dos.close();}catch(IOException e){e.printStackTrace();}
        }
        if(socket!=null)
        {
            try{socket.close();}catch(IOException e){e.printStackTrace();}
        }
        return;
    }
}