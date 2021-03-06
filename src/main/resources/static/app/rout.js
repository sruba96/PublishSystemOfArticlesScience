/**
 * Created by pawel on 22.05.16.
 */
app.config(function ($routeProvider) {
    $routeProvider
        .when('/addUserForm',
            {
                templateUrl: "app/core/users/add-user.tpl.html",
                controller: "addUserCtrl"
            })
        .when('/logUserForm',
            {
                templateUrl: "app/core/users/log-user.tpl.html",
                controller: "logUserCtrl"
            })
        .when('/showUser',
            {
                templateUrl: "app/core/users/show-users.tpl.html",
                controller: "showUsersCtrl"
            })
        .when('/showFiles',
            {
                templateUrl: "app/core/files/show-files.tpl.html",
                controller: "showFilesCtrl"
            })
        .when('/uploadFile',
            {
                templateUrl: "app/core/files/upload-file.tpl.html",
                controller: "uploadFileCtrl"
            })
        .when('/',
            {
                templateUrl: "app/core/default/default.html"
            })
        .when('/logout',
            {
                templateUrl: "app/core/default/default.html"
            })
        .when('/project',
            {
                templateUrl: "app/core/projects/project.tpl.html",
                controller: "project"
            })
        .when('/selectProject',
            {
                templateUrl: "app/core/projects/select-project.tpl.html",
                controller: "selectProjectCtrl"
            })
        .when('/myProfile',
            {
                templateUrl: "app/core/default/default.html"
            })
        .otherwise
        ({
            template: "Error 404!"
        })
});