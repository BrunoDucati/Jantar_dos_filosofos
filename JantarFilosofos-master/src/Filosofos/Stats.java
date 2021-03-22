package Filosofos;

public class Stats {
    private String name;
    private int number;
    private int timesAte = 0;
    private int timesTriedEat = 0;
    private int timesThought = 0;

    public void setName(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public void sumTimesAte(){
        timesAte++;
    }

    public void sumTimesTriedEating(){
        timesTriedEat++;
    }

    public void sumTimesThought(){
        timesThought++;
    }

    public void actionsReport(){
        System.out.println("=====================================");
        System.out.println("| " + name + " comeu " + timesAte + " vezes" + "\t\t\t|");
        System.out.println("| " + name + " tentou comer " + timesTriedEat + " vezes" + "\t|");
        System.out.println("| " + name + " pensou " + timesThought+ " vezes" + "\t\t\t|");
        System.out.println("=====================================");
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }
}
