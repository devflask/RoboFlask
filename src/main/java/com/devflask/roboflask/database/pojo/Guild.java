package com.devflask.roboflask.database.pojo;


public class Guild {

  private long id;
  private String name;
  private long ownerId;
  private java.sql.Date joined;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public long getOwnerId() {
    return ownerId;
  }

  public void setOwnerId(long ownerId) {
    this.ownerId = ownerId;
  }


  public java.sql.Date getJoined() {
    return joined;
  }

  public void setJoined(java.sql.Date joined) {
    this.joined = joined;
  }

}
