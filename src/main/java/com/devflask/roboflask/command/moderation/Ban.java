package com.devflask.roboflask.command.moderation;

import com.devflask.roboflask.command.Command;
import com.devflask.roboflask.command.CommandInformation;
import com.devflask.roboflask.util.MessageUtil;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class Ban implements Command {

    @NotNull
    @Override
    public String getName() {
        return "ban";
    }

    @NotNull
    @Override
    public Collection<Permission> getRequiredPermissions(){
        HashSet<Permission> set = new HashSet<>();
        set.add(Permission.BAN_MEMBERS);
        return set;
    }

    @Override
    public void execute(CommandInformation info){
        if (info.isGuild()) execute(info.getGuildEvent());
    }

    private void execute(GuildMessageReceivedEvent event){

        final TextChannel channel = event.getChannel();
        final Message message = event.getMessage();
        final Member member = event.getMember();
        final Member target = message.getMentionedMembers().isEmpty() ? null : message.getMentionedMembers().get(0);
        final String[] args = message.getContentRaw().split(" ");


        if (target == null || message.getMentionedMembers().isEmpty()){
            channel.sendMessage(MessageUtil.getCommandError(
                        MessageUtil.Messages.COMMAND_ERROR_USAGE,
                        member.getEffectiveName(),
                        member.getUser().getAvatarUrl(),
                        "!ban <user> [reason]"
                ).build()
            ).queue();
            return;
        }

        if (!member.canInteract(target) || !event.getGuild().getSelfMember().canInteract(target)){
            channel.sendMessage(MessageUtil.getPermissionError(
                        MessageUtil.Messages.PERMISSION_ERROR_HIERARCHY,
                        this.getRequiredPermissions(),
                        member.getEffectiveName(),
                        member.getUser().getAvatarUrl()
                    ).clearFields()
                    .build()
            ).queue();
            return;
        }

        final String reason = String.join(" ", Arrays.asList(args).subList(2, args.length));
        target.ban(0).reason(reason).queue();
        channel.sendMessage(MessageUtil.getCommandSuccess(
                    MessageUtil.Messages.COMMAND_SUCCESS_BAN,
                    member.getEffectiveName(),
                    member.getUser().getAvatarUrl(),
                    target.getEffectiveName(),
                    " for ",
                    reason
                ).build()
        ).queue();
    }
}