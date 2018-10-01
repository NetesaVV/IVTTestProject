<#import "/spring.ftl" as spring/>

<html>
<head>
    <title>Add Client</title>
    <link rel="stylesheet"
          type="text/css" href="<@spring.url '/css/style.css'/>"/>

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
      <#if errorMessage??>
      <div style="color:red;font-style:italic;">
          ${errorMessage}
      </div>
      </#if>

<div>
    <fieldset>
        <legend>Add client</legend>
        <form name="clientForm" action="" method="POST">
            Login:     <@spring.formInput "clientForm.login" "" "text"/>    <br/>
            Password:  <@spring.formInput "clientForm.password" "" "text"/>    <br/>
            Full name: <@spring.formInput "clientForm.fullName" "" "text"/>    <br/>
            Sex:       <@spring.formInput "clientForm.sex" "" "text"/>    <br/>
            <br/>
            <input type="submit" class="btn" value="Create" />
        </form>
    </fieldset>
</div>

<br/>
<div>
    <button type="button" class = "btn" onclick="location.href='/clientList';">Client List</button>
</div>

</body>

</html>