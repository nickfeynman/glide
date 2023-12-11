package com.example.glide.work;

import java.lang.reflect.Constructor;

public abstract class AbstractTypedWork<IT extends TypedWorkInput, OT extends TypedWorkOutput> extends AbstractWork {

    private Class<IT> inputClass;

    public AbstractTypedWork(Class<IT> inputClass) {
        this.inputClass = inputClass;
    }

    @SuppressWarnings("unchecked")
    protected IT createTypedWorkInput(WorkInput workInput) {
        try {
            Class<IT> inputClass = this.inputClass;
            Constructor<IT> constructor = inputClass.getDeclaredConstructor(WorkInput.class);
            constructor.setAccessible(true);
            return constructor.newInstance(workInput);
        } catch (Exception e) {
            throw new RuntimeException("Failed to create TypedWorkInput instance.", e);
        }
    }
    protected abstract OT createTypedWorkOutput();

    @Override
    protected WorkOutput doApply(WorkInput workInput) {
        IT typedWorkInput = createTypedWorkInput(workInput);
        return doTypedApply(typedWorkInput).getWorkOutput();
    }

    protected abstract OT doTypedApply(IT typedWorkInput);
}
