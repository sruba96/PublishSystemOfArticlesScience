/**
 * Created by pawel on 22.05.16.
 */
app.controller('addUserCtrl', function ($scope, $http) // serwis $http umożliwia zapytania ajax
{



    this.user = {};

    $scope.addUser = function () {

        // this.user = {};
        console.log(this.user);
        console.log($scope.user);

        var ajax = $http.post('addUser', this.user);
        
        console.log("function is working");

        ajax.success(function (data) {
            if (data.result) {
                console.log("Response is working");

            }
        });
    };
});