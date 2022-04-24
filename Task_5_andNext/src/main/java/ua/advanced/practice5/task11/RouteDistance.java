package ua.advanced.practice5.task11;

public enum RouteDistance {
    SHORT(100), MIDDLE(1000), LONG(2000);

    RouteDistance(int value){
        this.value = value;
    }
    private int value;

    public int getValue() {
        return value;
    }
}
