package chapter17;

import java.awt.*;
import java.awt.event.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {
        try {
            final String HOST = "localhost";
            final int PORT = 9000;
            
            String NICKNAME = "홍길동";

            Frame f = new Frame("채팅 - " + NICKNAME);
            Panel p = new Panel();
            f.setLayout(new BorderLayout());

            TextArea ta = new TextArea();
            TextField tf = new TextField(40);

            Button send = new Button("전송");
            Button button1 = new Button("종료");

            ta.setEditable(false);
            tf.setText("");

            p.add(tf);
            p.add(send);

            f.add(p, BorderLayout.NORTH);
            f.add(ta, BorderLayout.CENTER);
            f.add(button1, BorderLayout.SOUTH);

            f.setSize(400, 500);
            f.setVisible(true);

            Socket s = new Socket(HOST, PORT);
            DataInputStream input = new DataInputStream(s.getInputStream());
            DataOutputStream output = new DataOutputStream(s.getOutputStream());

            // 서버에서 초기 메시지 수신
            ta.append(input.readUTF() + "\n");

            // 서버 메시지 수신용 스레드
            new Thread(() -> {
                try {
                    while (true) {
                        String msg = input.readUTF();
                        ta.append(msg + "\n");
                    }
                } catch (Exception e) {
                    System.out.println("서버와 연결이 끊어졌습니다.");
                }
            }).start();

            // 전송 버튼 이벤트
            send.addActionListener(e -> {
                try {
                    String message = NICKNAME + " : " + tf.getText();
                    output.writeUTF(message);
                    tf.setText("");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            });

            // 종료 버튼 이벤트
            button1.addActionListener(e -> {
                try {
                    output.close();
                    input.close();
                    s.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                System.out.println("-- 클라이언트 종료 --");
                System.exit(0);
            });

            // 창 닫기 버튼 이벤트
            f.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    try {
                        output.close();
                        input.close();
                        s.close();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    System.exit(0);
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

