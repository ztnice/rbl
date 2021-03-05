package com.cc.site.rbl.service;

import com.cc.site.rbl.entity.SysJob;

import java.util.List;

/**
 * @author haozt
 * @since 2021/3/5
 */
public interface SysJobService {

    int insert(SysJob sysJob);
    int update(SysJob  sysJob);
    List<SysJob> listAllSysJob();
}
