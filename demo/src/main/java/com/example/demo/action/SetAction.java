package com.example.demo.action;

import com.bstek.urule.model.ExposeAction;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * SetAction class
 *
 * @author ZF
 * @date 2018-11-8
 */
@Component
public class SetAction {

    @ExposeAction("Set取值")
    public String get(Set<String> set, int index){
        if(set == null){
            return null;
        }
        List<String> list = new ArrayList(set);
        if(index > list.size()){
            return list.get(0);
        } else {
            return list.get(index);
        }
    }

    @ExposeAction("copy")
    public Set<String> copy(Set<String> source, Set<String> target){
        if(source == null){
            return null;
        }
        if(target == null){
            target = new HashSet<>();
        }
        for(String str: source){
            target.add(str);
        }
        return target;
    }

    @ExposeAction("size")
    public Integer size(Set<Object> set){
        if(set == null){
            return 0;
        }
        return set.size();
    }
}
