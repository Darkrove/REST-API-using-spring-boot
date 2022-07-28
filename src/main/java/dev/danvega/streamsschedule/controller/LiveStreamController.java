package dev.danvega.streamsschedule.controller;

import com.fasterxml.jackson.annotation.JsonRawValue;
import dev.danvega.streamsschedule.exception.LiveStreamNotFoundException;
import dev.danvega.streamsschedule.model.LiveStream;
import dev.danvega.streamsschedule.repository.LiveStreamRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/streams")
public class LiveStreamController {

    private final LiveStreamRepository repository;

    public LiveStreamController(LiveStreamRepository repository) {
        this.repository = repository;
    }

    // GET http://localhost:8080/streams/
    @GetMapping
    public List<LiveStream> findAll() {
        return repository.findAll();
    }

    // GET http://localhost:8080/streams/id={id}
    @GetMapping("/id={id}")
    public LiveStream findById(@PathVariable String id) throws LiveStreamNotFoundException {
        return repository.findById(id);
    }

    // DELETE http://localhost:8080/streams/id={id}
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/id={id}")
    public void delete(@PathVariable String id) throws LiveStreamNotFoundException {
        repository.delete(id);
    }

    // POST http://localhost:8080/streams/
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public LiveStream create(@RequestBody LiveStream stream) {
        return repository.create(stream);
    }

    // PUT http://localhost:8080/streams/id={id}
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PostMapping("/id={id}")
    public void update(@PathVariable String id, @RequestBody LiveStream stream) {
        repository.update(stream, id);
    }

}
