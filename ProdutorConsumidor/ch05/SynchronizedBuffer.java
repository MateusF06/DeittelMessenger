public class SynchronizedBuffer implements Buffer {
    private int buffer;
    private boolean occupied = false;

    @Override
    public synchronized void set(int value) {
        while (occupied) {
            try { wait(); }
            catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new IllegalStateException("Producer interrupted", e);
            }
        }
        buffer = value;
        occupied = true;
        System.err.println(Thread.currentThread().getName() + " writes " + value);
        notifyAll();
    }

    @Override
    public synchronized int get() {
        while (!occupied) {
            try { wait(); }
            catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new IllegalStateException("Consumer interrupted", e);
            }
        }
        int value = buffer;
        occupied = false;
        System.err.println(Thread.currentThread().getName() + " reads " + value);
        notifyAll();
        return value;
    }
}
