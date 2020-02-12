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
   



    
    it('should add one letter in serch area',function(){
        menuPage.istrazivaciBtn.click();
        expect(istrazivaciMainPage.pretragaIstrazivaca.isDisplayed()).toBe(true);
        istrazivaciMainPage.pretragaIstrazivaca = 'S'
        expect(istrazivaciMainPage.pretragaPrekratka.isDisplayed()).toBe(true);

        
      });

    it('should add two letters in serch area',function(){
        menuPage.istrazivaciBtn.click();
        expect(istrazivaciMainPage.pretragaIstrazivaca.isDisplayed()).toBe(true);
        istrazivaciMainPage.pretragaIstrazivaca = 'St'
        expect(istrazivaciMainPage.pretragaPrekratka.isDisplayed()).toBe(true);

        
    });

    it('should add non existing letters in serch area',function(){
        menuPage.istrazivaciBtn.click();
        expect(istrazivaciMainPage.pretragaIstrazivaca.isDisplayed()).toBe(true);
        istrazivaciMainPage.pretragaIstrazivaca = 'qqqqqqqqqqqqq'
        expect(istrazivaciMainPage.pretraga0Matches.isDisplayed()).toBe(true);

        
    });


    it('should add tree letter in serch area',function(){

        
        menuPage.istrazivaciBtn.click();
        expect(istrazivaciMainPage.pretragaIstrazivaca.isDisplayed()).toBe(true);
        istrazivaciMainPage.pretragaIstrazivaca = 'Tam'
        expect(istrazivaciMainPage.pretragaPrekratka.isDisplayed()).not.toBe(true);
        expect(istrazivaciMainPage.searchDropdown.isDisplayed()).not.toBe(true);

        istrazivaciMainPage.trazeniResultat("ara Bjelobrk (rođ. null)").click();

       



        
      });


     







   // afterAll(function() {
   //     menuPage.dropdownmenu.click();
	//	menuPage.logoutBtn.click();
   // });
});