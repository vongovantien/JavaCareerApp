/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vnvt.repository;

import com.vnvt.pojo.Employer;
import java.util.List;

/**
 *
 * @author 18510
 */
public interface EmployerRepository {

    List<Employer> getEmployers(String kw, int page);

    List<Object[]> getHotEmployers(int num);

    List<Object[]> getMostDiscussEmployers(int num);

    Employer getEmployerById(int employerId);

    long countEmployer();

    boolean addOrUpdate(Employer employer);
}
