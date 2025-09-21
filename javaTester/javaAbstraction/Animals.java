package javaAbstraction;

public abstract class Animals {
    // A B: dùng chung (Non-Abstract Method)
    public void eat(){
        System.out.println("Eating");
    }

    public void sleep(){
        System.out.println("Sleeping");
    }

    // C: implement lại (Abstract Method)
    public abstract void run();
}
