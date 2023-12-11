package com.example.glide.work;

import java.util.Map;

public class WorkInput {

    private Map<String, Object> input;

    public WorkInput(Map<String, Object> input) {
        this.input = input;
    }

    Map<String, Object> getInput() {
        return this.input;
    }

}
