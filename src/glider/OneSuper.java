package glider;

public abstract class OneSuper {

    int key;

    public OneSuper(int key) {
        this.key = key;
    }

    abstract void firstAction();

    public void secondAction(){
        System.out.println("Second action");
    }
}
