/**
 * Created by pawel on 22.05.16.
 */
app.controller('showFilesCtrl', function ($scope, $http) {

    var self = this;

    self.fileList = {};

    this.showFiles = function () {

        var ajax = $http.get('/showfiles');

        ajax.success(function (data) {
            if (data.result) {
                self.fileList = data.fileList;
            }
        });
    };
    self.showFiles();

    $scope.downloadFile = function (uniqueMark) {
        window.open('files/' + uniqueMark, '_blank');
    };

});