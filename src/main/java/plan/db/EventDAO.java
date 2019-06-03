package plan.db;

import io.dropwizard.hibernate.AbstractDAO;
import plan.api.Event;
import org.hibernate.SessionFactory;

import java.util.Optional;

public class EventDAO extends AbstractDAO<Event> {

    public EventDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public Optional<Event> findById(long id) {
        return Optional.ofNullable(get(id));
    }

    public void save(Event event) {
        persist(event);
    }
}
