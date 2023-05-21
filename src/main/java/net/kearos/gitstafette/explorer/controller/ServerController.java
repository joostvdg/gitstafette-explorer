package net.kearos.gitstafette.explorer.controller;


import net.kearos.gitstafette.explorer.client.GitstafetteServerClient;
import net.kearos.gitstafette.explorer.model.Server;
import net.kearos.gitstafette.explorer.model.WatchedRepositoryList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    ServerController(GitstafetteServerClient gitstafetteServerClient) {
        this.gitstafetteServerClient = gitstafetteServerClient;
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

    // TODO implement HATEOAS
    // https://spring.io/projects/spring-hateoas

}
