package toy.raffle.model;

import java.util.PriorityQueue;
import java.util.concurrent.ThreadLocalRandom;

public class ToysService {

    /**
     * случайное число из диапазона от 1 до
     * количества существующих игрушек
     * @param quantity количество существующих игрушек
     * @return int
     */
    private int getRandom(int quantity) {
        return ThreadLocalRandom.current().nextInt(1, quantity + 1);
    }

    /**
     * Формирование набора игрушек для розыгрыша
     * @param numToys количество игрушек в наборе
     * @param quantity количество существующих игрушек
     * @return PriorityQueue<Toy>
     */
    public PriorityQueue<Toy> setToys(int numToys, int quantity) {
        PriorityQueue<Toy> set = new PriorityQueue<>(new ToysComparator());
        for (int i = 0; i < numToys; i++) {
            Toy toy = new Toy(getRandom(quantity));
            set.add(toy);
        }
        return set;
    }

    public void drawingToys(PriorityQueue<Toy> set) {
        Toy currentToy;
        while ((currentToy = set.poll()) != null) {
            System.out.println("Ваш приз: " + currentToy);
        }
    }
}
