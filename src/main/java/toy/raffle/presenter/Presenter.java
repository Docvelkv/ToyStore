package toy.raffle.presenter;

import toy.raffle.model.toy.Toy;
import toy.raffle.model.ToysService;

import java.util.List;

public class Presenter {
    ToysService service = new ToysService();

    public int numberOfSavedFiles(){
        return service.numberOfSavedFiles();
    }

    public void raffle(int numToys, int quantity){
        List<Toy> lst = service.drawingToys(service.setToys(numToys, quantity));
        service.saving(lst);
        StringBuilder sb = new StringBuilder();
        for (Toy toy : lst){
            sb.append(toy);
        }
        System.out.println(sb);
    }

    public void loading(String name) {
        System.out.println(service.loading(name));
    }
}
