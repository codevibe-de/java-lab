package threads;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.IntStream;

public class ThreadDemoFinal {

    public static void main(String[] args) throws InterruptedException {
        List<String> collectedIds = new ArrayList<>();
        Runnable runnable = () -> {
            System.out.println("Starting...");
            int n = 0;
            while (true) {
                n++;
                String id = UUID.randomUUID().toString();
                if (id.startsWith("000000")) {
                    System.out.println(n + ": " + id);
                    collectedIds.add(id);
                    break;
                }
            }
        };

        IntStream.rangeClosed(1, Runtime.getRuntime().availableProcessors())
                .mapToObj(n -> new Thread(runnable))
                .peek(Thread::start)
                .toList()
                .forEach(ThreadDemoFinal::join);
    }


    private static void join(Thread thread) {
        try {
            thread.join();
        } catch (InterruptedException ignored) {
        }
    }
}
