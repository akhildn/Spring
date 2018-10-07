
angular.module("springRest.login", ["ngRoute"])
.config(function($routeProvider) {
    $routeProvider
    .when("/home", {
        templateUrl : "login/home.html"
    })
    .when("/login", {
        templateUrl : "login/login.html"
    })
    .when("/welcome", {
        templateUrl : "login/welcome.html"
    });    
})

.controller('LoginController', ['$location','$http', function($location, $http) {
    var login = this;
       
    
    login.validate = function(){
    	console.log(login.user);
    	$http.post("http://localhost:8090/SpringRest/login", login.user).then(function(response){
    	if(response.data == true){    		
    		login.success = true;
    		$location.path('/welcome');    		
    	};
    })
    }
    
    login.logout = function(){    	
    	$http.get("http://localhost:8090/SpringRest/logout").then(function(response){
    	if(response.data == true){    		
    		login.success = false;    		
    		login.user.username='';
    		login.user.password='';
    		login.user.userType='admin';
    		$location.path('/login');    		
    	};
    })
    }
  }]);