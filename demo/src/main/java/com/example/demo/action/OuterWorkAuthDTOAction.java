package com.example.demo.action;

import com.bstek.urule.model.ExposeAction;
import com.example.demo.model.OuterWorkAuthDTO;
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
public class OuterWorkAuthDTOAction {

    @ExposeAction("newInstance")
    public OuterWorkAuthDTO newInstance(OuterWorkAuthDTO outerWorkAuthDTO){
        if(outerWorkAuthDTO == null){
            return new OuterWorkAuthDTO();
        }
        OuterWorkAuthDTO result = new OuterWorkAuthDTO();
        BeanUtils.copyProperties(outerWorkAuthDTO, result);
        return result;
    }

    @ExposeAction("listAdd")
    public void add(List<OuterWorkAuthDTO> outerWorkAuthDTOList, OuterWorkAuthDTO outerWorkAuthDTO){
        if(outerWorkAuthDTOList != null && outerWorkAuthDTO != null){
            OuterWorkAuthDTO _outerWorkAuthDTO = new OuterWorkAuthDTO();
            BeanUtils.copyProperties(outerWorkAuthDTO, _outerWorkAuthDTO);
            outerWorkAuthDTOList.add(_outerWorkAuthDTO);
        }
    }
}
