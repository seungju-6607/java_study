package chapter17;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {

    public final static int PORT = 9000;
    // synchronizedList로 동기화
    public static List<ClientHandler> clients = java.util.Collections.synchronizedList(new ArrayList<>());

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(PORT);
            System.out.println("서버 실행 중 : " + PORT);
            System.out.println("클라이언트 접속 대기 중~");

            while (true) {
                Socket s = server.accept();
                System.out.println("✅클라이언트 접속!!");

                ClientHandler ch = new ClientHandler(s);
                clients.add(ch);
                ch.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler extends Thread {
    private Socket socket;
    private DataInputStream input;
    private DataOutputStream output;

    public ClientHandler(Socket s) {
        try {
            this.socket = s;
            this.input = new DataInputStream(s.getInputStream());
            this.output = new DataOutputStream(s.getOutputStream());
            output.writeUTF("서버에 접속하셨습니다.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run() {
        try {
            while (true) {
                String msg = input.readUTF();
                System.out.println("받은 메시지: " + msg);

                // 접속된 모든 클라이언트에게 메시지 전송
                synchronized (Server.clients) {
                    for (ClientHandler ch : Server.clients) {
                        try {
                            ch.output.writeUTF(msg);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("클라이언트 접속 종료");
        } finally {
            try {
                input.close();
                output.close();
                socket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            Server.clients.remove(this);
        }
    }
}
