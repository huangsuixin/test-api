package com.github.huangsuixin.testapi.controller;

import com.github.huangsuixin.testapi.domain.ApiInfoDO;
import com.github.huangsuixin.testapi.repo.ApiInfoRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author suixin
 * @version 1.0
 * @className DemoController
 * @date 2018/11/16 10:05
 * @description //TODO
 * @program test-api
 */
@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ApiController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ApiController.class);
    @Autowired
    private ApiInfoRepo apiInfoRepo;


    @PostMapping("/save")
    public String save(@RequestBody ApiInfoDO apiInfoDO) {
        LOGGER.info("save入参:{}", apiInfoDO.toString());
        apiInfoRepo.save(apiInfoDO);
        return "success";
    }

    @GetMapping("findAll")
    public List<ApiInfoDO> findAll() {
        return apiInfoRepo.findAll();
    }

    @GetMapping("/{id}")
    public String get(@PathVariable Integer id) {
        return apiInfoRepo.findById(id).map(ApiInfoDO::getContent).orElse("");
    }

}
