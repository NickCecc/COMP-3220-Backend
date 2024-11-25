package com.example.my_backend.model;

import java.util.Map;
import java.util.HashMap;

public class Housing {

    public Map<String, State> states;

    public Housing() {
        states = new HashMap<String, State>();
    }

    public void add(String state) {
        State newstate = new State(state);
        states.put(state, newstate);
    }

    public Map<String, State> getStates() {
        return states;
    }

}