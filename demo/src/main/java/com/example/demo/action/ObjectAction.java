package com.example.demo.action;

import com.bstek.urule.model.ExposeAction;
import org.springframework.stereotype.Component;

/**
 * ObjectAction class
 *
 * @author ZF
 * @date 2018-11-21
 */
@Component
public class ObjectAction {

    @ExposeAction("initObject")
    public Object initObject(String className){
        try {
            return Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return new Object();
        }
    }
}
