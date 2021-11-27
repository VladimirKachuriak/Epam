package ua.univer.task7MVC;

public class View {
    public static final String INPUT_MIN_DATA = "Input Min integer value = ";
    public static final String INPUT_MAX_DATA = "Input Max integer value = ";
    public static final String INPUT_Guess_DATA = "Input Guess value = ";
    public static final String WRONG_INPUT_DATA = "Wrong input! Repeat please! ";
    public static final String WIN_CONGRATULATIONS = "congratulations you won !!! ";
    public static final String SET_PARAMETERS = "want to set parameters min and max? [y/n] ";
    public static final String OUR_INT = "INT value = ";
    public static final String NEED_ACTIVATION = "to use your account you must be logged in ";

    public void printMessage(String message) {
        System.out.println(message);
    }
}
