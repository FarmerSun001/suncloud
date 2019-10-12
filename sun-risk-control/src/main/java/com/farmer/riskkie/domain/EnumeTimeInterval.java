package com.farmer.riskkie.domain;

import java.util.Date;

/**
 * @ClassName:
 * @Desc:
 * @Author: Sunzhigang
 * @Date: 2019/10/11 11:10
 */
public enum EnumeTimeInterval {
    /**
     * 所有时间段
     */
    ALL,
    /**
     * 一秒
     */
    LASTSECOND,
    /**
     * 一分钟
     */
    LASTMIN,
    /**
     * 一小时
     */
    LASTHOUR,
    /**
     * 一天
     */
    LASTDAY;

    public Date getMinTime(Date now) {
        if (this.equals(ALL)) {
            return new Date(0);
        } else {
            return new Date(now.getTime() - getTimeDiff());
        }
    }

    public Date getMaxTime(Date now) {
        return now;
    }

    public long getTimeDiff() {
        long timeDiff;
        switch (this) {
            case ALL:
                timeDiff = Long.MAX_VALUE;
                break;
            case LASTSECOND:
                timeDiff = 1000L;
                break;
            case LASTHOUR:
                timeDiff = 3600 * 1000L;
                break;
            case LASTDAY:
                timeDiff = 24 * 3600 * 1000L;
                break;
            default: //默认去一分钟的
                timeDiff = 60 * 1000L;
                break;
        }
        return timeDiff;
    }
}
