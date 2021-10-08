var btnRegistrar = document.getElementById("btnRegistro2");
btnRegistrar.addEventListener("click", function(){
    var params = new URLSearchParams();
    var usuario = document.getElementById("txtusuario2").value;
    var pass = document.getElementById("txtcontraseña2").value;
    var pass2 = document.getElementById("txtcontraseña3").value;
    if(pass.value === pass2.value){
        params.append("usuario", usuario);
        params.append("pass", pass);
        console.log(params.get("usuario"));
        axios.get("http://localhost:4567/hola?"+params).then(
            function (rs) {
                console.log(rs.data);
                alert(rs.data);
            }
        )
    }else{
        console.error("contraseña diferente");
    }
    
});