<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>InstaGrails</title>
    <asset:link rel="icon" href="favicon.ico" type="image/x-ico" />
</head>

<body>
    <div id="content" role="main">


		<h3>Create Post</h3>

        <div class="row">
            <div class="col-md-6">

        <g:uploadForm controller="post" action="save">

            <div class="form-group">
                <label>File</label>
                <input class="form-control" type="file" name="content" value="${cmd.content}"/>
            </div>

            <div class="form-group">
                <label>Post</label>
                <textarea rows="10" class="form-control" name="text">${cmd.text}</textarea>
            </div>

            <input type="submit" class="btn btn-primary" value="upload"/>
            
        </g:uploadForm>

    </div>
</div>

    </div>

</body>
</html>
