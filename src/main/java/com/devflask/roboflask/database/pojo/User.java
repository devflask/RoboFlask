package com.devflask.roboflask.database.pojo;


public class User {

  private long discordId;
  private long id;
  private long guildId;
  private String name;
  private long money;
  private long xp;
  private long level;
  private java.sql.Timestamp nextDaily;


  public long getDiscordId() {
    return discordId;
  }

  public void setDiscordId(long discordId) {
    this.discordId = discordId;
  }


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getGuildId() {
    return guildId;
  }

  public void setGuildId(long guildId) {
    this.guildId = guildId;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public long getMoney() {
    return money;
  }

  public void setMoney(long money) {
    this.money = money;
  }


  public long getXp() {
    return xp;
  }

  public void setXp(long xp) {
    this.xp = xp;
  }


  public long getLevel() {
    return level;
  }

  public void setLevel(long level) {
    this.level = level;
  }


  public java.sql.Timestamp getNextDaily() {
    return nextDaily;
  }

  public void setNextDaily(java.sql.Timestamp nextDaily) {
    this.nextDaily = nextDaily;
  }

}
