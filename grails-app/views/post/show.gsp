<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>InstaGrails</title>
    <asset:link rel="icon" href="favicon.ico" type="image/x-ico" />
</head>

<body>
    <div id="content" role="main">

    	<div class="row">
    		<div class="col-md-9">

    			<h3>Post</h3>

       			<img src="${createLink(controller:'image', action:'original', id:post.id)}" />

    		</div>

    		<div class="col-md-3">

    			<h3>Post</h3>

    			<div class="comment">
    				<div class="user">${post.user.username}</div>
    				<div class="date">${post.dateCreated.format("yyyy-MM-dd hh:mm:ss z")}</div>
    				<div class="text">${post.text}</div>
    			</div>

    			<h3>Add a Comment</h3>

    			<g:form controller="comment" action="add" id="${post.id}">
    				<div class="form-group">
    					<textarea class="form-controls"></textarea>
    				</div>
    				<input class="btn btn-primary btn-sm" type="submit" action="save"/>
    			</g:form>

    			<br/>

    			<g:each var="comment" in="${post.comments}">

    			<div class="comment">
    				<div class="user">${comment.user.username}</div>
    				<div class="date">${comment.dateCreated.format("yyyy-MM-dd hh:mm:ss z")}</div>
    				<div class="text">${comment.text}</div>
    			</div>

    			</g:each>

    		</div>
    	</div>

    </div>

</body>
</html>
