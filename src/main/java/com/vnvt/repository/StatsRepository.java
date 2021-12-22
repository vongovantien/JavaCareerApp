/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vnvt.repository;

import java.util.Date;
import java.util.List;

/**
 *
 * @author 18510
 */
public interface StatsRepository {

    List<Object[]> cateStats();

    List<Object[]> postStats(String kw, Date fromDate, Date toDate);

    List<Object[]> postMonthStats(String kw, Date fromDate, Date toDate);
}
