var RegistarPodaci = function() {};
var utils = require('../utils.js');
var _ = require('lodash');

RegistarPodaci.prototype = Object.create({}, {

    tabPodaciZaRegistar: {
        get: function() {
            return utils.waitForElementPresence(by.xpath(".//li[2]// tab-heading"), 10000);
        }
    },

    bibliografija: {
        get: function() {
            return utils.waitForElementPresence(by.name("bibliography"), 10000);
        }
    },

    oblastIstrazivanja: {
        get: function() {
            return utils.waitForElementPresence(by.name("researchAreas"), 10000);
        }
    },

    medjunarodniID: {
        get: function() {
            return utils.waitForElementPresence(by.xpath(".//input[@ng-model='data.mntrn']"), 10000);
        }
    },

    napomena: {
        get: function() {
            return utils.waitForElementPresence(by.name("note"), 10000);
        },
        set: function(value) {
            this.napomena.clear();
            this.napomena.sendKeys(value);
        }
    },

    saveBtn: {
        get: function() {
            return utils.waitToBeClickable(by.xpath(".//button[@ng-click='addctrl.savePerson(Register)']"), 10000);
        }
    },

    cancelBtn: {
        get: function() {
            return utils.waitToBeClickable(by.xpath(".//button[@ng-click='reset()']"), 10000);
        }
    },

    unosPodatakaZaRegistar: {
        value: function(bibliografija, oblastIstrazivanja,medjunarodniID,napomena) {
            this.bibliografija = bibliografija;
            this.oblastIstrazivanja = oblastIstrazivanja;
            this.medjunarodniID = medjunarodniID;
            this.napomena = napomena;
            this.saveBtn.click();
        }
    }




    
});

// Export klase
module.exports = RegistarPodaci;