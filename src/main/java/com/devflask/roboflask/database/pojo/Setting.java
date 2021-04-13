package com.devflask.roboflask.database.pojo;


public class Setting {

  private long id;
  private String prefix;
  private long logChannel;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getPrefix() {
    return prefix;
  }

  public void setPrefix(String prefix) {
    this.prefix = prefix;
  }


  public long getLogChannel() {
    return logChannel;
  }

  public void setLogChannel(long logChannel) {
    this.logChannel = logChannel;
  }

}
