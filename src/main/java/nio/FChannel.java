package nio;

import java.io.*;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.FileChannel;

public class FChannel {
    public static void main(String[] args) throws IOException {
        FileInputStream in = new FileInputStream("C:"+ File.separator +"Users"+File.separator+"26984"+File.separator+".gitconfig");
        FileOutputStream out = new FileOutputStream("C:"+ File.separator +"Users"+File.separator+"26984"+File.separator+"target");
            FileChannel in_ch=in.getChannel();
            FileChannel out_ch=out.getChannel();
        ByteBuffer buffer =ByteBuffer.allocate(512);
        while(true){
            buffer.clear();
          int len=  in_ch.read(buffer);
          if (len==-1) break;
            buffer.flip();
            out_ch.write(buffer);
        }
    }
}
