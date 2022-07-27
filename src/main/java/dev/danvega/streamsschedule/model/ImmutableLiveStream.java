package dev.danvega.streamsschedule.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class ImmutableLiveStream {
    private final String id;
    private final String title;
    private final String description;
    private final String streamUrl;
    private final LocalDateTime startDate;
    private final LocalDateTime endDate;

    public ImmutableLiveStream(String id, String title, String description, String streamUrl, LocalDateTime startDate, LocalDateTime endDate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.streamUrl = streamUrl;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getStreamUrl() {
        return streamUrl;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImmutableLiveStream that = (ImmutableLiveStream) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(title, that.title) &&
                Objects.equals(description, that.description) &&
                Objects.equals(streamUrl, that.streamUrl) &&
                Objects.equals(startDate, that.startDate) &&
                Objects.equals(endDate, that.endDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, streamUrl, startDate, endDate);
    }
}