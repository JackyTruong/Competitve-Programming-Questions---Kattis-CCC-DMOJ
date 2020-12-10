package com.company;

import java.util.ArrayList;

public class Flights {
    ArrayList<Integer> city1;
    ArrayList<Integer> city2;
    ArrayList<Integer> cost;
    public Flights(int p){
        this.city1 = new ArrayList<>(p);
        this.city2 = new ArrayList<>(p);
        this.cost = new ArrayList<>(p);
    }
}
