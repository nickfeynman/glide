package com.example.glide.work;

import org.junit.jupiter.api.Test;

import java.util.Map;

public class WorkTests {

    @Test
    void testUnTyped() {
        WorkInput workInput = new WorkInput(Map.of(UpperCaseWork.INPUTS.ANAME, "joe"));

        // Create work unit - untyped
        UpperCaseWork upperCaseWork = new UpperCaseWork();

        // Invoke
        WorkOutput workOutput = upperCaseWork.doApply(workInput);

        // Print
        System.out.println(workOutput.getOutput().get(UpperCaseWork.OUTPUTS.UPPER_NAME));
    }

    @Test
    void testTyped() {
        WorkInput workInput = new WorkInput(Map.of(UpperCaseWork.INPUTS.ANAME, "joe"));

        // Create work unit typed
        UpperCaseTypedWork upperTypedCaseWork = new UpperCaseTypedWork(UpperCaseWorkInput.class);

        // Invoke
        UpperCaseWorkOutput upperCaseWorkOutput = upperTypedCaseWork.doWork(new UpperCaseWorkInput(workInput));

        // Print
        System.out.println(upperCaseWorkOutput.getUpperName());


    }
}
