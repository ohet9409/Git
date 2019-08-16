
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;


public class Client extends JFrame implements ActionListener {

   // GUI�ڿ�
   private JPanel main_pnl;
   private JTextField hostIP_tf;
   private JTextField port_tf;
   private JTextField userID_tf;
   private JTextField chatting_tf;
   private JTextArea viewChat_ta;
   private JButton connect_btn;
   private JButton confirm_btn;
   private JButton sendNote_btn;
   private JButton joinRomm_btn;
   private JList totalList_lst; // ��ü������ ����Ʈ
   private JList roomList_lst; // �� ����Ʈ
   private JButton btn_makeRoom;
   private JButton btn_outRoom;
   private JButton btn_end;
   private JPanel panel_1;

   // network �ڿ�
   private Socket socket;
   private String ip;
   private int port;
   private String user_id;
   private InputStream is;
   private OutputStream os;
   private DataInputStream dis;
   private DataOutputStream dos;

   // �׿� ������
   private Vector<String> user_Vclist = new Vector<String>();
   private Vector<String> roomList_vc = new Vector<String>();
   private StringTokenizer st;
   private String my_roomName;

   public Client() {
      init();
      addListener();
   }

   private void init() {
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(100, 100, 474, 483);
      main_pnl = new JPanel();
      main_pnl.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(main_pnl);
      main_pnl.setLayout(null);

      JTabbedPane Jtab = new JTabbedPane(JTabbedPane.TOP);
      Jtab.setBounds(12, 27, 328, 407);
      main_pnl.add(Jtab);

      panel_1 = new JPanel();
      Jtab.addTab("�α���", null, panel_1, null);
      panel_1.setLayout(null);

      JLabel hostIP_lbl = new JLabel("Host_IP ");
      hostIP_lbl.setFont(new Font("�޸ո���T", Font.BOLD, 13));
      hostIP_lbl.setBounds(12, 25, 91, 15);
      panel_1.add(hostIP_lbl);

      hostIP_tf = new JTextField();
      hostIP_tf.setFont(new Font("�޸ո���T", Font.BOLD, 13));
      hostIP_tf.setBounds(112, 21, 199, 21);
      panel_1.add(hostIP_tf);
      hostIP_tf.setColumns(10);

      JLabel port_lbl = new JLabel("Server_Port");
      port_lbl.setFont(new Font("�޸ո���T", Font.BOLD, 13));
      port_lbl.setBounds(12, 72, 91, 15);
      panel_1.add(port_lbl);

      port_tf = new JTextField();
      port_tf.setFont(new Font("�޸ո���T", Font.BOLD, 13));
      port_tf.setBounds(112, 69, 199, 21);
      panel_1.add(port_tf);
      port_tf.setColumns(10);

      JLabel userID_lbl = new JLabel("User_ID");
      userID_lbl.setFont(new Font("�޸ո���T", Font.BOLD, 13));
      userID_lbl.setBounds(12, 122, 91, 15);
      panel_1.add(userID_lbl);

      userID_tf = new JTextField();
      userID_tf.setBounds(112, 119, 199, 21);
      panel_1.add(userID_tf);
      userID_tf.setColumns(10);

      JLabel img_lbl = new JLabel("input the image");
      img_lbl.setIcon(new ImageIcon());
      img_lbl.setBounds(12, 213, 299, 155);
      panel_1.add(img_lbl);

      connect_btn = new JButton("connect");
      connect_btn.setFont(new Font("�޸ո���T", Font.BOLD, 12));
      connect_btn.setBounds(214, 162, 97, 23);
      panel_1.add(connect_btn);

      JPanel panel = new JPanel();
      Jtab.addTab("����", null, panel, null);
      panel.setLayout(null);

      JLabel totalList_lbl = new JLabel("��ü������");
      totalList_lbl.setHorizontalAlignment(SwingConstants.CENTER);
      totalList_lbl.setFont(new Font("�޸ո���T", Font.BOLD, 13));
      totalList_lbl.setBounds(12, 28, 102, 15);
      panel.add(totalList_lbl);

      JLabel roomList_lbl = new JLabel("�� ����Ʈ");
      roomList_lbl.setHorizontalAlignment(SwingConstants.CENTER);
      roomList_lbl.setFont(new Font("�޸ո���T", Font.BOLD, 13));
      roomList_lbl.setBounds(209, 27, 102, 15);
      panel.add(roomList_lbl);

      totalList_lst = new JList();
      totalList_lst.setBounds(12, 69, 102, 257);
      panel.add(totalList_lst);

      roomList_lst = new JList();
      roomList_lst.setBounds(209, 69, 102, 257);
      panel.add(roomList_lst);

      sendNote_btn = new JButton("����������");
      sendNote_btn.setFont(new Font("�޸ո���T", Font.BOLD, 12));
      sendNote_btn.setBounds(12, 345, 102, 23);
      panel.add(sendNote_btn);

      joinRomm_btn = new JButton("ä�ù�����");
      joinRomm_btn.setFont(new Font("�޸ո���T", Font.BOLD, 12));
      joinRomm_btn.setBounds(209, 345, 102, 23);
      panel.add(joinRomm_btn);
      hostIP_tf.setText("127.0.0.1");

      JPanel panel_2 = new JPanel();
      Jtab.addTab("ä��", null, panel_2, null);
      panel_2.setLayout(null);

      viewChat_ta = new JTextArea();
      viewChat_ta.setEnabled(false);
      viewChat_ta.setEditable(false);
      viewChat_ta.setFont(new Font("�޸ո���T", Font.BOLD, 12));
      viewChat_ta.setBounds(0, 0, 323, 337);
      panel_2.add(viewChat_ta);

      chatting_tf = new JTextField();
      chatting_tf.setFont(new Font("�޸ո���T", Font.BOLD, 11));
      chatting_tf.setBounds(0, 347, 214, 21);
      panel_2.add(chatting_tf);
      chatting_tf.setColumns(10);

      confirm_btn = new JButton("�� ��");
      confirm_btn.setFont(new Font("�޸ո���T", Font.BOLD, 12));
      confirm_btn.setBounds(226, 346, 97, 23);
      panel_2.add(confirm_btn);

      JScrollPane scrollPane = new JScrollPane();
      scrollPane.setEnabled(false);
      scrollPane.setBounds(0, 0, 323, 337);
      panel_2.add(scrollPane);

      btn_makeRoom = new JButton("�� �����");
      btn_makeRoom.setFont(new Font("�޸ո���T", Font.BOLD, 11));
      btn_makeRoom.setBounds(352, 93, 97, 23);
      main_pnl.add(btn_makeRoom);

      btn_outRoom = new JButton("�� ������");
      btn_outRoom.setFont(new Font("�޸ո���T", Font.BOLD, 12));
      btn_outRoom.setBounds(352, 150, 97, 23);
      main_pnl.add(btn_outRoom);
      btn_outRoom.setEnabled(false);
      btn_end = new JButton("����");
      btn_end.setFont(new Font("�޸ո���T", Font.BOLD, 12));
      btn_end.setBounds(352, 398, 97, 23);
      main_pnl.add(btn_end);
      setVisible(true);

   }

