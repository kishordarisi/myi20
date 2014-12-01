var Myi20 = angular.module("Myi20", ['RegistrationService','ngCookies']);
Myi20.controller('UserController', function($scope,$location,$route,$http,$window,$cookieStore, registerService) {
  
  
  $scope.getUserDetails=function (){
      
      registerService.getUserDetails($cookieStore.get('Myi20.userName')).success(function(data) {
        $scope.userData=data;
        $scope.appjob=$scope.userData.applyNowDTO;
//        $scope.userData.photoURL="D:/Camera/2012-11-04 20.26.16.jpg";
        if($scope.userData.photoURL!==null){
            registerService.getProfilePic($scope.userData.photoURL).success(function (result){
               $scope.photoData="data:image/"+result.fileExtension+";base64," + result.image;
              // $("#userImage").attr('src',$scope.photoData);
            }).error(function(){
                
            });
        }
    }).error(function(err){
        alert(err);
    });
      
  };
  
  $scope.goToHomePage=function (){
      $window.location="ds-profile.html";
  };
  
    
  $scope.logout=function (){
      $cookieStore.put('Myi20.userName',null);
      $cookieStore.put('Myi20.crypt',null);
      $window.location="index.html";
  };
  $scope.updateProfile=function (){
      if($scope.imagePath!==null && $scope.imagePath!==undefined){
      registerService.uploadImage($scope.imagePath).success(
                function(data) {
                    console.log("image path after image changed : " + data);
                    $scope.imagePath1 = data;
                    $scope.userData.photoURL=$scope.imagePath1;
                    registerService.updateUser($scope.userData).success(
                function(result) {
                    $scope.photoData="data:image/"+result.fileExtension+";base64," + result.image;
                     $('#updateSuccess').modal({
              keyboard: false
              });
                });
                });
            }
            else{
                registerService.updateUser($scope.userData).success(
                function(result) {
                    $scope.photoData="data:image/"+result.fileExtension+";base64," + result.image;
                     $('#updateSuccess').modal({
              keyboard: false
              });
                });
            }
  };
  $scope.reloadPage=function (){
      $route.reload();
  };
  $scope.appjob={};
  $scope.appjob.ssc='';
  $scope.appjob.inter='';
  $scope.appjob.degree='';
  $scope.appjob.course1='';
  $scope.appjob.course2='';
  $scope.appjob.photo='';
  $scope.uploadSSc=function(){
      if($scope.ssc!==undefined && $scope.ssc!==null){
            var formData=new FormData();
          formData.append('file',$scope.ssc);
          //      alert(JSON.stringify(fd));
      registerService.uploadDocuments(formData).success(
                function(data) {
                    console.log("image path after image changed : " + data);
                    $scope.appjob.ssc=data;
                    $scope.uploadInter();
                });
            }else{
                $scope.uploadInter();
            }
      
  };
  $scope.uploadInter=function(){
      if($scope.inter!==undefined && $scope.inter!==null){
      var formData=new FormData();
          formData.append('file',$scope.inter);
          //      alert(JSON.stringify(fd));
      registerService.uploadDocuments(formData).success(
                function(data) {
                    console.log("image path after image changed : " + data);
                    $scope.appjob.inter=data;
                    $scope.uploadDegree();
                });
            }else{
                $scope.uploadDegree();
            }
  };
  $scope.uploadDegree=function(){
      if($scope.degree!==undefined && $scope.degree!==null){
      var formData=new FormData();
          formData.append('file',$scope.degree);
          //      alert(JSON.stringify(fd));
      registerService.uploadDocuments(formData).success(
                function(data) {
                    console.log("image path after image changed : " + data);
                    $scope.appjob.degree=data;
                    $scope.uploadCourse1();
                });
            }else{
                $scope.uploadCourse1();
            }
  };
  $scope.uploadCourse1=function(){
      if($scope.course1!==undefined && $scope.course1!==null){
      var formData=new FormData();
          formData.append('file',$scope.course1);
          //      alert(JSON.stringify(fd));
      registerService.uploadDocuments(formData).success(
                function(data) {
                    console.log("image path after image changed : " + data);
                    $scope.appjob.course1=data;
                    $scope.uploadCourse2();
                });
            }else{
                $scope.uploadCourse2();
            }
  };
  $scope.uploadCourse2=function(){
      if($scope.course2!==undefined && $scope.course2!==null){
      var formData=new FormData();
          formData.append('file',$scope.course2);
          //      alert(JSON.stringify(fd));
      registerService.uploadDocuments(formData).success(
                function(data) {
                    console.log("image path after image changed : " + data);
                    $scope.appjob.course2=data;
                    $scope.uploadPhoto();
                });
            }else{
                $scope.uploadPhoto();
            }
  };
  
  $scope.downLoad = function(fileLocation) {
        location.href = "/security-ws/employee/download_file?filePath=" + fileLocation;
    };
  $scope.uploadPhoto=function(){
      if($scope.photo!==undefined && $scope.photo!==null){
      var formData=new FormData();
          formData.append('file',$scope.photo);
          //      alert(JSON.stringify(fd));
      registerService.uploadDocuments(formData).success(
                function(data) {
                    console.log("image path after image changed : " + data);
                    $scope.appjob.photo=data;
                    $scope.saveAppliedJob();
                });
            }else{
                $scope.saveAppliedJob();
            }
  };
  $scope.saveAppliedJob=function (){
      registerService.applyNow($scope.appjob).success(
                function(data1) {
                    alert("success");
                    $window.location="ds-profile.html";
                    
                });
  };
  
  
  $scope.saveDocuments=function (){
      
      $scope.uploadSSc();
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
Myi20.directive('fileModel1', ['$parse', function($parse) {
        return {
            restrict: 'A',
            link: function(scope, element, attrs) {
                var model = $parse(attrs.fileModel1);
                var modelSetter = model.assign;

                element.bind('change', function() {
                    scope.$apply(function() {
                        modelSetter(scope, element[0].files[0]);
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
                        modelSetter(scope, element[0].files[0]);
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
                        modelSetter(scope, element[0].files[0]);
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
                        modelSetter(scope, element[0].files[0]);
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
                        modelSetter(scope, element[0].files[0]);
                    });
                });
            }
        };
    }]);
