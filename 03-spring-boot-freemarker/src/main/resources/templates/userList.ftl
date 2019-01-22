<html>
    <head>
        <title>展示用户数据</title>
        <meta charset="utf-8"/>
    </head>
    <body>
        <table border="1" width="50%" align="center">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Age</th>
            </tr>
            <#list list as user>
                <tr>
                    <td>${user.userid}</td>
                    <td>${user.username}</td>
                    <td>${user.userage}</td>
                </tr>
            </#list>
        </table>
    </body>

</html>