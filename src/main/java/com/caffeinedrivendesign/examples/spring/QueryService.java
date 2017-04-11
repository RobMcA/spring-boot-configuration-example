package com.caffeinedrivendesign.examples.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class QueryService {

  private static final Logger LOG = LoggerFactory.getLogger(QueryService.class);

  private QueryProperties config;

  private RestTemplate restTemplate;

  @Autowired
  public void QueryService(QueryProperties config, RestTemplate restTemplate) {
    this.config = config;
    this.restTemplate = restTemplate;
  }

  public String query() {

    if (config.isEnabled()) {
      String url = config.getUrl();
      LOG.debug("Calling Query Service at {}", url);

      return restTemplate.getForObject(url, String.class);

    } else {
      LOG.debug("Query Service disabled. Set query.enabled = true to enable.");

      return "{\"message\":\"Query service is disabled. Please set query.enabled = true\"}";
    }

  }

}
