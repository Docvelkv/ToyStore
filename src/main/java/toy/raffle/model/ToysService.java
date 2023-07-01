package toy.raffle.model;

import toy.raffle.model.toy.Toy;
import toy.raffle.model.toy.ToysComparator;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.concurrent.ThreadLocalRandom;

public class ToysService implements SaveAndLoad{

    private final Path pathSaveDir = Paths.get("./src/main/resources/archive");

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

    /**
     * Формирование списка объектов в соответствии с приоритетом
     * @param set коллекция PriorityQueue
     * @return List<Toy>
     */
    public List<Toy> drawingToys(PriorityQueue<Toy> set) {
        List<Toy> lstWin = new ArrayList<>();
        Toy currentToy;
        while ((currentToy = set.poll()) != null) {
            lstWin.add(currentToy);
        }
        return lstWin;
    }

    /**
     * Подсчёт количества сохранённых объектов
     * @return int
     */
    public int numberOfSavedFiles() {
        List<String> list = new ArrayList<>();
        try (DirectoryStream<Path> files = Files.newDirectoryStream(pathSaveDir)) {
            for (Path path : files){
                list.add(path.getFileName().toString());
            }
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return list.size();
    }

    /**
     * Сохранение объекта
     * @param lst объект для сохранения
     */
    @Override
    public void saving(List<Toy> lst) {
        try {
            Files.createDirectories(pathSaveDir);
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        int name = numberOfSavedFiles() + 1;
        Path dirPath = Paths.get(pathSaveDir + "/" + name + ".txt");
        try(ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(dirPath))){
            oos.writeObject(lst);
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Загрузка содержимого сохранённого файла
     *
     * @param name имя файла (без расширения)
     * @return String
     */
    @Override
    public String loading(String name) {
        Path dirPath = Paths.get(pathSaveDir + "/" + name + ".txt");
        try(ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(dirPath))){
            return ois.readObject().toString()
                    .replaceAll("[\\[\\]]", "")
                    .replace(".,", "")
                    .replace(".", "");
        }
        catch (Exception ex){
            System.out.printf("Всего сохранённых файлов %d (файла с именем \"%s\" нет.)\n",
                    numberOfSavedFiles(), name);
        }
        return "___";
    }
}
