package ef.service;

import ef.model.Event;
import ef.model.File;
import ef.repository.EventRepository;
import ef.repository.FileRepository;
import ef.repository.impl.EventRepoImpl;
import ef.repository.impl.FileRepoImpl;

import java.util.List;

public class EventService {
    private EventRepository eventRepository = new EventRepoImpl();

    public Event getEventByID(Integer id) {
        return eventRepository.getById(id);
    }

    public void deleteEventByID(Integer id) {
        eventRepository.deleteById(id);
    }

    public Event saveEvent(Event event) {
        return eventRepository.save(event);
    }

    public Event updateEvent(Event event) {
        return eventRepository.update(event);
    }

    public List<Event> getAllEvents() {
        return eventRepository.getAll();
    }
}
