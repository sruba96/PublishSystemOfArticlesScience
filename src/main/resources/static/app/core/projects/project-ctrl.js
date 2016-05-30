/**
 * Created by pawel on 30.05.16.
 */
app.controller('project', function ($scope, $http) // serwis $http umożliwia zapytania ajax
{
    // this.user = {};
    $scope.show = false;

    var self = $scope;
    $scope.change = function () {
       self.show = !self.show;
    };
});