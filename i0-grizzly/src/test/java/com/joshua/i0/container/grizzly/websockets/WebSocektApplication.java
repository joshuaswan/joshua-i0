package com.joshua.i0.container.grizzly.websockets;

import com.joshua.i0.config.Configuration;
import com.joshua.i0.config.util.LogLevel;
import com.joshua.i0.container.grizzly.EmbeddedGrizzly;
import com.joshua.i0.container.grizzly.WebSocket;
import com.joshua.i0.core.Application;
import com.joshua.i0.core.ApplicationModule;

import static com.joshua.i0.config.Configuration.config;

@EmbeddedGrizzly
@WebSocket
@Application("websocket")
public class WebSocektApplication extends ApplicationModule<Configuration> {
    @Override
    protected Configuration createDefaultConfiguration(Configuration.ConfigurationBuilder config) {
        return config().http().port(8051).end().logging().level(LogLevel.INFO).console().end().end().build();
    }
}
