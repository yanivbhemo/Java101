package chat.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Socket;

public class ClientGUI implements interfaces.StringConsumer, interfaces.StringProducer
{
    public static void main(String[]args)
    {
        ClientGUI gui = new ClientGUI();
    }

    //Tips
    // - Should have reference to 'ConnectProxy' class and backward
    //
    private JFrame chatboard;
    private JTextArea chatArea;
    private JTextField hostname;
    private JTextField port;
    private JTextField nickname;
    private JTextField msg;
    private Socket socket;
    private ClientDescriptor client_dc;
    private ConnectionProxy connection;

    public void addConsumer(interfaces.StringConsumer sc){

    }
    public void removeConsumer(interfaces.StringConsumer sc){

    }
    public void consume(String str){
        //Suppose to take the string it receive (str) and put it on the screen.
        this.chatArea.append("\n" + str);
    }

    public ClientGUI()
    {
        BuildGUI(this);
    }

    public void BuildGUI(ClientGUI gui){
        //General structure
        this.chatboard = new JFrame("Chat System");
        JPanel top_panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel middle_panel = new JPanel(new BorderLayout());
        JPanel bottom_panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        chatboard.setLayout(new BorderLayout());
        chatboard.setSize(500,500);

        //Components
        this.hostname = new JTextField("127.0.0.1");
        this.hostname.setPreferredSize(new Dimension(120,40));
        this.port = new JTextField("2080");
        this.port.setPreferredSize(new Dimension(70,40));
        this.nickname = new JTextField("Nickname");
        this.nickname.setPreferredSize(new Dimension(120,40));
        JButton connectBtn = new JButton("Connect");
        connectBtn.setPreferredSize(new Dimension(70,40));
        connectBtn.addActionListener(new ConnectActionListener(gui));

        this.chatArea = new JTextArea("Welcome to...\nThe Amazing Chat System");
        this.chatArea.setEditable(false);
        this.chatArea.setBorder(BorderFactory.createCompoundBorder(
                this.chatArea.getBorder(),
                BorderFactory.createEmptyBorder(5,5,5,5)
        ));
        JScrollPane scroller = new JScrollPane(this.chatArea);

        this.msg = new JTextField();
        this.msg.setPreferredSize(new Dimension(400,40));
        JButton sendBtn = new JButton("Send");
        sendBtn.setPreferredSize(new Dimension(70,40));
        sendBtn.addActionListener(new SendActionListener());

        //Add components
        chatboard.add(top_panel,BorderLayout.NORTH);
        chatboard.add(middle_panel,BorderLayout.CENTER);
        chatboard.add(bottom_panel,BorderLayout.SOUTH);
        top_panel.add(this.nickname);
        top_panel.add(this.hostname);
        top_panel.add(this.port);
        top_panel.add(connectBtn);
        middle_panel.add(scroller);
        bottom_panel.add(msg);
        bottom_panel.add(sendBtn);

        chatboard.setVisible(true);
    }

    public void AppendTextToChat(String msg){
        this.chatArea.append("\n"+msg);
    }

    public String getHostname() {
        return hostname.getText();
    }

    public int getPort() {
        return Integer.parseInt(this.port.getText());
    }

    public String getNickname() {
        return this.nickname.getText();
    }

    public JTextField getMsg() {
        return msg;
    }

    public JTextArea getChatArea() {
        return chatArea;
    }

    public ConnectionProxy getConnection() {
        return connection;
    }

    public ClientDescriptor getClient() {
        return client_dc;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public void setClient(ClientDescriptor client) {
        this.client_dc = client;
    }

    public void setConnection(ConnectionProxy connection) {
        this.connection = connection;
    }

    //Actions listeners
    class ConnectActionListener implements ActionListener{
        private ClientGUI gui;
        public ConnectActionListener(ClientGUI gui){
            this.gui = gui;
        }
        public void actionPerformed(ActionEvent ae) {
            try{
                setSocket(new Socket(getHostname(),getPort()));
                setConnection(new ConnectionProxy(getSocket()));
                getConnection().consume(getNickname());
                AppendTextToChat("Connection established\n");
                setClient(new ClientDescriptor(getNickname()));
                getClient().setClient_ref(this.gui);
                getConnection().setClient(getClient());
                getConnection().start();
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    class SendActionListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            getConnection().consume(getMsg().getText());
            getMsg().setText("");
        }
    }
}