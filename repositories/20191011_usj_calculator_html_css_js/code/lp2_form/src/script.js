function soma() {
    var num1 = Number(document.getElementById('num1').value);
    var num2 = Number(document.getElementById('num2').value);
    var result = document.getElementById('result');
    result.value = "" + (num1 + num2);
}

function subt() {
    var num1 = Number(document.getElementById('num1').value);
    var num2 = Number(document.getElementById('num2').value);
    var result = document.getElementById('result');
    result.value = "" + (num1 - num2);
}

function divs() {
    var num1 = Number(document.getElementById('num1').value);
    var num2 = Number(document.getElementById('num2').value);
    var result = document.getElementById('result');
    result.value = "" + (num1 / num2);
}

function mult() {
    var num1 = Number(document.getElementById('num1').value);
    var num2 = Number(document.getElementById('num2').value);
    var result = document.getElementById('result');
    result.value = "" + (num1 * num2);
}