package net.kearos.gitstafette.explorer.model;

import java.util.List;

public record RepositoryEvents(List<WebhookEvent> Events) {
}
