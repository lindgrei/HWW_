package com.lindgrei.HWW.Util;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.awt.*;

public class LevelUtil {
    public static double calcXp(double length, MessageReceivedEvent event) {
        double rate = event.getMember().isBoosting() || event.getMember().isOwner() ? 1.5 : 1;
//        double current_xp = 0;
//        double current_level = 0;
//        double desired_level = current_level + 1;
//        double xp_to_desired_level = 5 / 6 * desired_level * (2 * desired_level * desired_level + 27 * desired_level + 91);
//        double xp_of_current_level = 5 / 6 * current_level * (2 * current_level * current_level + 27 * current_level + 91);
//        double xp_needed = Math.round(xp_to_desired_level - xp_of_current_level - current_xp);
//        double min_xp_gain_per_message = Math.floor(15 * rate);
//       double max_xp_gain_per_message = Math.ceil(25 * rate);
        double xp_gain = 0;

        if (length < 40) {
            xp_gain = Math.floor(5 * rate);
        } else if (length > 40 && length < 250) {
            xp_gain = Math.floor(15 * rate);
        } else if (length > 250 && length < 500) {
            xp_gain = Math.floor(25 * rate);
        } else if (length > 500) {
            xp_gain = Math.floor(50 * rate);
            event.getMessage().reply("***SUPER CHONKY MESSAGE!!!!***").queue();
        }

        return xp_gain;


    }

    private static double func(int x) {
        return Math.ceil(0.833 * x * ((2 * x * x) + 27 * x + 91));
    }

    public static void main(String[] args) {
        StringBuilder res = new StringBuilder();
        for (int i = 200; i > 0; i--) {
            //int f = (int) Math.ceil();
            res.append("else if( xp >=").append(func(i)).append(") { \n").append("\tcreateXpMessage(xp, level, event); \n \t} \n");


        }
        System.out.println(res);
    }

    public static void checkForLevelSteps(int level, double xp, MessageReceivedEvent event) {


        if( xp >=1.4242801E7) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=1.4034829E7) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=1.3828892E7) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=1.3624978E7) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=1.3423079E7) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=1.3223184E7) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=1.3025283E7) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=1.2829367E7) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=1.2635424E7) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=1.2443446E7) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=1.2253422E7) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=1.2065342E7) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=1.1879197E7) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=1.1694976E7) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=1.1512669E7) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=1.1332266E7) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=1.1153757E7) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=1.0977133E7) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=1.0802383E7) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=1.0629497E7) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=1.0458465E7) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=1.0289278E7) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=1.0121925E7) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=9956396.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=9792682.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=9630772.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=9470656.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=9312324.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=9155767.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=9000974.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=8847935.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=8696640.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=8547080.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=8399244.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=8253123.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=8108706.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=7965983.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=7824944.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=7685580.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=7547880.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=7411835.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=7277433.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=7144666.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=7013524.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=6883996.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=6756072.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=6629743.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=6504997.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=6381827.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=6260220.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=6140168.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=6021661.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=5904688.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=5789239.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=5675304.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=5562874.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=5451939.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=5342488.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=5234511.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=5127998.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=5022941.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=4919327.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=4817148.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=4716393.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=4617053.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=4519117.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=4422576.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=4327419.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=4233636.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=4141218.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=4050155.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=3960436.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=3872051.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=3784991.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=3699245.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=3614804.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=3531657.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=3449795.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=3369207.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=3289884.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=3211815.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=3134991.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=3059401.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=2985036.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=2911885.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=2839939.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=2769187.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=2699620.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=2631228.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=2563999.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=2497926.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=2432997.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=2369202.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=2306533.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=2244977.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=2184526.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=2125170.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=2066898.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=2009701.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=1953569.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=1898491.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=1844457.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=1791459.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=1739484.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=1688525.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=1638570.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=1589609.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=1541634.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=1494632.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=1448596.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=1403514.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=1359377.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=1316174.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=1273896.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=1232532.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=1192073.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=1152509.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=1113830.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=1076025.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=1039085.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=1002999.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=967758.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=933352.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=899770.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=867004.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=835041.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=803874.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=773491.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=743883.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=715039.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=686951.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=659607.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=632997.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=607113.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=581943.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=557477.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=533707.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=510621.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=488210.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=466464.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=445372.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=424925.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=405113.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=385926.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=367353.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=349386.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=332013.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=315224.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=299011.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=283362.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=268268.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=253719.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=239705.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=226215.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=213240.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=200770.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=188795.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=177305.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=166289.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=155738.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=145642.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=135991.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=126775.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=117983.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=109607.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=101635.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=94058.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=86866.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=80048.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=73596.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=67498.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=61746.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=56328.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=51235.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=46457.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=41984.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=37805.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=33912.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=30293.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=26940.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=23841.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=20987.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=18368.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=15974.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=13795.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=11821.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=10041.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=8447.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=7028.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=5773.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=4674.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=3719.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=2899.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=2205.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=1625.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=1150.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=770.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=475.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=255.0) {
            createXpMessage(xp, level, event);
        }
        else if( xp >=100.0) {
            createXpMessage(xp, level, event);
        }
    }

    public static void createXpMessage(double xp, int level, MessageReceivedEvent event) {

        EmbedBuilder eb = new EmbedBuilder();
        eb.setTitle(event.getAuthor().getAsTag()+" has gained a level!", null);

/*
    Set the color
 */
        eb.setColor(Color.red);
        eb.setColor(new Color(0xF40C0C));
        eb.setColor(new Color(255, 0, 54));

/*
    Set the text of the Embed:
    Arg: text as string
 */
        eb.setDescription("You are now level: **" + level+"**");

/*
    Add fields to embed:
    1. Arg: title as string
    2. Arg: text as string
    3. Arg: inline mode true / false
 */
        eb.addField("XP:", String.valueOf(xp), false);

/*
    Add spacer like field
    Arg: inline mode true / false
 */
/*
    Add embed author:
    1. Arg: name as string
    2. Arg: url as string (can be null)
    3. Arg: icon url as string (can be null)
 */
        eb.setAuthor("He, Who Watches#8700", null, "https://cdn.discordapp.com/app-icons/1052646068753535007/595ffa33320ba42f9b27eaea14ecde18.png?size=256");

/*
    Set footer:
    1. Arg: text as string
    2. icon url as string (can be null)
 */
        eb.setFooter("Race to the top!");

/*
    Set image:
    Arg: image url as string
 */
        //eb.setImage(event.getMember().getAvatarUrl());

/*
    Set thumbnail image:
    Arg: image url as string
 */
        eb.setImage(generateAvatarUrl(event.getAuthor()));
        event.getChannel().sendMessage("Nice!").setEmbeds(eb.build()).complete();
    }



    private static String generateAvatarUrl(User user) {
        String avatarUrl = user.getEffectiveAvatarUrl();
        String[] parts = avatarUrl.split("\\.");

        String extension = parts[parts.length - 1];

        return avatarUrl + "?size=256&." + extension;
    }
}

