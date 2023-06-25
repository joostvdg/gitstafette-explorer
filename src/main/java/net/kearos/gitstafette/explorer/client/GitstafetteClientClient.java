package net.kearos.gitstafette.explorer.client;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import net.kearos.gitstafette.explorer.model.WatchedRepositoryList;
import net.kearos.gitstafette.grpc.GitstafetteGrpc;
import net.kearos.gitstafette.grpc.WatchedRepositoriesRequest;



@org.springframework.stereotype.Component
public class GitstafetteClientClient {
    private final String GitstafetteClientHost = "localhost";
    private final int GitstafetteClientPort = 51000;

    public GitstafetteClientClient() {
    }


    public WatchedRepositoryList getWatchedRepositoryList() {
        ManagedChannel channel = ManagedChannelBuilder
                .forAddress(GitstafetteClientHost, GitstafetteClientPort)
                .usePlaintext()
                .build();

        var request = WatchedRepositoriesRequest.newBuilder().setClientId("explorer").build();
        GitstafetteGrpc.GitstafetteBlockingStub gitstafetteClient = GitstafetteGrpc.newBlockingStub(channel);
        gitstafetteClient.watchedRepositories(request).getWatchedRepositoriesList().forEach(watchedRepository -> System.out.println(watchedRepository.toString()));

        channel.shutdown();
        return null;
    }
}
