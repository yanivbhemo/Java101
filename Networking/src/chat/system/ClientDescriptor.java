package chat.system;

import javax.swing.*;
import java.net.Socket;

public class ClientDescriptor implements interfaces.StringConsumer, interfaces.StringProducer
{
    //Holds the user metadata like: nickname
    private String nickname;
    private MessageBoard mb;
    private ClientGUI clientgui_ref;

    public void addConsumer(interfaces.StringConsumer sc){
        //Adds a reference of a MassageBoard
        this.mb = (MessageBoard)sc;
    }
    public void removeConsumer(interfaces.StringConsumer sc){

    }
    public void consume(String str){
        System.out.println(str);
        if(mb!=null){
            str = this.nickname + ": " + str;
            mb.consume(str);
        }
        if(clientgui_ref!=null){
            clientgui_ref.consume(str);
        }
    }

    public ClientDescriptor(String nickname){
        this.nickname=nickname;
    }

    public String getNickname() {
        return nickname;
    }

    public void setClient_ref(ClientGUI client_ref) {
        this.clientgui_ref = client_ref;
    }

}