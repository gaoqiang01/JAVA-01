package socket;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @param
 * @author silent
 * @time 9:57 2021/1/18
 * @description  使用固定线程池处理
 *  压测结果(40并发 60秒) -- >> RPS: 1175.1 (requests/second)
 *
 *
 */
public class HttpSever03 {


    public static void main(String[] args) throws IOException {
        ExecutorService executorService = Executors.newFixedThreadPool(40);
        final ServerSocket serverSocket = new ServerSocket(8083);

        while (true) {
            try {
                final Socket socket = serverSocket.accept();
                executorService.execute(() -> {
                    service(socket);
                });

            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    private static void service(Socket socket) {


        try {
            Thread.sleep(20);
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
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
