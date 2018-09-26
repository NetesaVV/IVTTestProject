<#import "/spring.ftl" as spring/>

<html>
<head>
    <title>Add Person</title>
    <link rel="stylesheet"
          type="text/css" href="<@spring.url '/css/style.css'/>"/>
</head>
<body>
      <#if errorMessage??>
      <div style="color:red;font-style:italic;">
          ${errorMessage}
      </div>
      </#if>

<div>
    <fieldset>
        <legend>Add Client</legend>
        <form name="client" action="" method="POST">
            Login: <@spring.formInput "client.login" "" "text"/>    <br/>
            Password: <@spring.formInput "client.password" "" "text"/>    <br/>
            Password: <@spring.formInput "client.fullName" "" "text"/>    <br/>
            Password: <@spring.formInput "client.sex" "" "text"/>    <br/>
            <input type="submit" value="Create" />
        </form>
    </fieldset>
</div>


</body>

</html>