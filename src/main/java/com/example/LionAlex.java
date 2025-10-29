package com.example;

import java.util.Arrays;
import java.util.List;

public class LionAlex extends Lion {

    public LionAlex(Feline feline) throws Exception {
        super("Самец", feline);
    }


    public List<String> getFriends() { // Новый метод, возвращающий список друзей льва Алекса
        return Arrays.asList("Марти", "Глория", "Мелман");
    }


    public String getPlaceOfLiving() {  // Новый метод, возвращающий место жительства льва Алекса
        return "Нью-Йоркский зоопарк";
    }


    @Override
    public int getKittens() {  // Переопределенный метод getKittens(),  так как у льва Алекса нет собственных львят
        return 0;
    }
}
