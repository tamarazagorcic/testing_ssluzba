var ModalPage = function() {};
var utils = require('../utils.js');

ModalPage.prototype = Object.create({}, {
    
successSaveAlert: {
        get: function() {
            return utils.waitForElementPresence(by.css("div.alert-success"), 10000);
        }
    },
   
closeSuccessBtn:{
        get:function(){
          browser.actions().mouseMove(utils.waitForElementPresence(by.css("div.alert-success")),1000).perform();
           return utils.waitForElementPresence(by.xpath("//span[@class='fa fa-times']"),1000).click();

       

       }
     },
	
    
successTitle: {
        get: function() {
            return utils.waitForElementPresence(by.xpath("//div [@class='ui-pnotify-title']"), 10000);
        }
    },
	
errorAlert: {
        get: function() {
            return utils.waitForElementPresence(by.css("div.alert-danger']"), 10000);
        }
    },
	
	
});

// Export klase
module.exports = ModalPage; 