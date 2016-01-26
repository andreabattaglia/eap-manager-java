package com.redhat.utils.eapmanager.commands;

public interface Command<R> {
    String getCommandName();

    R execute(Object... args);
}
