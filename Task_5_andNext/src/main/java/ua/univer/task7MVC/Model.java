package ua.univer.task7MVC;

public class Model {
    private int min;
    private int max;
    private int rand_num;
    private String statistic = "////////////LOGS////////////////\n";


    public int getRand_num() {
        return rand_num;
    }

    public String getStatistic() {
        return statistic;
    }

    public void Generate() {
        rand_num = (int) (Math.random() * (max - min)) + min;
    }

    public int getMin() {
        return min;
    }

    public void setStatistic(String statistic) {
        this.statistic = statistic;
    }

    public void setMin(int min) {
        this.min = min;
    }


    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

}
