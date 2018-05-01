/*
 * Copyright 2002-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example;

import com.example.entity.ServiceVisit;
import com.example.repo.VisitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@Controller
@Configuration
@EnableAutoConfiguration
@ComponentScan("com.example")
@EnableJpaRepositories(basePackages = "com.example.repo")
public class Main {

    @Autowired
    VisitRepository visitRepository;

    public static final String SERVICE_NAME = "Time Now in EST";

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Main.class, args);
    }

    @GetMapping(value = "/timeNow", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public VisitInfo getVisitInfo() {
        final VisitInfo visitInfo = new VisitInfo();
        visitRepository.save(new ServiceVisit(SERVICE_NAME));
        visitInfo.setCalls(visitRepository.count());
        visitInfo.setService(SERVICE_NAME);
        return visitInfo;
    }

}
