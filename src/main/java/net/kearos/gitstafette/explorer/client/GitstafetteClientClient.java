package net.kearos.gitstafette.explorer.client;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import net.kearos.gitstafette.grpc.GitstafetteGrpc;
import net.kearos.gitstafette.grpc.WatchedRepositoriesRequest;
import net.kearos.gitstafette.grpc.WatchedRepository;

import java.util.List;


@org.springframework.stereotype.Component
public class GitstafetteClientClient {
    private final String GitstafetteClientHost = "localhost";
    private final int GitstafetteClientPort = 51000;

    public GitstafetteClientClient() {
    }


    public List<WatchedRepository> getWatchedRepositoryList() {
        ManagedChannel channel = ManagedChannelBuilder
                .forAddress(GitstafetteClientHost, GitstafetteClientPort)
                .usePlaintext()
                .build();

        var request = WatchedRepositoriesRequest.newBuilder().setClientId("explorer").build();
        GitstafetteGrpc.GitstafetteBlockingStub gitstafetteClient = GitstafetteGrpc.newBlockingStub(channel);
        var response = gitstafetteClient.watchedRepositories(request);

        channel.shutdown();
        return response.getWatchedRepositoriesList();
    }
}
