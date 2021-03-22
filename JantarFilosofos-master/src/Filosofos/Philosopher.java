package Filosofos;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Philosopher implements Runnable {
    private Stats stats;
    private Semaphore forks[];
    private long dinnerTime = 0;

    private int numberPhilosofers;

    public Philosopher (Semaphore forks[], int numberPhilosofers, String name, Stats stats, long dinnerTime, int number) {
        this.forks = forks;
        this.numberPhilosofers = numberPhilosofers;
        this.dinnerTime = dinnerTime;
        this.stats = stats;
        stats.setName(name, number);
    }

    private void think() {
        try {
            System.out.println(stats.getName() + " esta pensando!");
            Thread.sleep(2500);
            System.out.println(stats.getName() + " ainda esta pensando...");
            Thread.sleep(2500);
            System.out.println(stats.getName() + " pensou!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        stats.sumTimesThought();
    }

    private void eat() {
        try {
            System.out.println(stats.getName() + " esta comendo!");
            Thread.sleep(1000);
            System.out.println(stats.getName() + " ainda esta comendo...");
            Thread.sleep(1000);
            System.out.println(stats.getName() + " comeu!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        stats.sumTimesAte();
    }

    private void takeFork(int fork) {
        if (forks[fork].tryAcquire()){
            forks[fork].release();
            try {
                forks[fork].acquire();
                tryingToEat(fork);
                forks[fork].release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void tryingToEat(int fork){
        Random random = new Random();
        int randomTime = 0;
        int time = 0;

        randomTime = random.nextInt(3);

        try {
            while (time < randomTime){
                System.out.println(stats.getName() + " vai tentar comer!");
                if (forks[(fork+1) % numberPhilosofers].tryAcquire()){
                   forks[(fork+1) % numberPhilosofers].release();
                    forks[(fork+1) % numberPhilosofers].acquire();
                    eat();
                    forks[(fork+1) % numberPhilosofers].release();
                    break;
                }
                else {
                    System.out.println(stats.getName() + " ainda tentando...");
                    time++;

                }

                if (time == randomTime) {
                    System.out.println(stats.getName() + " nao conseguiu comer :c");
                    Thread.sleep(randomTime);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        stats.sumTimesTriedEating();
    }

    @Override
    public void run() {
        int fork = stats.getNumber();

        long inicio = System.currentTimeMillis();
        long fim;

        while(true){
            think();
            takeFork(fork);

            fim = System.currentTimeMillis();
            if((fim-inicio)>(dinnerTime*1000)) {
                break;
            }
        }
    }
}
