package net.kearos.gitstafette.explorer.model;

import java.time.LocalDateTime;

public record WebhookEvent(
        String id,
        boolean isRelayed,
        LocalDateTime timestamp,
        WebhookEventHeaders headers ) {
}
