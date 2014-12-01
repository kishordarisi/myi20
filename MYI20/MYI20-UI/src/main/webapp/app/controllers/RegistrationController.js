var Myi20 = angular.module("Myi20", ['RegistrationService','ngCookies']);
Myi20.controller('RegistrationContoller', function($scope,$location,$window,$cookieStore, registerService) {
  
  $scope.registerUser1=function (user){
      $scope.regUser=user;
      registerService.registerUser(user).success(function(data) {
          $('#successRegistration').modal({
              keyboard: false
              });
    }).error(function(err){
        alert(err);
    });
      
  };
  
  $scope.redirectToHomePage=function (){
      $window.location="index.html";
  };
  $scope.login=function (){
      var crypted=$scope.crypt();
      registerService.login(crypted).success(function(data) {
        $cookieStore.put('Myi20.userName',data.userName);
        $cookieStore.put('Myi20.crypt',crypted);
        $window.location="ds-profile.html";
    }).error(function(err){
        alert(err);
    });
      
  };
  
  $scope.crypt = function() {
        return "Basic " + window.btoa($scope.logUserName + ':' + $scope.userPassword);
    };
});

Myi20.config(function($routeProvider) {
    $routeProvider.when('/', {
        templateUrl: 'index.html',
        controller: 'RegistrationContoller'
    });
});
