package com.joshua.i0.core.guicemodule.p2;

import com.google.inject.AbstractModule;

public class Module2 extends AbstractModule {
    @Override
    protected void configure() {
        bind(Integer.class).toInstance(42);
    }
}
