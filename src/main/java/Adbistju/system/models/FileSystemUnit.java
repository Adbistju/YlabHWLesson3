package Adbistju.system.models;

public class FileSystemUnit {
    protected String name;
    protected FolderMy prev;

    public FolderMy getPrev() {
        return prev;
    }

    public void setPrev(FolderMy prev) {
        this.prev = prev;
    }

    public String getName() {
        return name;
    }
}
