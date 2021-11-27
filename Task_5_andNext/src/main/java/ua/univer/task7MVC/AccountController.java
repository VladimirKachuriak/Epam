package ua.univer.task7MVC;

import java.util.Scanner;

public class AccountController {
    private AccountModel model;
    private AccountView view;

    private static boolean activated_account = false;

    private final String DEFAULT_NAME = "user" ;
    private final String DEFAULT_PASSWORD = "user" ;

    public AccountController(AccountModel model, AccountView view) {
        this.model = model;
        this.view = view;
    }
    public void enterInAccount(){
        Scanner sc= new Scanner(System.in);
        while (true) {
            model.setLogin(inputNameWithScanner(sc));
            model.setPassword(inputPasswordWithScanner(sc));
            if (DEFAULT_NAME.equals(model.getLogin()) && DEFAULT_PASSWORD.equals(model.getPassword())) {
                activated_account = true;
                view.printMessage(AccountView.LOGIN);
                model.setStatistic(model.getStatistic()+AccountView.INPUT_LOGIN+model.getLogin()+
                        AccountView.INPUT_PASSWORD+model.getPassword()+"\n"+AccountView.LOGIN+"\n");
                break;
            } else {
                view.printMessage(AccountView.WRONG_LOGIN_OR_PASSWORD);
                model.setStatistic(model.getStatistic()+AccountView.WRONG_LOGIN_OR_PASSWORD+"\n");
            }
        }
    }

    public static boolean isActivated_account() {
        return activated_account;
    }

    private String inputNameWithScanner(Scanner scan){
        view.printMessage(AccountView.ENTER_LOGIN);
        return scan.next();
    }
    private String inputPasswordWithScanner(Scanner scan){
        view.printMessage(AccountView.ENTER_Password);
        return scan.next();
    }

    public void showStatistic(){
        view.printMessage(model.getStatistic());
    }
}
