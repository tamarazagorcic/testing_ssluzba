var LoginPage = function() {};
var utils = require('../utils.js');


LoginPage.prototype = Object.create({}, {
    
   
    username: {
        get: function() {
            return utils.waitForElementPresence(by.id('username'), 10000);
        },
        set: function(value) {
            this.username.clear();
            this.username.sendKeys(value);
        }
    },
    usernameRequired: {
        get: function() {
            return utils.waitForElementPresence(by.xpath("//span [contains(text(), 'Korisničko ime obavezno')]"), 10000);
        }
    },
    
    
    password: {
        get: function() {
            return utils.waitForElementPresence(by.id('password'), 10000);
        },
        set: function(value) {
            this.password.clear();
            this.password.sendKeys(value);
        }
    },
    passwordRequired: {
        get: function() {
            return utils.waitForElementPresence(by.xpath("//span [contains(text(), 'Lozinka obavezna')]"), 10000);
        }
    },
    
    
    prijaviSeBtn: {
        get: function() {
            return utils.waitForElementPresence(by.buttonText('Prijavi se'), 10000);
        }
    },

    OdustaniBtn: {
        get: function() {
            return utils.waitForElementPresence(by.xpath("//button[@type='button']"), 10000);
        }
    },
    
    loginError: {
        get: function() {
            return utils.waitForElementPresence(by.xpath("//li[contains (text(),'Pogrešno korisničko ime ili lozinka!')]"), 10000);
        }
    },
    loginError1: {
        get: function() {
            return utils.waitForElementPresence(by.xpath("//span[contains (text(),'Problem sa logovanjem')]"), 10000);
        }
    },
    
  
    login: {
        value: function(usernameString, passwordString) {
            this.username = usernameString;
            this.password = passwordString;
            this.prijaviSeBtn.click();
        }
    }
});

// Export klase
module.exports = LoginPage;