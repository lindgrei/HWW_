package com.lindgrei.HWW.Commands.SlashCommands;

import net.dv8tion.jda.api.entities.UserSnowflake;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;

import java.util.Objects;

public class AvatarSlashCommand extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event){
        if(event.getName().equals("avatar")){


            event.reply(event.getUser().getAvatar().getUrl()).queue();
    }
}
}
