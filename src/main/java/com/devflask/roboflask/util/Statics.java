package com.devflask.roboflask.util;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;

public class Statics{

    public enum MESSAGE {
        ERROR_PERMISSION_BOT("I do not seem to have permission"),
        ERROR_PERMISSION_USER("Sorry but you do not have permission to do that"),
        ERROR_PERMISSION_HIERARCHY("Can't modify a member with a higher or equal highest role"),
        ERROR_UNKNOWN("An unknown error has occurred. Please report this to the developers https://github.com/devflask/roboflask"),
        ERROR_USAGE("Wrong usage. Use: %"),
        ERROR_UNBAN("This user is not banned! %"),

        SUCCESS_BAN("% banned % for %%"),
        SUCCESS_UNBAN("% unbanned %"),
        SUCCESS_KICK("% kicked % for %%"),

        ;

        private String message;

        MESSAGE(String message) {
            this.message = message;
        }

        public MESSAGE insert(String ... array){
            for (String s : array){
                message = message.replaceFirst("%", s);
            }
            message = message.replaceAll("%", "");
            return this;
        }

        public String get(){
            return message;
        }


    }

    public enum EMBED {

        BAN(new EmbedBuilder().setColor(EmbedColor.MODERATION.color)),
        KICK(new EmbedBuilder().setColor(EmbedColor.MODERATION.color))
        ;

        private EmbedBuilder embedBuilder;

        EMBED(EmbedBuilder embedBuilder){
            this.embedBuilder = embedBuilder;
        }

        private String insert(String message, String ... array){
            String str = message;
            for (String s : array){
                str = str.replaceFirst("%", s);
            }
            str = str.replaceAll("%", "");
            return str;
        }

        public MessageEmbed get(){
            return embedBuilder.build();
        }

        public EmbedBuilder embed(){
            return embedBuilder;
        }

        public EMBED title(MESSAGE msg){
            embedBuilder.setTitle(msg.get());
            return this;
        }

        public EMBED description(MESSAGE msg){
            embedBuilder.setDescription(msg.get());
            return this;
        }

        public EMBED footer(MESSAGE msg){
            embedBuilder.setFooter(msg.get());
            return this;
        }

    }

}