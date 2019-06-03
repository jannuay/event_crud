package plan;

import plan.api.Event;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.db.DataSourceFactory;
import plan.db.EventDAO;
import plan.resources.EventResource;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class EventsApplication extends Application<EventsConfiguration> {

    public static void main(final String[] args) throws Exception {
        new EventsApplication().run(args);
    }

    // Hibernate bundle
    // What's this doing?
    private final HibernateBundle<EventsConfiguration> hibernateBundle = new HibernateBundle<EventsConfiguration>(
            Event.class) {

        @Override
        public DataSourceFactory getDataSourceFactory(
                EventsConfiguration configuration
        ) {
            return configuration.getDataSourceFactory();
        }

    };


    @Override
    public String getName() {
        return "events";
    }

    @Override
    public void initialize(final Bootstrap<EventsConfiguration> bootstrap) {
        // What's this doing?
        bootstrap.addBundle(hibernateBundle);
    }

    @Override
    public void run(final EventsConfiguration configuration,
                    final Environment environment) {
        DateFormat eventDateFormat = new SimpleDateFormat(configuration.getDateFormat());
        environment.getObjectMapper().setDateFormat(eventDateFormat);

        // Register Event method
        EventDAO eventDAO = new EventDAO(hibernateBundle.getSessionFactory());
        EventResource eventResource = new EventResource(eventDAO);
        environment.jersey().register(eventResource);
    }
}
