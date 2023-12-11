package com.example.glide.work;

import java.util.Objects;

public class WorkOutputDescription {

    private final String name;
    private final String shortDescription;
    private final String longDescription;
    private final boolean optional;
    private final Class type;

    public WorkOutputDescription(String name, String shortDescription, String longDescription, Class type, boolean optional) {
        this.name = Objects.requireNonNull(name, "Name cannot be null");
        this.shortDescription = Objects.requireNonNull(shortDescription, "Short description cannot be null");
        this.longDescription = Objects.requireNonNull(longDescription, "Long description cannot be null");
        this.type = Objects.requireNonNull(type, "Type cannot be null");
        this.optional = optional;
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

    public Class getType() {
        return type;
    }
    public boolean isOptional() {
        return optional;
    }


    public static class Builder {

        private String name;
        private String shortDescription;
        private String longDescription;
        private boolean optional;
        private Class<?> type;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder shortDescription(String shortDescription) {
            this.shortDescription = shortDescription;
            return this;
        }

        public Builder longDescription(String longDescription) {
            this.longDescription = longDescription;
            return this;
        }

        public Builder optional(boolean optional) {
            this.optional = optional;
            return this;
        }

        public Builder type(Class<?> type) {
            this.type = type;
            return this;
        }

        public WorkOutputDescription build() {
            return new WorkOutputDescription(name, shortDescription, longDescription,
                    type, optional);
        }
    }

}
