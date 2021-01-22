package socket;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @param
 * @author silent
 * @time 9:57 2021/1/18
 * @description   每个请求创建一个线程
 *
 *
 * 压测结果(40并发 60秒) -->> RPS: 1064.4 (requests/second)
 *
 */
public class HttpSever02 {



    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket= new ServerSocket(8082);

        while (true){
            try {
                Socket socket = serverSocket.accept();
                new Thread(()->{
                    service(socket);
                }).start();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    private static void service(Socket socket) {


        try {
            Thread.sleep(20);
            PrintWriter printWriter= new PrintWriter(socket.getOutputStream(),true);
            printWriter.println("http/1.1 200 ok ");
            printWriter.println("Content-typpe/html;charset=utf-8");
            printWriter.println();
            printWriter.println("hello,nio");
            printWriter.close();
            socket.close();
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }


    }


}
