package com.example.glide.work;

public class UpperCaseWork extends AbstractWork {

    public static class OUTPUTS {
        public static final String UPPER_NAME = "upperName";
    }

    public static class INPUTS {
        public static final String ANAME = "aname";
    }

    private UpperCaseWorkOutput upperCaseWorkOutput = new UpperCaseWorkOutput();

    @Override
    protected WorkOutput doApply(WorkInput workInput) {
        // Typesafe accessor for inputs
        UpperCaseWorkInput upperCaseWorkInput = getUpperCaseWorkInput(workInput);

        // Do the work
        String upperName = upperCaseWorkInput.getAName().toUpperCase();

        // Typesafe accessor for outputs
        upperCaseWorkOutput.setUpperName(upperName);

        return upperCaseWorkOutput.getWorkOutput();

    }

    private static UpperCaseWorkInput getUpperCaseWorkInput(WorkInput workInput) {
        UpperCaseWorkInput upperCaseWorkInput = new UpperCaseWorkInput(workInput);
        return upperCaseWorkInput;
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
