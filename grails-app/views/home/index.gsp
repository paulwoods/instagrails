
<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>InstaGrails</title>

    <asset:link rel="icon" href="favicon.ico" type="image/x-ico" />
</head>
<body>
    
    <div id="content" role="main">
       
    <g:each var="post" in="${posts}">
        <div>
            <img src="${createLink(controller:'image', action:'thumbnail', id:post.id)}" />
            <div>${post.text}</div>
        </div>
    </g:each>

    </div>

</body>
</html>
