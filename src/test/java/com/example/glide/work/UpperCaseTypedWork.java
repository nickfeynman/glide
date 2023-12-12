package com.example.glide.work;

public class UpperCaseTypedWork extends AbstractTypedWork<UpperCaseWorkInput, UpperCaseWorkOutput> {

    public UpperCaseTypedWork(Class<UpperCaseWorkInput> inputClass) {
        super(inputClass);
    }

    @Override
    protected UpperCaseWorkOutput doWork(UpperCaseWorkInput upperCaseWorkInput) {
       // Do the work
       String upperName = upperCaseWorkInput.getAName().toUpperCase();

       // Prepare the output
       var upperCaseWorkOutput = createTypedWorkOutput();
       upperCaseWorkOutput.setUpperName(upperName);

       // Return the output
       return upperCaseWorkOutput;
    }

    @Override
    protected UpperCaseWorkInput createTypedWorkInput(WorkInput workInput) {
        return new UpperCaseWorkInput(workInput);
    }

    @Override
    protected UpperCaseWorkOutput createTypedWorkOutput() {
        return new UpperCaseWorkOutput();
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
