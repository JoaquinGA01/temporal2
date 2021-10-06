function setResult(value) {
    document.calc.result.value = value;
}
function getResult() {
    return(document.calc.result.value);
}
function add(key) { 
    var result = getResult();
    if (result!='0' || isNaN(key)) setResult(result + key);
    else setResult(key);
}
function calc() {
    var result = eval(getResult()); 
    setResult("document.calc.resultado.value=eval(document.calc.resultado.value)");
}
function del() { 
    setResult(0);
}

