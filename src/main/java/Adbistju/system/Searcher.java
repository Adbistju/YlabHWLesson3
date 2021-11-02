package Adbistju.system;

import Adbistju.system.models.File;
import Adbistju.system.models.FileSystemUnit;
import Adbistju.system.models.FolderMy;

import java.util.ArrayList;

public class Searcher {
    public static void search(FolderMy folderMy, String name){
        ArrayList arrayList = (ArrayList) folderMy.getFile();
        for (int i = 0; i < arrayList.size(); i++) {
            if(arrayList.get(i) instanceof File && ((File) arrayList.get(i)).getName().matches(name)){
//                System.out.println(((File) arrayList.get(i)).getName());
                printAddress((FileSystemUnit) arrayList.get(i));
            }else if(arrayList.get(i) instanceof FolderMy){
                if(((FolderMy) arrayList.get(i)).getName().matches(name)){
//                    System.out.println(((FolderMy) arrayList.get(i)).getName());
                    printAddress((FileSystemUnit) arrayList.get(i));
                }
                search(((FolderMy) arrayList.get(i)), name);
            }
        }
    }

    private static void printAddress(FileSystemUnit fsu){
        FileSystemUnit current = fsu;
        String str = "";
//        str = str+"/"+current.getName();
        while (current.getPrev() != null){
            str = "/"+current.getName() +str;
            current = current.getPrev();
        }
        System.out.println(str);
    }
}
