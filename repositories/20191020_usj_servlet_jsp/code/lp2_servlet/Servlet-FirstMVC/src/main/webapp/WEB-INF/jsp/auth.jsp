<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>LOGIN</title>
    <style>
        body {
            background-color: lightslategray;
        }

        .authJSP {
            width: 20%;
            padding: 10px;
            margin: auto;
        }

        .authentication {
            margin: 3px auto;
            padding: 3px;
        }

        .newUSer {
            margin: 3px auto;
            padding: 3px;
        }
        .inputText{
            width: 100%;
            margin-bottom: 3px;
        }
        .inputBtn{
            margin-top: 3px;
            margin-bottom: 3px;
        }
    </style>
</head>

<body>

    <section class="authJSP">
        <div class="authentication">
            <h1>Login:</h1>
            <form action="auth" method="post" target="page">
                <div><input id="login" name="login" class="inputText" onfocus="this.value=''" type="text" value="L O G I N"></div>
                <div><input id="pass" name="pass" class="inputText" onfocus="this.value=''; this.type='password' " type="text" value="P A S S W O R D"></div>
                <div><input id="id" name="Submit" class="inputBtn" type="Submit" value="Submit" ></div>
            </form>
        </div>
        <div class="newUSer">
            <form action="">
                <input class="inputBtn"  type="button" value="New User" name="New User">
            </form>
        </div>
    </section>

</body>

</html>