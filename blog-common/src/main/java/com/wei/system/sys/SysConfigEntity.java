package com.wei.system.sys;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 系统配置信息
 *
 * @author Mark sunlightcs@gmail.com
 */
@Data
@TableName("sys_config")
public class SysConfigEntity {
	@TableId
	private Long id;
	/**
	 * 参数key
	 */
	private String paramKey;
	/**
	 * 参数值
	 */
	private String paramValue;
	/**
	 * 备注
	 */
	private String remark;

}
