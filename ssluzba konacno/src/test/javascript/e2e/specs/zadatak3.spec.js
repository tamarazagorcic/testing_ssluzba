var LoginPage = require('../pages/global/login.page.js');
var MenuPage = require('../pages/global/menu.page.js');
var IspitniRokoviListPage = require('../pages/ispitni-rokovi/ispitni-rokovi-list.page.js');
var IspitniRokoviCreationPage = require('../pages/ispitni-rokovi/ispitni-rokovi-creation.page.js');
var IspitnePrijaveListPage = require('../pages/ispitne-prijave/ispitne-prijave-list.page.js');
var IspitnePrijaveCreationPage = require('../pages/ispitne-prijave/ispitne-prijave-creation.page.js');

var utils = require('../pages/utils.js');
var baseUrl = 'http://localhost:8080/#/';

describe('zadatak3', function() {
    var loginPage,
        menuPage,
        ispitniRokoviListPage,
        ispitniRokoviCreationPage,
        ispitnePrijaveListPage,
        ispitnePrijaveCreationPage;

    beforeAll(function() {
        loginPage = new LoginPage();
		menuPage = new MenuPage();
		ispitniRokoviListPage = new IspitniRokoviListPage();
		ispitniRokoviCreationPage = new IspitniRokoviCreationPage();
		ispitnePrijaveListPage = new IspitnePrijaveListPage();
		ispitnePrijaveCreationPage = new IspitnePrijaveCreationPage();
        browser.get('/');

        // Login
        menuPage.accountMenu.click();
		expect(menuPage.signUp.isDisplayed()).toBe(true);
		menuPage.signUp.click();
        utils.waitForTitle('Sign in');
		loginPage.login("admin", "admin");
    });

	// sve provere su ubacene u jedan test
	// TODO za vezbu razdvojiti ovaj test u manje celine
	it('should add an exam application and a term date.', function() {
		menuPage.entities.click();
		expect(menuPage.ispitniRokoviLink.isDisplayed()).toBe(true);
		menuPage.ispitniRokoviLink.click();

		ispitniRokoviListPage.createBtn.click();
		ispitniRokoviCreationPage.createIspitniRok("Aprilski", "2016-04-15", "2016-04-22");

		menuPage.entities.click();
		expect(menuPage.ispitnePrijaveLink.isDisplayed()).toBe(true);
		menuPage.ispitnePrijaveLink.click();

		ispitnePrijaveListPage.createBtn.click();
		ispitnePrijaveCreationPage.createIspitnaPrijava("30", "55", "Aprilski", "E1234 Marko Markovic", "Matematika");

	});

    afterAll(function() {
        menuPage.accountMenu.click();
		menuPage.logOut.click();
    });
});