package toy.raffle.model;

import java.util.Comparator;

public class ToysComparator implements Comparator<Toy> {

    /**
     * переопределение метода compare. Объекты сравниваются:
     * по весу
     * при одинаковом весе, по названию
     * @param o1 первый объект для сравнения
     * @param o2 второй объект для сравнения
     * @return int
     */
    @Override
    public int compare(Toy o1, Toy o2) {
        if (o1 == o2) return 0;
        if (o1 == null) return -1;
        if (o2 == null) return 1;
        int difWeight = o1.getWight() - o2.getWight();
        if (difWeight != 0) return difWeight;
        return o1.getTitle().compareTo(o2.getTitle());
    }
}
