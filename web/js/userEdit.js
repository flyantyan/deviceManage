function toCreateUser(){
    var bathPath=$("#basePath").val();
    window.open(bathPath+"user/toUserEdit.do",
        'newwindow', 'width=500,height=500, top=50, left=50,toolbar=no, menubar=no, scrollbars=yes, ' +
        'resizable=yes, location=no, status=no,left=460px');
}
function closePage(){
    window.close();
}
function saveUser(){
    var bathPath=$("#basePath").val();
    $.ajax({
            type:"POST",
            url:bathPath+"user/createUser.do",
            data:$("#userForm").serialize(),
            async:false,
            error:function(request){
                alert("系统内部错误");
            },
            success:function(data){
                alert("保存成功");
                closePage();
            }
        }
    )
}
function queryUserList(){
    var role=$("#queryRole").val();
    var realName=$("#queryRealName").val();
    var bathPath=$("#basePath").val();
    $.ajax({
            type:"POST",
            url:bathPath+"user/userList.do",
            data:{realName:realName,userRole:role},
            async:false,
            error:function(XMLHttpRequest, textStatus, errorThrown){
                alert("服务器内部错误");
            },
            success:function(data){
                $("#userId").val("");
                initUserList(eval(data));
            }
    })
}
function initUserList(obj){
    for(var i=0;i<obj.length;i++){
        obj[i].id="<input type='radio' name='radio01' onclick='radioClick(this)' value='"+obj[i].id+"'/>";
    }
    $("#userTable").bootstrapTable('load',obj);
}
function radioClick(obj){
    $("#userId").val(obj.value);
}
function resetPwd(){
    var bathPath=$("#basePath").val();
    if($("#userId").val()==""){
        alert("请选择要重置密码的用户");
        return;
    }
    if(!confirm("确定要重置该用户的密码吗？")){
        return;
    }
    $.ajax({
        type:"POST",
        url:bathPath+"user/resetPwd.do",
        data:{id:$("#userId").val()},
        async:false,
        error:function(XMLHttpRequest, textStatus, errorThrown){
            alert("操作失败，服务器内部错误");
        },
        success:function(data){
            if(data=="1"){
                alert("该用户的密码已成功重置");
                queryUserList();
            }else{
                alert("操作失败，请稍后再试");
            }
        }
    })
}
function queryApplyListByEmpId(){
    var bathPath=$("#basePath").val();
    if($("#userId").val()==""){
        alert("请选择要查看申请列表的用户");
        return;
    }
    window.open(bathPath+"apply/queryApplyListByEmpId.do?applyEmpId="+$("#userId").val(),
        'newwindow', 'width=700,height=500, top=50, left=50,toolbar=no, menubar=no, scrollbars=yes, ' +
        'resizable=yes, location=no, status=no,left=460px');
}
function delUserById(){
    var bathPath=$("#basePath").val();
    if($("#userId").val()==""){
        alert("请选择要删除的用户");
        return;
    }
    if(!confirm("确定要删除该用户吗？")){
        return;
    }
    $.ajax({
        type:"POST",
        url:bathPath+"user/delUserById.do",
        data:{id:$("#userId").val()},
        async:false,
        error:function(XMLHttpRequest, textStatus, errorThrown){
            alert("删除失败，服务器内部错误");
        },
        success:function(data){
            if(data=="1"){
                alert("删除成功");
                queryUserList();
            }else{
                alert("删除失败，请稍后再试");
            }
        }
    })
}
function downloadUser(){
    var role=$("#queryRole").val();
    var realName=$("#queryRealName").val();
    var bathPath=$("#basePath").val();
    $.ajax({
        type:"POST",
        url:bathPath+"user/downLoadUser.do",
        data:{realName:realName,userRole:role},
        async:false,
        error:function(XMLHttpRequest, textStatus, errorThrown){
            alert("系统内部错误，请稍后再试");
        },
        success:function(data){
            alert("导出成功");
            window.open(bathPath+"temp/"+data+".xls");
        }
    })
}