import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        final ExecutorService threadPool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        try {
            threadPool.invokeAll(getTasks());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            System.out.println("Самый быстрый поток крутанул цикл " + threadPool.invokeAny(getTasks()) + " раз");
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        threadPool.shutdown();
    }

    public static List<Callable<Integer>> getTasks() {
        List<Callable<Integer>> tasks = new ArrayList<>();
        tasks.add(new MyCallable("1", 250, 10));
        tasks.add(new MyCallable("2", 500, 6));
        tasks.add(new MyCallable("3", 750, 5));
        tasks.add(new MyCallable("4", 1000, 3));
        return tasks;
    }
}
