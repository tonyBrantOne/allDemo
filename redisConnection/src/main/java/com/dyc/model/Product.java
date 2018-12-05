package com.dyc.model;



/**
 * 产品表实体
 *
 * @author wqm
 * @time 2018-8-16 13:51:34
 */
//region your codes 1
public class Product {
//endregion your codes 1

	//region your codes 3
	private static final long serialVersionUID = -2040206578221843298L;
	//endregion your codes 3

	//region property name constants
	public static final String PROP_ID = "id";
	public static final String PROP_NO = "no";
	public static final String PROP_NAME = "name";
	public static final String PROP_PACKAGE_NAME = "packageName";
	public static final String PROP_VERSION = "version";
	public static final String PROP_CREATE_TIME = "createTime";
	public static final String PROP_COMPLETE_TIME = "completeTime";
	public static final String PROP_USERNAME = "username";
	public static final String PROP_FILE_PATH = "filePath";
	//endregion
	
	
	//region properties
	/** 主键id */
	private Integer id;
	/** 编号 */
	private String no;
	/** 产品名称 */
	private String name;
	/** 包名 */
	private String packageName;
	/** 版本号 */
	private String version;
	/** 创建时间 */
	private java.util.Date createTime;
	/** 完成时间 */
	private java.util.Date completeTime;
	/** 发布者 */
	private String username;
	/** 文件保存路径 */
	private String filePath;
	//endregion


	private Integer installedNewestNum;//安装了最新包的服务器数量
	private Integer installedNum;//安装了包的服务器数量

	//region constuctors
	public Product(){
	}

	public Product(Integer id){
		this.id = id;
	}
	//endregion


	//region getters and setters
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer value) {
		this.id = value;
	}
	public String getNo() {
		return this.no;
	}

	public void setNo(String value) {
		this.no = value;
	}
	public String getName() {
		return this.name;
	}

	public void setName(String value) {
		this.name = value;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getVersion() {
		return this.version;
	}

	public void setVersion(String value) {
		this.version = value;
	}
	public java.util.Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(java.util.Date value) {
		this.createTime = value;
	}
	public java.util.Date getCompleteTime() {
		return this.completeTime;
	}

	public void setCompleteTime(java.util.Date value) {
		this.completeTime = value;
	}
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String value) {
		this.username = value;
	}
	public String getFilePath() {
		return this.filePath;
	}

	public void setFilePath(String value) {
		this.filePath = value;
	}
	//endregion

	public Integer getInstalledNewestNum() {
		return installedNewestNum;
	}

	public void setInstalledNewestNum(Integer installedNewestNum) {
		this.installedNewestNum = installedNewestNum;
	}

	public Integer getInstalledNum() {
		return installedNum;
	}

	public void setInstalledNum(Integer installedNum) {
		this.installedNum = installedNum;
	}


	//region your codes 2

	//endregion your codes 2

}