package com.farmer.riskkie.domain;

import lombok.Data;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName:
 * @Desc: 作为风控事件基础类
 * @Author: Sunzhigang
 * @Date: 2019/10/11 10:57
 */
@Data
public abstract class BaseEvent  implements Serializable {
    /**
     * 场景
     */
    private String scene;

    /**
     * 事件id
     */
    private String id;

    /**
     * 操作时间
     */
    private Date operateTime;

    /**
     * 事件评分
     */
    private int score;



    /**
     * 计算事件评分
     *
     * @param count      当前值
     * @param level      阀值
     * @param levelScore 阀值评分
     * @param perScore   超过阀值以上，每个评分
     * @return 是否达到阈值
     */


    public boolean addScore(int count, int level, int levelScore, int perScore) {
        if (level <= 0 || levelScore <= 0 || perScore < 0) {
            return false;
        }
        if (count >= level) {
            this.score += levelScore + (count - level) * perScore;
            return true;
        }
        return false;
    }
}
