package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.biz.Transform;
import com.example.demo.model.TaskDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.*;

/**
 * @author jt
 * @date 2020-6-13
 */
@RestController
@RequestMapping
public class TestController {


    @Autowired
    private Transform transform;

    @GetMapping("/test")
    public void test() {

        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setTaskStatus("2");
        LocalDate now = LocalDate.now();
        Date date = new Date();
        taskDTO.setAlertDate(date.getTime());
        taskDTO.setSoc("jifen");

        List set = new ArrayList();

        set.add("name1");
        set.add("name2");
        set.add("name2");
        set.add("name2");
        set.add("name2");
        set.add("name2");
        set.add("name2");

        taskDTO.setDealName(set);


        Map transform = this.transform.transform(taskDTO);

        System.out.println("map:"+ JSON.toJSONString(transform));


    }

}
