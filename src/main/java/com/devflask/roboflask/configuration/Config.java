package com.devflask.roboflask.configuration;

import net.dv8tion.jda.api.entities.TextChannel;

public class Config {

    public final String status;
    public final Long[] adminsID;
    public static final String DEFAULT_PREFIX = "!";
    public final Database database;
    public final TextChannel logChannel;

    class Database {
        public final String ip;
        public final int port;
        public final String username;
        public final String password;


        public Database(String ip, int port, String username, String password) {
            this.ip = ip;
            this.port = port;
            this.username = username;
            this.password = password;
        }
    }


    public Config(String status, Long[] adminsID, String defaultPrefix, Database database, TextChannel logChannel){
        this.status = status;
        this.adminsID = adminsID;
        this.database = database;
        this.logChannel = logChannel;
    }

    public TextChannel getLogChannel() {
        return logChannel;
    }
}
