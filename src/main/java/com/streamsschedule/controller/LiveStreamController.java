package com.streamsschedule.controller;

import com.streamsschedule.repository.LiveStreamRepository;
import com.streamsschedule.exception.LiveStreamNotFoundException;
import com.streamsschedule.model.LiveStream;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v.0.1/streams")
public class LiveStreamController {

    private final LiveStreamRepository repository;

    public LiveStreamController(LiveStreamRepository repository) {
        this.repository = repository;
    }

    // GET http://localhost:8080/api/v.0.1/streams/
    @GetMapping
    public List<LiveStream> findAll() {
        return repository.findAll();
    }

    // GET http://localhost:8080/api/v.0.1/streams/id={id}
    @GetMapping("/id={id}")
    public LiveStream findById(@PathVariable String id) throws LiveStreamNotFoundException {
        return repository.findById(id);
    }

    // DELETE http://localhost:8080/api/v.0.1/streams/id={id}
    @ResponseStatus(HttpStatus.ACCEPTED)
    @DeleteMapping("/id={id}")
    public String delete(@PathVariable String id) throws LiveStreamNotFoundException {
        repository.delete(id);
        return "Id "+id+" Successfully Deleted!!";
    }

    // POST http://localhost:8080/api/v.0.1/streams/
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public LiveStream create(@Valid @RequestBody LiveStream stream) {
        return repository.create(stream);
    }

    // PUT http://localhost:8080/api/v.0.1/streams/id={id}
    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping("/id={id}")
    public String update(@PathVariable String id, @RequestBody LiveStream stream) {
        repository.update(stream, id);
        return "Id "+id+" Successfully Updated!!";
    }

}
