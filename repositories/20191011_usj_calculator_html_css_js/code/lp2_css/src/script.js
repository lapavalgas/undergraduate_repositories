var calculadora = {
    valorA: "",
    valorB: "",
    operador: "null",
    /*  null    - não ativo
        end     - concluida operação     */
}

/*      RESETA CALC      */
function restartCalc() {
    calculadora.valorA = "";
    calculadora.valorB = "";
    calculadora.operador = "null";
}

/*      ATUALIZA TELA    */
function printUserClick(userClick) {
    var result = document.querySelector('#results');
    if (userClick === "") {
        HTMLTemporario = result.innerHTML;
        HTMLTemporario = "";
        result.innerHTML = HTMLTemporario;
    } else {
        HTMLTemporario = result.innerHTML;
        HTMLNovo = userClick;
        HTMLTemporario += HTMLNovo;
        result.innerHTML = HTMLTemporario;
    }
}
/** */
function selectUserClick(userClick) {
    if (calculadora.operador === "null") {
        switch (userClick) {
            case '/':
                printUserClick(userClick);
                calculadora.operador = "/";
                break;
            case '*':
                printUserClick(userClick);
                calculadora.operador = "*";
                break;
            case '-':
                printUserClick(userClick);
                calculadora.operador = "-";
                break;
            case '+':
                printUserClick(userClick);
                calculadora.operador = "+";
                break;
            default:
                calculadora.valorA += "" + userClick;
                printUserClick(userClick);
        }
    } else {
        switch (userClick) {
            case '/':
                break;
            case '*':
                break;
            case '-':
                break;
            case '+':
                break;
            default:
                calculadora.valorB += "" + userClick;
                printUserClick(userClick);
        }
    }
}

/*      LIMPA TELA      */
function clearCalc() {
    printUserClick("");
}

/*      CALCULA         */
function operar() {
    var a = +(calculadora.valorA);
    var b = +(calculadora.valorB);
    var result = 0;
    switch (calculadora.operador) {
        case '/':
            result = a / b;
            clearCalc();
            printUserClick(result);
            calculadora.operador = "end";
            break;
        case '*':
            result = a * b;
            clearCalc();
            printUserClick(result);
            calculadora.operador = "end";
            break;
        case '-':
            result = a - b;
            clearCalc();
            printUserClick(result);
            calculadora.operador = "end";
            break;
        case '+':
            result = a + b;
            clearCalc();
            printUserClick(result);
            calculadora.operador = "end";
            break;
    }
    operador = "end";
}

function userClick(userClick) {
    console.log(calculadora.valorA, calculadora.valorB, calculadora.operador);
    if (calculadora.operador === "end") {
        switch (userClick) {
            case '/':
                calculadora.valorA = document.querySelector('#results').innerHTML;
                calculadora.valorB = "";
                calculadora.operador = "/";
                printUserClick(userClick);

                break;
            case '*':
                calculadora.valorA = document.querySelector('#results').innerHTML;
                calculadora.valorB = "";
                calculadora.operador = "*";
                printUserClick(userClick);

                break;
            case '-':
                calculadora.valorA = document.querySelector('#results').innerHTML;
                calculadora.valorB = "";
                calculadora.operador = "-";
                printUserClick(userClick);

                break;
            case '+':
                calculadora.valorA = document.querySelector('#results').innerHTML;;
                calculadora.valorB = "";
                calculadora.operador = "+";
                printUserClick(userClick);

                break;
            default:
                restartCalc();
                clearCalc();
        }
    } else {
        switch (userClick) {
            case 'ac':
                restartCalc();
                clearCalc();
                break;
            case '=':
                if (calculadora.operador != "null") {
                    operar();
                    break
                } else {
                    break;
                }
            default:
                selectUserClick(userClick);
                break;
        }
    }
    console.log(calculadora.valorA, calculadora.valorB, calculadora.operador);
}