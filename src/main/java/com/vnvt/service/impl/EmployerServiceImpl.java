/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vnvt.service.impl;

import com.vnvt.service.EmployerService;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.vnvt.pojo.Employer;
import com.vnvt.repository.EmployerRepository;
import com.vnvt.service.EmployerService;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author 18510
 */
@Service
public class EmployerServiceImpl implements EmployerService {

    @Autowired
    private EmployerRepository employerRepository;
    @Autowired
    private Cloudinary cloudinary;

    @Override
    public List<Employer> getEmployers(String kw, int page) {
        return this.employerRepository.getEmployers(kw, page);
    }

    @Override
    public boolean addOrUpdate(Employer employer) {
//        String p ="";
//        p.startsWith(p)
//        try {
//            Map r = this.cloudinary.uploader().upload(employer.getFile().getBytes(),
//                    ObjectUtils.asMap("resource_type", "auto"));
//            employer.setImage((String) r.get("secure_url"));
//            
//            return this.employerRepository.addOrUpdate(employer);
//        } catch (IOException ex) {
//            System.err.println("== ADD PRODUCT ==" + ex.getMessage());
//        }

        return false;
    }

    @Override
    public long countEmployer() {
        return this.employerRepository.countEmployer();
    }

    @Override
    public Employer getEmployerById(int i) {
        return this.employerRepository.getEmployerById(i);
    }

    @Override
    public List<Object[]> getHotEmployers(int num) {
        return this.employerRepository.getHotEmployers(num);
    }

    @Override
    public List<Object[]> getMostDiscussEmployers(int i) {
        return this.employerRepository.getMostDiscussEmployers(i);
    }
}
