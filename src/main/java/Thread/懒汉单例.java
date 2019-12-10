package Thread;

public class 懒汉单例 {
    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                int s = singletonFactory.getSingletonInstance().hashCode();
                System.out.println(s);
            }).start();
        }
    }
}


