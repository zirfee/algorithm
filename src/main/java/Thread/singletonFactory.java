package Thread;

public class singletonFactory {
    volatile private static Obj o =null;
    private static Object obj = new Object();
    public static Obj getSingletonInstance(){
        if (o==null) {
            synchronized (obj) {
                if (o == null) o = new Obj();
            }
        }
        return o;
    }
}

class Obj {
}