package ua.univer.task7MVC;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Controller {
    private Model model;
    private View view;

    private final int MIN = 0;
    private final int MAX = 1000;
    private final String REGEX_INT = "[-+]?\\d+";

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;

        model.setMin(MIN);
        model.setMax(MAX);
    }

    public void processUser() {
        if (AccountController.isActivated_account()) {
            Scanner sc = new Scanner(System.in);
            view.printMessage(View.SET_PARAMETERS);

            if (userConfirm(sc)) {
                model.setMin(inputMinValueWithScanner(sc));
                view.printMessage(View.OUR_INT + model.getMin());

                model.setMax(inputMaxValueWithScanner(sc));
                view.printMessage(View.OUR_INT + model.getMax());
            }
            model.Generate();

            model.setStatistic(model.getStatistic() + View.INPUT_MIN_DATA + model.getMin() + " " + View.INPUT_MAX_DATA + model.getMax() + "\n");
        } else {
            view.printMessage(View.NEED_ACTIVATION);
        }
    }

    public void startGame() {
        if (AccountController.isActivated_account()) {
            while (true) {
                view.printMessage(View.INPUT_MIN_DATA + model.getMin() + " " + View.INPUT_MAX_DATA + model.getMax());
                Scanner sc = new Scanner(System.in);
                int number = inputValueWithScanner(sc);
                if (model.getRand_num() == number) {
                    model.setStatistic(model.getStatistic() + View.WIN_CONGRATULATIONS + "\n");
                    view.printMessage(View.WIN_CONGRATULATIONS);
                    break;
                } else if (number < model.getRand_num()) {
                    model.setMin(number);
                } else if (number > model.getRand_num()) {
                    model.setMax(number);
                }
                model.setStatistic(model.getStatistic() + View.INPUT_MIN_DATA + model.getMin() + " " + View.INPUT_MAX_DATA + model.getMax() + "\n");
            }
        } else {
            view.printMessage(View.NEED_ACTIVATION);
        }
    }

    private int inputValueWithScanner(Scanner scan) {

        while (true) {
            view.printMessage(View.INPUT_Guess_DATA);
            String str = scan.next();
            if (Pattern.matches(REGEX_INT, str)) {
                int temp = Integer.parseInt(str);
                model.setStatistic(model.getStatistic() + View.INPUT_Guess_DATA + temp + "\n");
                if (temp < model.getMin() || temp > model.getMax()) {
                    view.printMessage(View.WRONG_INPUT_DATA);
                    model.setStatistic(model.getStatistic() + View.WRONG_INPUT_DATA + "\n");
                } else {
                    return temp;
                }
            } else {
                view.printMessage(View.WRONG_INPUT_DATA);
                model.setStatistic(model.getStatistic() + View.WRONG_INPUT_DATA + "\n");
            }
        }
    }

    private int inputMinValueWithScanner(Scanner scan) {

        while (true) {
            view.printMessage(View.INPUT_MIN_DATA);
            String str = scan.next();
            if (Pattern.matches(REGEX_INT, str)) {

                return Integer.parseInt(str);
            } else {
                view.printMessage(View.WRONG_INPUT_DATA);
            }
        }

    }

    private int inputMaxValueWithScanner(Scanner scan) {

        while (true) {
            view.printMessage(View.INPUT_MAX_DATA);
            String str = scan.next();
            if (Pattern.matches(REGEX_INT, str)) {
                return Integer.parseInt(str);
            } else {
                view.printMessage(View.WRONG_INPUT_DATA);
            }
        }
    }

    private boolean userConfirm(Scanner scan) {

        if (scan.next().equals("y")) return true;
        return false;

    }

    private void setMin_Max(int min, int max) {
        model.setMin(min);
        model.setMax(max);
    }

    public void showStatistic() {
        view.printMessage(model.getStatistic());
    }

    public int getMin() {
        return getMin();
    }

    public int getMax() {
        return getMax();
    }

}
