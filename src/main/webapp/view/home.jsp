<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<div align="center" >
GetJar
</div>
<script src="js/jquery/jquery.min.js"></script>
<script>
function getJar()
        {
	
		var artifactId = $('#artifactId').val();
		var groupId = $('#groupId').val();
		var version =  $('#version').val();
            $.ajax({
                type: "POST",
                url: "/getJar", 
                data: {
                	"aId": artifactId,
                	"gId": groupId,
                	"vId": version},
                success: function(msg){      
                        //todo
                }
            });
        }


</script>


</head>
<body>
<div align="center">
</br>
<input id="artifactId" name="artifactId" type="text" placeholder="com.example" />
<br></br>
<input id="groupId" name="groupId" type="text" placeholder="groupId" />
<br></br>
<input id="version" name="version" type="text" placeholder="version" />
<br></br>
<input type="button" id="call" onclick="getJar();" value="getjar" />
<div>
<body>
</html>