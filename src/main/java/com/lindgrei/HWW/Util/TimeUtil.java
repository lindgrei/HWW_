package HWW.Util;

import java.time.ZonedDateTime;


public class TimeUtil {

    public static long GetTimeDiff(long TimestampToEpochMilli){
        return Math.abs(ZonedDateTime.now().toInstant().toEpochMilli() - TimestampToEpochMilli) ;
    }
}
