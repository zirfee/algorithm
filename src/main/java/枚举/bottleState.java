package 枚举;

public enum bottleState {
   OPEN{
       @Override
       public bottleState nextState() {
           return WAITING;
       }
   },
    WAITING{
        @Override
        public bottleState nextState() {
            return CLOSED;
        }
    },
    CLOSED{
        @Override
        public bottleState nextState() {
            return CLOSED;
        }
    };


    public abstract bottleState nextState();
}
