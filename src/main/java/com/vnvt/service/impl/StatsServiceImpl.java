/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vnvt.service.impl;

import com.vnvt.repository.StatsRepository;
import com.vnvt.repository.impl.*;
import com.vnvt.service.StatsService;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author 18510
 */
@Service
public class StatsServiceImpl implements StatsService{
    @Autowired
    private StatsRepository statsRepository;

    @Override
    public List<Object[]> cateStats() {
        return this.statsRepository.cateStats();
    }

    @Override
    public List<Object[]> postStats(String kw, Date fromDate, Date toDate) {
        return this.statsRepository.postStats(kw, fromDate, toDate);
    }

    @Override
    public List<Object[]> postMonthStats(String string, Date date, Date date1) {
        return this.statsRepository.postMonthStats(string, date, date1);
    }
}
