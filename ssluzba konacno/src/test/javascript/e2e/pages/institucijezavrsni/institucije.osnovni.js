var InstitucijeOsnovniPodaci = function() {};
var utils = require('../utils.js');
var _ = require('lodash');

InstitucijeOsnovniPodaci.prototype = Object.create({}, {

    
tabOsnovniPodaci: {
        get: function() {
            return utils.waitForElementPresence(by.xpath("//ul/li[1]//tab-heading"), 10000);
        }
    },
nazivInstitucije: {
        get: function() {
            return utils.waitForElementPresence(by.name("name"), 10000);
        },
        set: function(value) {
            this.nazivInstitucije.clear();
            this.nazivInstitucije.sendKeys(value);
        }
    },
nazivRequired: {
        get: function() {
            return utils.waitForElementPresence(by.xpath("//span[contains (text(),'Morate uneti naziv.')]"), 10000).getText();
        }
    },

      
nazivNaEngleskom: {
        get: function() {
            return utils.waitForElementPresence(by.name("eng_name"), 10000);
        },
        set: function(value) {
            this.nazivNaEngleskom.clear();
            this.nazivNaEngleskom.sendKeys(value);
        }
    },
    	
   
    drzava: {
        get: function() {
            return utils.waitForElementPresence(by.name("state"), 10000);
        },
        set: function(value) {
            var drzava = this.drzava;
            _.each(value, function(value) {
                drzava.element(by.cssContainingText('option', value)).click();
            });
        }
    },
    naziv: {
        get: function() {
            return utils.waitForElementPresence(by.name("stateName"), 10000);
        },
        set: function(value) {
            this.naziv.clear();
            this.naziv.sendKeys(value);
        }
    },
    opis: {
        get: function() {
            return utils.waitForElementPresence(by.name("stateDescription"), 10000);
        },
        set: function(value) {
            this.opis.clear();
            this.opis.sendKeys(value);
        }
    },
    saveButtonZaNovuDrzavu: {
        get: function() {
            return utils.waitForElementPresence(by.xpath(".//button[@type='submit']"), 10000);
        }
    },

    noveDrzave: {
        value: function(naziv,opis) {
            this.naziv=naziv;
            this.opis=opis;
            
            this.saveButtonZaNovuDrzavu.click();

          
        }
    },
    

drzavaRequired: {
        get: function() {
            return utils.waitForElementPresence(by.xpath("//span[contains (text(),'Morate izabrati državu')]"), 10000).getText();
        }
    },

nazivMesta: {
        get: function() {
            return utils.waitForElementPresence(by.name("place"), 10000);
        },
            set: function(value) {
            this.nazivMesta.clear();
            this.nazivMesta.sendKeys(value);
            }
    },

mestoRequired: {
        get: function() {
            return utils.waitForElementPresence(by.xpath("//span[contains (text(),'Morate uneti mesto.')]"), 10000).getText();
        }
    },

nazivOpstine: {
        get: function() {
            return utils.waitForElementPresence(by.name("townShipText"), 10000);
        },
            set: function(value) {
            this.nazivOpstine.clear();
            this.nazivOpstine.sendKeys(value);
            }
    },

nazivUlice: {
        get: function() {
            return utils.waitForElementPresence(by.name("address"), 10000);
        },
            set: function(value) {
            this.nazivUlice.clear();
            this.nazivUlice.sendKeys(value);
            }
    },
adresaReqired: {
        get: function() {
            return utils.waitForElementPresence(by.xpath("//span[contains (text(),'Morate uneti adresu.')]"), 10000).getText();
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
webReqired: {
        get: function() {
            return utils.waitForElementPresence(by.xpath("//span[contains (text(),'Morate uneti veb adresu.')]"), 10000).getText();
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
emailReqired: {
        get: function() {
            return utils.waitForElementPresence(by.xpath("//span[contains (text(),'Morate uneti adresu elektronske pošte.')]"), 10000).getText();
        }
    },

phone: {
        get: function() {
            return utils.waitForElementPresence(by.name("phone"), 10000);
        },
            set: function(value) {
            this.phone.clear();
            this.phone.sendKeys(value);
            }
    },
telefonReqired: {
        get: function() {
            return utils.waitForElementPresence(by.xpath("//span[contains (text(),'Morate uneti broj telefona.')]"), 10000).getText();
        }
    },

skraceniNaziv: {
        get: function() {
            return utils.waitForElementPresence(by.name("acro"), 10000);
        },
            set: function(value) {
            this.skraceniNaziv.clear();
            this.skraceniNaziv.sendKeys(value);
            }
    },
   
    
nadredjenaInstitucija: {
        get: function() {
            return utils.waitForElementPresence(by.name("supetInstitution"), 10000);
        },
        set: function(value) {
            
               this.nadredjenaInstitucija.element(by.cssContainingText('option', value)).click();
            
        }
    },


saveButton: {
        get: function() {
            return utils.waitToBeClickable(by.xpath(".//*[@ng-click='addctrl.saveInstitution(Basic)']"), 10000);
        }
    },

cancelButton: {
        get: function() {
            return utils.waitToBeClickable(by.xpath(".//button[@ng-click='reset(Basic)']"), 10000);
        }
    },


	
    
unosOsnovnihPodataka: {
        value: function(nazivInstitucije, nazivNaEngleskom, drzava, nazivMesta, nazivOpstine,
        nazivUlice,webAdresa,email,phone,skraceniNaziv,nadredjenaInstitucija) {
            this.nazivInstitucije=nazivInstitucije;
            this.nazivNaEngleskom=nazivNaEngleskom;
            this.drzava=drzava;
            this.nazivMesta=nazivMesta;
            this.nazivOpstine=nazivOpstine;
            this.nazivUlice=nazivUlice;
            this.webAdresa=webAdresa;
            this.email=email;
            this.phone=phone;
            this.skraceniNaziv=skraceniNaziv;
            this.nadredjenaInstitucija=nadredjenaInstitucija;
            this.saveButton.click();

          
        }
    }
});

// Export klase
module.exports = InstitucijeOsnovniPodaci;
    


//nadredjenaInstitucija: {
 //   get: function() {
 //       return utils.waitForElementPresence(by.name("supetInstitution"), 10000);
 //   },
 //   set: function(value) {
  //      var nadredjenaInstitucija = this.nadredjenaInstitucija;
 //       _.each(value, function(value) {
  //          nadredjenaInstitucija.element(by.cssContainingText('option', value)).click();
 //       });
  //  }
//},