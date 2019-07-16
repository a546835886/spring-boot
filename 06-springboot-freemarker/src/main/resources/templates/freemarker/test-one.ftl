<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:th="http://www.thymeleaf.org"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
<h1 style="color: chartreuse">FreeMarker模板引擎</h1>


message: ${message}<br/>
content: ${content}<br/>
${message?if_exists}　<br/>　　　　  　<#--// 变量存在，输出该变量，否则不输出-->
${message!}　　<br/>　　　　　　　　    <#--// 变量存在，输出该变量，否则不输出-->
${message?default("default")}  <br/>      <#--// 变量不存在，取默认值xxx-->
${message!"blank"}  <br/>  　　　　　　  <#--// 变量不存在，取默认值xxx-->
<HR style="FILTER: progid:DXImageTransform.Microsoft.Shadow(color:#987cb9,
    direction:145,strength:15)" width="80%" color=#987cb9 SIZE=1>
${content?if_exists}　　<br/>　　　
${content!}　　　　　<br/>　　　　　
${content?default("default")}<br/>
${content!"blank"}<br/>
${"123<br/>456"?html}    　　<#--// 对字符串进行HTML编码，对html中特殊字符进行转义-->
<br/>
<#assign str ="abcdefghijklmn"/>
<#--//方法1-->
${str?substring(0,4)} <#--//输出abcd-->
<#--//方法2-->
${str[0]}${str[4]} <#--//结果是ae-->
${str[1..4]} <#--//结果是bcde-->
<#--//返回指定字符的索引-->
${str?index_of("n")}

<hr/>
${date?string('yyyy-MM-dd HH:mm:ss')}

<hr/>
${20?string.number} <#--输出20-->
${20?string.currency} <#--¥20.00-->
${20?string.percent} <#--20％-->
${1.222?int} <#--//将小数转为int，输出1-->


<#--<h1>${resource.name}</h1>
<h1>${resource.website}</h1>
<h1>${resource.language}</h1>-->
</body>
</html>