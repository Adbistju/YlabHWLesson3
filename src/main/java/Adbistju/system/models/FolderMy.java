package Adbistju.system.models;

import java.util.ArrayList;
import java.util.List;

public class FolderMy extends FileSystemUnit{
    private List<FileSystemUnit> file;
    private FolderMy previous;

    public FolderMy(String name) {
        this.name = name;
        this.file = new ArrayList();
    }

    public FolderMy(String name, FolderMy folderMy) {
        this.name = name;
        this.file = new ArrayList();
        this.previous = folderMy;
    }

    public FolderMy addFile(FileSystemUnit e){
        file.add(e);
        return this;
    }

    public FolderMy getPrevious() {
        return previous;
    }

    public void setPrevious(FolderMy previous) {
        this.previous = previous;
    }

    public List<FileSystemUnit> getFile() {
        return file;
    }

    @Override
    public String toString() {
        return "Folder{" +
                "name='" + name +
                ", file=" + file + '\'' +
                '}';
    }
}
