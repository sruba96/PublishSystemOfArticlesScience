/**
 * Created by pawel on 22.05.16.
 */
app.controller('uploadFileCtrl', ['$scope', 'fileUpload', function ($scope, fileUpload) {

   

    $scope.uploadFile = function () {
        var file = $scope.myFile;
        var desc = $scope.desc;

        console.log(desc);
        console.log('file is ');
        console.dir(file);
        var uploadUrl = "/uploadfile";
        fileUpload.uploadFileToUrl(file, uploadUrl, desc);
    };

}]);