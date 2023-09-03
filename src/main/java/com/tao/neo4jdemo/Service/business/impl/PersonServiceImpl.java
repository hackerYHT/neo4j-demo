package com.tao.neo4jdemo.Service.business.impl;

import com.tao.neo4jdemo.Service.business.ApplicationService;
import com.tao.neo4jdemo.Service.business.PersonService;
import com.tao.neo4jdemo.entity.business.Application;
import com.tao.neo4jdemo.entity.business.Person;
import com.tao.neo4jdemo.repository.business.PersonRepository;
import org.neo4j.driver.internal.shaded.io.netty.util.internal.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yehaitao01
 */
@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private ApplicationService applicationService;

    @Override
    public void importData() {
        List<Application> applicationList = applicationService.getAllApplication();
        List<Person> personList = new ArrayList<>();
        for (Application application : applicationList) {
            if (StringUtil.isNullOrEmpty(application.getOwner()) ||
                    StringUtil.isNullOrEmpty(application.getL1Biz()) ||
                    StringUtil.isNullOrEmpty(application.getL2Biz())) {
                return;
            }
            Person person = Person.builder().name(application.getOwner())
                    .l1Biz(application.getL1Biz())
                    .l2Biz(application.getL2Biz()).build();
            personList.add(person);
        }
        personList = personList.stream().distinct().collect(Collectors.toList());
        personRepository.saveAll(personList);
    }

}
