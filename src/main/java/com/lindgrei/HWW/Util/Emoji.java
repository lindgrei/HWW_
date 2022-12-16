package HWW.Util;



import java.util.Arrays;
import java.util.List;
import java.util.Random;

public final class Emoji {
    private Emoji(){

    }

    //Custom Emojis:
    public final static String EZ = "<:EZ:1030984901215924304>";
    public final static String FBM = "<:FeelsBadMan:1030984874020057229>";
    public final static String KEKW = "<:KEKW:1030984887576039424>";
    public final static String LULW = "<:LULW:1030984984091164842>";
    public final static String OLUL = "<:OMEGALUL:1030984735389913088>";
    public final static String POGGERS = "<:POGGERS:1030984749021405274>";
    public final static String PauseCH = "<:PauseChamp:1030984803161489448>";
    public final static String PepeHands = "<:PepeHands:1030984914511876206>";
    public final static String Sadge = "<:Sadge:1034238992146763877>";


    //Arraylists to keep shit tidy.
    static List<String> NiceMojis = Arrays.asList(new String[]{EZ,PauseCH,POGGERS});
    static List<String> BadMojis = Arrays.asList(new String[]{KEKW, LULW, OLUL, PepeHands, Sadge});

    public static String GetRandomMojiBasedOnPing(long ping){
        String returnMoji = "";
        Random rand = new Random();
        if(ping < 150){
            returnMoji = NiceMojis.get((rand.nextInt(NiceMojis.size())));
        }else{
            returnMoji = BadMojis.get((rand.nextInt(BadMojis.size())));
        }
        return returnMoji;
    }





    public final static String BOT          = "<:bot:850113743764717627>";
    public final static String BOT_VERIFIED = "<:botVerified:850113743760654397>";
    public final static String BOT_SYSTEM   = "<:botSystem:850113743488811031>";

    // badges
    public final static String BADGE_NITRO                = "<:badgeNitro:850113719702781953>";
    public final static String BADGE_BUG_HUNTER           = "<:badgeBugHunter:850113719652450315>";
    public final static String BADGE_EARLY_SUPPORTER      = "<:badgeEarlySupported:850113719634755624>";
    public final static String BADGE_HYPESQUAD            = "<:badgeHypesquad:850113719476027414>";
    public final static String BADGE_HYPESQUAD_BALANCE    = "<:badgeBalance:850113719400792065>";
    public final static String BADGE_HYPESQUAD_BRAVERY    = "<:badgeBravery:850113719526227969>";
    public final static String BADGE_HYPESQUAD_BRILLIANCE = "<:badgeBrilliance:850113719689412618>";
    public final static String BADGE_PARTNER              = "<:badgePartner:850113719752065054>";
    public final static String BADGE_STAFF                = "<:badgeStaff:850113719764910111>";
    public final static String BADGE_VERIFIED_DEVELOPER   = "<:badgeVerifiedDev:850113719559782401>";
    public final static String BADGE_CERTIFIED_MODERATOR  = "<:badgeModerator:850113719551918121>";

    // status
    public final static String STATUS_STREAMING      = "<:statusStreaming:850113664873922560>";
    public final static String STATUS_ONLINE         = "<:statusOnline:850113664694353941>";
    public final static String STATUS_IDLE           = "<:statusAway:850113664873660427>";
    public final static String STATUS_DO_NOT_DISTURB = "<:statusDND:850113664873660426>";
    public final static String STATUS_INVISIBLE      = "<:statusInvisible:850113664643891262>";
    public final static String STATUS_OFFLINE        = "<:statusOffline:850113664556204124>";

    // logs
    public final static String VOICE_JOIN   = "<:voicejoin:850102867687243796>";
    public final static String VOICE_LEAVE  = "<:voiceleave:850102867586056232>";
    public final static String VOICE_CHANGE = "<:voicechange:850102867250511903>";
    public final static String GIF_AVATAR   = "<:gif:850113698504507445>";
}
