package com.example.demo.model;

import com.bstek.urule.model.Label;
import lombok.Data;

/**
 * OuterWorkAuthDTO class
 *
 * @author ZF
 * @date 2018/10/17
 */
@Data
public class OuterWorkAuthDTO {

    @Label("ID")
    private String id;

    /**
     * 关联外部工作id
     */
    @Label("关联待办ID")
    private String workId;
    /**
     * 权限对象代码
     */
    @Label("权限对象编码")
    private String code;
    /**
     * 权限对象类型（岗位、组织、人员等）
     */
    @Label("权限对象类型")
    private String type;
    /**
     * 单位代码（分区分表依据）
     */
    @Label("组织code")
    private String orgCode;

    @Label("状态")
    private String status;

    @Label("开始时间")
    private Long startDate;

    @Label("分区code")
    private String partitionCode;

    @Label("用户名")
    private String userName;


    /**是否完成**/
    @Label("是否已完成")
    private Boolean finished;

    @Label("组织名称")
    private  String orgName;

    @Label("岗位组织ID")
    private String roleIdUnitId;

    @Label("日志标识")
    protected String logId;
}
