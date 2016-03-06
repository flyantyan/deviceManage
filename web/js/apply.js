var nowItemLine=2
function queryApplyList(){
    var applyNo=$("#applyNo").val();
    var applyEmpName=$("#applyEmpName").val();
    var bathPath=$("#basePath").val();
    $.ajax({
        type:"POST",
        url:bathPath+"apply/queryApplyList.do",
        data:{applyNo:applyNo,applyEmpName:applyEmpName},
        async:false,
        error:function(){
            alert("系统内部错误，请稍后再试");
        },
        success:function(data){
            initApplyList(eval(data));
        }
    })
}
function initApplyList(obj){
    for(var i=0;i<obj.length;i++){
        obj[i].id="<input type='radio' name='radio01' onclick='radioClick(this)' value='"+obj[i].id+"'/>";
    }
    $("#applyTable").bootstrapTable('load',obj);
}
function radioClick(obj){
    $("#applyId").val(obj.value);
}
function queryApplyDetail(){
    var basePath=$("#basePath").val();
    var applyId=$("#applyId").val();
    if(applyId==""){
        alert("请选择要查看的行！");
        return;
    }
    window.open(basePath+'apply/toApplyDetail.do?applyId='+applyId)
}
function addApplyItem(){
    nowItemLine=nowItemLine+1;
    var item="<div class='row'>"
    +"<input type='hidden' id='devId"+nowItemLine+"' name='devId'>"
    +"<div class='breadcrumb'>申请设备"+nowItemLine+"</div>"
    +"<div style='margin-left: 50px;'>"
    +"<label>设备编号</label>"
    +"<input id='devNo"+nowItemLine+"' style='width: 200px;'>"
    +"<a href='javascript:findDevInfo("+nowItemLine+")' >加载</a>"
    +"<label style='margin-left: 165px;'>设备名称</label>"
    +"<input id='devName"+nowItemLine+"' style='width: 200px;' readonly='true'><br>"
    +"</div>"
    +"<div style='margin-left: 50px;'>"
    +"<label>设备型号</label>"
    +"<input id='modelNo"+nowItemLine+"' style='width: 200px;' readonly='true'>"
    +"<label style='margin-left: 192px;'>设备规格</label>"
    +"<input id='standard"+nowItemLine+"' style='width: 200px;' readonly='true'><br>"
    +"</div>"
    +"<div style='margin-left: 50px;'>"
    +"<label>设备类别</label>"
    +"<input id='cate"+nowItemLine+"' style='width: 200px;' readonly='true'>"
    +"<label style='margin-left: 192px;'>设备国别</label>"
    +"<input id='country"+nowItemLine+"' style='width: 200px;' readonly='true'><br>"
    +"</div>"
    +"<div style='margin-left: 50px;'>"
    +"<label>设备来源</label>"
    +"<input id='origin"+nowItemLine+"' style='width: 200px;' readonly='true'>"
    +"<label style='margin-left: 192px;'>使用方向</label>"
    +"<input id='direct"+nowItemLine+"' style='width: 200px;' readonly='true'><br>"
    +"</div>"
    +"<div style='margin-left: 50px;'>"
    +"<label>申请数量</label>"
    +"<input id='applyNum"+nowItemLine+"' style='width: 200px;'><br>"
    +"</div>"
    +"</div>";
    $("#applyItem").append(item);
}
function findDevInfo(obj){
    var devNoId="#devNo"+obj;
    var devIdId="#devId"+obj;
    var devNameId="#devName"+obj;
    var modelNoId="#modelNo"+obj;
    var standardId="#standard"+obj;
    var cateId="#cate"+obj;
    var countryId="#country"+obj;
    var directId="#direct"+obj;
    var originId="#origin"+obj;
    var basePath=$("#basePath").val();
    var devNo=$(devNoId).val();
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
            $(devIdId).val(result.id);
            $(devNameId).val(result.devName);
            $(modelNoId).val(result.modelNo);
            $(standardId).val(result.standard);
            $(cateId).val(result.cateName);
            $(countryId).val(result.countryName);
            $(directId).val(result.direcName);
            $(originId).val(result.originName);
        }
    })
}
function saveApply(){
    var basePath=$("#basePath").val();
    var itemJson="[";
    for(var i=1;i<=nowItemLine;i++){
        var devIdId="#devId"+i;
        var applyNumId="#applyNum"+i;
        var devId=$(devIdId).val();
        var applyNum=$(applyNumId).val();
        if(devId!=""){
            itemJson=itemJson+"{"+"\""+"devId"+"\""+":"+devId+","+"\""+"devNum"+"\""+":"+applyNum+"},";
        }
    }
    if(itemJson=="["){
        alert("请填写设备申请信息!");
        return;
    }
    itemJson=itemJson.substring(0,itemJson.length-1)+"]";
    var applyText=$("#applyText").val();
    var remark=$("#remark").val();
    var applyJson="{"+"\""+"applyText"+"\""+":"+"\""+applyText+"\""+","+"\""+"remark"+"\""+":"
        +"\""+remark+"\""+"}";
    $.ajax({
        type:"POST",
        url:basePath+"apply/createApply.do",
        data:{appliItemListJson:itemJson,applyJson:applyJson},
        async:false,
        error:function(){
            alert("系统内部错误，请稍后再试");
        },
        success:function(data){
            if(data=="1"){
               alert("保存成功");
                window.close();
            }else{
                alert("保存失败,请稍候再试");
            }
        }
    })
}
function toApplyReview(){
    var basePath=$("#basePath").val();
    var applyId=$("#applyId").val();
    var status;
    if(applyId==""){
        alert("请选择要审核的行！");
        return;
    }
    $.ajax({
        type:"POST",
        url:basePath+"apply/queryApplyStatus.do",
        data:{applyId:applyId},
        async:false,
        error:function(){
            alert("系统内部错误，请稍后再试");
        },
        success:function(data){
            status=data;
        }
    })
    if(status=="2"){
        alert("申请已经审核通过");
        return;
    }else if(status=="3"){
        alert("申请设备已借出");
        return;
    }else if(status=="4"){
        alert("申请设备已归还");
        return;
    }else if(status=="-1"){
        alert("申请已被拒绝");
        return;
    }else if(status=="1"){
        window.open(basePath+'apply/toApplyReview.do?applyId='+applyId);
    }
}
function applyReview(obj){
    var basePath=$("#basePath").val();
    var applyId=$("#applyId").val();
    var dealText=$("#dealText").val();
    $.ajax({
        type:"POST",
        url:basePath+"apply/updateApplyToPass.do",
        data:{id:applyId,dealText:dealText,status:obj},
        async:false,
        error:function(){
            alert("系统内部错误，请稍后再试");
        },
        success:function(data){
            if(data=="1"){
                alert("申请审核成功");
                window.close();
            }else{
                alert("申请审核失败,请稍候再试");
            }
        }
    })
}
function lend(){
    var basePath=$("#basePath").val();
    var applyId=$("#applyId").val();
    var status;
    if(applyId==""){
        alert("请选择要操作的行！");
        return;
    }
    $.ajax({
        type:"POST",
        url:basePath+"apply/queryApplyStatus.do",
        data:{applyId:applyId},
        async:false,
        error:function(){
            alert("系统内部错误，请稍后再试");
        },
        success:function(data){
            status=data;
        }
    })
    if(status=="1"){
        alert("申请还未审核通过");
        return;
    }else if(status=="3"){
        alert("申请设备已借出");
        return;
    }else if(status=="4"){
        alert("申请设备已归还");
        return;
    }else if(status=="-1"){
        alert("申请已被拒绝");
        return;
    }else if(status=="2") {
        if (confirm("确定要将申请状态更新为已借出吗？")) {
            $.ajax({
                type: "POST",
                url: basePath + "apply/updateApply.do",
                data: {id: applyId, status: 3},
                async: false,
                error: function () {
                    alert("系统内部错误，请稍后再试");
                },
                success: function (data) {
                    if (data == "1") {
                        alert("申请设备借出，状态更新成功");
                        return;
                    } else {
                        alert("申请设备借出，状态更新失败，请稍候再试");
                        return;
                    }
                }
            })
        }
    }
}
function revert(){
    var basePath=$("#basePath").val();
    var applyId=$("#applyId").val();
    var status;
    if(applyId==""){
        alert("请选择要操作的行！");
        return;
    }
    $.ajax({
        type:"POST",
        url:basePath+"apply/queryApplyStatus.do",
        data:{applyId:applyId},
        async:false,
        error:function(){
            alert("系统内部错误，请稍后再试");
        },
        success:function(data){
            status=data;
        }
    })
    if(status=="1"){
        alert("申请还未审核通过");
        return;
    }else if(status=="2"){
        alert("申请设备还未借出");
        return;
    }else if(status=="4"){
        alert("申请设备已归还");
        return;
    }else if(status=="-1"){
        alert("申请已被拒绝");
        return;
    }else if(status=="3") {
        if (confirm("确定要将申请状态更新为已归还吗？")) {
            $.ajax({
                type: "POST",
                url: basePath + "apply/updateApply.do",
                data: {id: applyId, status: 4},
                async: false,
                error: function () {
                    alert("系统内部错误，请稍后再试");
                },
                success: function (data) {
                    if (data == "1") {
                        alert("申请设备归还，状态更新成功");
                        return;
                    } else {
                        alert("申请设备归还，状态更新失败，请稍候再试");
                        return;
                    }
                }
            })
        }
    }
}