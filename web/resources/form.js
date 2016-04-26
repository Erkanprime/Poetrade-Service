$(document).ready(function(){
    $("#mods").load('/poe-trade/resources/select.html');
    $("#base").load('/poe-trade/resources/base.html');

    $("#addmod").click(function(){
       var select = document.getElementById("selectGroup");
       console.log(select);
       $("#mods").append(select);
    });
});

