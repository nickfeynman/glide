package com.example.glide.work;

import java.util.UUID;
import java.util.function.Function;

public interface Work extends Function<WorkInput, WorkOutput> {

    default String getId() {
        return UUID.randomUUID().toString();
    }

    WorkInput preProcess(WorkInput workInput);

    WorkOutput postProcess(WorkInput workInput, WorkOutput workOutput);

    WorkDescription getDescription();
}
