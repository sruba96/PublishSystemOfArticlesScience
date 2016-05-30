/**
 * Created by pawel on 22.05.16.
 */
(function () {
    "use strict";
    angular.module("app")
        .controller('logUserCtrl', function ($scope, $http) {
            this.user = {};
            $scope.logUser = function () {

                console.log(this.user);
                var ajax = $http.post('logging', this.user);

                ajax.success(function (data) {
                    if (data.result) {
                        console.log("good you are log in");
                        location.reload("#/");
                    }

                    $scope.checkSession();
                    console.log(self);
                });


            };

            // other controller
            $scope.invisible = false;
            $scope.invisibleLog = true;


            var self = $scope;

            $scope.login = "";

            $scope.checkSession = function () {

                var ajax = $http.post('checkLoggedIn');

                console.log("checking...");

                ajax.success(function (data) {
                    if (data.result) {
                        console.log("you are logged :)");
                        self.login = data.message;
                        self.logged = true;
                        self.invisible = true;
                        self.invisibleLog = false;

                    }
                });

            };
            $scope.checkSession();
        });
})();