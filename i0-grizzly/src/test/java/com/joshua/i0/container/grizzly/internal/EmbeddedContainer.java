package com.joshua.i0.container.grizzly.internal;

import com.joshua.i0.config.Configuration;
import com.joshua.i0.config.util.LogLevel;
import com.joshua.i0.container.grizzly.EmbeddedGrizzly;
import com.joshua.i0.core.Application;
import com.joshua.i0.core.ApplicationModule;
import com.joshua.i0.core.Servlet3;

import static com.joshua.i0.config.Configuration.config;
import static com.joshua.i0.container.grizzly.EmbeddedGrizzly.Asset;

@Application("embedded")
@EmbeddedGrizzly(assets = @Asset(uri = "/static", resource = "./webapp"),
mimeExtensions = {@EmbeddedGrizzly.MimeExtension(extension = "eot", mime = "application/vnd.ms-fontobject"),
@EmbeddedGrizzly.MimeExtension(extension = "svg", mime = "image/svg+xml")})
@Servlet3
public class EmbeddedContainer extends ApplicationModule<Configuration> {
    @Override
    protected Configuration createDefaultConfiguration(Configuration.ConfigurationBuilder config) {
        return config().http().port(8051).end().logging().level(LogLevel.INFO).console().end().end().build();
    }
}
