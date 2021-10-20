/*var btnIncio = document.getElementById("btnInicio");
btnIncio.addEventListener("click",
    function () {
       
        var usuario = document.getElementById("txtusuario");
        var contraseña = document.getElementById("txtpassword");
        var params = new URLSearchParams();
        params.append("name", usuario);
        params.append("pass", contraseña);
        axio.get("http://localhost:8080/index?"+params).then(
            function (rs) {
                console.log(rs.data);
                alert(rs.data);
            }
        )
    }); */