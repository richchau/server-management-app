package com.richchau.servermanagementapp.repo;

import com.richchau.servermanagementapp.model.Server;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ServerRepo extends JpaRepository<Server, Long> {
    Server findByIpAddress(String ipAddress);
}
