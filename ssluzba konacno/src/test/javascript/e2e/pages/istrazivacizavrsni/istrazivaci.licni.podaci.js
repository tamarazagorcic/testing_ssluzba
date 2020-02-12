var IstrazivaciPodaci = function() {};
var utils = require('../utils.js');
var _ = require('lodash');

IstrazivaciPodaci.prototype = Object.create({}, {



    dodajIstrazivacaBtn: {
        get: function() {
            return utils.waitToBeClickable(by.xpath(".//a[@ui-sref='addPerson']"), 20000);
        }
    },

    tabLicniPodaci: {
        get: function() {
            return utils.waitForElementPresence(by.xpath(".//li[1]//tab-heading"), 10000);
        }
    },

    ime: {
        get: function() {
            return utils.waitForElementPresence(by.name("firstNameText"), 10000);
        },
        set: function(value) {
            this.ime.clear();
            this.ime.sendKeys(value);
        }
    },
    imeRequired: {
        get: function() {
            return utils.waitForElementPresence(by.xpath("//span[contains (text(),'Morate uneti ime.')]"), 10000).getText();
        }
    },

    prezime: {
        get: function() {
            return utils.waitForElementPresence(by.xpath(".//*[@id='personSearchLastNameT']/input"), 10000);
        },
        set: function(value) {
            this.prezime.clear();
           
            this.prezime.sendKeys(value);
        }
    },

    
    prezimeRequired: {
        get: function() {
            return utils.waitForElementPresence(by.xpath("//span[contains (text(),'Morate uneti prezime.')]"), 10000).getText();
        }
    },

    imeRoditelja: {
        get: function() {
            return utils.waitForElementPresence(by.name("middleName"), 10000);
        },
        set: function(value) {
            this.imeRoditelja.clear();
            this.imeRoditelja.sendKeys(value);
        }
    },


    titulaIstrazivaca: {
        get: function() {
            return utils.waitForElementPresence(by.name("personTitle"), 10000);
        },
        set: function(value) {
           
                this.titulaIstrazivaca.element(by.cssContainingText('option', value)).click();
            
        }
    },

	
    datumRodjenja: {
        get: function() {
            return utils.waitForElementPresence(by.xpath(".//input[@ng-model='data.date']"), 10000);
        },
        set: function(value) {
            this.datumRodjenja.clear();
            this.datumRodjenja.sendKeys(value);
        }
    },
    datumError: {
        get: function() {
           return utils.waitForElementPresence(by.xpath(".//span[contains (text(),'Datum rođenja mora biti u formatu DD.MM.GGGG')]"), 10000).getText();
    }
     },


    drzavaRodjenja: {
        get: function() {
            return utils.waitForElementPresence(by.name("state"), 10000);
        },
        set: function(value) {
            this.drzavaRodjenja.clear();
            this.drzavaRodjenja.sendKeys(value);
        }
    },

    gradRodjenja: {
        get: function() {
            return utils.waitForElementPresence(by.name("placeOfBirth"), 10000);
        },
        set: function(value) {
            this.gradRodjenja.clear();
            this.gradRodjenja.sendKeys(value);
        }
    },

    opstinaRodjenja: {
        get: function() {
            return utils.waitForElementPresence(by.name("townShipOfBirth"), 10000);
        },
        set: function(value) {
            this.opstinaRodjenja.clear();
            this.opstinaRodjenja.sendKeys(value);
        }
    },

    drzavaPrebivalista: {
        get: function() {
            return utils.waitForElementPresence(by.name("stateOfResidence"), 10000);
        },
        set: function(value) {
            this.drzavaPrebivalista.clear();
            this.drzavaPrebivalista.sendKeys(value);
        }
    },

    mestoPrebivalista: {
        get: function() {
            return utils.waitForElementPresence(by.name("city"), 10000);
        },
        set: function(value) {
            this.mestoPrebivalista.clear();
            this.mestoPrebivalista.sendKeys(value);
        }
    },

    opstinaPrebivalista: {
        get: function() {
            return utils.waitForElementPresence(by.name("townShipOfResidence"), 10000);
        },
        set: function(value) {
            this.opstinaPrebivalista.clear();
            this.opstinaPrebivalista.sendKeys(value);
        }
    },

    adresa: {
        get: function() {
            return utils.waitForElementPresence(by.name("address"), 10000);
        },
        set: function(value) {
            this.adresa.clear();
            this.adresa.sendKeys(value);
        }
    },

  pol: {
        get: function() {
           return utils.waitForElementPresence(by.name("gender"), 10000);
        },
        set: function(value) {
           this.pol.element(by.cssContainingText('option', value)).click();
        
        }
   },
    

    //pol: {
      //  get: function() {
      //      return utils.waitForElementPresence(by.name("gender"), 10000);
     //   },
     //   set: function(value) {
     //       var pol = this.pol;
     //       _.each(value, function(value) {
     //          pol.element(by.cssContainingText('option', value)).click();
     //       });
     //   }
     //},


    jmbg: {
        get: function() {
            return utils.waitForElementPresence(by.name("jmbg"), 10000);
        },
        set: function(value) {
            this.jmbg.clear();
            this.jmbg.sendKeys(value);
        }
    },
    jmbgRequired: {
        get: function() {
           return utils.waitForElementPresence(by.xpath(".//span[contains (text(),'Morate uneti JMBG')]"), 10000).getText();
    }
     },

    email: {
        get: function() {
            return utils.waitForElementPresence(by.name("email"), 10000);
        },
        set: function(value) {
            this.email.clear();
            this.email.sendKeys(value);
        }
    },

    telefon: {
        get: function() {
            return utils.waitForElementPresence(by.name("phones"), 10000);
        },
        set: function(value) {
            this.telefon.clear();
            this.telefon.sendKeys(value);
        }
    },

    webAdresa: {
        get: function() {
            return utils.waitForElementPresence(by.name("uri"), 10000);
        },
        set: function(value) {
            this.webAdresa.clear();
            this.webAdresa.sendKeys(value);
        }
    },

    statusIstrazivaca: {
        get: function() {
            return utils.waitForElementPresence(by.name("personStatus"), 10000);
        },
        set: function(value) {
           
                this.statusIstrazivaca.element(by.cssContainingText('option', value)).click();
        
        }
    },

	

    saveBtn: {
        get: function() {
            return utils.waitToBeClickable(by.xpath(".//button[@ng-click='addctrl.savePerson(Basic)']"), 10000);
        }
    },
    
    cancelBtn: {
        get: function() {
            return utils.waitToBeClickable(by.xpath(".//button[@ng-click='reset()']"), 10000);
        }
    },

    unosPodatakaZaIstrazivace: {
        value: function(ime, prezime,imeRoditelja,titulaIstrazivaca,datumRodjenja,drzavaRodjenja,gradRodjenja,
            opstinaRodjenja,drzavaPrebivalista,mestoPrebivalista,opstinaPrebivalista,adresa,pol,jmbg,email,telefon, webAdresa, statusIstrazivaca  ) {
            this.ime = ime;
            this.prezime = prezime;
            this.imeRoditelja = imeRoditelja;
            this.titulaIstrazivaca = titulaIstrazivaca;
            this.datumRodjenja = datumRodjenja;
            this.drzavaRodjenja = drzavaRodjenja;
            this.gradRodjenja = gradRodjenja;
            this.opstinaRodjenja = opstinaRodjenja;
            this.drzavaPrebivalista = drzavaPrebivalista;
            this.mestoPrebivalista = mestoPrebivalista;
            this.opstinaPrebivalista = opstinaPrebivalista;
            this.adresa = adresa;
            this. pol = pol;
            this.jmbg = jmbg;
            this.email = email;
            this.telefon = telefon;
            this.webAdresa = webAdresa;
            this.statusIstrazivaca = statusIstrazivaca;


            this.saveBtn.click();
        }
    }

    

   


});

// Export klase
module.exports = IstrazivaciPodaci;