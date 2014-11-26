var Myi20 = angular.module("Myi20", ['RegistrationService','ngCookies']);
Myi20.controller('UserController', function($scope,$location,$window,$cookieStore, registerService) {
  
  $scope.getUserDetails=function (){
      
      registerService.getUserDetails($cookieStore.get('Myi20.userName')).success(function(data) {
        alert("success...");
        $scope.userData=data;
        
    }).error(function(err){
        alert(err);
    });
      
  };
  $scope.logout=function (){
      alert("logging out....");
      $cookieStore.put('Myi20.userName',null);
      $cookieStore.put('Myi20.crypt',null);
      $window.location="index.html";
  };
});

Myi20.config(function($routeProvider) {
    $routeProvider.when('/', {
        templateUrl: 'index.html',
        controller: 'RegistrationContoller'
    });
});
