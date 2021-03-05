package com.cc.site.rbl.service.impl;

import com.cc.site.rbl.entity.SysJob;
import com.cc.site.rbl.mapper.SysJobMapper;
import com.cc.site.rbl.service.SysJobService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author haozt
 * @since 2021/3/5
 */
@Service("sysJobService")

public class SysJobServiceImpl implements SysJobService {

    @Autowired
    private SysJobMapper jobMapper;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public int insert(SysJob sysJob) {
        logger.info("插入数据");
        return jobMapper.insertSelective(sysJob);
    }

    @Override
    public int update(SysJob sysJob) {
        logger.info("修改数据");
        return jobMapper.updateByPrimaryKeySelective(sysJob);
    }

    @Override
    public List<SysJob> listAllSysJob() {
        logger.info("查询全部");
        return jobMapper.listAll();
    }
}
