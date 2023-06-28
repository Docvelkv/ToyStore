package toy.raffle;

import toy.raffle.model.Toy;
import toy.raffle.model.ToysService;

import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        ToysService service = new ToysService();
        PriorityQueue<Toy> set = service.setToys(10, 3);
        service.drawingToys(set);
    }
}