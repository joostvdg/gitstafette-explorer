package net.kearos.gitstafette.explorer.model;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.TreeMap;

public record Server(
        String name,
        String host,
        String port,
        LocalDateTime lastVisited,
        Map<String, Integer> cachedEvents
    ) {
    public Server(String name, String host, String port) {
        this(name, host, port, LocalDateTime.now(),  new TreeMap<String, Integer>());
    }
}
