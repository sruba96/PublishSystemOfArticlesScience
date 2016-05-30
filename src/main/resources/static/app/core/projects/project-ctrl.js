/**
 * Created by pawel on 30.05.16.
 */
app.controller('project', function ($scope, $http) // serwis $http umożliwia zapytania ajax
{
    $scope.label = "New project";
    var selfS = $scope;
    var self = this;
    this.show = true;
    this.data = {};

    this.change = function () {
        console.log(self.show);

        self.show = !self.show;

        if(!self.show)
            selfS.label = "hide";
        else
            selfS.label = "New project";
    };

    this.addProject = function () {


        console.log(this.projectData);
        var ajax = $http.post('addProject', this.data);

        ajax.success(function (data) {
            if (data.result) {
                this.change();

            }
        });
    };

});