<!DOCTYPE html>
<html lang="hu">
<head>
    <meta charset="UTF-8">
    <title>Registrations</title>
    <link href="/css/main.css" rel="stylesheet">
    <style>
		thead {color:green;}
		tbody {color:blue;}
		tfoot {color:red;}
		
		table, th, td {
		  border: 1px solid black;
		}
	</style>
</head>
<body>
    <h2 class="hello-title">SMS lista</h2>
    <table>
    	<thead>
    	<tr>
        	<th>Id</th>
            <th>Felhasznalo</th>
            <th>Email</th>
            <th>Telefonszam</th>
            <th>SMS kod</th>
         </tr>
    	</thead>
    	<tbody>
    		<#list registrations as reg>
                <tr>
                    <td>${reg.id}</td>
                    <td>${reg.userName}</td>
                    <td>${reg.email}</td>
                    <td>${reg.phoneNumber}</td>
                    <td>${reg.smsCode}</td>
                </tr>
            </#list>
        	</tbody>
        </table>
</body>
</html>
