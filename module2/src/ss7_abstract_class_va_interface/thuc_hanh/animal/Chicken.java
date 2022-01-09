package ss7_abstract_class_va_interface.bai_tap.animal;

public class Chicken extends Animal implements Edible{
    @Override
    public String howToEat() {
        return "Could be fried";
    }

    @Override
    public String makeSound() {
        return "Chicken: cuc-cuc-tac-tac!";
    }
}
