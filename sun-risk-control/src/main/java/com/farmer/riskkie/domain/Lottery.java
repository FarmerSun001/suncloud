package com.farmer.riskkie.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName:
 * @Desc:
 * @Author: Sunzhigang
 * @Date: 2019/10/12 17:35
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Lottery {

    /**
     * 红包概率
     */
    private double rate;

    /**
     * 红包ID用于激活红包
     */
    private long lotteryId;


    public static Lottery buildTankYouLottery() {
        return new Lottery(0, 1000L);
    }

}
