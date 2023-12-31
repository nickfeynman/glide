package com.example.glide.work;

import java.util.Map;

public class UpperCaseWork extends AbstractWork {

    public static class INPUTS {
        public static final String ANAME = "aname";
    }

    public static class OUTPUTS {
        public static final String UPPER_NAME = "upperName";
    }

    @Override
    protected WorkOutput doApply(WorkInput workInput) {
        // Access to input using a key name
        String aname = (String) workInput.getInput().get(INPUTS.ANAME);

        // Do the work
        String upperName = aname.toUpperCase();

        // Create the WorkOutput with a key name
        WorkOutput workOutput = new WorkOutput(Map.of(OUTPUTS.UPPER_NAME, upperName));

        // Return the output
        return workOutput;

    }

    @Override
    public WorkDescription getDescription() {
        WorkDescription workDescription = new WorkDescription.Builder()
                .shortDescription("Upper case work")
                .longDescription("Takes a String as input and upper cases it for output")
                .name("UpperCaseWork")
                .addInputDescription(new WorkInputDescription.Builder()
                        .name(INPUTS.ANAME)
                        .shortDescription("Input String")
                        .longDescription("Input String to be upper cased")
                        .type(String.class)
                        .build())
                .addOutputDescription(new WorkOutputDescription.Builder()
                        .name(OUTPUTS.UPPER_NAME)
                        .shortDescription("Output String")
                        .longDescription("Output String upper cased")
                        .type(String.class)
                        .build())
                .build();
        return workDescription;
    }

}
