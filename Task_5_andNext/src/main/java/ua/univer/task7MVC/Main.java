package ua.univer.task7MVC;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        AccountController accountController = new AccountController(new AccountModel(), new AccountView());
        accountController.enterInAccount();
        accountController.showStatistic();
        Model model = new Model();
        View view = new View();
        Controller controller = new Controller(model,view);
        controller.processUser();
        controller.startGame();
        System.out.println("///////////////////////");
        controller.showStatistic();


    }
}
