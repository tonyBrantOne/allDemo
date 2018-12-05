package com.dyc.model;



/**
 * 服务器实体
 *
 * @author wqm
 * @time 2018-8-16 13:54:27
 */
//region your codes 1
public class Server  {
//endregion your codes 1

	//region your codes 3
	private static final long serialVersionUID = 1625971111244688413L;
	//endregion your codes 3

	//region property name constants
	public static final String PROP_ID = "id";
	public static final String PROP_SERVER_NAME = "serverName";
	public static final String PROP_SERVER_IP = "serverIp";
	public static final String PROP_MACHINE_ROOM = "machineRoom";
	public static final String PROP_TAG = "tag";
	//endregion
	
	
	//region properties
	/** 主键 */
	private Integer id;
	/** 服务器名称 */
	private String serverName;
	/** 服务器ip */
	private String serverIp;
	/** 机房 */
	private String machineRoom;
	/** 标签 */
	private String tag;
	//endregion

	
	//region constuctors
	public Server(){
	}

	public Server(Integer id){
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
	
	public String getServerName() {
		return this.serverName;
	}

	public void setServerName(String value) {
		this.serverName = value;
	}
	
	public String getServerIp() {
		return this.serverIp;
	}

	public void setServerIp(String value) {
		this.serverIp = value;
	}
	public String getMachineRoom() {
		return this.machineRoom;
	}

	public void setMachineRoom(String value) {
		this.machineRoom = value;
	}
	public String getTag() {
		return this.tag;
	}

	public void setTag(String value) {
		this.tag = value;
	}
	//endregion

	//region your codes 2

	//endregion your codes 2

}