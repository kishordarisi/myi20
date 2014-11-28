var Myi20 = angular.module("Myi20", ['RegistrationService','ngCookies']);
Myi20.controller('UserController', function($scope,$location,$window,$cookieStore, registerService) {
  
  $scope.getUserDetails=function (){
      
      registerService.getUserDetails($cookieStore.get('Myi20.userName')).success(function(data) {
        $scope.userData=data;
        
    }).error(function(err){
        alert(err);
    });
      
  };
  
  $scope.applyNow=function (){
      
      
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
  
  $scope.saveDocuments=function (){
      var fd = new FormData();
      fd.append('file0', $scope.ssc);
      fd.append('file1', $scope.inter);
      fd.append('file2', $scope.degree);
      fd.append('file3', $scope.course1);
      fd.append('file4', $scope.course2);
      registerService.uploadDocuments(fd).success(
                function(data) {
                    console.log("image path after image changed : " + data);
                    $scope.imagePath1 = data;
//                    $scope.userData.photoURL=$scope.imagePath1;
//                    registerService.updateUser($scope.userData).success(
//                function(data1) {
//                    console.log("user updated : ");
//                    
//                });
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
                        modelSetter(scope, element[0].files[files.length-1]);
                    });
                });
            }
        };
    }]);
Myi20.directive('fileModel1', ['$parse', function($parse) {
        return {
            restrict: 'A',
            link: function(scope, element, attrs) {
                var model = $parse(attrs.fileModel1);
                var modelSetter = model.assign;

                element.bind('change', function() {
                    scope.$apply(function() {
                        modelSetter(scope, element[0].files[files.length-10]);
                    });
                });
            }
        };
    }]);
Myi20.directive('fileModel2', ['$parse', function($parse) {
        return {
            restrict: 'A',
            link: function(scope, element, attrs) {
                var model = $parse(attrs.fileModel2);
                var modelSetter = model.assign;

                element.bind('change', function() {
                    scope.$apply(function() {
                        modelSetter(scope, element[0].files[files.length-1]);
                    });
                });
            }
        };
    }]);
Myi20.directive('fileModel3', ['$parse', function($parse) {
        return {
            restrict: 'A',
            link: function(scope, element, attrs) {
                var model = $parse(attrs.fileModel3);
                var modelSetter = model.assign;

                element.bind('change', function() {
                    scope.$apply(function() {
                        modelSetter(scope, element[0].files[files.length-1]);
                    });
                });
            }
        };
    }]);
Myi20.directive('fileModel4', ['$parse', function($parse) {
        return {
            restrict: 'A',
            link: function(scope, element, attrs) {
                var model = $parse(attrs.fileModel4);
                var modelSetter = model.assign;

                element.bind('change', function() {
                    scope.$apply(function() {
                        modelSetter(scope, element[0].files[files.length-1]);
                    });
                });
            }
        };
    }]);
Myi20.directive('fileModel5', ['$parse', function($parse) {
        return {
            restrict: 'A',
            link: function(scope, element, attrs) {
                var model = $parse(attrs.fileModel5);
                var modelSetter = model.assign;

                element.bind('change', function() {
                    scope.$apply(function() {
                        modelSetter(scope, element[0].files[files.length-1]);
                    });
                });
            }
        };
    }]);
