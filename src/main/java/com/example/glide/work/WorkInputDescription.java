package com.example.glide.work;

import java.util.Objects;

public class WorkInputDescription {

    private final String name;
    private final String shortDescription;
    private final String longDescription;
    private final boolean optional;

    private Object defaultValue;
    private final Class type;

    public WorkInputDescription(String name, String shortDescription, String longDescription, Class type, boolean optional, Object defaultValue) {
        this.name = Objects.requireNonNull(name, "Name cannot be null");
        this.shortDescription = Objects.requireNonNull(shortDescription, "Short description cannot be null");
        this.longDescription = Objects.requireNonNull(longDescription, "Long description cannot be null");
        this.type = Objects.requireNonNull(type, "Type cannot be null");
        this.optional = optional;
        this.defaultValue = defaultValue; // Assuming defaultValue can be null; if not, add requireNonNull here as well

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

    public Object getDefaultValue() {
        return defaultValue;
    }

    public String getJsonSchema() {
        return null;
    }

    public static class Builder {

        private String name;
        private String shortDescription;
        private String longDescription;
        private boolean optional;
        private Object defaultValue;
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

        public Builder defaultValue(Object defaultValue) {
            this.defaultValue = defaultValue;
            return this;
        }

        public Builder type(Class<?> type) {
            this.type = type;
            return this;
        }

        public WorkInputDescription build() {
            return new WorkInputDescription(name, shortDescription, longDescription,
                    type, optional, defaultValue);
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WorkInputDescription that)) return false;
        return optional == that.optional && Objects.equals(shortDescription, that.shortDescription) && Objects.equals(longDescription, that.longDescription) && Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(shortDescription, longDescription, optional, type);
    }
}