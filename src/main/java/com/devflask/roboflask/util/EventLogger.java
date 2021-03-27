package com.devflask.roboflask.util;

import net.dv8tion.jda.api.events.GenericEvent;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.events.guild.member.GuildMemberRemoveEvent;
import net.dv8tion.jda.api.events.guild.member.GuildMemberRoleAddEvent;
import net.dv8tion.jda.api.events.guild.member.GuildMemberRoleRemoveEvent;
import net.dv8tion.jda.api.events.message.guild.GuildMessageDeleteEvent;

import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class EventLogger extends ListenerAdapter {

    public void onGenericEvent(GenericEvent e){

        Object o =
            e instanceof GuildMessageDeleteEvent ? log(e, ((GuildMessageDeleteEvent) e).getMessageId()+"") :
            e instanceof GuildMemberJoinEvent ? log(e, "GuildMemberJoinEvent was fired") :
            e instanceof GuildMemberRemoveEvent ? log(e, "GuildMemberRemoveEvent was fired") :
            e instanceof GuildMemberRoleRemoveEvent ? log(e, "GuildMemberRoleRemoveEvent was fired") :
            e instanceof GuildMemberRoleAddEvent ? log(e, "GuildMemberRoleAddEvent was fired") :
        null;

    }

    private Object log(Object ... o){
        GenericEvent e = (GenericEvent) o[0];

        /*TEMP*/ String message = (String) o[1];

        e.getJDA().getGuildById("298480981441118208").getTextChannelById("807733786028015627")
                .sendMessage(message).queue();

        return null;
    }

}
