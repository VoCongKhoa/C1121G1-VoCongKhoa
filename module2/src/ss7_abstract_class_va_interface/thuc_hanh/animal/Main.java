package ss7_abstract_class_va_interface.bai_tap.animal;

public class Main {
    public static void main(String[] args) {
        //Animal
        Animal[] animals = new Animal[2];
        animals[0] = new Tiger();
        animals[1] = new Chicken();
        for (Animal animal : animals) {
            System.out.println(animal.makeSound());
            Edible edibler;
            if (animal instanceof Chicken) {
                edibler = (Chicken) animal;
            } else {
                edibler = (Tiger) animal;
            }
            System.out.println(edibler.howToEat());
        }
        //Fruit
        Fruit[] fruits = new Fruit[2];
        fruits[0] = new Orange();
        fruits[1] = new Apple();
        for (Fruit fruit : fruits) {
            System.out.println(fruit.howToEat());
        }
    }
}
