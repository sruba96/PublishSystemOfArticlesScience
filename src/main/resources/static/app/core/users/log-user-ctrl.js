/**
 * Created by pawel on 22.05.16.
 */
app.controller('logUserCtrl', function ($scope, $http)
{
    $scope.logUser = function () {

        var ajax = $http.post('addUser', this.user);
        this.user = {};

        ajax.success(function (data) {
            if (data.result) {
                $scope.registerForm = true;
            }
        });
        console.log("Here will be login");
    };
});