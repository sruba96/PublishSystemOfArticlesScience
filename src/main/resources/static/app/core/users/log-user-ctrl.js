/**
 * Created by pawel on 22.05.16.
 */
app.controller('logUserCtrl', function ($scope, $http)
{
    this.user = {};
    $scope.logUser = function () {

        console.log(this.user);
        var ajax = $http.post('logging', this.user);

        ajax.success(function (data) {
            if (data.result) {
                console.log("good you are log in");
            }
        });
    };
});