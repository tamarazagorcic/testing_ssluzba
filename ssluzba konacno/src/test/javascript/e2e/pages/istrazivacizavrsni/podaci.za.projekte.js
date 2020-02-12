var ProjektiPodaci = function() {};
var utils = require('../utils.js');
var _ = require('lodash');

ProjektiPodaci.prototype = Object.create({}, {

    tabPodaciZaProjekte: {
        get: function() {
            return utils.waitForElementPresence(by.xpath(".//li[3]//tab-heading"), 10000);
        }
    },

    tipOsobe: {
        get: function() {
            return utils.waitForElementPresence(by.xpath(".//select[@name='personType']"), 10000);
        },
        set: function(value) {
            var tipOsobe = this.tipOsobe;
            _.each(value, function(value) {
                tipOsobe.element(by.cssContainingText('option', value)).click();
            });
        }
    },

    obracunskoZvanje: {
        get: function() {
            return utils.waitForElementPresence(by.xpath(".//select[@name='personPosition']"), 10000);
        },
        set: function(value) {
            var obracunskoZvanje = this.obracunskoZvanje;
            _.each(value, function(value) {
                obracunskoZvanje.element(by.cssContainingText('option', value)).click();
            });
        }
    },


    kategorija: {
        get: function() {
            return utils.waitForElementPresence(by.xpath(".//div[@title='Kategorije istraživača']//input"), 10000);
        },
        set: function(value) {
            this.kategorija.clear();
            this.kategorija.sendKeys(value);
        }
    },

    saveBtn: {
        get: function() {
            return utils.waitToBeClickable(by.xpath(".//button[@ng-click='addctrl.savePerson(Project)']"), 10000);
        }
    },

    cancelBtn: {
        get: function() {
            return utils.waitToBeClickable(by.xpath(".//button[@ng-click='reset()']"), 10000);
        }
    },

    unosPodatakaZaProjekte: {
        value: function(tipOsobe, obracunskoZvanje,kategorija) {
            this.tipOsobe = tipOsobe;
            this.obracunskoZvanje = obracunskoZvanje;
            this.kategorija = kategorija;
            this.saveBtn.click();
        }
    }

    
});

// Export klase
module.exports = ProjektiPodaci;