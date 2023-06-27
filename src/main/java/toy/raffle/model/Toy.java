package toy.raffle.model;


public class Toy {
    private final Name name;
    private final int id;
    private final int wight;

    public Toy(int id) {
        this.id = id;
        this.name = getName();
        this.wight = getWight();
    }

    public int getId() {
        if (this.name == Name.doll) return 1;
        if (this.name == Name.robot) return 2;
        if (this.name == Name.constructor) return 3;
        return 0;
    }

    public Name getName() {
        if (this.id == 1) return Name.doll;
        if (this.id == 2) return Name.robot;
        if (this.id == 3) return Name.constructor;
        return null;
    }

    public int getWight() {
        if (this.id == 1) return 1300;
        if (this.id == 2) return 900;
        if (this.id == 3) return 1600;
        return  0;
    }

    public String getTitle() {
        if (this.id == 1) return "Кукла Алиса";
        if (this.id == 2) return "Робот Гига7";
        if (this.id == 3) return "Конструктор LEGO";
        return "";
    }

    @Override
    public String toString() {
        return "\nИгрушка: №" + this.getId() + ", " +
                "название - " + this.getTitle() + ", " +
                "вес - " + this.getWight() + "г.";
    }
}

