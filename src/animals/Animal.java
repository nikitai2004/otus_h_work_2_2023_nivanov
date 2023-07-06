package animals;

public abstract class Animal {
    private String name = "";
    private int age = 0;
    private int weight = 0;
    private String color = "";

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getWeight() {
        return weight;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    @Override
    public String toString() {
        return String.format("Привет! Меня зовут %s, мне %d %s, я вешу: %d кг, мой цвет: %s",
                getName(), getAge(), getYearPadej(), getWeight(), getColor());
    }
    private String getYearPadej() {
        int ost = getAge() % 10;

        if (ost > 5 || getAge() >= 11 && getAge() <= 14) {
            return "лет";
        }
        if (ost == 1) {
            return "год";
        }
        if (ost >= 2 && ost <= 4) {
            return "года";
        }
        if (ost > 0) {
            return "лет";
        }
        return "ошибка возраста";
    }
    public void say() {
        System.out.println("Я говорю");
    }
    public void go() {
        System.out.println("Я иду");
    }
    public void eat() {
        System.out.println("Я ем");
    }
    public void drink() {
        System.out.println("Я пью");
    }
}