package com.example.kr1;
import java.util.Comparator;

public class Word {
    public int id;
    public String word;
    public Word(int a, String b)
    {
        this.id=a;
        this.word=b;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    @Override
    public String toString() {
        return id + " "
                + word;
    }

}
