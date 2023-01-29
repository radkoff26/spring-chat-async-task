package com.radkoff26.springchatasynctask.domain.body;

public record AuthorizationMailCodeBody(String type, String email, String code) {
}
