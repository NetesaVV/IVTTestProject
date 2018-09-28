<#import "/spring.ftl" as spring/>

<html>
<head>
    <title>Client List</title>
    <link rel="stylesheet"
          type="text/css"
          href="<@spring.url '/css/style.css'/>"/>

    <style>
        .btn {		//Задание общего стиля для кнопки
        height:30px;
            border-color: #0014e2 #212ab8 #212ab8 #0014e2;
            border-style:solid;
            border-width:1px;
            background: #e0dfe2;
            cursor:pointer;
        }
        .btn:hover {	//Стиль кнопки при новедении на него курсора
        border-color:#FFCC66 #FFFF99 #FFFF99 #FFCC66;
            border-style:solid;
            border-width:1px;
            background: #6679ff;
        }
        .btn:focus {	//Стиль кнопки, когда она в фокусе
        background:#ddd;
            border-color:#ddd #333 #333 #ddd;
            border-style:solid;
            border-width:1px;
        }
        .btn:active {		//Стиль кнопки при нажатии
        background:#ff0000;
            border-color:#ddd #333 #333 #ddd;
            border-style:solid;
            border-width:1px;
        }
    </style>
</head>
<body>
<h3>Client List</h3>

<div>

    <table border="1">
        <tr>
            <th>Login</th>
            <th>Password</th>
            <th>Full name</th>
            <th>Sex</th>
        </tr>
            <#list clients as client>
            <tr>
                <td>${client.login}</td>
                <td>${client.password}</td>
                <td>${client.fullName}</td>
                <td>${client.sex}</td>
            </tr>
            </#list>
    </table>
</div>

<div style="position:fixed; top:10%; left:80%">
    <button type="button" class = "btn" onclick="location.href='/addClient';">Add Client</button>
</div>
<div style="position:fixed; top:14%; left:80%">
    <button type="button" class = "btn" onclick="location.href='/index';">Start page</button>
</div>
</body>
</html>