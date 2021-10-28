package com.richchau.servermanagementapp.service.implementation;

import java.io.IOException;
import java.net.InetAddress;
import java.util.Collection;

import javax.transaction.Transactional;

import com.richchau.servermanagementapp.model.Server;
import com.richchau.servermanagementapp.repo.ServerRepo;
import com.richchau.servermanagementapp.service.ServerService;
import com.richchau.servermanagementapp.enumeration.Status;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class ServerServiceImpl implements ServerService {

    private final ServerRepo serverRepo;

    @Override
    public Server create(Server server) {
        log.info("Saving new server: {}", server.getName());
        server.setImageUrl(setServerImageUrl());
        return serverRepo.save(server);
    }

    @Override
    public Server ping(String ipAddress) throws IOException {
        log.info("Pinging server IP: {}", ipAddress);
        Server server = serverRepo.findByIpAddress(ipAddress);
        InetAddress address = InetAddress.getByName(ipAddress);
        server.setStatus(address.isReachable(10000) ? Status.SERVER_UP : Status.SERVER_DOWN);
        serverRepo.save(server);
        return server;
    }

    @Override
    public Collection<Server> list(int limit) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Server get(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Server update(Server server) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    private String setServerImageUrl() {
        return null;
    }
}
