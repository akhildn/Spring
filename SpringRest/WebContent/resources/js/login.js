angular.module('serviceDesk', [])
  .controller('LoginController', ['$http', function($http) {
    var login = this;
	$http.get("http://localhost:8090/SpringRest/customers").then(function(response){
    	customerList.customers = response.data;
    	console.log('data'+customers);
    });
    /*customerList.customers = [
      {firstName:'Mark', lastName:'Smith'},
      {firstName:'Steve', lastName:'Randle'},
	  {firstName:'Glen', lastName:'Garry'},
	  {firstName:'Maurizio', lastName:'Bonzani'},
	  {firstName:'Tom', lastName:'Miller'}];*/
 
    customerList.addCustomer = function() {
      customerList.customers.push({firstName:customerList.firstName, lastName:customerList.lastName});
      customerList.firstName = '';
	  customerList.lastName = '';
    }
  }]
    
  );