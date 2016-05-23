/**
 * Created by pawel on 22.05.16.
 */
app.controller('addUserCtrl', function ($scope, $http) // serwis $http umożliwia zapytania ajax
{
    $scope.addUser = function () {

        var ajax = $http.post('addUser', this.user);
        this.user = {};

        ajax.success(function (data) {
            if (data.result) {
                $scope.registerForm = true;
            }
        });
    };
});