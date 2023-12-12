package com.example.glide.work;

import java.util.HashMap;

public class UpperCaseWorkOutput implements TypedWorkOutput {

    private final WorkOutput workOutput = new WorkOutput(new HashMap<>());

    public void setUpperName(String upperName) {
        this.workOutput.getOutput().put(UpperCaseWork.OUTPUTS.UPPER_NAME, upperName);
    }

    public String getUpperName() {
        return (String) this.workOutput.getOutput().get(UpperCaseWork.OUTPUTS.UPPER_NAME);
    }

    public WorkOutput getWorkOutput() {
        return workOutput;
    }
}
