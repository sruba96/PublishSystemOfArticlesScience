/**
 * Created by pawel on 30.05.16.
 */
app.controller('selectProjectCtrl', function ($scope, $http) {

    var self = this;

    self.projects = {};

    $scope.showUsers = function () {
        var ajax = $http.post('showProject');

        ajax.success(function (data) {
            if (data.result)
                self.projects = data.list;
        });
    };

    $scope.showUsers();

    this.select = function (id) {
        console.log("id is:"+id);
        var ajax = $http.post('chooseProject',id);

        ajax.success(function (data) {
            if (data.result)
                console.log("Assigned");
        });
    };


});