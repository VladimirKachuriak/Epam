package ua.univer.task7MVC;

public class AccountModel {
    private String login;
    private String password;

    private String statistic = "////////////LOGS////////////////\n";

    public String getLogin() {
        return login;
    }

    public void setLogin(String firstname) {
        this.login = firstname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatistic() {
        return statistic;
    }

    public void setStatistic(String statistic) {
        this.statistic = statistic;
    }
}
