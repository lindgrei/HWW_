package com.lindgrei.HWW.Commands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class CommandManager extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        //Get the name of the command.
        String command = event.getName();
        if (command.equals("welcome")){
            String userTag = event.getUser().getAsTag();
            event.reply("Welcome To The Server, " + userTag).queue();

        }
    }

    
}
