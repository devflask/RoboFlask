package com.devflask.roboflask;

import com.devflask.roboflask.configuration.Config;
import net.dv8tion.jda.api.entities.TextChannel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.security.auth.login.LoginException;


public class Robo  {

    public static Config getConfig;

    private static final Logger LOGGER = LogManager.getLogger(Robo.class);
    private final Bot bot;
    private  static String[] arguments;

    //Way into the program
    public static void main(String[] args) {
        try {
            arguments = args;
            Robo robo = new Robo();
        } catch (LoginException | InterruptedException e) {
            e.printStackTrace();
        }

    }

    public Robo() throws LoginException, InterruptedException {
        bot = new Bot(arguments[0]);

        //test
        getConfig = new Config(
                "something",
                new Long[]{null},
                "!",
                null,
                (TextChannel) bot.getBot().getGuildChannelById("807733786028015627")
        );
    }

}
