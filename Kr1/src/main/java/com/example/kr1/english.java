package com.example.kr1;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class english {
    public ArrayList<Word> words;

    public english() {
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
        words.sort((Word o1, Word o2) -> o1.getWord().compareTo(o2.getWord()));
    }

    int search(String Name){
        Word medic = new Word(0, "");
        medic.word=Name;
        Comparator<Word> comparator = Comparator.comparing(obj -> obj.word);
        int i =Collections.binarySearch(words, medic, comparator);
        if(i>=0) {
            return words.get(i).getId();
        }
        else{
            return -1;
        }
    }
}

