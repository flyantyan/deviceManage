function queryMaintainList(){
    var maintainNo=$("#maintainNo").val();
    var maintainEmp=$("#maintainEmp").val();
    var bathPath=$("#basePath").val();
    $.ajax({
        type:"POST",
        url:bathPath+"maintain/queryMaintainList.do",
        data:{maintainNo:maintainNo,maintainEmp:maintainEmp},
        async:false,
        error:function(){
            alert("系统内部错误，请稍后再试");
        },
        success:function(data){
            initMaintainList(eval(data));
        }
    })
}
function initMaintainList(obj){
    for(var i=0;i<obj.length;i++){
        obj[i].id="<input type='radio' name='radio01' onclick='radioClick(this)' value='"+obj[i].id+"'/>";
    }
    $("#maintainTable").bootstrapTable('load',obj);
}
function radioClick(obj){
    $("#maintainId").val(obj.value);
}
function findDevInfo(){
    var basePath=$("#basePath").val();
    var devNo=$("#devNo").val();
    if(devNo==""){
        alert("设备编号不能为空!");
        return;
    }
    $.ajax({
        type:"GET",
        url:basePath+"devInfo/findDevInfoByNo.do",
        data:{devNo:devNo},
        async:false,
        error:function(){
            alert("系统内部错误，请稍后再试");
        },
        success:function(data){
            var result=jQuery.parseJSON(data);
            $("#devId").val(result.id);
            $("#devName").val(result.devName);
            $("#barCode").val(result.barCode);
            $("#devPower").val(result.devPower);
            $("#modelNo").val(result.modelNo);
            $("#standard").val(result.standard);
            $("#cate").val(result.cateName);
            $("#country").val(result.countryName);
            $("#direct").val(result.direcName);
            $("#depo").val(result.depositName);
            $("#origin").val(result.originName);
            $("#found").val(result.foundName);
            $("#firm").val(result.firm);
            $("#outFirmNo").val(result.outFirmNo);
            $("#purchaseTime").val(result.purchaseTime);
        }
    })
}
function saveDevMaintain(){
    var basePath=$("#basePath").val();
    var devId=$("#devId").val();
    var maintainNum=$("#maintainNum").val();
    var maintainEmp=$("#maintainEmp").val();
    var remark=$("#remark").val();
    $.ajax({
        type:"POST",
        url:basePath+"maintain/createMaintain.do",
        data:{devId:devId,maintainNum:maintainNum,maintainEmp:maintainEmp,remark:remark},
        async:false,
        error:function(){
            alert("系统内部错误，请稍后再试");
        },
        success:function(data){
            if(data=="1"){
                alert("设备维修信息保存成功!")
                window.close();
                queryDevInfoList();
            }else{
                alert("设备维修信息保存失败，请稍后再试!");
                window.close();
            }
        }
    })
}
function showDetail(){
    var basePath=$("#basePath").val();
    var maintainId=$("#maintainId").val();
    if(maintainId==""){
        alert("请选择要查看的行!");
        return;
    }
    window.open(basePath+"maintain/queryMaintainById.do?maintainId="+maintainId,
        'newwindow', 'width=710,height=600, top=50, left=50,toolbar=no, menubar=no, scrollbars=yes,' +
        'resizable=yes, location=no, status=no,left=500px');
}
function updateToMaintain(){
    var basePath=$("#basePath").val();
    var maintainId=$("#maintainId").val();
    var maintainStatus;
    if(maintainId==""){
        alert("请选择要修改的行!");
        return;
    }
    $.ajax({
        type:"POST",
        url:basePath+"maintain/queryMaintainStatusById.do",
        data:{maintainId:maintainId},
        async:false,
        error:function(){
            alert("系统内部错误，请稍后再试");
        },
        success:function(data){
            maintainStatus=data;
        }
    })
    if(maintainStatus=="2"){
        alert("设备正处于维修状态!");
        return;
    }else if(maintainStatus=="3"){
        alert("设备已维修完成!");
        return;
    }else if(maintainStatus=="1"){
        if(confirm("确认要将设备维修状态更新为维修中吗？")){
            $.ajax({
                type:"POST",
                url:basePath+"maintain/updateMaintainStatus.do",
                data:{id:maintainId,status:2},
                async:false,
                error:function(){
                    alert("系统内部错误，请稍后再试");
                },
                success:function(data){
                    if(data=="1"){
                        alert("设备维修状态更新成功!")
                    }else{
                        alert("设备维修状态更新失败，请稍后再试!");
                    }
                }
            })
        }
    }
}
function updateToMaintainFinish(){
    var basePath=$("#basePath").val();
    var maintainId=$("#maintainId").val();
    var maintainStatus;
    if(maintainId==""){
        alert("请选择要修改的行!");
        return;
    }
    $.ajax({
        type:"POST",
        url:basePath+"maintain/queryMaintainStatusById.do",
        data:{maintainId:maintainId},
        async:false,
        error:function(){
            alert("系统内部错误，请稍后再试");
        },
        success:function(data){
            maintainStatus=data;
        }
    })
    if(maintainStatus=="1"){
        alert("设备正处于申请维修状态!");
        return;
    }else if(maintainStatus=="3"){
        alert("设备已维修完成!");
        return;
    }else if(maintainStatus=="2"){
        if(confirm("确认要将设备维修状态更新为维修完成吗？")){
            $.ajax({
                type:"POST",
                url:basePath+"maintain/updateMaintainStatus.do",
                data:{id:maintainId,status:3},
                async:false,
                error:function(){
                    alert("系统内部错误，请稍后再试");
                },
                success:function(data){
                    if(data=="1"){
                        alert("设备维修状态更新成功!")
                    }else{
                        alert("设备维修状态更新失败，请稍后再试!");
                    }
                }
            })
        }
    }
}