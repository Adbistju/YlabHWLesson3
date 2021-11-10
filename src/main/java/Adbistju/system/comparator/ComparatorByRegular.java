package Adbistju.system.comparator;

public class ComparatorByRegular extends Comparator{

    private String param;

    public ComparatorByRegular(String param) {
        this.param = param;
    }

    @Override
    public boolean check(String name) {
        return name.matches(param);
    }
}
