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
    if($("#applyId").val()==""){
        alert("请选择要查看的行！");
    }
    
}