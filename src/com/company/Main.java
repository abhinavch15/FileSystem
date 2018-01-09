package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Folder m = new Folder("Root");
        m.createFolder("folder1");
        m.setPrevfolder(m);
        m.setPrevfname("root");
        m.onFolderOpen();
    }
}
