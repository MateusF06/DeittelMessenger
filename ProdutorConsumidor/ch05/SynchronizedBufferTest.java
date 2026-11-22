public class SynchronizedBufferTest {
    public static void main(String[] args) {
        Buffer sharedLocation = new SynchronizedBuffer();
        Producer producer = new Producer(sharedLocation);
        Consumer consumer = new Consumer(sharedLocation);
        producer.start();
        consumer.start();
    }
}
