package com.example.glide.work;

import java.util.*;
import java.util.stream.Collectors;

public abstract class AbstractWork implements Work {
    @Override
    public String getId() {
        return Work.super.getId();
    }

    @Override
    public WorkInput preProcess(WorkInput workInput) {
        validateInputs(workInput.getInput());
        return workInput;
    }

    @Override
    public WorkOutput apply(WorkInput workInput) {
        WorkInput workInputToUse = preProcess(workInput);
        WorkOutput workOutput = doApply(workInputToUse);
        return postProcess(workInput, workOutput);
    }

    protected abstract WorkOutput doApply(WorkInput workInput);

    @Override
    public WorkOutput postProcess(WorkInput workInput, WorkOutput workOutput) {
        validateOutputs(workOutput.getOutput());
        Map<String, Object> combindedMap = new HashMap<>();
        combindedMap.putAll(workInput.getInput());
        combindedMap.putAll(workOutput.getOutput());
        return new WorkOutput(combindedMap);
    }


    protected void validateInputs(Map<String, Object> inputMap) {
        Set<String> missingKeys = new HashSet<>(getInputNames());
        missingKeys.removeAll(inputMap.keySet());
        if (!missingKeys.isEmpty()) {
            throw new IllegalArgumentException("Missing some input keys: " + missingKeys);
        }
    }

    private List<String> getInputNames() {
        return getDescription().getInputDescriptions().stream()
                .map(WorkInputDescription::getName)
                .collect(Collectors.toList());
    }

    private List<String> getOutputNames() {
        return getDescription().getOutputDescriptions().stream()
                .map(WorkOutputDescription::getName)
                .collect(Collectors.toList());
    }

    protected void validateOutputs(Map<String, Object> outputMap) {
        Set<String> missingKeys = new HashSet<>(getOutputNames());
        missingKeys.removeAll(outputMap.keySet());
        if (!missingKeys.isEmpty()) {
            throw new IllegalArgumentException("Missing some output keys: " + missingKeys);
        }
    }
}
