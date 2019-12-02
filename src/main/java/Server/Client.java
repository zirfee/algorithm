package Server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.Socket;
import java.util.LinkedList;
import java.util.Queue;

public class Client implements Runnable{
      private static final Logger logger = LoggerFactory.getLogger(Client.class);
      Socket socket =null;
    DataInputStream input=null;
    DataOutputStream out=null;
    Queue<String> queue=null;
      Client(Queue<String> queue) throws IOException {
          this.socket =new Socket("localhost",7777);
          input = new DataInputStream(socket.getInputStream());
          out = new DataOutputStream(socket.getOutputStream());
          this.queue=queue;
      }


      public void run(){
              while (true) {
                  String s=null;
                  synchronized (queue) {
                      try {
                          queue.wait();
                          s = queue.poll();
                      } catch (InterruptedException e) {
                          e.printStackTrace();
                      }
                  }

                 try {
                    out.writeUTF(s);
                     logger.info("客户端发送{}", s);
                 }catch (Exception e){
                     logger.error("客户端发送异常，服务器已关闭");
                     break;
                 }

                 try {
                     String str = input.readUTF();
                     logger.info("服务器发送：{}", str);
                 }catch (Exception e){
                     logger.error("客户端接受异常，服务器已关闭");
                     break;
                 }

              }


              try {
                  out.close();
                  input.close();
                  socket.close();
                  logger.info("客户端正常结束");
              }catch (Exception e){
                  logger.info("客户端不正常结束");
              }


      }

}
