package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Folder> list = new ArrayList<Folder>();

    public static void main(String[] args) {
        Folder folder1 = new Folder("folder1");
        list.add(folder1);
        Folder folder2 = new Folder("folder2");
        list.add(folder2);
        Folder folder3 = new Folder("folder3");
        list.add(folder3);


        for (Folder folder : list) {
            System.out.println(folder);
        }

        while (true) {
            System.out.println("Which folder would you like to open? \nOr enter '0' to create a new folderr\nOr enter -1 to delete a folderr");
            int option;
            Scanner scanner = new Scanner(System.in);
            option = scanner.nextInt();
            if (option == -1) {
                System.out.println("Enter folder number to be deletedd: ");
                list.remove(scanner.nextInt() - 1);
                for (Folder folder : list) {
                    System.out.println(folder);
                }
            }
            else if (option==0){
                System.out.println("Name of new folderr");
                Folder newfolder = new Folder(scanner.next());
                list.add(newfolder);
                for (Folder folder : list) {
                    System.out.println(folder);
                }

            }
            else {
                if (option <= list.size()) {
                    System.out.println(list.get(option - 1) + ": \n");
                    //list.get(option - 1).createFolder("Test");
                    list.get(option - 1).onFolderOpen();

                } else {
                    System.out.println("ERROR");
                }
            }
        }
    }
}
