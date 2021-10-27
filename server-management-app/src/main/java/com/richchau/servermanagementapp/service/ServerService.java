package com.richchau.servermanagementapp.service;

import java.util.Collection;

import com.richchau.servermanagementapp.model.Server;

public interface ServerService {
    Server create(Server server);

    Collection<Server> list(int limit);

    Server get(Long id);

    Server update(Server server);

    Boolean delete(Long id);
}
