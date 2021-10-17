var btnPost = document.getElementById("btnPost");
btnPost.addEventListener("click", function(){
    var params = new URLSearchParams();
    var usuario = document.getElementById("txtusuario").value;
    var pass = document.getElementById("txtcontraseña").value;
    params.append("usuario", usuario);
    params.append("pass", pass);
    console.log("------")
    console.log("{" + "usuario:'" + params.get("usuario") + "'," + "pass:'" + params.get("pass") + "'}");
    axios.post("http://localhost:4567/HolaJson", { usuario : params.get("usuario"), pass : params.get("pass") } )
    .then(
        function (rs) {
            console.log(rs.data);
            //alert(rs.data);
        }
    ).catch(function(error){
        console.log(error);
    })
});

var btnGet = document.getElementById("btnGet");
btnGet.addEventListener("click", function(){
    var params = new URLSearchParams();
    var usuario = document.getElementById("txtusuario").value;
    var pass = document.getElementById("txtcontraseña").value;
    params.append("usuario", usuario);
    params.append("pass", pass);
    console.log(params.get("usuario"));
    axios.get("http://localhost:4567/hola?"+params).then(
        function (rs) {
            console.log(rs.data);
            alert(rs.data);
        }
    )

});

