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