package com.lindgrei.HWW.EventListeners;

import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class JoinListener extends ListenerAdapter {
    @Override
    public void onGuildMemberJoin(GuildMemberJoinEvent event) {
        String mention = event.getMember().getAsMention();
        TextChannel txt = event.getGuild().getTextChannelById(1052648179578962010L);
        assert txt != null;
        txt.sendMessage("Welcome " +mention+" To the "+"***"+event.getGuild().getName()+"***" +" Server! Hope you enjoy it here!").queue();

    }

}
