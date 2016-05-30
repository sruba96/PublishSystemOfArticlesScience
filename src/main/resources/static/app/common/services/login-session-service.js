/**
 * Created by pawel on 28.05.16.
 */
/*app.service('loginSessionService', ['$http' , function () {

    var isLogged = false;
    var login = {};


    var setLogin = function (login) {
        this.login = login;
        this.isLogged = true;
    };

    var getLogin = function () {

        console.log("service is working");
        if (isLogged)
            return this.login
    };

    var checkIsLogged = function () {
        return isLogged;
    }

    var outLogin = function () {
        login = {};
        isLogged = false;
    };

    var updateSession = function (){

        var ajax = $http.post('checkLoggedIn');

        ajax.success(function (data) {
            if (data.result) {
                console.log("you are logged :)");
                // self.loginVisible = true;
                login = data.message;
                console.log(login);
            }
        });

    };

    return {
        setLogin: setLogin,
        outLogin: outLogin,
        getLogin: getLogin,
        checkIsLogged: checkIsLogged,
        updateSession: updateSession
    };


}]);*/


app.service('loginSessionService', ['$http', function ($http) {


    var self = this;
    var logged = false;

    this.login = {};




    this.updateSession = function () {
        var ajax = $http.post('checkLoggedIn');

        console.log("checking...");

        ajax.success(function (data) {
            if (data.result) {
                console.log("you are logged :)");
                // self.loginVisible = true;
                self.logged = true;
                login = data.message;
                console.log(login);
            }
        });
    }

    this.getLogged = function (){

        return self.logged;
    };
}]);