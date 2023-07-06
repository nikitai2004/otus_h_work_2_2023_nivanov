import animals.Animal;
import data.CommandsData;
import factory.AnimalFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
public class Main {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<>();
        while (true) {
            System.out.println("Введите одну из команд - add / list / exit ");
            String commandStr = scanner.next().trim().toUpperCase(Locale.ROOT);
            boolean isExist = false;
            for (CommandsData commandsData : CommandsData.values()) {
                if (commandsData.name().equals(commandStr)) {
                    isExist = true;
                    break;
                }
            }
            if (!isExist) {
                System.out.printf("Команда %s не поддерживается%n", commandStr);
                continue;
            }
            CommandsData commandsData = CommandsData.valueOf(commandStr);
            switch (commandsData) {
                case ADD: {
                    System.out.println("Введите одно из животных cat/dog/duck");
                    AnimalFactory animalFactory = new AnimalFactory();
                    String animalStr = scanner.next().trim().toUpperCase(Locale.ROOT);
                    Animal animal = animalFactory.create(animalStr);
                    while (animal == null) {
                        System.out.println("Введен неверный тип животного - введите одно из cat/dog/duck");
                        animalStr = scanner.next().trim().toUpperCase(Locale.ROOT);
                        animal = animalFactory.create(animalStr);
                    }
                    animals.add(fillAnimalData(animal));
                    break;
                }
                case LIST: {
                    for (Animal animal : animals) {
                        System.out.println(animal.toString());
                    }
                    break;
                }
                case EXIT: {
                    System.exit(0);
                }
            }
        }
    }
    private static Animal fillAnimalData(Animal animal) {
        System.out.println("Введите Имя животного");
        animal.setName(scanner.next());
        System.out.println("Введите Цвет животного");
        animal.setColor(scanner.next());

        System.out.println("Введите Возраст животного, в целых годах и больше нуля");
        Scanner sc = new Scanner(System.in);
        int i = 1;
        int number = 0;
        while (i < 2) {
            if (sc.hasNextInt()) {
                number = sc.nextInt();
                if (number > 0 & number < 10000) {
                    i = 2;
                } else {
                    System.out.println("Неверный возраст. Введите Возраст животного снова!");
                }
            } else {
                System.out.println("Неверный возраст. Введите Возраст животного снова!");
                sc = new Scanner(System.in);
            }
        }
        animal.setAge(number);

        System.out.println("Введите Вес животного");
        sc = new Scanner(System.in);
        i = 1;
        number = 0;
        while (i < 2) {
            if (sc.hasNextInt()) {
                number = sc.nextInt();
                if (number > 0 & number < 1000000) {
                    i = 2;
                } else {
                    System.out.println("Неверный вес. Введите Вес животного снова!");
                }
            } else {
                System.out.println("Неверный вес. Введите Вес животного снова!");
                sc = new Scanner(System.in);
            }
        }
        animal.setWeight(number);
        animal.say();
        return animal;
    }
}