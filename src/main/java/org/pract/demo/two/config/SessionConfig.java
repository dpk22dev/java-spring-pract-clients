package org.pract.demo.two.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.web.context.AbstractHttpSessionApplicationInitializer;

//@Configuration
//@EnableRedisHttpSession
@Profile("prod") // enabling only on prod, disabling on local
public class SessionConfig extends AbstractHttpSessionApplicationInitializer {
}
