package Adbistju.system;

public class Main {
    public static void main(String[] args) {
        SaxMyParser parser = new SaxMyParser();
        parser.setComparator(args).setFilePath(args).parse();
    }
}
