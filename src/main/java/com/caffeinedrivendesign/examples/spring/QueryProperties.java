package com.caffeinedrivendesign.examples.spring;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("query")
public class QueryProperties {

  private boolean enabled;

  private String url;

  public boolean isEnabled() {
    return enabled;
  }

  public void setEnabled(boolean enabled) {
    this.enabled = enabled;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

}
