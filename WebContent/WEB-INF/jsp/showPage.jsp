<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
	<title>${post.title}</title>
</head>
<body>
	<h1>${post.title}</h1>
	
	<p>${post.content}</p>
	
	<c:if test="${type == 'photoPost'}">
		<img alt="" src="${post.photoUrl}">
	</c:if>
	
	<c:if test="${type == 'videoPost'}">
		<img alt="" src="${post.videoUrl}">
	</c:if>
	
	
	
	

</body>
</html>