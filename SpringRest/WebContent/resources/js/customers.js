angular.module('customerApp', [])
  .controller('CustomerController', ['$http', function($http) {
    var customerList = this;
	$http.get("http://localhost:8090/SpringRest/customers").then(function(response){
    	customerList.customers = response.data;    	
    });
    
  }]
    
  );