package com.richchau.servermanagementapp.resource;

import java.util.Map;

import com.richchau.servermanagementapp.model.Response;
import com.richchau.servermanagementapp.service.implementation.ServerServiceImpl;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.OK;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/server")
@RequiredArgsConstructor
public class ServerResouce {
    private final ServerServiceImpl serverService;

    @GetMapping("/list")
    public ResponseEntity<Response> getServers() {
        return ResponseEntity.ok(Response.builder().timeStamp(now()).data(Map.of("servers", serverService.list(30)))
                .message("Servers retrieved").status(OK).statusCode(OK.value()).build());
    }
}
