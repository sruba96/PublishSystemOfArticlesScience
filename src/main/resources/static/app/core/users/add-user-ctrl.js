/**
 * Created by pawel on 22.05.16.
 */
app.controller('addUserCtrl', function ($scope, $http) // serwis $http umożliwia zapytania ajax
{

    var self = this;

    this.user = {};

    $scope.addUser = function () {

        // this.user = {};
        var ajax = $http.post('addUser', this.user);
        
        //*
        // check something*/
        console.log("function is working");

        ajax.success(function (data) {
            if (data.result) {
                console.log("Response is working");

                $scope.registerForm = true;
            }
        });
    };
});