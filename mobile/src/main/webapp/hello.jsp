<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="resources/css/style.css" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<title>Mobile Out</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</head>
<body class=" mybody">
<header>
      <nav class="navbar navbar-light bg-fb-blue">
        <div class="container-fluid">
          <a class="navbar-brand badge text-dark"><h1>MOBILE</h1></a>
          <div>
          <a href="index.jsp"><button class="btn btn-outline-dark" type="submit"><h6>Save Data</h6></button></a>
          <a href="updatePrice.jsp"><button class="btn btn-outline-dark" type="submit"><h6>update price</h6></button></a>
          <a href="updateAvailability.jsp"><button class="btn btn-outline-dark" type="submit"><h6>update availability</h6></button></a>
          <a href="getByPrice.jsp"><button class="btn btn-outline-dark" type="submit"><h6>Get By price</h6></button></a> 
          <a href="getByBrand.jsp"><button class="btn btn-outline-dark" type="submit"><h6>Get By Brand</h6></button></a> 
        </div>
        </div>
      </nav>
    </header>
    
    <section> 
        <div class="container fs-6 shadow p-3 mb-5 bg-white card-round">
            <div class="row">
	            <c:if test="${out!=null}">
		            <div>
		            	<h3 class="text-center">${out}</h3>
					</div>
	            </c:if>
              <table class="table table-hover">
				<c:choose>
					<c:when test="${!empty data}">
						<c:if test="${data!=null}">
							<thead>
								<tr>
									<th scope="col">Id</th>
									<th scope="col">Brand Name</td>
									<th scope="col">Model Number</th>
									<th scope="col">Model Name</th>
									<th scope="col">Type</th>
									<th scope="col">RAM</th>
									<th scope="col">ROM</th>
									<th scope="col">Price</th>
									<th scope="col">Availability</th>
								</tr>
							</thead>
						</c:if>
						<tbody>
						<c:forEach var="item" items="${data}">
							<tr>
								<th scope="row">${item.id}</th>
								<td>${item.brandName}</td>
								<td>${item.modelNumber}</td>
								<td>${item.modelName}</td>
								<td>${item.type}</td>
								<td>${item.ram}</td>
								<td>${item.rom}</td>
								<td>${item.price}</td>
								<td>${item.availability}</td>
							</tr>
							</tbody>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<h3 class="text-center">${msg}</h3>
					</c:otherwise>
				</c:choose>
				</table>
              <div class="col-sm-6">
              </div>
            </div>
          </div>
      </section>
      
 <footer class="text-center ft1 fixed-bottom"><h6>&copy;Copyrights Reserved</h6></footer>     

</body>
</html>