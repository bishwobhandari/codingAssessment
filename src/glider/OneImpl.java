package glider;

public class OneImpl extends OneSuper{


    public OneImpl(int key) {
        super(key);
    }

    @Override
    void firstAction() {
        super.secondAction();
    }
}
