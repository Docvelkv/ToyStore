package toy.raffle.view;

import toy.raffle.presenter.Presenter;
import toy.raffle.view.interfaces.View;

import java.util.Scanner;

public class Console implements View {

    private final Menu menu;
    private final Scanner scan;
    private final Presenter presenter = new Presenter();
    private boolean work;

    public Console() {
        menu = new Menu(this);
        scan = new Scanner(System.in);
        work = true;
    }

    // ########## Собственные методы ##########

    /**
     * Отображение меню
     */
    private void showMenu(){
        menu.showMenu();
    }

    /**
     * Приветствие
     */
    private void greeting(){
        System.out.println("Начало работы");
    }

    /**
     * Вывод ошибки
     */
    private void showError(){
        System.out.println("Неверный ввод");
    }

    /**
     * Проверка, что введены цифры или ничего не введено
     * @param text введённый текст
     * @return boolean
     */
    private boolean checkingTextForInt(String text){
        if (text.matches("[0-9]+") || text.equals("")) return true;
        else {
            showError();
            return false;
        }
    }

    /**
     * Проверка, что введённая цифра не превышает пунктов меню
     * @param commandNum введённая цифра
     * @return boolean
     */
    private boolean checkingCommandsNum(int commandNum){
        if (commandNum <= menu.menuSize()) return true;
        else {
            showError();
            return false;
        }
    }

    /**
     * Выполнение пункта меню
     */
    private void execute(){
        System.out.print("Введите номер команды: ");
        String text = scan.nextLine();
        if (checkingTextForInt(text)) {
            int commandNum = Integer.parseInt(text);
            if (checkingCommandsNum(commandNum)){
                System.out.print("**********\n");
                menu.execute(commandNum);
                System.out.print("**********\n");
            }
        }
    }

    /**
     * Старт приложения
     */
    public void start(){
        greeting();
        while (work){
            showMenu();
            execute();
        }
    }
    // ########## Конец региона ##########

    // ########## Методы интерфейса View ##########

    @Override
    public void raffle() {
        System.out.print("Введите количество игрушек в наборе: ");
        int numToys = Integer.parseInt(scan.nextLine());
        System.out.print("Введите число существующих игрушек: ");
        int quantity = Integer.parseInt(scan.nextLine());
        presenter.raffle(numToys, quantity);
    }

    @Override
    public void loading() {
        int num = presenter.numberOfSavedFiles();
        if (num != 0){
            System.out.printf("Всего сохранённых файлов %d\n", num);
            System.out.print("Введите номер файла: ");
            String name = scan.nextLine();
            presenter.loading(name);
        }
        else {
            System.out.println("Нет сохранённых файлов");
        }
    }

    @Override
    public void finish() {
        System.out.println("Работа закончена");
        work = false;
    }
    // ########## Конец региона ##########
}
