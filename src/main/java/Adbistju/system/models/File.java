package Adbistju.system.models;

public class File extends FileSystemUnit{
    public File(String name, FolderMy folder) {
        this.name = name;
        this.prev = folder;
    }

    @Override
    public String toString() {
        return "File{" +
                "name='" + name + '\'' +
                '}';
    }
}
