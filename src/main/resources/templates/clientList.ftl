<#import "/spring.ftl" as spring/>

<html>
<head>
    <title>Person List</title>
    <link rel="stylesheet"
          type="text/css"
          href="<@spring.url '/css/style.css'/>"/>
</head>
<body>
<h3>Person List</h3>
<a href="addClient">Add Client</a>
<br><br>
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
</body>
</html>