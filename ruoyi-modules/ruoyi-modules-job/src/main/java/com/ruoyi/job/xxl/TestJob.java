package com.ruoyi.job.xxl;

import com.xxl.job.core.annotation.XxlJobService;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.annotation.XxlJob;

/**
 * <p>
 *  XxlJob调度中心
 * </p>
 *
 * @author: 韩福贵
 * @date: 2022-11-12
 */
@XxlJobService
public class TestJob {

    @XxlJob("JobTest")
    public ReturnT<String > test(String param) {

        return ReturnT.SUCCESS;
    }

}
