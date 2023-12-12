package com.example.glide.work;

public class UpperCaseTypedWork extends AbstractTypedWork<UpperCaseWorkInput, UpperCaseWorkOutput> {

    public UpperCaseTypedWork(Class<UpperCaseWorkInput> inputClass, Class<UpperCaseWorkOutput> outputClass) {
        super(inputClass, outputClass);
    }

    @Override
    protected UpperCaseWorkOutput doWork(UpperCaseWorkInput upperCaseWorkInput) {
        // Access the input in a type safe-ish way
        String aname = upperCaseWorkInput.getAName();

        // Do the work
        String upperName = aname.toUpperCase();

        // Create the output in a type safe way
        var upperCaseWorkOutput = createWorkOutput();
        upperCaseWorkOutput.setUpperName(upperName);

        // Return the output
        return upperCaseWorkOutput;
    }

    @Override
    public WorkDescription getDescription() {
        WorkDescription workDescription = new WorkDescription.Builder()
                .shortDescription("Upper case work")
                .longDescription("Takes a String as input and upper cases it for output")
                .name("UpperCaseWork")
                .addInputDescription(new WorkInputDescription.Builder()
                        .name(UpperCaseWork.INPUTS.ANAME)
                        .shortDescription("Input String")
                        .longDescription("Input String to be upper cased")
                        .type(String.class)
                        .build())
                .addOutputDescription(new WorkOutputDescription.Builder()
                        .name(UpperCaseWork.OUTPUTS.UPPER_NAME)
                        .shortDescription("Output String")
                        .longDescription("Output String upper cased")
                        .type(String.class)
                        .build())
                .build();
        return workDescription;
    }
}
