<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>

<html>

<head>
    <meta charset="UTF-8">
    <title>Cadastrar e editar hospedes</title>
    <script src="scripts.js">
    </script>
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
        integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
        crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
        integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
        crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
        integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <style>
        .page {
            max-width: 1024px;
            margin: 0.5em auto;
        }

        .header {
            padding: 0.5em;
            margin-bottom: 1.5em;
        }

        .controller {
            display: flex;
            justify-content: space-between;
        }

        .main {
            margin: auto;
        }

        .list-group {
            margin-bottom: 1em;

        }

        .list-group h4 {
            padding-top: 10px;

        }
    </style>

</head>
<!-------------------------------------------------------------------------------------------------------------------------->

<body>
    <header class="page">

        <section class="header" style="border-bottom: 1px dashed black;">
            <div class="logo">
                <h1>HOTEL DAHORA</h1>
            </div>

            <div class="controller">
                <div class="data">
                    <div style="display: flex;">
                        <form action="SistemaDataAtual" method="post" style="display: flex;">
                            <input id="day" type="date" name="data" placeholder="date" value="${data}"
                                class="form-control" style="min-width: 250px">
                            <button type="submit" class="btn btn-primary">OK</button>
                        </form>
                        <form action="SistemaDataAtual" method="post">
                            <button type="submit" class="btn btn-info">Data atual</button>
                            <input type="hidden" name="data" value="dataAtual">
                        </form>
                    </div>
                </div>

                <div class="cadastro" style="padding-right: 10px;">
                    <form action="SistemaCadastroController" method="post">
                        <input name="cadastrar" type="Submit" value="Cadastros" class="btn btn-primary btn-lg"
                            style="width: 208px;">
                    </form>
                </div>

            </div>

        </section>

    </header>
    <!-------------------------------------------------------------------------------------------------------------------------->
    <main class="page">
        <section class="main">

            <div class="editar__cadastro" style="margin-bottom: 2em;">
                <h4>Localizar Hospede</h4>
                <fieldset>
                    <form action="HospedeController" method="post">
                        <label for="hospedeCpf">Localizar por CPF</label>
                        <div class="form-group" style="margin-bottom: 1em; display: flex;">
                            <input type="text" class="form-control" id="hospedeCpf" placeholder="Ex.:   xxx.xxx.xxx-xx"
                                autocomplete="off" name="hospedeCpf" oninput="mascara(this, 'cpf')"
                                style="max-width: 250px">
                            <button type="submit" name="read" value="" class="btn btn-primary">Localizar</button>
                            <button type="submit" name="delete" value="" class="btn btn-danger">Deletar</button>
                        </div>
                    </form>
                </fieldset>
            </div>

            <div class="cadastro__forms">
                <!-- VERIFICAR SE LOCALIZOU -->
                <!-- VERIFICAR SE LOCALIZOU -->
                <h4>Cadastrar Hospede</h4>
                <!-- <h4>Editar Hospede</h4> -->
                <!-- VERIFICAR SE LOCALIZOU -->
                <!-- VERIFICAR SE LOCALIZOU -->
                <fieldset>
                    <form action="HospedeController" method="post">
                        <div class="form-group">
                            <label for="hospedeName">Nome</label>
                            <input type="text" class="form-control" name="hospedeName" id="hospedeName"
                                placeholder="Nome do hospede">
                        </div>
                        <div class="form-group">
                            <label for="hospedeCpf">CPF</label>
                            <input type="text" class="form-control" id="hospedeCpf" placeholder="Ex.:   xxx.xxx.xxx-xx"
                                autocomplete="off" name="hospedeCpf" oninput="mascara(this, 'cpf')">
                            <!-- name="customer['cpf']" -->
                        </div>
                        <button type="submit" name="create" value="" class="btn btn-primary">CADASTRAR</button>
                        <button type="submit" name="update" value="" class="btn btn-primary">EDITAR</button>
                    </form>
                </fieldset>
            </div>
        </section>
</body>

</html>