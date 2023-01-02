package com.lindgrei.HWW.Commands.SlashCommands;

import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.UserSnowflake;
import net.dv8tion.jda.api.events.guild.GuildReadyEvent;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.DefaultMemberPermissions;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class BanSlashCommand extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        if(event.getName().equals("ban")){
            //DATABASE IS HE BANNED TRUE
            OptionMapping userToBan = event.getOption("user");

            //Objects.requireNonNull(event.getGuild()).ban((UserSnowflake) userToBan,0, TimeUnit.DAYS).queue();
            event.getGuild().ban(UserSnowflake.fromId(userToBan.getAsMember().getId()), 999, TimeUnit.DAYS).queue();

        }else if(!event.getMember().hasPermission(Permission.BAN_MEMBERS)){
            event.reply(event.getUser().getAsMention() + " You don't have permission to use this command.").queue();
        }

    }

    public void onGuildReady(GuildReadyEvent event) {
        List<CommandData> commandData = new ArrayList<>();
        OptionData op = new OptionData(OptionType.USER,"user","The user to ban", true);
        commandData.add(Commands.slash("ban", "Hits a user with the Ban Hammer.")
                .setDefaultPermissions(DefaultMemberPermissions.enabledFor(Permission.BAN_MEMBERS)));
        event.getGuild().updateCommands().addCommands(commandData).queue();
    }

}
