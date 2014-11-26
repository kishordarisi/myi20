var Myi20 = angular.module("Myi20", ['RegistrationService','ngCookies']);
Myi20.controller('UserController', function($scope,$location,$window,$cookieStore, registerService) {
  
  $scope.getUserDetails=function (){
      
      registerService.getUserDetails($cookieStore.get('Myi20.userName')).success(function(data) {
        $scope.userData=data;
        
    }).error(function(err){
        alert(err);
    });
      
  };
  $scope.logout=function (){
      $cookieStore.put('Myi20.userName',null);
      $cookieStore.put('Myi20.crypt',null);
      $window.location="index.html";
  };
  $scope.updateProfile=function (){
      registerService.uploadImage($scope.imagePath).success(
                function(data) {
                    console.log("image path after image changed : " + data);
                    $scope.imagePath1 = data;
                    $scope.userData.photoURL=$scope.imagePath1;
                    registerService.updateUser($scope.userData).success(
                function(data1) {
                    console.log("user updated : ");
                    
                });
                });
  };
  
});

Myi20.config(function($routeProvider) {
    $routeProvider.when('/', {
        templateUrl: 'index.html',
        controller: 'RegistrationContoller'
    });
});

Myi20.directive('fileModel', ['$parse', function($parse) {
        return {
            restrict: 'A',
            link: function(scope, element, attrs) {
                var model = $parse(attrs.fileModel);
                var modelSetter = model.assign;

                element.bind('change', function() {
                    scope.$apply(function() {
                        modelSetter(scope, element[0].files[0]);
                    });
                });
            }
        };
    }]);
