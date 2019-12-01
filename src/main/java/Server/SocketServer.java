package Server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer implements Runnable{
    private static final Logger logger = LoggerFactory.getLogger(SocketServer.class);
    public static final int PORT=7777;
    private ServerSocket server;
    private Boolean isRun=true;
    public SocketServer() throws IOException {
        server= new ServerSocket(PORT);
    }

    public static void main(String[] args) {
        try {
            new SocketServer().run();
        } catch (IOException e) {
            logger.error("服务器启动失败");
        }
    }

    public void run(){
          while (isRun){
              Socket socket=null;
              try {
                  socket = server.accept();
                  logger.info("建立tcp连接成功，客户端ip:{}，端口：{}",socket.getRemoteSocketAddress(),socket.getPort());
              } catch (IOException e) {
                   logger.error("tcp握手失败");
                   continue;
              }
              serverSocketThread st = null;
              try {
                  st = new serverSocketThread(socket);
              } catch (IOException e) {
                  logger.error("socket线程启动失败");
                  continue;
              }
              new Thread(st).start();
              logger.info("启动新的socket成功");
          }
          logger.info("serverSocket结束，服务器关闭");
    }
    public void shutdown(){
        this.isRun=false;
    }


}

class serverSocketThread implements Runnable{
     private static final Logger logger = LoggerFactory.getLogger(serverSocketThread.class);
    private Socket socket=null;
    private DataInputStream input;
    private DataOutputStream out;
    serverSocketThread(Socket socket) throws IOException {
        this.socket=socket;
       this.input = new DataInputStream(socket.getInputStream());
        this.out = new DataOutputStream(socket.getOutputStream());
    }
    @Override
    public void run() {

       try {
           while (!socket.isClosed()) {
               String clientMessage=null;
               try {
                  clientMessage = input.readUTF();
               }catch (Exception e){
                   logger.error("读取失败，看来是客户端关闭了");
                   break;
               }
               System.out.println("客户端说：" + clientMessage);
               try {
                   out.writeUTF("777");
               } catch (IOException e) {
                   logger.error("服务器回应异常");
               }
           }
       } finally {
           try {
               input.close();
               out.close();
               socket.close();
               logger.info("socket正常结束");
           }catch (Exception e){
               logger.error("流关闭失败");
           }
       }
    }
}