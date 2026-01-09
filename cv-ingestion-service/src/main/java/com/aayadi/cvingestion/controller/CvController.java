package com.aayadi.cvingestion.controller;

import com.aayadi.contracts.apis.CvSubmitRequest;
import com.aayadi.contracts.apis.CvSubmitResponse;
import com.aayadi.cvingestion.service.CvSubmissionService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/cvs")
public class CvController {

    private final CvSubmissionService service;

    public CvController(CvSubmissionService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<CvSubmitResponse> submit(@RequestBody @Valid CvSubmitRequest req) {
        var res = service.submit(req);
        return ResponseEntity.accepted().body(res);
    }

}