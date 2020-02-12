var InstitucijeProjekti = function() {};
var utils = require('../utils.js');
var _ = require('lodash');

InstitucijeProjekti.prototype = Object.create({}, {

tabPodaciZaProjekte: {
        get: function() {
            return utils.waitToBeClickable(by.xpath(".//ul/li[3]//tab-heading"), 10000);
        }
},
    
racun: {
        get: function() {
            return utils.waitForElementPresence(by.name("account"), 10000);
        },
        set: function(value) {
            this.racun.clear();
            this.racun.sendKeys(value);
        }
},

racunFormatError: {
    get: function() {
        return utils.waitForElementPresence(by.xpath("//span[contains (text(),'Broj računa mora biti u formatu XXX-XXXXXXXXXXXXX-XX.')]"), 10000).getText();
    }
},

racuRequired: {
    get: function() {
        return utils.waitForElementPresence(by.xpath(".//span[contains (text(),'Morate uneti broj računa.')]"), 10000).getText();
    }
},
    
brojMinistarstva: {
        get: function() {
            return utils.waitForElementPresence(by.name("mntrID"), 10000);
        },
        set: function(value) {
            this.brojMinistarstva.clear();
            this.brojMinistarstva.sendKeys(value);
        }
},
   
medjbrojMinistarstva: {
        get: function() {
            return utils.waitForElementPresence(by.name("orcid"), 10000);
        },
            set: function(value) {
            this.medjbrojMinistarstva.clear();
            this.medjbrojMinistarstva.sendKeys(value);
            }
},

statusInstitucije: {
    get: function() {
        return utils.waitForElementPresence(by.name("institutionStatus"), 10000);
    },
    set: function(value) {
        
            this.statusInstitucije.element(by.cssContainingText('option', value)).click();
      
    }
},


statusRequred: {
    get: function() {
        return utils.waitForElementPresence(by.xpath("//span[contains (text(),'Morate izabrati status institucije.')]"), 10000).getText();
    }
},

oblastIstrazivanja: {
        get: function() {
            return utils.waitForElementPresence(by.id("s2id_autogen6"), 10000);
        },
            set: function(value) {
            this.oblastIstrazivanja.clear();
            this.oblastIstrazivanja.sendKeys(value);
            }
},

    	
cancelBtn: {
        get: function() {
            return utils.waitToBeClickable(by.xpath(".//button[@ng-click='reset(Project)']"), 10000);
        }
    },

	
saveBtn: {
        get: function() {
            return utils.waitToBeClickable(by.xpath(".//*[@ng-click='addctrl.saveInstitution(Project)']"), 10000);
        }
    },


	

   
	
	

unosPodatakaZaProjekte: {
        value: function(racun, medjbrojMinistarstva,statusInstitucije) {
            this.racun = racun;
            this.medjbrojMinistarstva = medjbrojMinistarstva;
            this.statusInstitucije = statusInstitucije;
            this.saveBtn.click();
        }
    }


});


//statusInstitucije: {
 //   get: function() {
 //       return utils.waitForElementPresence(by.name("institutionStatus"), 10000);
 //   },
 //   set: function(value) {
 //       var statusInstitucije = this.statusInstitucije;
 //       _.each(value, function(value) {
  //          statusInstitucije.element(by.cssContainingText('option', value)).click();
 //       });
 //   }
//},

// Export klase
module.exports = InstitucijeProjekti;