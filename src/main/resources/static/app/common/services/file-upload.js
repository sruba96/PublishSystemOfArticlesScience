/**
 * Created by pawel on 22.05.16.
 */

app.service('fileUpload', ['$http', function ($http) {
    this.uploadFileToUrl = function (file, uploadUrl, desc) {
        var fd = new FormData();
        fd.append('file', file, desc);
        $http.post(uploadUrl, fd, {
            transformRequest: angular.identity,
            headers: {'Content-Type': undefined}
        })
            .success(function () {
            })
            .error(function () {
            });
    }
}]);