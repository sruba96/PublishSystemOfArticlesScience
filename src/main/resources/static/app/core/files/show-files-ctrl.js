/**
 * Created by pawel on 22.05.16.
 */
app.controller('showFilesCtrl', function ($scope, $http) {

    var self = this;

    self.filesList = {};

    this.showFiles = function () {

        var ajax = $http.get('/showfiles');

        ajax.success(function (data) {
            if (data.result) {
                self.filesList = data.fileList;
            }
        });
    };
    self.showFiles();

    this.downloadFile = function (uniqueMark) {
        console.log("here");
        window.open('files/' + uniqueMark, 'downloadFrame');
    };

});