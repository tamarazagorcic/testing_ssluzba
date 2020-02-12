var utils = require('../pages/utils.js');
var LoginPage = require('../pages/globalzavrsni/login.page.js');
var MenuPage = require('../pages/globalzavrsni/menu.page.js');
var ModalPage = require('../pages/globalzavrsni/modal.succes.page.js');
var InstitucijeOsnovniPage = require('../pages/institucijezavrsni/institucije.osnovni.js');
var InstitucijeProjektiPage = require('../pages/institucijezavrsni/institucije.projekti.js');
var InstitucijeRegistarPage = require('../pages/institucijezavrsni/institucije.registar.js');
var IstrazivaciLicniPodaciPage = require('../pages/istrazivacizavrsni/istrazivaci.licni.podaci.js');
var IstrazivaciMainPage = require('../pages/istrazivacizavrsni/istrazivaci.main.page.js');
var IstrazivaciProjektiPage = require('../pages/istrazivacizavrsni/podaci.za.projekte.js');
var IstrazivaciRegistarPage = require('../pages/istrazivacizavrsni/podaci.za.registar.js');
var baseUrl = 'http://127.0.0.1:8080/#/login';


describe('testAll', function() {
    var loginPage,
        menuPage,
        modalPage,
        institucijeOsnovniPage,
        institucijeProjektiPage,
        institucijeRegistarPage,
        istrazivaciLicniPodaciPage,
        istrazivaciMainPage,
        istrazivaciProjektiPage,
        istrazivaciRegistarPage;

    beforeAll(function() {
        loginPage = new LoginPage();
        menuPage = new MenuPage();
        modalPage = new ModalPage();
		institucijeOsnovniPage = new InstitucijeOsnovniPage();
		institucijeProjektiPage = new InstitucijeProjektiPage();
        institucijeRegistarPage = new InstitucijeRegistarPage();
        istrazivaciLicniPodaciPage = new IstrazivaciLicniPodaciPage();
        istrazivaciMainPage = new IstrazivaciMainPage();
        istrazivaciProjektiPage = new IstrazivaciProjektiPage();
        istrazivaciRegistarPage = new IstrazivaciRegistarPage();
        browser.get('/');

        // Login
        
        expect(loginPage.username.isDisplayed()).toBe(true);
        expect(loginPage.password.isDisplayed()).toBe(true);
        loginPage.login("djura@djuraminis.com", "adminvinca");
        expect(browser.getCurrentUrl()).toEqual('http://localhost:8080/#/admin-institution/');
    });

    it('should change language on Serbian Latin',function(){
        menuPage.languages.click();
        menuPage.srpskiLatinica.click();
        
      });
      it('should close alert adding istrazivac without surname',function(){
        menuPage.istrazivaciBtn.click();
        expect(istrazivaciMainPage.pretragaIstrazivaca.isDisplayed()).toBe(true);
        istrazivaciLicniPodaciPage.dodajIstrazivacaBtn.click();
 
        istrazivaciLicniPodaciPage.ime = 'Tamarica';
        istrazivaciLicniPodaciPage.jmbg = '14456565';
        istrazivaciLicniPodaciPage.saveBtn.click();
        var EC = protractor.ExpectedConditions;
        browser.wait(EC.alertIsPresent(), 5000, "Alert is not getting present ")
  
       // var alert = element(by.id("typeahead-1505-9202"));  
        //browser.switchTo().frame(alert.getWebElement());
        browser.switchTo().alert().accept()
  
        
    });

    it('should be a name required',function(){
        menuPage.istrazivaciBtn.click();
        expect(istrazivaciMainPage.pretragaIstrazivaca.isDisplayed()).toBe(true);
        istrazivaciLicniPodaciPage.dodajIstrazivacaBtn.click();
 
        istrazivaciLicniPodaciPage.ime = '';
        istrazivaciLicniPodaciPage.prezime = 'Ninic';
        istrazivaciLicniPodaciPage.jmbg = '14456565';
        istrazivaciLicniPodaciPage.saveBtn.click();
        expect(istrazivaciLicniPodaciPage.imeRequired.isDisplayed()).toBe(true);
  
        
    });

    //jmbg da li moze 12 cifara, da li moze 14 cifara, da li mogu slova
    it('should be a jmbg required',function(){
        menuPage.istrazivaciBtn.click();
        expect(istrazivaciMainPage.pretragaIstrazivaca.isDisplayed()).toBe(true);
        istrazivaciLicniPodaciPage.dodajIstrazivacaBtn.click();
 
        istrazivaciLicniPodaciPage.ime = 'Nina';
        istrazivaciLicniPodaciPage.prezime = 'Ninic';
        istrazivaciLicniPodaciPage.jmbg = '';
        istrazivaciLicniPodaciPage.saveBtn.click();
        expect(istrazivaciLicniPodaciPage.jmbgRequired.isDisplayed()).toBe(true);
  
        
    });


    it('should be a date a day more',function(){
        menuPage.istrazivaciBtn.click();
        expect(istrazivaciMainPage.pretragaIstrazivaca.isDisplayed()).toBe(true);
        istrazivaciLicniPodaciPage.dodajIstrazivacaBtn.click();
 
        istrazivaciLicniPodaciPage.ime = 'Nina';
        istrazivaciLicniPodaciPage.prezime = 'Ninic';
        istrazivaciLicniPodaciPage.datumRodjenja = '32.12.2016'
        istrazivaciLicniPodaciPage.jmbg = '';
        istrazivaciLicniPodaciPage.saveBtn.click();
        expect(istrazivaciLicniPodaciPage.jmbgRequired.isDisplayed()).toBe(true);
        expect(istrazivaciLicniPodaciPage.datumError.isDisplayed()).toBe(true);
  
        
    });

    it('should be a date a mounth more',function(){
        menuPage.istrazivaciBtn.click();
        expect(istrazivaciMainPage.pretragaIstrazivaca.isDisplayed()).toBe(true);
        istrazivaciLicniPodaciPage.dodajIstrazivacaBtn.click();
 
        istrazivaciLicniPodaciPage.ime = 'Nina';
        istrazivaciLicniPodaciPage.prezime = 'Ninic';
        istrazivaciLicniPodaciPage.datumRodjenja = '31.13.2016'
        istrazivaciLicniPodaciPage.jmbg = '';
        istrazivaciLicniPodaciPage.saveBtn.click();
        expect(istrazivaciLicniPodaciPage.jmbgRequired.isDisplayed()).toBe(true);
        expect(istrazivaciLicniPodaciPage.datumError.isDisplayed()).toBe(true);
  
        
    });

    it('should add Istrazivac',function(){
        menuPage.istrazivaciBtn.click();
        expect(istrazivaciMainPage.pretragaIstrazivaca.isDisplayed()).toBe(true);
        istrazivaciLicniPodaciPage.dodajIstrazivacaBtn.click();
 
        istrazivaciLicniPodaciPage.ime = 'Tamara8_protractor';
        istrazivaciLicniPodaciPage.prezime = 'Istrazivac';
        istrazivaciLicniPodaciPage.jmbg = '12345667845';
        istrazivaciLicniPodaciPage.saveBtn.click();
        expect(istrazivaciMainPage.angazovanjeProzor.isDisplayed()).toBe(true);
        istrazivaciMainPage.cancelAngazovanjeBtn.click();
        expect(istrazivaciMainPage.getIstrazivaciRowByNameAndSurname('Tamara8_protractor').rowElement.isPresent()).toBe(true);;

  
        
    });












   afterAll(function() {
        menuPage.dropdownmenu.click();
		menuPage.logoutBtn.click();
    });
});