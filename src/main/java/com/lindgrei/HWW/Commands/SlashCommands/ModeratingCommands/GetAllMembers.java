package com.lindgrei.HWW.Commands.SlashCommands.ModeratingCommands;

import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.guild.GuildReadyEvent;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.DefaultMemberPermissions;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;

import java.util.ArrayList;
import java.util.List;

import static com.lindgrei.HWW.Database.DatabaseHandler.InsertMember;
import static com.lindgrei.HWW.Database.DatabaseHandler.checkIfMemberExists;
import static com.lindgrei.HWW.Util.TerminalUtil.logging;

public class GetAllMembers extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        if (event.getName().equals("members")) {
            List<Member> members = event.getGuild().getMembers();

            event.deferReply().setEphemeral(true).queue();
            logging(event);
            for(Member m : members){
                if(m.getUser().isBot()){
                    continue;
                }else {
                    if (!checkIfMemberExists(m.getIdLong())){
                        event.getChannel().sendMessage(m.getAsMention() + " Already exists!");
                    }else{
                        if (InsertMember(m.getIdLong(), m.getUser().getAsTag())) {
                            event.getChannel().sendMessage(m.getAsMention() + " -> DB").queue();
                        } else {
                            event.getChannel().sendMessage("An error has occured while trying to insert " + m.getAsMention()).queue();
                        }
                    }
                }
            }

            event.getHook().sendMessage("Done adding all members!").queue();


        }
    }
    public void onGuildReady(GuildReadyEvent event) {
        List<CommandData> commandData = new ArrayList<>();
        commandData.add(Commands.slash("members","Sends all members to Database").setDefaultPermissions(DefaultMemberPermissions.enabledFor(Permission.ADMINISTRATOR)));
        event.getGuild().updateCommands().addCommands(commandData).queue();
    }

}


