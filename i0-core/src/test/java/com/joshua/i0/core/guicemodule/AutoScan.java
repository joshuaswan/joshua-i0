package com.joshua.i0.core.guicemodule;

import com.joshua.i0.config.Configuration;
import com.joshua.i0.core.Application;
import com.joshua.i0.core.ApplicationModule;
import com.joshua.i0.core.GuiceModule;

@GuiceModule
@Application("autoscan")
public class AutoScan extends ApplicationModule<Configuration> {
    @Override
    protected Configuration createDefaultConfiguration(Configuration.ConfigurationBuilder config) {
        return Configuration.config().http().end().build();
    }
}
