package net.kearos.gitstafette.explorer.controller;


import net.kearos.gitstafette.explorer.client.GitstafetteClientClient;
import net.kearos.gitstafette.explorer.client.GitstafetteServerClient;
import net.kearos.gitstafette.explorer.model.Server;
import net.kearos.gitstafette.explorer.model.WatchedRepositoryList;
import net.kearos.gitstafette.grpc.WatchedRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/server")
public class ServerController {

    private final static Logger logger = LoggerFactory.getLogger(ServerController.class);

    private final Server server = new Server("local","127.0.0.1", "1323");

    private final GitstafetteServerClient gitstafetteServerClient;

    private final GitstafetteClientClient gitstafetteClientClient;

    ServerController(GitstafetteServerClient gitstafetteServerClient, GitstafetteClientClient gitstafetteClientClient) {
        this.gitstafetteServerClient = gitstafetteServerClient;
        this.gitstafetteClientClient = gitstafetteClientClient;
    }


    @GetMapping("/")
    List<Server> dummyServer() {
        logger.info("Dummy server list");
        var servers = new ArrayList<Server>();
        servers.add(server);
        return servers;
    }

    @GetMapping("/remote")
    WatchedRepositoryList collectFromRemoteServers() {
        logger.info("Collecting from remote server");
        var result = gitstafetteServerClient.getWatchedRepositoryList();
        logger.info("Result collected: {}", result);
        return result;
    }

    @GetMapping(path="/clients", produces="application/json")
    ResponseEntity<List<WatchedRepository>> collectFromRemoteClients() {
        logger.info("Collecting from remote client");
        var watchedRepositoryList = gitstafetteClientClient.getWatchedRepositoryList();
        watchedRepositoryList.forEach(watchedRepository -> logger.info("Watched repository: {}", watchedRepository));
        return ResponseEntity.ok(watchedRepositoryList);
    }

    // TODO implement HATEOAS
    // https://spring.io/projects/spring-hateoas

}
