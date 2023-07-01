package toy.raffle.model;

import toy.raffle.model.toy.Toy;

import java.util.List;

public interface SaveAndLoad {

    void saving(List<Toy> lst);
    String loading(String name);
}
