package toy.raffle.model;

import java.util.List;

public interface SaveAndLoad {

    void saving(List<Toy> lst);
    String loading(String path);
}
