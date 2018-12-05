<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page isELIgnored="false" %>
<html>
<body>
        <div style="width: 500px;margin: 0px auto;margin-top: 300px;height: 80px;font-size: 60px;">
            ${num}
        </div>
        <div style="width: 500px;margin: 0px auto;margin-top: 20px;">
            请输入并发数：
            <input id="countNumId" type="text" value="${countNum}"/>
        </div>
        <div style="width: 500px;margin: 0px auto;margin-top: 20px;">
            请输入要更新的id：
            <input id="id" type="text" value=""/>
            <input type='button' value='请求' style="margin-left: 50px;" onclick="doRequest();">
        </div>32

</body>


<
<script >

    function doRequest() {
        var countNum = document.getElementById("countNumId").value;
        var id = document.getElementById("id").value;
        var url = "testUpdate";
        var paramUrl = "?num=" + parseInt(countNum) + "&id="+id;
        window.location = url + paramUrl;
    }
</script>
</html>
