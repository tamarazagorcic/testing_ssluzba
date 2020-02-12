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
        browser.ignoreSynchronization=true;
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
        
       
    });
   

    it('should login with no credentials',function(){
        expect(loginPage.username.isDisplayed()).toBe(true);
        expect(loginPage.password.isDisplayed()).toBe(true);
        loginPage.username= 'ahahah';
        loginPage.username.clear();
        loginPage.password= 'xfgzdgf';
        loginPage.password.clear();
        expect(loginPage.usernameRequired.isDisplayed()).toBe(true);
        expect(loginPage.passwordRequired.isDisplayed()).toBe(true);
        
        
        browser.refresh();
    });
    it('should login with no password',function(){
        expect(loginPage.username.isDisplayed()).toBe(true);
        expect(loginPage.password.isDisplayed()).toBe(true);
        loginPage.username= 'sthxdthzd';
        
        loginPage.password= 'dzgzdfg';
        loginPage.password.clear();
        expect(loginPage.usernameRequired.isDisplayed()).toBe(false);
        expect(loginPage.passwordRequired.isDisplayed()).toBe(true);
        
        
        browser.refresh();
    });

    it('should login with no username',function(){
        expect(loginPage.username.isDisplayed()).toBe(true);
        expect(loginPage.password.isDisplayed()).toBe(true);
        loginPage.username= 'xzfvgbz';
        loginPage.username.clear();
        loginPage.password= 'zdfgzfdgzg';
        expect(loginPage.usernameRequired.isDisplayed()).toBe(true);
        expect(loginPage.passwordRequired.isDisplayed()).toBe(false);
        
        
        browser.refresh();
    });

    it('should login with wrong username',function(){
        expect(loginPage.username.isDisplayed()).toBe(true);
        expect(loginPage.password.isDisplayed()).toBe(true);
        
        loginPage.login("djura@djuraminis", "adminvinca");

       // expect(loginPage.loginError1.isDisplayed()).toBe(true);
       expect(loginPage.loginError.isDisplayed()).toBe(true);
        
       
        browser.refresh();
    });

    it('should login with wrong password',function(){
        expect(loginPage.username.isDisplayed()).toBe(true);
        expect(loginPage.password.isDisplayed()).toBe(true);
       
        loginPage.login("djura@djuraminis.com", "admin");
        expect(loginPage.loginError.isDisplayed()).toBe(true);
       // expect(loginPage.loginError1.isDisplayed()).toBe(true);
        
        
        browser.refresh();
    });

    it('should login',function(){
        expect(loginPage.username.isDisplayed()).toBe(true);
        expect(loginPage.password.isDisplayed()).toBe(true);
        loginPage.login("djura@djuraminis.com", "adminvinca");
        
        
        expect(menuPage.istrazivaciBtn.isDisplayed()).toBe(true);
       
    });

    afterAll(function() {
        menuPage.dropdownmenu.click();
		menuPage.logoutBtn.click();
    });
});