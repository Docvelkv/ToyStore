package toy.raffle.model;


import java.io.Serializable;

public class Toy implements Serializable {
    TypeToy typeToy;
    private final int id;
    int wight;

    /**
     * Конструктор
     * @param id номер игрушки
     */
    public Toy(int id) {
        this.id = id;
        this.typeToy = getTypeToy();
        this.wight = getWight();
    }

    /**
     * Получение номера игрушки
     * @return int
     */
    public int getId() {
        return id;
    }

    /**
     * Получение типа игрушки
     * @return TypeToy
     */
    public TypeToy getTypeToy() {
        if (this.id == 1) return TypeToy.doll;
        if (this.id == 2) return TypeToy.robot;
        if (this.id == 3) return TypeToy.constructor;
        return null;
    }

    /**
     * Получение веса игрушки (в граммах)
     * @return int
     */
    public int getWight() {
        if (this.id == 1) return 1300;
        if (this.id == 2) return 900;
        if (this.id == 3) return 1600;
        return  0;
    }

    /**
     * Получение названия игрушки
     * @return String
     */
    public String getTitle() {
        if (this.id == 1) return "Алиса";
        if (this.id == 2) return "Гига7";
        if (this.id == 3) return "LEGO";
        return "Игрушек с таким id нет";
    }

    /**
     * переопределение метода toString
     * @return String
     */
    @Override
    public String toString() {
        return "\nИгрушка: №" + this.getId() + ", " +
                this.getTypeToy() + " \"" + this.getTitle() + "\"" + ", " +
                "вес - " + this.getWight() + "г.";
    }
}