   private void connectServer() {
      try {
         // ������ �����մϴ�.
         socket = new Socket(ip, port);
         network();
      } catch (UnknownHostException e) {
         JOptionPane.showMessageDialog(null, "�������!", "�˸�",
               JOptionPane.ERROR_MESSAGE);
      } catch (IOException e) {
         JOptionPane.showMessageDialog(null, "�������!", "�˸�",
               JOptionPane.ERROR_MESSAGE);
      }
   }

   private void network() {
      
      try {
         is = socket.getInputStream();
         dis = new DataInputStream(is);
         os = socket.getOutputStream();
         dos = new DataOutputStream(os);

         user_id = userID_tf.getText().trim();
         sendmessage(user_id);

         // ���Ϳ� ������ id �� �����ϰ� ����Ʈ ȭ�鿡 �߰������ش�.
         user_Vclist.add(user_id);
         totalList_lst.setListData(user_Vclist);

         Thread cth = new Thread(new Runnable() {
            @Override
            public void run() {
               while (true) {
                  try {
                     // �����κ��� ���ŵ� �޼���.
                     String msg = dis.readUTF();
                     inmessage(msg);
                  } catch (IOException e) {
                     try {
                        user_Vclist.removeAll(user_Vclist);
                        roomList_vc.removeAll(roomList_vc);
                        totalList_lst.setListData(user_Vclist);
                        roomList_lst.setListData(roomList_vc);
                        viewChat_ta.setText("\n");
                        is.close();
                        os.close();
                        dis.close();
                        dos.close();
                        socket.close();
                        JOptionPane.showMessageDialog(null, "������ �����!", "�˸�",
                              JOptionPane.ERROR_MESSAGE);
                        break;
                     } catch (Exception e2) {
                        return ;
                     }
                  }
               }
            }
         });
         cth.start();
      } catch (IOException e) {
         JOptionPane.showMessageDialog(null, "�������!", "�˸�",
               JOptionPane.ERROR_MESSAGE);
      }// Stream �غ�Ϸ�
      connect_btn.setEnabled(false);
   }

