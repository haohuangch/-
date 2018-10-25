package com.chh.core.utils.context;



/**
 *  
 * 公用常量类定义
 * 
 * @version 1.0
 * @author 吴国成f
 * @created 2014年9月23日 下午2:17:20
 */
public class Constant {

	/** session用户 **/
	public static final String SESSION_OPERATOR = "session_operator";

	public static final String RESPONSE_CODE = "code";

	public static final String RESPONSE_CODE_MSG = "msg";

	
	public static final String INSERT = "create";
	
	public static final String UPDATE = "update";

	
	public static final String RESPONSE_DATA = "data";
	
	public static final String RESPONSE_DATA_TOTAL = "total";
	
	public static final String RESPONSE_DATA_TOTALCOUNT = "totalCount";
	
	public static final String OPERATION_SUCCESS = "操作成功";
	
	public static final String OPERATION_FAIL = "操作失败";
	
	public static final String OPERATION_PARAM_ERROR ="页面参数错误";
	
	public static final String OPERATION_DATA_NULL_EXCEPTION ="数据空异常";
	
	public static final String OPERATION_ROLE_ERROR = "当前用户没有此操作权限!";
	
	public static final String OPERATION_REPEAT_SUBMIT = "不允许重复提交！";
	
	public static final String RESOLUTION_FAIL = "请检查输入的数据是否正确!";

	public static final int SUCCEED_CODE_VALUE = 200; // 成功 插入 、删除 更新 修改

	/** 参数列表不完整 */
	public static final int FAIL_CODE_PARAM_INSUFFICIENT = 300;

	public static final int FAIL_CODE_VALUE = 400; // 失败 插入 、删除 更新 修改

	public static final int OTHER_CODE_VALUE = 500; // 其他异常
	
	public static final String NEXT_STEP_OPERATOR = "下一步操作用户"; // 其他异常
	
	/**  角色session 暂用*/
	public static final String ROLEID = "roleId";
	
	public static final String DATEFORMAT_Y_M_D = "yyyy-MM-dd";
	public static final String DATEFORMAT_Y_M_D_CH = "yyyy年MM月dd日";

	public static final String PAGE_TOTAL = "total";
	public static final String PAGE_PAGESIZE = "pageSize";
	public static final String PAGE_CURRENT = "current";
	public static final String PAGE_PAGES = "pages";
	public static final String RESPONSE_DATA_PAGE = "page";
	
}
