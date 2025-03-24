package testSave;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

class Animal implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private int age;

    public Animal(String name, int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString(){
        return name+" ("+age+"살)";
    }
}

class Player implements Serializable {
    private String name;
    private int money;
    private List<Animal> animals;

    public Player(String name, int money) {
        this.name = name;
        this.money = money;
        this.animals = new ArrayList<>();
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    public void showInfo() {
        System.out.println("플레이어: " + name);
        System.out.println("소지금: " + money + "원");
        System.out.println("보유한 동물들: " + animals);
    }
}
