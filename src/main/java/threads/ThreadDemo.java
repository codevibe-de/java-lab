package threads;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadDemo {

    public static Map<Integer, String> collectedIds = new ConcurrentHashMap<>();
    public static AtomicInteger resultCounter = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        //
        final CountDownLatch latch = new CountDownLatch(1);
        Runnable miningRunnable = () -> {
            System.out.println("Starting on " + Thread.currentThread());
            while (latch.getCount() > 0) {
                String id = UUID.randomUUID().toString();
                if (id.startsWith("000000")) {
                    collectedIds.put(
                            resultCounter.getAndIncrement(),
                            id
                    );
                    System.out.println(id);
                    latch.countDown();
                    return;
                }
            }
        };

        // let it run
        new StopableMinindThread().start();
    }


    static class StopableMinindThread extends StopableThread {

        @Override
        protected void starting() {
            System.out.println("Starting on " + Thread.currentThread());
        }

        @Override
        protected void loop() {
            String id = UUID.randomUUID().toString();
            if (id.startsWith("000000")) {
                collectedIds.put(
                        resultCounter.getAndIncrement(),
                        id
                );
                System.out.println(id);
                stopThread();
            }
        }

        @Override
        protected void stopped() {
            System.out.println("Thread finished");
        }
    }


    private static void join(Thread thread) {
        try {
            thread.join(); // aktuelle Thread wartet auf "thread"
        } catch (InterruptedException ignored) {
        }
    }
}