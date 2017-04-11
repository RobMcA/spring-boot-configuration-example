package com.caffeinedrivendesign.examples.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class Controller {

  private QueryService queryService;

  @Autowired
  public void Controller(QueryService queryService) {
    this.queryService = queryService;
  }

  @RequestMapping("/")
  public String getQueryInfo() {

    return queryService.query();

  }

}
