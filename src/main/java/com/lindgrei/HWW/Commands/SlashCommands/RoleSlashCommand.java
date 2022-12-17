package com.lindgrei.HWW.Commands.SlashCommands;

import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.guild.GuildReadyEvent;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.build.Commands;

import java.util.Objects;

public class RoleSlashCommand extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        if(event.getName().equals("roles")){
            event.deferReply().setEphemeral(true).queue();

            StringBuilder response = new StringBuilder();
            for(Role role : Objects.requireNonNull(event.getGuild()).getRoles()){
                response.append(role.getAsMention()).append("\n");


            }
            event.getHook().sendMessage(response.toString()).queue();
        }
    }

}
