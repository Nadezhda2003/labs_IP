package com.example.kr1;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class franc {
    public ArrayList<Word> words;

    public franc() {
        words = new ArrayList<>();
    }

    public void file(String file) throws FileNotFoundException {
        Scanner in = new Scanner(new File(file));
        String line = "";
        while (in.hasNextLine()) {
            line = in.nextLine();
            String[] mas = line.split(" ");
            words.add(new Word(Integer.parseInt(mas[0]), mas[1].toLowerCase()));
        }
    }
    void sort()
    {
        Comparator<Word> comparator1 = (o1, o2) -> (int) (o1.getId() - o2.getId());
        words.sort(comparator1);
    }

    String search(int id){
        if (id == -1)
            return "----";
        Word medic = new Word(0, "");
        medic.id=id;
        Comparator<Word> comparator = Comparator.comparing(obj -> obj.id);
        int i =Collections.binarySearch(words, medic, comparator);
        if(i>=0) {
            return words.get(i).getWord();
        }
        else{
            return "----";
        }
    }
}

