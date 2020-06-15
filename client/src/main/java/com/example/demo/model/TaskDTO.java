package com.example.demo.model;

import com.bstek.urule.model.Label;
import lombok.Data;

import java.util.List;
import java.util.Set;
import java.util.UUID;

/**
 * TaskDTO class
 *
 * @author ZF
 * @date 2018/10/17
 */
@Data
public class TaskDTO  {

    @Label("ID")
    protected String id =UUID.randomUUID().toString().replace("-", "");


    @Label("标题")
    protected String taskTitle;

    @Label("来源")
    protected String soc;


    @Label("计划截止时间")
    protected Long planingEndDate;

    @Label("实际处理时间")
    protected Long hendlingDate;

    @Label("URL")
    protected String taskUrl;


    @Label("状态")
    protected String taskStatus;


    @Label("预警时间")
    protected Long alertDate;


    @Label("处理人")
    protected  List<String> dealName;



}
