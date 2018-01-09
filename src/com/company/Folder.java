package com.company;


import java.util.ArrayList;
import java.util.Scanner;

public class Folder {

    Folder prevfolder;

    public void setPrevfolder(Folder prevfolder) {
        this.prevfolder = prevfolder;
    }

    private String fname;
    private String prevfname;

    public void setPrevfname(String prevfname) {
        this.prevfname = prevfname;
    }

    private ArrayList<Folder> llist = new ArrayList<Folder>();
    private ArrayList<Folder> prevllist = new ArrayList<Folder>();

    Folder(String name){
        this.fname=name;
    }

    public void setPrevllist(ArrayList<Folder> prevllist) {
        this.prevllist = prevllist;
    }

    public void createFolder(String name){
        Folder newfolder = new Folder(name);
        llist.add(newfolder);
        newfolder.setPrevllist(llist);
        newfolder.setPrevfname(fname);
        newfolder.setPrevfolder(this);

    }
    public void displaycontents()
    {
        for (Folder folder : llist) {
            System.out.println(prevfname+"/"+folder);
        }
    }

    public void onFolderOpen() {
        while (true) {
            System.out.println("\n");
            displaycontents();
            System.out.println("\n");
            System.out.println("Which folder would you like to open? \nOr enter '0' to create a new folder\nOr enter -1 to delete a folder");
            int option;
            Scanner scanner = new Scanner(System.in);
            option = scanner.nextInt();
            if (option == -1) {
                System.out.println("Enter folder number to be deleted: ");
                llist.remove(scanner.nextInt() - 1);
            } else if (option == 0) {
                System.out.println("Name of new folder");
                this.createFolder(scanner.next());
            } else if (option == -2){
                prevfolder.onFolderOpen();
            }
            else {
                if (option <= llist.size()) {

                    llist.get(option-1).setPrevfname(prevfname+"/"+llist.get(option - 1).toString()+"");//prevfname(fname);
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
