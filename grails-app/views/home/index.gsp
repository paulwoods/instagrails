
<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>InstaGrails</title>
    <asset:link rel="icon" href="favicon.ico" type="image/x-ico" />
</head>

<body>
    <div id="content" role="main">
        <h3>Latest Images</h3>
        <g:each var="post" in="${posts}">
            <div class="thumbnail">
                <g:link controller="post" action="show" id="${post.id}">
                    <img src="${createLink(controller:'image', action:'thumbnail', id:post.id)}" />
                </g:link>
                <div>${post.text}</div>
            </div>
        </g:each>

    </div>

</body>
</html>
