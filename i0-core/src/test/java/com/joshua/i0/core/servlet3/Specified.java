package com.joshua.i0.core.servlet3;

import com.joshua.i0.config.Configuration;
import com.joshua.i0.core.Application;
import com.joshua.i0.core.ApplicationModule;
import com.joshua.i0.core.Servlet3;

import static com.joshua.i0.config.Configuration.config;

@Application("specified")
@Servlet3(packages = "com.joshua.i0.core.servlet3.p2")
public class Specified extends ApplicationModule<Configuration> {
    @Override
    protected Configuration createDefaultConfiguration(Configuration.ConfigurationBuilder config) {
        return config().http().end().build();
    }
}

