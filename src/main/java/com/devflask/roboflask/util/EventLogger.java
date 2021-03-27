package com.devflask.roboflask.util;

import net.dv8tion.jda.api.events.GenericEvent;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class EventLogger extends ListenerAdapter {

    @Override
    public void onGenericEvent(@NotNull GenericEvent event) {
        GuildMessageReceivedEvent gmre = null;

        if (event instanceof GuildMessageReceivedEvent)  gmre = (GuildMessageReceivedEvent) event;

        if (gmre == null){
            event.getJDA().getGuildById("298480981441118208").getTextChannelById("807733786028015627")
                    .sendMessage("EVENT: "+event.getClass()).queue();
        }
    }
}
