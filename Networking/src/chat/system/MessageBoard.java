package chat.system;

public class MessageBoard implements interfaces.StringConsumer, interfaces.StringProducer
{
    // - Should posses all the connection proxies the system has.
    // -
    private static int queue_length = 5;
    private ConnectionProxy list_of_connections[];

    public void addConsumer(interfaces.StringConsumer sc){
        //Add a reference of a connection proxy
        for(int i=0;i<queue_length;i++)
        {
            if(list_of_connections[i]==null){
                list_of_connections[i] = (ConnectionProxy)sc;
                return;
            }
        }
        System.out.println("No empty sockets! Please wait");
        return;
    }
    public void removeConsumer(interfaces.StringConsumer sc){

    }
    public void consume(String str){
        for(int i=0;i<queue_length;i++)
        {
            if(list_of_connections[i]!=null){
                if(list_of_connections[i].SocketAlive())
                    list_of_connections[i].consume(str);
                else if(list_of_connections[i]!=null)
                    list_of_connections[i]=null;
            }
        }
        return;
    }

    public MessageBoard() {
        list_of_connections = new ConnectionProxy[queue_length];
    }
}