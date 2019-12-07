package Thread;

import javax.swing.plaf.TableHeaderUI;

public class demoTarget extends Thread {
     private Boolean isRun = true;

                             //每个线程运行都有自己的私有栈内存，就像方法用到的参数会先入栈一样，线程运行时用到的成员变量也会先入私有栈作为缓存
    @Override               //一个线程运行run()方法时，为了运行效率考虑，run方法里用到的成员变量并不总是从成员变量里去取,有时会从线程私有栈里去取
    public void run() {    //当另一个线程改变Boolean状态时，成员变量确实改变了，但私有栈内的变量没有改变，从私有栈取值时自然检测不到这种变化
          while (isRun){  //为什么该线程检测不到Boolean的变化，却可以检测到int的变化？
                          // 错觉，跟数据类型无关，关键在于线程是否更新了私有栈变量
          }
        System.out.println("当前线程："+Thread.currentThread().getName()+"停止了");
    }

    public static void main(String[] args) throws InterruptedException {
       demoTarget dt = new demoTarget();
       dt.start();
       Thread.sleep(500);
        dt.isRun=false;
    }
}
