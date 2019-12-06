package 枚举;

public class bottle {
    private bottleState bs =bottleState.OPEN;

    public bottleState getState(){
        return this.bs;
    }

    public void setNextState(){
        this.bs=this.bs.nextState();
    }

    public static void main(String[] args) {
        bottle b = new bottle();
          System.out.println(b.getState().toString());
        System.out.println("状态改变后：");
        b.setNextState();
        System.out.println(b.getState().toString());
    }
}
