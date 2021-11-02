package Adbistju.system;

import Adbistju.system.models.File;
import Adbistju.system.models.FolderMy;

import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        String filePath = "D:\\!\\10.xml";
        SaxMyParser parser = new SaxMyParser();
        FolderMy folder = parser.parse(filePath);

//        System.out.println(folder.toString());
//        FolderMy folder = new FolderMy("/");
//        File file1 = new File("1");
//        File file2 = new File("2");
//        FolderMy folder2 = new FolderMy("a");
//        File file3 = new File("3");
//        File file4 = new File("4");
//        folder.addFile(file1);
//        folder.addFile(file2);
//        folder.addFile(folder2);
//        folder2.addFile(file3);
//        folder2.addFile(file4);
//        folder2.setPrevious(folder);
        System.out.println(folder);

        seach(folder,"file-4a.xml");
        seach(folder,"file-bb.xml");
    }

    public static void seach(FolderMy folderMy, String name){
        if(folderMy.getName().equals(name)){
            System.out.println(folderMy);
        }
        ArrayList arrayList = (ArrayList) folderMy.getFile();
        for (int i = 0; i < arrayList.size(); i++) {
            if(arrayList.get(i) instanceof File && ((File) arrayList.get(i)).getName().equals(name)){
                FolderMy iter = folderMy;
                System.out.print(((File) arrayList.get(i)).getName()+"\\");
                while (iter.getPrevious() != null){
                    System.out.print(iter.getName()+"\\");
                    iter = iter.getPrevious();
                }
//                System.out.println(folderMy.getPrevious().getName()+"\\"+folderMy.getName()+"\\"+arrayList.get(i));
                System.out.println();
                return;
            }else if(arrayList.get(i) instanceof FolderMy){
                seach((FolderMy) arrayList.get(i), name);
            }
        }
    }
}
