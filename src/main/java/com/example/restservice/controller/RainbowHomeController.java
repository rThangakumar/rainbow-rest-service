package com.example.restservice.controller;

import com.example.restservice.model.RainbowHomeResponse;
import com.example.restservice.service.RainbowHomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class RainbowHomeController {
    @Autowired
    private RainbowHomeService rainbowHomeService;

    @GetMapping("/homes")
    public List<RainbowHomeResponse> getRainbowHomes(@RequestParam List<Short> stateNetworkNos) {
        return rainbowHomeService.getRainbowHomes(stateNetworkNos);
    }
}