   private void inmessage(String str) {

      st = new StringTokenizer(str, "/");

      String protocol = st.nextToken();
      String message = st.nextToken();

      System.out.println("��������" + protocol);
      System.out.println("�޼���" + message);

      if (protocol.equals("NewUser")) {
         user_Vclist.add(message);
         totalList_lst.setListData(user_Vclist);
      } else if (protocol.equals("OldUser")) {
         user_Vclist.add(message);
         totalList_lst.setListData(user_Vclist);
      } else if (protocol.equals("Note")) {
         st = new StringTokenizer(message, "@");
         String user = st.nextToken();
         String note = st.nextToken();
         JOptionPane.showMessageDialog(null, note, user + "�� ���� �� �޼���",
               JOptionPane.CLOSED_OPTION);
      } else if (protocol.equals("CreateRoom")) {
         // �游��Ⱑ �������� ���
         my_roomName = message;
         joinRomm_btn.setEnabled(false);
         btn_outRoom.setEnabled(true);
         btn_makeRoom.setEnabled(false);
      } else if (protocol.equals("CreateRoomFail")) {
         JOptionPane.showMessageDialog(null, "���� �� �̸��� �����մϴ�.!", "�˸�",
               JOptionPane.ERROR_MESSAGE);
      } else if (protocol.equals("new_Room")) {
         roomList_vc.add(message);
         roomList_lst.setListData(roomList_vc);
      } else if (protocol.equals("Chatting")) {
         String msg = st.nextToken();
         viewChat_ta.append(message + " : " + msg + "\n");
      } else if (protocol.equals("OldRoom")) {
         roomList_vc.add(message);
         roomList_lst.setListData(roomList_vc);
      } else if (protocol.equals("JoinRoom")) {
         my_roomName = message;
         JOptionPane.showMessageDialog(null, "ä�ù� (  " + my_roomName
               + " ) �� ����Ϸ�", "�˸�", JOptionPane.INFORMATION_MESSAGE);
         viewChat_ta.setText("");
      } else if(protocol.equals("UserOut")) {
         user_Vclist.remove(message);
         sendmessage("OutRoom/"+my_roomName);
      } else if(protocol.equals("UserData_Updata")) {
         totalList_lst.setListData(user_Vclist);
         roomList_lst.setListData(roomList_vc);
      } else if(protocol.equals("OutRoom")) {
         viewChat_ta.append("*** (( "+my_roomName+"���� ���� ))***\n");
         my_roomName = null;
         btn_makeRoom.setEnabled(true);
         btn_outRoom.setEnabled(false);
      } else if(protocol.equals("EmptyRoom")) {
         roomList_vc.remove(message);
      //Ŭ���̾�Ʈ�� ���� ���� �Ǿ��� ���� ������� �� ��Ͽ��� �� ���� �����ش�.   
      } else if(protocol.equals("ErrorOutRoom") ) {
         roomList_vc.remove(message);
      }
   }

