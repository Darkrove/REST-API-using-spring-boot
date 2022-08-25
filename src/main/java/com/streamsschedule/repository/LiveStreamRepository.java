package com.streamsschedule.repository;

import com.streamsschedule.exception.LiveStreamNotFoundException;
import com.streamsschedule.model.LiveStream;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class LiveStreamRepository {

    List<LiveStream> streams = new ArrayList<>();

    public LiveStreamRepository() {
        streams.add(new LiveStream(
                UUID.randomUUID().toString(),
                "Creating NFTs using different token standards",
                """
                    A closer look at different token standards for NFTs namely ERC721, ERC721A and ERC1155
                    and understanding differences, optimizations and opportunities.
                    """,
                "https://metaschool.so/courses/creating-nfts-using-different-token-standards",
                LocalDateTime.of(2022,11,11,12,30),
                LocalDateTime.of(2022,11,11,18,30)
        ));
        streams.add(new LiveStream(
                UUID.randomUUID().toString(),
                "Writing your first Hello World contract in Solidity",
                """
                        This is a beginner level project for anyone looking to start in web3 space.
                        """,
                "https://metaschool.so/courses/writing-your-first-hello-world-contract-in-solidity",
                LocalDateTime.of(2022,9,23,10,45),
                LocalDateTime.of(2022,11,11,14,45)
        ));
    }

    public List<LiveStream> findAll() {
        return streams;
    }

    public LiveStream create(LiveStream stream) {
        streams.add(stream);
        return stream;
    }

    public void update(LiveStream stream, String id) {
        LiveStream existing = streams.stream().filter(s -> s.id().equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Stream not found"));
        int i = streams.indexOf(existing);
        streams.set(i, stream);
    }

    public void delete(String id) {
        streams.removeIf(stream -> stream.id().equals(id));
    }

    public LiveStream findById(String id) throws LiveStreamNotFoundException {
        return streams.stream().filter(stream -> stream.id().equals(id))
                .findFirst().orElseThrow(LiveStreamNotFoundException::new);
    }
}