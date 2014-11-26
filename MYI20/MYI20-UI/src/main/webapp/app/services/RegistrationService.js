 'use strict';
/* Resident Details service */
angular.module('RegistrationService', []).
  
factory('registerService', function($http,$cookieStore) {
   return {
     registerUser:function(user){
         alert(JSON.stringify(user));
         return $http({
             method:'POST',
             url:'/security-ws/secure/registerUser',
             data:user
         });
     },
     
     login: function(hash) {
                    return $http({
                        method: 'POST',
                        url: '/security-ws/secure/login',
                        headers: {
                            'Authorization': hash
                        },
                        async: false
                    });
                }
                ,
     
     getUserDetails: function(userName) {
                    return $http({
                        method: 'GET',
                        url: '/security-ws/secure/getUser',
                        params:{
                            userName:userName
                        },
                        headers: {
                            'Authorization': $cookieStore.get('Myi20.crypt')
                        },
                        async: false
                    });
                }
                
   };
   
}); 