   private void sendmessage(String msg) {
      try {
         dos.writeUTF(msg);
         dos.flush();
      } catch (IOException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
   }
   // �̺�Ʈ������
   private void addListener() {
      connect_btn.addActionListener(this);
      confirm_btn.addActionListener(this);
      sendNote_btn.addActionListener(this);
      joinRomm_btn.addActionListener(this);
      chatting_tf.addActionListener(this);
      btn_end.addActionListener(this);
      btn_makeRoom.addActionListener(this);
      btn_outRoom.addActionListener(this);
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      if (e.getSource() == connect_btn) {
         if(hostIP_tf.getText().length() ==0) {
            hostIP_tf.setText("IP�� �Է��ϼ���");
            hostIP_tf.requestFocus();
         } else if(port_tf.getText().length() ==0) {
            port_tf.setText("��Ʈ��ȣ�� �Է��ϼ���");
            port_tf.requestFocus();
         } else if(userID_tf.getText().length() == 0) {
            userID_tf.setText("id �� �Է��ϼ���");
            userID_tf.requestFocus();
         } else {
            ip = hostIP_tf.getText();
            try{
            port = Integer.parseInt(port_tf.getText().trim());
            }catch (Exception e2) {
               port_tf.setText("�߸� �Է��Ͽ����ϴ�.");
            }
            user_id = userID_tf.getText().trim();
            // ���������ϱ�
            connectServer();
            setTitle("[" + user_id + " ] �� �����忡 ���Ű� ȯ���մϴ�.");
         }
      } else if (e.getSource() == confirm_btn) {
         System.out.println("���۹�ưŬ��");
         sendmessage("Chatting/" + my_roomName + "/"
               + chatting_tf.getText().trim());
      } else if (e.getSource() == sendNote_btn) {
         System.out.println("�����������ư Ŭ��");
         String user = (String) totalList_lst.getSelectedValue();
         if (user == null) {
            JOptionPane.showMessageDialog(null, "����� �����ϼ���", "�˸�",
                  JOptionPane.ERROR_MESSAGE);
         }
         String note = JOptionPane.showInputDialog("�����޼���");
         if (note != null) {
            sendmessage("Note/" + user + "@" + note);
         }
      } else if (e.getSource() == joinRomm_btn) {
         System.out.println("�������ư Ŭ��");
         String joinRoom = (String) roomList_lst.getSelectedValue();
         btn_outRoom.setEnabled(true);
         btn_makeRoom.setEnabled(false);
         sendmessage("JoinRoom/" + joinRoom);
      } else if (e.getSource() == chatting_tf) {
         if(chatting_tf.getText().length() == 0 ){
            System.out.println("�̰� 0������ ����?");
            sendmessage("Chatting/" + my_roomName + "/"
                  + chatting_tf.getText()+"   ");
         }else {
            sendmessage("Chatting/" + my_roomName + "/"
                  + chatting_tf.getText());
         }
      } else if (e.getSource() == btn_makeRoom) {
         System.out.println("�������ưŬ��");
         String roomName = JOptionPane.showInputDialog("�� �̸��� �Է��ϼ���");
         if (roomName != null) {
            sendmessage("CreateRoom/" + roomName);
         }
      } else if(e.getSource() == btn_outRoom) {
         System.out.println("�泪�����ưŬ��.");
         sendmessage("OutRoom/"+my_roomName);
      } else if(e.getSource() == btn_end) {
         System.exit(0);
      }
      chatting_tf.setText("");
   }
   public static void main(String[] args) {
      new Client();
   }
}

