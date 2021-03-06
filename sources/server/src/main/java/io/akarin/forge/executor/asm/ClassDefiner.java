package io.akarin.forge.executor.asm;

import io.akarin.forge.executor.asm.SafeClassDefiner;

public interface ClassDefiner {
    default public boolean isBypassAccessChecks() {
        return false;
    }

    public Class<?> defineClass(ClassLoader var1, String var2, byte[] var3);

    public static ClassDefiner getInstance() {
        return SafeClassDefiner.INSTANCE;
    }
}

