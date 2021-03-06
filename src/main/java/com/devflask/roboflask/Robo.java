package com.devflask.roboflask;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.security.auth.login.LoginException;


public class Robo  {

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
    }

}
