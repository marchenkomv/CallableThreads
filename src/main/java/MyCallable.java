import java.util.concurrent.Callable;

public class MyCallable implements Callable {

    private Integer messageCount;
    private Integer sleepTime;
    private Integer cycleCount;

    public MyCallable(String name, Integer sleepTime, Integer cycleCount) {
        this.sleepTime = sleepTime;
        this.messageCount = 0;
        this.cycleCount = cycleCount;
        Thread.currentThread().setName(name);
    }

    @Override
    public Integer call() {
        try {
            for (int i = 0; i < cycleCount; i++) {
                System.out.println("Я поток " + Thread.currentThread().getName() + ". Всем привет!");
                messageCount++;
                Thread.sleep(sleepTime);
            }
        } catch (InterruptedException err) {
            System.out.println("Ошибка при попытке вызова метода sleep для потока " + Thread.currentThread().getName());
        } finally {
            System.out.printf("Поток %s завершен\n", Thread.currentThread().getName());
        }
        return messageCount;
    }
}
