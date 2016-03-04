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