package com.lindgrei.HWW.Commands.SlashCommands;

import net.dv8tion.jda.api.events.guild.GuildReadyEvent;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;

import java.util.ArrayList;
import java.util.List;

import static com.lindgrei.HWW.Util.TerminalUtil.logging;

public class SetTwitchSlashCommand extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        if(event.getName().equals("linktwt")){
            event.deferReply().setEphemeral(true).queue();
            long id = event.getUser().getIdLong();
            String namae = event.getGuild().getName();
            OptionMapping opm = event.getOption("twitch");
            if (opm == null){
                event.getHook().sendMessage("No Twitch URL was posted...").setEphemeral(true).queue();

            } else {
                String name = namae.strip().replace(" ", "_").replace("'", "");
                if (opm.toString().contains("twitch.tv/")) {
                    String[] splitURL = opm.toString().split("/");
                    String TwitchName = splitURL[splitURL.length -1];

                    // InsertTwitchNameIntoDatabase(event, name,event.getUser().getIdLong(), TwitchName.replace(")",""));
                    event.getHook().sendMessage("Your name is: " +TwitchName.replace(")","" + " And has been added to the database!")).setEphemeral(true).queue();



                }else if(!opm.toString().contains("twitch.tv/") || !opm.toString().contains("https://www.twitch.tv/")){
                    // InsertTwitchNameIntoDatabase(event, name,event.getUser().getIdLong(), opm.getAsString().replace(")",""));
                    logging(event);
                    event.getHook().sendMessage("Your name is: " + opm.getAsString().replace(")","" + " And has been added to the database!")).setEphemeral(true).queue();
                }
            }
        }
    }

    @Override
    public void onGuildReady(GuildReadyEvent event) {
        List<CommandData> commandData = new ArrayList<>();
        OptionData twitchName = new OptionData(OptionType.STRING,"twitch", "A direct link, or straight up your twitch username!", true);
        commandData.add(Commands.slash("linktwt", "Links your twitch name to your Discord TAG").addOptions(twitchName));

        event.getGuild().updateCommands().addCommands(commandData).queue();
    }
}
