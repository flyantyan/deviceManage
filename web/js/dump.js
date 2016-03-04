function queryDumpList(){
    var dumpNo=$("#dumpNo").val();
    var dumpEmp=$("#dumpEmp").val();
    var bathPath=$("#basePath").val();
    $.ajax({
        type:"POST",
        url:bathPath+"dump/queryDumpList.do",
        data:{dumpNo:dumpNo,dumpEmp:dumpEmp},
        async:false,
        error:function(){
            alert("系统内部错误，请稍后再试");
        },
        success:function(data){
            initDumpList(eval(data));
        }
    })
}
function initDumpList(obj){
    for(var i=0;i<obj.length;i++){
        obj[i].id="<input type='radio' name='radio01' onclick='radioClick(this)' value='"+obj[i].id+"'/>";
    }
    $("#dumpTable").bootstrapTable('load',obj);
}
function radioClick(obj){
    $("#dumpId").val(obj.value);
}
function showDetail(){
    var bathPath=$("#basePath").val();
    var dumpId=$("#dumpId").val();
    if(dumpId==""){
        alert("请选择要查看的行!");
        return;
    }
    window.open(bathPath+"dump/queryDumpById.do?dumpId="+dumpId,
        'newwindow', 'width=710,height=600, top=50, left=50,toolbar=no, menubar=no, scrollbars=yes,' +
        'resizable=yes, location=no, status=no,left=500px');
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
function saveDevDump(){
    var basePath=$("#basePath").val();
    var devId=$("#devId").val();
    var dumpNum=$("#dumpNum").val();
    var dumpEmp=$("#dumpEmp").val();
    var remark=$("#remark").val();
    $.ajax({
        type:"POST",
        url:basePath+"dump/createDevDump.do",
        data:{devId:devId,dumpNum:dumpNum,dumpEmp:dumpEmp,remark:remark},
        async:false,
        error:function(){
            alert("系统内部错误，请稍后再试");
        },
        success:function(data){
            if(data=="1"){
                alert("设备报废信息保存成功!")
                window.close();
                queryDevInfoList();
            }else{
                alert("设备报废信息保存失败，请稍后再试!");
                window.close();
            }
        }
    })
}