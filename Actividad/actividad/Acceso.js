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
