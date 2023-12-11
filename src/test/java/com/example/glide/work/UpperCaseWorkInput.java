package com.example.glide.work;

public class UpperCaseWorkInput implements TypedWorkInput {

    private WorkInput workInput;

    public UpperCaseWorkInput(WorkInput workInput) {
        this.workInput = workInput;
    }

    String getAName() {
        return (String) this.workInput.getInput().get(UpperCaseWork.INPUTS.ANAME);
    }
}
