package com.lindgrei.HWW.Commands.SlashCommands;

import net.dv8tion.jda.api.events.guild.GuildJoinEvent;
import net.dv8tion.jda.api.events.guild.GuildReadyEvent;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;

import java.util.ArrayList;
import java.util.List;

public class CommandManager extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        //Get the name of the command.
        String command = event.getName();
        if (command.equals("welcome")){
            String userTag = event.getUser().getId();
            String mentionnable = "<@"+userTag+">";
            event.reply("Welcome To The "+ "***"+event.getGuild().getName()+"***" +" Server, " + mentionnable)
                    .setEphemeral(true).queue();

        }
    }




}
