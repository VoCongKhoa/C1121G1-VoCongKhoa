package ss7_abstract_class_va_interface.bai_tap.animal;

public class Tiger extends Animal implements Edible{
    @Override
    public String howToEat() {
        return "Could be hunted and grilled!";
    }

    @Override
    public String makeSound() {
        return "Tiger: roarrrrr!";
    }
}
