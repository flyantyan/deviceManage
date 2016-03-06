function queryDevInfoList(){
    var devNo=$("#devNo").val();
    var devName=$("#devName").val();
    var cateId=$("#cateId").val();
    var countryId=$("#countryId").val();
    var originId=$("#originId").val();
    var depositId=$("#depositId").val();
    var bathPath=$("#basePath").val();
    $.ajax({
            type:"POST",
            url:bathPath+"devInfo/queryDevInfo.do",
            data:{devNo:devNo,devName:devName,cateId:cateId,countryId:countryId,originId:originId,depositId:depositId},
            async:false,
            error:function(XMLHttpRequest, textStatus, errorThrown){
                alert("系统内部错误，请稍后再试");
            },
            success:function(data){
                initDevInfoList(eval(data));
            }
    })
}
function initDevInfoList(obj){
    for(var i=0;i<obj.length;i++){
        obj[i].id="<input type='radio' name='radio01' onclick='radioClick(this)' value='"+obj[i].id+"'/>";
    }
    $("#devInfoTable").bootstrapTable('load',obj);
}
function radioClick(obj){
    $("#devInfoId").val(obj.value);
}
function devInfoDetail(){
    var bathPath=$("#basePath").val();
    var devId=$("#devInfoId").val();
    if(devId==""){
        alert("请选择要要查看的设备");
        return;
    }
    window.open(bathPath+"devInfo/toDevInfoDetail.do?devId="+devId,
        'newwindow', 'width=710,height=600, top=50, left=50,toolbar=no, menubar=no, scrollbars=yes,' +
        'resizable=yes, location=no, status=no,left=500px');
}
function downloadDevInfo(){
    var devNo=$("#devNo").val();
    var devName=$("#devName").val();
    var cateId=$("#cateId").val();
    var countryId=$("#countryId").val();
    var originId=$("#originId").val();
    var depositId=$("#depositId").val();
    var bathPath=$("#basePath").val();
    $.ajax({
        type:"POST",
        url:bathPath+"devInfo/downLoadDevInfo.do",
        data:{devNo:devNo,devName:devName,cateId:cateId,countryId:countryId,originId:originId,depositId:depositId},
        async:false,
        error:function(XMLHttpRequest, textStatus, errorThrown){
            alert("系统内部错误，请稍后再试");
        },
        success:function(data){
            window.open(bathPath+"temp/"+data+".xls");
        }
    })
}
function toDevInfoUpdate(){
    var bathPath=$("#basePath").val();
    var devId=$("#devInfoId").val();
    if(devId==""){
        alert("请选择要修改的设备");
        return;
    }
    window.open(bathPath+"devInfo/toDevInfoUpdate.do?devId="+devId,
        'newwindow', 'width=710,height=600, top=50, left=50,toolbar=no, menubar=no, scrollbars=yes,' +
        'resizable=no, location=no, status=no,left=500px');
}
function updateDevInfo(){
    var basePath=$("#basePath").val();
    if(!confirm("确认要修改设备基本信息吗?")){
        return;
    }
    $.ajax({
        type:"POST",
        url:basePath+"devInfo/updateDevInfo.do",
        data:$("#devInfoForm").serialize(),
        async:false,
        error:function(XMLHttpRequest, textStatus, errorThrown){
            alert("系统内部错误，请稍后再试");
        },
        success:function(data){
            if(data=="1"){
                alert("设备基本信息修改成功!")
                window.close();
                queryDevInfoList();
            }else{
                alert("设备基本信息修改失败，请稍后再试!");
                window.close();
            }
        }
    })
}
function toDevInfoCreate(){
    var bathPath=$("#basePath").val();
    window.open(bathPath+"devInfo/toDevInfoCreate.do",
        'newwindow', 'width=710,height=600, top=50, left=50,toolbar=no, menubar=no, scrollbars=yes,' +
        'resizable=no, location=no, status=no,left=500px');
}
function createDevInfo(){
    var basePath=$("#basePath").val();
    if(!confirm("确认要新增设备基本信息吗?")){
        return;
    }
    $.ajax({
        type:"POST",
        url:basePath+"devInfo/createDevInfo.do",
        data:$("#devInfoForm").serialize(),
        async:false,
        error:function(XMLHttpRequest, textStatus, errorThrown){
            alert("系统内部错误，请稍后再试");
        },
        success:function(data){
            if(data=="1"){
                alert("设备基本信息保存成功!")
                window.close();
                queryDevInfoList();
            }else{
                alert("设备基本信息保存失败，请稍后再试!");
                window.close();
            }
        }
    })
}
function toDevInfoImport(){
    var bathPath=$("#basePath").val();
    window.open(bathPath+"devInfo/toDevInfoImport.do",
        'newwindow', 'width=500,height=250, top=300, left=50,toolbar=no, menubar=no, scrollbars=yes,' +
        'resizable=no, location=no, status=no,left=500px');
}