var InstitucijeRegistar = function() {};
var utils = require('../utils.js');
var _ = require('lodash');

InstitucijeRegistar.prototype = Object.create({}, {

 
tabPodaciZaRegistar: {
    get: function() {
        return utils.waitForElementPresence(by.xpath("//ul/li[2]//tab-heading"), 10000);
    }
},

pib: {
    get: function() {
        return utils.waitForElementPresence(by.name("pib"), 10000);
    },
        set: function(value) {
        this.pib.clear();
        this.pib.sendKeys(value);
        }
},
pibFormatError: {
    get: function() {
        return utils.waitForElementPresence(by.xpath("//span[contains (text(),'Poreski broj nije u dobrom formatu.')]"), 10000).getText();
    }
},
pibRequired: {
    get: function() {
        return utils.waitForElementPresence(by.xpath("//span[contains (text(),'Morate uneti PIB.')]"), 10000).getText();
    }
},


  
maticniBroj: {
    get: function() {
        return utils.waitForElementPresence(by.name("maticniBroj"), 10000);
    },
        set: function(value) {
        this.maticniBroj.clear();
        this.maticniBroj.sendKeys(value);
        }
},

mbRequired: {
    get: function() {
        return utils.waitForElementPresence(by.xpath("//span[contains (text(),'Unesite matični broj.')]"), 10000).getText();
    }
},
mbFormatError: {
    get: function() {
        return utils.waitForElementPresence(by.xpath("//span[contains (text(),'Matični broj se mora sastojati od 13 cifara')]"), 10000).getText();
    }
},


brojAkreditacije: {
    get: function() {
        return utils.waitForElementPresence(by.name("accreditationNumber"), 10000);
    },
        set: function(value) {
        this.brojAkreditacije.clear();
        this.brojAkreditacije.sendKeys(value);
        }
},
brAkreditacijeRequired: {
    get: function() {
        return utils.waitForElementPresence(by.xpath("//span[contains (text(),'Morate uneti broj akreditacije.')]"), 10000).getText();
    }
},


datumAkreditacije: {
    get: function() {
        return utils.waitForElementPresence(by.xpath("(.// input[@ng-model='data.date'])[1]"), 10000);
    },
        set: function(value) {
        this.datumAkreditacije.clear();
        this.datumAkreditacije.sendKeys(value);
        }
},
datumAkreditacijeRequired: {
    get: function() {
        return utils.waitForElementPresence(by.xpath("//span[contains (text(),'Unesite datum akreditacije!')]"), 10000).getText();
    }
},



institucijaAkreditacije: {
    get: function() {
        return utils.waitForElementPresence(by.name("accreditationNote"), 10000);
    },
        set: function(value) {
        this.institucijaAkreditacije.clear();
        this.institucijaAkreditacije.sendKeys(value);
        }
},
institucijaAkreditacijeRequired: {
    get: function() {
        return utils.waitForElementPresence(by.xpath("//span[contains (text(),'Morate uneti naziv institucije iz akreditacije.')]"), 10000).getText();
    }
},
  
napomenaoRegistru: {
    get: function() {
        return utils.waitForElementPresence(by.name("note"), 10000);
    },
        set: function(value) {
        this.napomenaoRegistru.clear();
        this.napomenaoRegistru.sendKeys(value);
        }
},

vrstaInstitucije: {
    get: function() {
        return utils.waitForElementPresence(by.name("institutionType"), 10000);
    },
    set: function(value) {
        
            this.vrstaInstitucije.element(by.cssContainingText('option', value)).click();
    
    }
},




delatnost: {
    get: function() {
        return utils.waitForElementPresence(by.id("s2id_autogen4"), 10000);
    },
        set: function(value) {
        this.delatnost.clear();
        this.delatnost.sendKeys(value);
        }
},


osnivac: {
    get: function() {
        return utils.waitForElementPresence(by.name("founder"), 10000);
    },
        set: function(value) {
        this.osnivac.clear();
        this.osnivac.sendKeys(value);
        }
},

datumOsnivanja: {
    get: function() {
        return utils.waitForElementPresence(by.xpath("(.// input[@ng-model='data.date'])[2]"), 10000);
    },
        set: function(value) {
        this.datumOsnivanja.clear();
        this.datumOsnivanja.sendKeys(value);
        }
},


brojResenjaOOsnivanju: {
    get: function() {
        return utils.waitForElementPresence(by.name("rescriptNumber"), 10000);
    },
        set: function(value) {
        this.brojResenjaOOsnivanju.clear();
        this.brojResenjaOOsnivanju.sendKeys(value);
        }
},

vlasnickaStruktura: {
    get: function() {
        return utils.waitForElementPresence(by.name("ownershipStructure"), 10000);
    },
    set: function(value) {
       
            this.vlasnickaStruktura.element(by.cssContainingText('option', value)).click();
    
    }
},


 
cancelBtn: {
    get: function() {
        return utils.waitToBeClickable(by.xpath(".//button[@ng-click='reset(Register)']"), 10000);
    }
},
    
saveBtn: {
    get: function() {
        return utils.waitToBeClickable(by.xpath(".//button[@ng-click='addctrl.saveInstitution(Register)']"), 10000);
    }
},
    
  
 

unosPodatakaZaRegistar: {
    value: function(pib, maticniBroj, brojAkreditacije, datumAkreditacije, institucijaAkreditacije,
    napomenaoRegistru,vrstaInstitucije,osnivac,datumOsnivanja,brojResenjaOOsnivanju,vlasnickaStruktura) {
        this.pib=pib;
        this.maticniBroj=maticniBroj;
        this.brojAkreditacije=brojAkreditacije;
        this.datumAkreditacije=datumAkreditacije;
        this.institucijaAkreditacije=institucijaAkreditacije;
        this.napomenaoRegistru=napomenaoRegistru;
        this.vrstaInstitucije=vrstaInstitucije;
        this.osnivac=osnivac;
        this.datumOsnivanja=datumOsnivanja;
        this.brojResenjaOOsnivanju=brojResenjaOOsnivanju;
        this.vlasnickaStruktura=vlasnickaStruktura;
       this.saveBtn.click();

    }
}







});

// Export klase
module.exports = InstitucijeRegistar;



//vrstaInstitucije: {
 //   get: function() {
  //      return utils.waitForElementPresence(by.name("institutionType"), 10000);
//    },
 //   set: function(value) {
 //       var vrstaInstitucije = this.vrstaInstitucije;
 //       _.each(value, function(value) {
  //          vrstaInstitucije.element(by.cssContainingText('option', value)).click();
  //      });
 //   }
//},
