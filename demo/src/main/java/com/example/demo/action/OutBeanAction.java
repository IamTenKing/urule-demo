package com.example.demo.action;

import com.bstek.urule.model.ExposeAction;
import com.example.demo.model.OutBean;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * OuterWorkAuthAction class
 *
 * @author ZF
 * @date 2018-11-21
 */
@Component
public class OutBeanAction {

    @ExposeAction("newInstance")
    public OutBean newInstance(OutBean outBean){
        if(outBean == null){
            return new OutBean();
        }
        OutBean result = new OutBean();
        BeanUtils.copyProperties(outBean, result);
        return result;
    }

    @ExposeAction("listAdd")
    public void add(List<OutBean> outBeanList, OutBean outBean){
        if(outBeanList != null && outBean != null){
            OutBean _outBean = new OutBean();
            BeanUtils.copyProperties(outBean, _outBean);
            outBeanList.add(_outBean);
        }
    }
}
