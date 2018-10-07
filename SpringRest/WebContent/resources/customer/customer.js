
angular.module("springRest.customer", ["ngRoute"])
.config(function($routeProvider) {
    $routeProvider
    .when("/customers", {
        templateUrl : "customer/customers.html"
    })
    .when("/addCustomer", {
        templateUrl : "customer/addCustomer.html"
    })
    .when("/editCustomer", {
        templateUrl : "customer/editCustomer.html"
    });    
})

.controller('CustomerController', ['$location','$http', function($location, $http) {
    var customer = this;
       
    
    customer.getCustomers = function(){
    	
    	$http.get("http://localhost:8090/SpringRest/customers").then(function(response){
    		customer.customers = response.data;    		
    		$location.path('/customers');    		
    	
    })
    }
    
    customer.addCustomer = function(){    	
    	$http.post("http://localhost:8090/SpringRest/addCustomer", customer.customer).then(function(response){
    		customer.getCustomers();     	
    })
    }
    
    customer.editCustomer = function(){    	
    	$http.get("http://localhost:8090/SpringRest/customer/{id}").then(function(response){
    	customer.customer = response.data;
    		$location.path('/editCustomer');    		
    	
    })
    }
  }]);