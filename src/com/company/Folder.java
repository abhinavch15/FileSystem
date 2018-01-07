package com.company;


import java.util.ArrayList;
import java.util.Scanner;

public class Folder {

    //Folder main;
    private String fname;
    private ArrayList<Folder> llist = new ArrayList<Folder>();

    Folder(String name){
        this.fname=name;
    }

    public void createFolder(String name){
        String name1=name;
        Folder newfolder = new Folder(name);
        llist.add(newfolder);
    }
    public void displaycontents()
    {
        for (Folder folder : llist) {
            System.out.println(folder);
        }
    }

    public void onFolderOpen() {
        while (true) {
            displaycontents();
            System.out.println("Which folder would you like to open? \nOr enter '0' to create a new folder\nOr enter -1 to delete a folder");
            int option;
            Scanner scanner = new Scanner(System.in);
            option = scanner.nextInt();
            if (option == -1) {
                System.out.println("Enter folder number to be deleted: ");
                llist.remove(scanner.nextInt() - 1);
                System.out.println(fname + ":");

            } else if (option == 0) {
                System.out.println("Name of new folder");
                this.createFolder(scanner.next());
                System.out.println(fname + ":");

            } else {
                if (option <= llist.size()) {
                    System.out.println(llist.get(option - 1) + ": \n");
                    llist.get(option-1).onFolderOpen();
                } else {
                    System.out.println("ERROR");
                }
            }
        }
    }
    @Override
    public String toString() {
        return fname;
    }
}
