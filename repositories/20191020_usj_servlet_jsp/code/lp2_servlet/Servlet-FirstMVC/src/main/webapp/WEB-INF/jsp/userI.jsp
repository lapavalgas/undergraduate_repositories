<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Lista de Tarefas</title>
    <style>
        a {
            text-decoration: none;
        }

        body {
            background-color: lightslategray;
            margin: 0;
            padding: 0;

        }

        .UI {
            display: grid;
            grid-template: "user user""schedule task";
            grid-template-columns: 2fr 6fr;
            grid-template-rows: 2fr 8fr;
        }

        .title {
            margin: 3px;
            margin-left: 1em;

        }

        .user {
            grid-area: user;
            width: 100%;
            margin: 0.5em;
            padding: 0.5em;
            display: flex;
            justify-content: space-between;
            border-bottom: 1px dashed black;

        }

        .user__name {
            height: 2em;
            min-width: 8em;
            margin-left: 3em;
            font-family: 'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif;

        }

        .user__schedules {
            margin-right: 8em;
            display: flex;


        }

        .schedule__card {
            width: 10em;
            padding: 0px;
            height: 2em;
            margin-left: 0.5em;
            margin-right: 0.5em;
            font-family: 'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif;
            font-size: 14px;
            border: 1px solid;
        }

        .theSchedule {
            margin: 0.5em;
            grid-area: schedule;
        }

        .task__card {
            margin: 3px auto;
            border: 1px dashed;
            display: flex;
            justify-content: space-between;

        }

        .icons {
            margin-top: 1.65em;
            margin-right: 0.25em;
        }

        .iconsImg {
            margin-right: 1em;
        }

        .task {
            margin: 0.5em;
            grid-area: task;
            border-left: 1px dashed;
        }

        .task__description {
            margin: 0.5em;
        }
    </style>
</head>

<body>

    <section class="UI">
        <section class="user">
            <div class="user__name">
                <span style="margin-left: 1em;">USER_NAME_HERE</span>
            </div>
            <div class="user__schedules">
                <!-- max 7 schedules -->
                <div class="schedule__card" style=" border: 1px dashed;""><span style=" margin-left: 0.5em;">
                    new_schedule</span></div>
                <div class="schedule__card"><span style="margin-left: 0.5em;">cards</span></div>
                <!-- <div class="schedule__card"><span style="margin-left: 0.5em;">cards</span></div>
                        <div class="schedule__card"><span style="margin-left: 0.5em;">cards</span></div>
                        <div class="schedule__card"><span style="margin-left: 0.5em;">cards</span></div>
                        <div class="schedule__card"><span style="margin-left: 0.5em;">cards</span></div>
                        <div class="schedule__card"><span style="margin-left: 0.5em;">cards</span></div> -->
            </div>
        </section>
        <section class="theSchedule">
            <div class="schedule">
                <div class="title">
                    <h3>Schedules</h3>
                </div>
                <div class="task__card">
                    <div class="title">
                        <h4>title__task ytdfuytrdutyrdutrs</h4>
                    </div>
                    <div class="icons">
                        <a href=""><img class="iconsImg" src="../webapp/img/edit.png" alt="Editar tarefa"
                                style="width: 16px; height: 16px;"> </a>
                        <a href=""><img class="iconsImg" src="../webapp/img/trash.png" alt="Deletar tarefa "
                                style="width: 16px; height: 16px;"> </a>
                    </div>
                </div>
            </div>
        </section>
        <section class="task">
            <div class="title">
                <h2>TASK_TITLE</h2>
            </div>
            <div class="task__description">
                <p>task__description</p>
            </div>
        </section>
    </section>

</body>

</html>