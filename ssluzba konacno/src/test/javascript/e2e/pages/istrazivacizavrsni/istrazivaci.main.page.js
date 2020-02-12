var IstrazivaciRow = require('./istrazivaci.row.page.js');

var IstrazivaciMain = function() {};
var utils = require('../utils.js');
var _ = require('lodash');

IstrazivaciMain.prototype = Object.create({}, {



    pretragaIstrazivaca: {
        get: function() {
            return utils.waitForElementPresence(by.xpath(".//input[@placeholder='Pretraži istraživače']"), 10000);
        },
        set: function(value) {
            this.pretragaIstrazivaca.clear();
            this.pretragaIstrazivaca.sendKeys(value);
        }
    },

    pretragaPrekratka: {
        get: function() {
            return utils.waitForElementPresence(by.xpath("//span[contains (text(),'Search query is too short')]"), 10000).getText();
        }
    },

    searchDropdown: {
        get: function() {
            return utils.waitForElementPresence(by.xpath(".//ul [@class='dropdown-menu ng-isolate-scope"), 10000);
        },
        
    },


    
    izborIzPretrageIstrazivaca: {
        get: function() {
            return this.searchDropdown.all(by.xpath("./li/a"))
            .map(function(element){
                return element.getText();

            })
        }
    },

    getSearchResultsLength :{
		get: function(){
			return this.izborIzPretrageIstrazivaca
			.then(function(texts) {
				return texts.length;
			});
		}
	},
    trazeniResultat: {
		value: function(value){
			return utils.waitForElementPresence(by.xpath(".//li/a[contains(text(),\"" + value+ "\")]/.."),10000);
		}
	},

    pretraga0Matches: {
        get: function() {
            return utils.waitForElementPresence(by.xpath("//span[contains (text(),'0 results found')]"), 10000).getText();
        }
    },
    //izborIzPretrageIstrazivaca: {
    //    get: function() {
    //        return utils.waitForElementPresence(by.xpath(".//li[@ng-repeat='match in matches track by $index']/a"), 10000);
    //    }
   // },






    istrazivaciTabela: {
        get: function() {
            return element(by.xpath("//table"));
        }
    },
    
    tableRows: {
        get: function() {
            return element.all(by.repeater('person in ctrl.persons'));
        }
    },
    
    getIstrazivaciRowByNameAndSurname: {
        value: function(ime) {
            var el = this.istrazivaciTabela.element(by.xpath('//*[contains(text(),"' + ime + '")]/../..'));
            
            return new IstrazivaciRow(el);
        }
    },

    //thead
	getTableIme: {
		get: function(){
			return utils.waitForElementPresence(by.xpath("//span[contains(text(),'Ime')]"),10000);
		}
	},
	getTablePrezime: {
		get: function(){
			return utils.waitForElementPresence(by.xpath("//span[contains(text(),'Prezime')]"),10000);
		}
	},
	getTableBirthday: {
		get: function(){
			return utils.waitForElementPresence(by.xpath("//span[contains(text(),'Datum rođenja')]"),10000);
		}
	},
	//sortiranje u tabeli
	getIme: {
		get: function(){
			return utils.waitForElementPresence(by.xpath("//table//th[1]"),10000);
		}
	},
	getPrezime: {
		get: function(){
			return utils.waitForElementPresence(by.xpath("//table//th[2]"),10000);
		}
	},
	getBirthday: {
		get: function(){
			return utils.waitForElementPresence(by.xpath("//table//th[3]"),10000);
		}
	},
	


	//navigacija

	getPrvi: {
		get: function(){
			return utils.waitForElementPresence(by.xpath("//a[contains(text(),'Prvi')]"),10000);
		}
	},
	getPrethodni: {
		get: function(){
			return utils.waitForElementPresence(by.xpath("//a[contains(text(),'Prethodni')]"),10000);
		}
	},
	getSledeci: {
		get: function(){
			return utils.waitForElementPresence(by.xpath("//a[contains(text(),'Sledeći')]"),10000);
		}
	},
	getPoslednji: {
		get: function(){
			return utils.waitForElementPresence(by.xpath("//a[contains(text(),'Poslednji')]"),10000);
		}
	},

	angazovanjeProzor: {
        get: function() {
            return utils.waitForElementPresence(by.className("modal-dialog"), 10000);
        },
        
	},
	tabAngazovanja: {
        get: function() {
            return utils.waitForElementPresence(by.xpath(".//li[4]//tab-heading"), 10000);
        }
	},

	angazovanjeBtn: {
        get: function() {
            return utils.waitToBeClickable(by.xpath("//button [@ng-click='addctrl.addConnection()']"), 10000);
        }
    },
	


    zvanjeIstrazivaca: {
        get: function() {
            return utils.waitForElementPresence(by.xpath(".//select[@ng-model='connection.position']"), 10000);
        },
        set: function(value) {
           
                this.zvanjeIstrazivaca.element(by.cssContainingText('option', value)).click();
            
        }
	},
	funkcijaIstrazivaca: {
        get: function() {
            return utils.waitForElementPresence(by.xpath("//select[@ng-model='connection.function']"), 10000);
        },
        set: function(value) {
           
                this.funkcijaIstrazivaca.element(by.cssContainingText('option', value)).click();
            
        }
	},
	procenat: {
        get: function() {
            return utils.waitForElementPresence(by.name("employmentPercentage"), 10000);
        },
        set: function(value) {
            this.procenat.clear();
            this.procenat.sendKeys(value);
        }
	},
	datumPocetka: {
        get: function() {
            return utils.waitForElementPresence(by.xpath("//em-date-time-picker[@name='startDate']//input"), 10000);
        },
        set: function(value) {
            this.datumPocetka.clear();
            this.datumPocetka.sendKeys(value);
        }
	},
	datumKraja: {
        get: function() {
            return utils.waitForElementPresence(by.xpath("//em-date-time-picker[@name='endDate']//input"), 10000);
        },
        set: function(value) {
            this.datumKraja.clear();
            this.datumKraja.sendKeys(value);
        }
    },
	saveAngazovanjeBtn: {
        get: function() {
            return utils.waitToBeClickable(by.xpath(".//button[@ng-click='save()']"), 10000);
        }
    },
    
    cancelAngazovanjeBtn: {
        get: function() {
            return utils.waitToBeClickable(by.xpath(".//button[@ng-click='cancel()']"), 10000);
        }
    }

    

});

// Export klase
module.exports = IstrazivaciMain;