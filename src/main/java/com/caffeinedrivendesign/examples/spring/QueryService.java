/*
MIT License

Copyright (c) 2017 Rob McArthur

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
 */
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
