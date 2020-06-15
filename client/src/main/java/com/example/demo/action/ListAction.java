package com.example.demo.action;

import com.bstek.urule.model.ExposeAction;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * ListAction class
 *
 * @author ZF
 * @date 2018-11-8
 */
@Component
public class ListAction {

    @ExposeAction("List取值")
    public String get(List<String> list, int index){
        if(index >= list.size()){
            return list.get(0);
        } else {
            return list.get(index);
        }
    }

    @ExposeAction("List初始化")
    public List<Object> init(){
        return Lists.newArrayList();
    }

    @ExposeAction("size")
    public Integer size(List<Object> list){
        if(list == null){
            return 0;
        }
        return list.size();
    }

    @ExposeAction("add")
    public List<Object> add(List<Object> list, Object obj){
        if(list != null && obj != null){
            list.add(obj);
        }
        return list;
    }
}
