var MenuPage = function() {};
var utils = require('../utils.js');

MenuPage.prototype = Object.create({}, {
    
 
		

ikonicaZaProsirenje: {
        get: function() {
            return utils.waitToBeClickable(by.css("a.sidebar-toggle"), 10000);
        }
    },


languages: {
        get: function() {
            return utils.waitToBeClickable(by.css("button.btn-default.dropdown-toggle"));
        }
    },
	
	
srpskiLatinica: {
        get: function() {
            return utils.waitToBeClickable(by.xpath("//a [@translate='BUTTON_LANG_SR_LAT']"), 20000);
        }
    },
	
	
srpskiCirilica: {
        get: function() {
            return utils.waitToBeClickable(by.xpath("//a [@translate='BUTTON_LANG_SR_CYR']"), 10000);
        }
    },
	
	
engleski: {
        get: function() {
            return utils.waitToBeClickable(by.xpath("//a [@translate='BUTTON_LANG_EN']"), 10000);
        }
    },



dropdownmenu: {
        get: function() {
            return utils.waitToBeClickable(by.xpath("//*[@id='main-page']/header/nav/div/ul[2]/li"), 10000);
        }
    },
	

image: {
        get: function() {
            return utils.waitForElementPresence(by.css("img-circle"), 10000);
        }
    },


 userManual: {
        get: function() {
            return utils.waitForElementPresence(by.xpath("//span[@translate='USER_MANUAL']"), 10000);
        }
    },
	

 contact: {
        get: function() {
            return utils.waitToBeClickable(by.xpath("//span[@translate='USER_SUPPORT']"), 10000);
        }
    },

 changePassword: {
        get: function() {
            return utils.waitToBeClickable(by.xpath("//span[@translate='CHANGE_PASSWORD']"), 10000);
        }
    },
    
logoutBtn: {
        get: function() {
            return utils.waitForElementPresence(by.css("span[translate='LOGOUT']"), 10000);
        }
    },
   


institucijaBtn: {
        get: function() {
            return utils.waitToBeClickable(by.xpath("//a [@href='#/admin-institution/']"), 10000);
        }
    },

istrazivaciBtn: {
        get: function() {
            return utils.waitToBeClickable(by.xpath("//a [@href='#/persons']"), 10000);
        }
    }

	
	
});

// Export klase
module.exports = MenuPage;