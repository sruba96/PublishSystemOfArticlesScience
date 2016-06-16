/**
 * Created by pawel on 22.05.16.
 */
app.controller('showUsersCtrl', function ($scope, $http) {

    var self = this;

    self.users = {};

    $scope.showUsers = function () {
        var ajax = $http.get('showUsers');

        ajax.success(function (data) {
            if (data.result)
                self.users = data.list;
        });
    };

    $scope.showUsers();

    this.selectToInvite = function (id) {
        console.log("id is:"+id);
        var ajax = $http.post('inviteUser',id);

        ajax.success(function (data) {
            if (data.result)
                console.log("invited user");
        });
    };

});