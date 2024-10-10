package threads;

// this class uses the TEMPLATE design pattern
public abstract class StopableThread extends Thread {

    boolean stopped = false;

    @Override
    public void run() {
        starting();
        while (!stopped) {
            loop();
        }
        stopped();
    }

    protected abstract void starting();

    protected abstract void loop();

    protected abstract void stopped();

    public void stopThread() {
        this.stopped = true;
    }

}
