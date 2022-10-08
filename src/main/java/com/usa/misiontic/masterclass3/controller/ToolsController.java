package com.usa.misiontic.masterclass3.controller;


import com.usa.misiontic.masterclass3.entities.Tools;
import com.usa.misiontic.masterclass3.service.ToolsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Tool")
public class ToolsController {


    @Autowired
    private ToolsService toolsService;

    @GetMapping("/all")
    public List<Tools> getAll(){
        return toolsService.getAll();
    }
    @PostMapping("/save")
    public Tools save(@RequestBody Tools p){
        return toolsService.save(p);
    }
}
