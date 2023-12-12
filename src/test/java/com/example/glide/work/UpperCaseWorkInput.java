package com.example.glide.work;

public class UpperCaseWorkInput implements TypedWorkInput {

    private WorkInput workInput;

    public UpperCaseWorkInput(WorkInput workInput) {
        this.workInput = workInput;
    }

    String getAName() {
        // no explicit casting, use utility converter methods on workInput
        return this.workInput.getInputString(UpperCaseWork.INPUTS.ANAME);
    }
}
