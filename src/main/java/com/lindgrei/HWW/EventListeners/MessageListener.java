package com.lindgrei.HWW.EventListeners;

import net.dv8tion.jda.api.entities.emoji.Emoji;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import static com.lindgrei.HWW.Database.DatabaseHandler.*;
import static com.lindgrei.HWW.Util.LevelUtil.calcXp;
import static com.lindgrei.HWW.Util.LevelUtil.createXpMessage;

public class MessageListener extends ListenerAdapter {
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {

        //TODO: spamfilter, xp counting
        if( event.getAuthor().isBot()  && event.getAuthor().getIdLong() != 1052646068753535007L){
            event.getMessage().addReaction(Emoji.fromUnicode("U+1F916")).queue();
            event.getMessage().reply("*beep boop?*").queue();
        } else {

            if (!checkIfMemberExists(event.getAuthor().getIdLong())){
                InsertMember(event.getAuthor().getIdLong(), event.getMember().getUser().getAsTag());
                messageProtocol(event);


            }else{
                messageProtocol(event);
            }


        }

        if (event.getMessage().getContentRaw().equals("!eb")){
            createXpMessage(1.1, 2, event);
        }

    }

    private void messageProtocol(MessageReceivedEvent event){
        incrementMSGCounter(event.getAuthor().getIdLong());
        addXpToUser(event.getAuthor().getIdLong(), calcXp(event.getMessage().getContentRaw().length(), event));
    }


}
