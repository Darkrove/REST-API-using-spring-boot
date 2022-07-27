package dev.danvega.streamsschedule.controller;

import dev.danvega.streamsschedule.exception.LiveStreamNotFoundException;
import dev.danvega.streamsschedule.model.LiveStream;
import dev.danvega.streamsschedule.repository.LiveStreamRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/streams")
public class LiveStreamController {

    private final LiveStreamRepository repository;

    public LiveStreamController(LiveStreamRepository repository) {
        this.repository = repository;
    }


    @GetMapping
    public List<LiveStream> findAll() {
        return repository.findAll();
    }

    @GetMapping("/id={id}")
    public LiveStream findById(@PathVariable String id) throws LiveStreamNotFoundException {
        return repository.findById(id);
    }

}
