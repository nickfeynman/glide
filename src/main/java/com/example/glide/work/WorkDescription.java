package com.example.glide.work;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class WorkDescription {

    private final String name;
    private final String shortDescription;
    private final String longDescription;
    private List<WorkInputDescription> inputDescriptions = new ArrayList<>();
    private List<WorkOutputDescription> outputDescriptions = new ArrayList<>();

    public WorkDescription(String name, String shortDescription, String longDescription,
                           List<WorkInputDescription> inputDescriptions, List<WorkOutputDescription> outputDescriptions) {
        this.name = name;
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
        this.inputDescriptions = inputDescriptions;
        this.outputDescriptions = outputDescriptions;
    }

    public String getName() {
        return name;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public List<WorkInputDescription> getInputDescriptions() {
        return inputDescriptions;
    }

    public List<WorkOutputDescription> getOutputDescriptions() {
        return outputDescriptions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WorkDescription that)) return false;
        return Objects.equals(name, that.name) && Objects.equals(shortDescription, that.shortDescription) && Objects.equals(longDescription, that.longDescription) && Objects.equals(inputDescriptions, that.inputDescriptions) && Objects.equals(outputDescriptions, that.outputDescriptions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, shortDescription, longDescription, inputDescriptions, outputDescriptions);
    }

    // Nested Builder class for WorkDescription
    public static class Builder {
        private String shortDescription;
        private String longDescription;
        private String name;
        private final List<WorkInputDescription> inputDescriptions = new ArrayList<>();
        private final List<WorkOutputDescription> outputDescriptions = new ArrayList<>();


        public Builder shortDescription(String shortDescription) {
            this.shortDescription = shortDescription;
            return this;
        }

        public Builder longDescription(String longDescription) {
            this.longDescription = longDescription;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder addInputDescription(WorkInputDescription inputDescription) {
            this.inputDescriptions.add(inputDescription);
            return this;
        }

        public Builder addOutputDescription(WorkOutputDescription outputDescription) {
            this.outputDescriptions.add(outputDescription);
            return this;
        }

        public WorkDescription build() {
            return new WorkDescription(name, shortDescription, longDescription, inputDescriptions, outputDescriptions);
        }


    }
}
