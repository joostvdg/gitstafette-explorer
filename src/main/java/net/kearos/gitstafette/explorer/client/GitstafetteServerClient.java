package net.kearos.gitstafette.explorer.client;

import net.kearos.gitstafette.explorer.model.RepositoryEvents;
import net.kearos.gitstafette.explorer.model.WatchedRepositoryList;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "gitstefette-server-api", url = "http://localhost:1323/v1/")
public interface GitstafetteServerClient  {

    @RequestMapping(method = RequestMethod.GET, value = "/watchlist")
    WatchedRepositoryList getWatchedRepositoryList();

    @RequestMapping(method = RequestMethod.GET, value = "/events/{repoId}")
    RepositoryEvents getRepositoryEvents(@PathVariable("repoId") Long repoId);
}
