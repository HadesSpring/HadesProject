/*
 * 李先瞧
 * 2015-8-5
 *
 */

package com.hades.permissions.db;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;

import com.hades.records.employee.db.EmployeeInfo;

/**
 * 权限组
 * HadesProject
 * @author 李先瞧
 * 2015-8-5
 *
 */
public class PermissionGroup implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3985758699560246311L;

	/**
	 * 员工信息与权限组双向 多对多  被控方
	 * 比如你在A表中有一个外键，是B表的ID（主键），这时候A就是主控方，B就是被控方。
	 * 当保存主控方实体Entity时，被控方entity也会级联保存，但保存被控方entity时，无法级联保存主控方entity，就像学生和学校的关系，学生需要知道学校在哪里，学校不一定知道学生在哪里。
	 * 
	 */
	@ManyToMany(mappedBy = "permissionGroups",cascade={CascadeType.MERGE,CascadeType.REFRESH})
	private List<EmployeeInfo> employeeInfos ;
	
	
	
}
