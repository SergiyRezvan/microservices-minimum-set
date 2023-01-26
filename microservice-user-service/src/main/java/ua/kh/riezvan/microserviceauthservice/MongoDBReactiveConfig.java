package ua.kh.riezvan.microserviceauthservice;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import io.micrometer.observation.ObservationRegistry;
import io.micrometer.observation.aop.ObservedAspect;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@Configuration
@EnableReactiveMongoRepositories(basePackageClasses = {MongoDBReactiveConfig.class})
public class MongoDBReactiveConfig extends AbstractReactiveMongoConfiguration {

    @Value("${mongo.url}")
    private String mongoURL;

    @Override
    protected String getDatabaseName() {
        return "data";
    }

    @Override
    protected void configureClientSettings(MongoClientSettings.Builder builder) {
        builder.applyConnectionString(new ConnectionString(mongoURL));
    }

    @Bean
    ObservedAspect observedAspect(ObservationRegistry observationRegistry) {
        return new ObservedAspect(observationRegistry);
    }

}
