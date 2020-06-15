package com.example.demo.action;

import com.bstek.urule.model.ExposeAction;
import org.springframework.stereotype.Component;

/**
 * BooleanAction class
 *
 * @author ZF
 * @date 2018-12-20
 */
@Component
public class BooleanAction {

    @ExposeAction("valueOf")
    public Boolean valueOf(String str){
        return Boolean.valueOf(str);
    }
}
