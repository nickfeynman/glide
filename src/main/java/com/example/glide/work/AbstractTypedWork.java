package com.example.glide.work;

import java.lang.reflect.Constructor;

public abstract class AbstractTypedWork<IT extends TypedWorkInput, OT extends TypedWorkOutput> extends AbstractWork {

    private Class<IT> inputClass;

    private Class<OT> outputClass;

    public AbstractTypedWork(Class<IT> inputClass, Class<OT> outputClass) {
        this.inputClass = inputClass;
        this.outputClass = outputClass;
    }


    @SuppressWarnings("unchecked")
    protected IT createWorkInput(WorkInput workInput) {
        try {
            Class<IT> inputClass = this.inputClass;
            Constructor<IT> constructor = inputClass.getDeclaredConstructor(WorkInput.class);
            constructor.setAccessible(true);
            return constructor.newInstance(workInput);
        } catch (Exception e) {
            throw new RuntimeException("Failed to create TypedWorkInput instance.", e);
        }
    }
    protected OT createWorkOutput() {
        try {
            Class<OT> outputClass = this.outputClass;
            Constructor<OT> constructor = outputClass.getConstructor();
            constructor.setAccessible(true);
            return constructor.newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Failed to create TypedWorkOutput instance.", e);
        }
    }

    @Override
    protected WorkOutput doApply(WorkInput workInput) {
        IT typedWorkInput = createWorkInput(workInput);
        return doWork(typedWorkInput).getWorkOutput();
    }

    protected abstract OT doWork(IT typedWorkInput);
}
