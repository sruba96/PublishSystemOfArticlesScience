/**
 * Created by pawel on 28.05.16.
 */
app.service('loginSessionService', function() {

    var isLogged = false;;
    var login = {};


    var setLogin = function(login) {
       this.login = login;
        this.isLogged = true;
    };

    var outLogin = function(){
        login = {};
        isLogged = false;
    };

    return {
        setLogin: setLogin,
        outLogin: outLogin
    };


});