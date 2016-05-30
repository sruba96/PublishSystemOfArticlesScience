/**
 * Created by pawel on 28.05.16.
 */
/*app.controller('homeNovCtrl', function ($scope, $http, loginSessionService) {

 this.loginVisible = false;
 this.loggedAs;
 var self = this;
 $scope.updateSession = function (){

 // var ajax = $http.post('checkLoggedIn');
 //
 // ajax.success(function (data) {
 //     if (data.result) {
 //         console.log("you are logged");
 //         self.loginVisible = true;
 //         self.loggedAs = data.message;
 //     }
 // });
 // self.loggedAs = loginSessionService.getLogin;
 };

 $scope.updateSession();



 });*/

app.controller('homeNovCtrl',  function ($scope, $http) {

    $scope.invisible = false;
    $scope.invisibleLog = true;


    var self = $scope;
    var inv = $scope.invisible;
    var inv2 = $scope.invisibleLog;
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