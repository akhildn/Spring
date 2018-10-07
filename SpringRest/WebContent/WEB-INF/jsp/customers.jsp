<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html ng-app="customerApp">
  <head>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>
    <script src="http://localhost:8090/SpringRest/resources/js/customers.js"></script>    
  </head>
  <body>
    <h2>Customers</h2>
    <div ng-controller="CustomerController as customerList">
           
      <table bgcolor="pink" border="1">
      <tr bgcolor="grey"><th>Id</th><th>username</th><th>password</th><th>Email</th><th>Contact No.</th>
		<tr ng-repeat="customer in customerList.customers">
		<td>{{customer.id}}</td><td>{{customer.username}}</td>
		<td>{{customer.password}}</td><td>{{customer.email}}</td>
		<td>{{customer.contactno}}</td>
		</tr>
		</table>
	  
      <form ng-submit="customerList.addCustomer()">
        <input type="text" ng-model="customerList.firstName"  size="30"
               placeholder="add first name">
			   <input type="text" ng-model="customerList.lastName"  size="30"
               placeholder="add last name">
        <input class="btn-primary" type="submit" value="add">
      </form>
    </div>
  </body>
</html>