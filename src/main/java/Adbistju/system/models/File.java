package Adbistju.system.models;

public class File extends FileSystemUnit{
    public File(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "File{" +
                "name='" + name + '\'' +
                '}';
    }
}
