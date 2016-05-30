/**
 * Created by pawel on 22.05.16.
 */
app.controller('addUserCtrl', function ($scope, $http) // serwis $http umożliwia zapytania ajax
{
    this.user = {};

    $scope.addUser = function () {


        if (this.user.password == this.user.retype) {

            var ajax = $http.post('addUser', this.user);

            ajax.success(function (data) {
                if (data.result) {


                }
            });
        }
    };
});