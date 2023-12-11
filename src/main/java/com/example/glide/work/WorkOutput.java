package com.example.glide.work;

import java.util.Map;

public class WorkOutput {

    private final Map<String, Object> output;

    public WorkOutput(Map<String, Object> output) {
        this.output = output;
    }

    Map<String, Object> getOutput() {
        return this.output;
    }
}
