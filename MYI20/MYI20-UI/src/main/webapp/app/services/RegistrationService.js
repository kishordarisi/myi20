'use strict';
/* Resident Details service */
angular.module('RegistrationService', []).
        factory('registerService', function($http, $cookieStore) {
            return {
                registerUser: function(user) {
                    alert(JSON.stringify(user));
                    return $http({
                        method: 'POST',
                        url: '/security-ws/employee/registerUser',
                        data: user
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
                        url: '/security-ws/employee/getUser',
                        params: {
                            userName: userName
                        },
                        headers: {
                            'Authorization': $cookieStore.get('Myi20.crypt')
                        },
                        async: false
                    });
                },
                uploadImage: function(image) {
                    var fd = new FormData();
                    fd.append('file', image);
                    console.log("image in uploadImage service :" + JSON.stringify(fd));
                    return $http({
                        method: 'POST',
                        url: '/security-ws/employee/uploadLogo',
                        data: fd,
                        transformRequest: angular.identity,
                        headers: {
                            'Authorization': $cookieStore.get('Myi20.crypt'),
                            'Content-Type': undefined
                        }
                    }).success(function(data, status, headers, config) {
                        console.log('image uploaded.Path is: ' + data);

                        return data;
                    }).error(function(data, status, headers, config) {
                        return data;
                    });
                },
                getProfilePic: function(imagePath) {
                    return $http({
                        method: 'GET',
                        url: '/security-ws/employee/userLogo',
                        params: {
                            "imagePath": imagePath
                        },
                        headers: {
                            'Authorization': $cookieStore.get('Myi20.crypt')
                        }
                    }).success(function(data) {
                                return data;
                            }).error(function(data) {
                        return data;
                    });
                },
                updateUser: function(user) {
                    return $http({
                        method: 'POST',
                        url: '/security-ws/employee/updateUser',
                        data: user,
                        headers: {
                            'Authorization': $cookieStore.get('Myi20.crypt')
                        }
                    });
                },
                 uploadDocuments: function(files) {
                    console.log("image in uploadImage service :" + JSON.stringify(files));
                    return $http({
                        method: 'POST',
                        url: '/security-ws/employee/uploadDocs/'+$cookieStore.get('Myi20.userName'),
                        data: files,
                        transformRequest: angular.identity,
                        headers: {
                            'Authorization': $cookieStore.get('Myi20.crypt'),
                            'Content-Type': false
                        }
                    }).success(function(data, status, headers, config) {
                        console.log('image uploaded.Path is: ' + data);

                        return data;
                    }).error(function(data, status, headers, config) {
                        return data;
                    });
                },
                applyNow: function(jobdata) {
                    alert(JSON.stringify(jobdata));
                    return $http({
                        method: 'POST',
                        url: '/security-ws/employee/'+$cookieStore.get('Myi20.userName')+'/applyNow',
                        data: jobdata,
                        headers: {
                            'Authorization': $cookieStore.get('Myi20.crypt'),
                        }
                    });
                }

            };

        });