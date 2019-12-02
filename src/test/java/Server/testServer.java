package Server;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class testServer {                     //执行测试方法相当于新开启了一个jvm执行，方法执行完毕后关闭jvm，
                                              // 如果方法里新开了线程无论该线程有没有执行完都会关闭
    Queue<String> queue = new LinkedList();
    @Test
    public void ts(){
        try {
            new SocketServer().start();
        } catch (IOException e) {
                System.out.println("服务器启动失败");
        }
    }
    @Test
    public void tc() throws IOException {
        Queue<String> queue = new LinkedList();
        try {
            new Thread(new Client(queue)).start();
        } catch (IOException e) {
            System.out.println("client线程启动失败");
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s=null;
        while((s=reader.readLine())!=null){
            synchronized (queue){
                queue.offer(s);
                queue.notify();
            }
        }
    }

}
